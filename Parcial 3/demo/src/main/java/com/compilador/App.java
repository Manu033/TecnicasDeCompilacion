package com.compilador;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.ParseCancellationException;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.gui.TreeViewer;

import javax.swing.*;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class App {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Uso: java -jar compilador.jar <archivo.txt>");
            System.exit(1);
        }

        try {

            // Obtener el nombre del archivo de entrada para generar nombres de salida
            String inputFilePath = args[0];
            String inputFileName = new File(inputFilePath).getName();
            String baseName = inputFileName.substring(0, inputFileName.lastIndexOf('.'));

            // Verificar que el archivo existe
            File inputFile = new File(inputFilePath);
            if (!inputFile.exists()) {
                System.err.println("❌ Error: El archivo '" + inputFilePath + "' no existe.");
                System.exit(1);
            }

            // === ANÁLISIS LÉXICO ===
            System.out.println("Analizando archivo: " + args[0]);
            CharStream input = CharStreams.fromFileName(args[0]);

            List<String> erroresLexicos = new ArrayList<>();
            MiLenguajeLexer lexer = new MiLenguajeLexer(input);
            lexer.removeErrorListeners();
            lexer.addErrorListener(new BaseErrorListener() {
                @Override
                public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
                        int line, int charPositionInLine, String msg, RecognitionException e) {
                    erroresLexicos.add("ERROR LÉXICO en línea " + line + ":" + charPositionInLine + " - " + msg);
                    throw new ParseCancellationException(msg);
                }
            });

            CommonTokenStream tokens = new CommonTokenStream(lexer);
            tokens.fill();

            System.out.println("\n=== ANÁLISIS LÉXICO ===");
            if (erroresLexicos.isEmpty()) {
                System.out.printf("%-20s %-30s %-10s %-10s\n", "TIPO", "LEXEMA", "LÍNEA", "COLUMNA");
                System.out.println("-------------------------------------------------------------------");
                for (Token token : tokens.getTokens()) {
                    if (token.getType() != Token.EOF) {
                        String tokenName = MiLenguajeLexer.VOCABULARY.getSymbolicName(token.getType());
                        System.out.printf("%-20s %-30s %-10d %-10d\n",
                                tokenName, token.getText(), token.getLine(), token.getCharPositionInLine());
                    }
                }
                System.out.println("\n✅ Análisis léxico completado sin errores.");
            } else {
                erroresLexicos.forEach(System.out::println);
                return;
            }

            // === ANÁLISIS SINTÁCTICO ===
            MiLenguajeParser parser = new MiLenguajeParser(tokens);
            List<String> erroresSintacticos = new ArrayList<>();
            parser.removeErrorListeners();
            parser.addErrorListener(new BaseErrorListener() {
                @Override
                public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol,
                        int line, int charPositionInLine, String msg, RecognitionException e) {
                    erroresSintacticos
                            .add("ERROR SINTÁCTICO en línea " + line + ":" + charPositionInLine + " - " + msg);
                }
            });

            System.out.println("\n=== ANÁLISIS SINTÁCTICO ===");
            ParseTree tree = parser.programa();
            if (!erroresSintacticos.isEmpty()) {
                erroresSintacticos.forEach(System.out::println);
                return;
            } else {
                System.out.println("✅ Análisis sintáctico completado sin errores.");
                System.out.println("Representación textual del árbol sintáctico:");
                System.out.println(tree.toStringTree(parser));
            }

            // === VISUALIZACIÓN DEL ÁRBOL ===
            generarImagenArbolSintactico(tree, parser);

            // === ANÁLISIS SEMÁNTICO ===
            SimbolosListener listener = new SimbolosListener();
            ParseTreeWalker walker = new ParseTreeWalker();
            walker.walk(listener, tree);

            TablaSimbolos tabla = listener.getTablaSimbolos();
            tabla.imprimir();

            List<String> erroresSemanticos = listener.getErrores();
            if (!erroresSemanticos.isEmpty()) {
                System.out.println("\n=== ERRORES SEMÁNTICOS ===");
                erroresSemanticos.forEach(System.out::println);
            } else {
                System.out.println("\n✅ Análisis semántico completado sin errores.");
            }

            List<String> advertencias = listener.obtenerAdvertenciasNoCriticas();
            if (!advertencias.isEmpty()) {
                System.out.println("\n=== ADVERTENCIAS ===");
                advertencias.forEach(System.out::println);
            }

            // 5. GENERACIÓN DE CÓDIGO INTERMEDIO
            System.out.println("\n=== 5. GENERACIÓN DE CÓDIGO INTERMEDIO ===" + "\n");
            System.out.println("   🎯 Iniciando recorrido del AST con CodigoVisitor...");

            // Crear el visitor con la tabla de símbolos
            CodigoVisitor visitor = new CodigoVisitor(tabla);

            // ¡AQUÍ! - Recorrer el AST para generar código intermedio
            visitor.visit(tree);

            // Obtener el generador con el código generado
            GeneradorCodigo generador = visitor.getGenerador();

            // Mostrar el código generado en consola
            System.out.println("   📝 Código de tres direcciones generado:");
            generador.imprimirCodigo();

            // Mostrar información adicional
            if (generador.getTiposVariables() != null) {
                generador.imprimirTipos();
            }
            generador.imprimirEstadisticas();

            // Guardar código intermedio en archivo
            String codigoIntermedioPath = baseName + "_codigo_intermedio.txt";
            guardarCodigoEnArchivo(generador.getCodigo(), codigoIntermedioPath);
            System.out.println("✅ Código intermedio guardado en: " + codigoIntermedioPath);

        } catch (IOException e) {
            System.err.println("❌ Error al leer el archivo: " + e.getMessage());
        } catch (ParseCancellationException e) {
            System.err.println("❌ Error de análisis: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("❌ Error inesperado:");
            e.printStackTrace();
        }

    }

    private static void generarImagenArbolSintactico(ParseTree tree, Parser parser) {
        try {
            JFrame frame = new JFrame("Árbol Sintáctico");
            JPanel panel = new JPanel();

            TreeViewer viewer = new TreeViewer(Arrays.asList(parser.getRuleNames()), tree);
            viewer.setScale(1.5); // Zoom

            panel.add(viewer);

            JScrollPane scrollPane = new JScrollPane(panel);
            scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

            frame.add(scrollPane);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);
            viewer.open(); // Puedes activar esta línea para mostrarlo automáticamente

        } catch (Exception e) {
            System.err.println("❌ Error al mostrar árbol sintáctico: " + e.getMessage());
        }
    }

    /**
     * Guarda una lista de líneas de código en un archivo de texto
     */
    private static void guardarCodigoEnArchivo(List<String> codigo, String rutaArchivo) throws IOException {
    Path filePath = Paths.get(rutaArchivo);
        try (BufferedWriter writer = Files.newBufferedWriter(filePath)) {
            writer.write("// Código de tres direcciones generado automáticamente");
            writer.newLine();
            writer.write("// Archivo: " + rutaArchivo);
            writer.newLine();
            writer.write("// Total de instrucciones: " + codigo.size());
            writer.newLine();
            writer.newLine();

            for (int i = 0; i < codigo.size(); i++) {
                writer.write(String.format("%3d: %s", i, codigo.get(i)));
                writer.newLine();
            }
        }
        System.out.println("   💾 Archivo guardado con " + codigo.size() + " instrucciones");
    }

}
