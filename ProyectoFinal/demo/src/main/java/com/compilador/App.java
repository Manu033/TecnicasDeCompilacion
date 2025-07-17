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

        String RESET = "\u001B[0m";
        String RED = "\u001B[31m";
        String GREEN = "\u001B[32m";
        String YELLOW = "\u001B[33m";

        if (args.length != 1) {
            System.out.println("Uso: java -jar compilador.jar <archivo.txt>");
            System.exit(1);
        }

        try {
            String inputFilePath = args[0];
            String inputFileName = new File(inputFilePath).getName();
            String baseName = inputFileName.substring(0, inputFileName.lastIndexOf('.'));

            File inputFile = new File(inputFilePath);
            if (!inputFile.exists()) {
                System.err.println(RED + "❌ Error: El archivo '" + inputFilePath + "' no existe." + RESET);
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
                    erroresLexicos.add(RED + "❌ ERROR LÉXICO en línea " + line + ":" + charPositionInLine + " - " + msg + RESET);
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
                System.out.println(GREEN + "\n✅ Análisis léxico completado sin errores." + RESET);
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
                    erroresSintacticos.add(RED + "❌ ERROR SINTÁCTICO en línea " + line + ":" + charPositionInLine + " - " + msg + RESET);
                }
            });

            System.out.println("\n=== ANÁLISIS SINTÁCTICO ===");
            ParseTree tree = parser.programa();
            if (!erroresSintacticos.isEmpty()) {
                erroresSintacticos.forEach(System.out::println);
                return;
            } else {
                System.out.println(GREEN + "✅ Análisis sintáctico completado sin errores." + RESET);
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
                System.out.println("\n" + RED + "=== ERRORES SEMÁNTICOS ===" + RESET);
                erroresSemanticos.forEach(e -> System.out.println(RED + "❌ " + e + RESET));
            } else {
                System.out.println(GREEN + "\n✅ Análisis semántico completado sin errores." + RESET);
            }

            List<String> advertencias = listener.getAdvertencias();
            if (!advertencias.isEmpty()) {
                System.out.println("\n" + YELLOW + "=== ADVERTENCIAS ===" + RESET);
                advertencias.forEach(w -> System.out.println(YELLOW + "⚠️ " + w + RESET));
            }

            // === GENERACIÓN DE CÓDIGO INTERMEDIO ===
            System.out.println("\n=== 5. GENERACIÓN DE CÓDIGO INTERMEDIO ===\n");
            System.out.println("   🎯 Iniciando recorrido del AST con CodigoVisitor...");

            CodigoVisitor visitor = new CodigoVisitor(tabla);
            visitor.visit(tree);

            GeneradorCodigo generador = visitor.getGenerador();

            System.out.println("   📝 Código de tres direcciones generado:");
            generador.imprimirCodigo();

            if (generador.getTiposVariables() != null) {
                generador.imprimirTipos();
            }
            generador.imprimirEstadisticas();

            String codigoIntermedioPath = baseName + "_codigo_intermedio.txt";
            guardarCodigoEnArchivo(generador.getCodigo(), codigoIntermedioPath);
            System.out.println(GREEN + "✅ Código intermedio guardado en: " + codigoIntermedioPath + RESET);

            // === 6. OPTIMIZACIÓN DE CÓDIGO ===
            Optimizador optimizador = new Optimizador(generador.getCodigo());
            List<String> codigoOptimizado = optimizador.optimizar();

            String codigoOptimizadoPath = baseName + "_codigo_optimizado.txt";
            guardarCodigoEnArchivo(codigoOptimizado, codigoOptimizadoPath);
            System.out.println(GREEN + "✅ Código optimizado guardado en: " + codigoOptimizadoPath + RESET);

            // (Opcional) Imprimir en consola el código optimizado
            optimizador.imprimirCodigoOptimizado();


            // === 7. RESUMEN DE COMPILACIÓN ===
            System.out.println("\n=== 7. RESUMEN DE COMPILACIÓN ===");
            // Nombre del archivo procesado
            System.out.printf("   📁 Archivo procesado: %s%n", inputFileName);
            // Número de tokens (restamos 1 si queremos excluir EOF)
            int totalTokens = tokens.getTokens().size() - 1;
            System.out.printf("   🔤 Tokens analizados: %d%n", totalTokens);
            // Símbolos en la tabla
            // Asumo que tu TablaSimbolos tiene un método para obtener la lista de símbolos registrados.
            // Si no fuera así, ajusta el llamado al método correspondiente.
            int totalSimbolos = tabla.getSimbolos().size();
            System.out.printf("   📊 Símbolos en tabla: %d%n", totalSimbolos);
            // Instrucciones generadas e instrucciones optimizadas
            int totalGeneradas = generador.getCodigo().size();
            int totalOpt = codigoOptimizado.size();
            System.out.printf("   📝 Instrucciones generadas: %d%n", totalGeneradas);
            System.out.printf("   🔧 Instrucciones optimizadas: %d%n", totalOpt);
            // Rutas de los archivos de salida
            System.out.printf("   📄 Archivo código intermedio: %s%n", codigoIntermedioPath);
            System.out.printf("   📄 Archivo código optimizado: %s%n", codigoOptimizadoPath);


        } catch (IOException e) {
            System.err.println(RED + "❌ Error al leer el archivo: " + e.getMessage() + RESET);
        } catch (ParseCancellationException e) {
            System.err.println(RED + "❌ Error de análisis: " + e.getMessage() + RESET);
        } catch (Exception e) {
            System.err.println(RED + "❌ Error inesperado:" + RESET);
            e.printStackTrace();
        }

    }

    private static void generarImagenArbolSintactico(ParseTree tree, Parser parser) {
        try {
            JFrame frame = new JFrame("Árbol Sintáctico");
            JPanel panel = new JPanel();

            TreeViewer viewer = new TreeViewer(Arrays.asList(parser.getRuleNames()), tree);
            viewer.setScale(1.5);

            panel.add(viewer);

            JScrollPane scrollPane = new JScrollPane(panel);
            scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
            scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

            frame.add(scrollPane);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);
            viewer.open();

        } catch (Exception e) {
            System.err.println("\u001B[31m❌ Error al mostrar árbol sintáctico: " + e.getMessage() + "\u001B[0m");
        }
    }

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
