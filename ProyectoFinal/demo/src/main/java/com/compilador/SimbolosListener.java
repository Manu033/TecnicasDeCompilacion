// package com.compilador;

// import org.antlr.v4.runtime.tree.ErrorNode;
// import java.util.*;

// public class SimbolosListener extends MiLenguajeBaseListener {

//     private TablaSimbolos tablaSimbolos;
//     private List<String> errores;
//     private List<TablaSimbolos.Simbolo> usados;
//     private Set<String> inicializadas;
//     private String tipoRetornoActual;

//     public SimbolosListener() {
//         this.tablaSimbolos = new TablaSimbolos();
//         this.errores = new ArrayList<>();
//         this.usados = new ArrayList<>();
//         this.inicializadas = new HashSet<>();
//         this.tipoRetornoActual = null;
//     }

//     public TablaSimbolos getTablaSimbolos() {
//         return tablaSimbolos;
//     }

//     public List<String> getErrores() {
//         return errores;
//     }

//     public List<String> obtenerAdvertenciasNoCriticas() {
//         List<String> advertencias = new ArrayList<>();
//         for (TablaSimbolos.Simbolo s : tablaSimbolos.getSimbolos()) {
//             if (!usados.contains(s)) {
//                 if (s.getCategoria().equals("variable") || s.getCategoria().equals("parametro")) {
//                     advertencias.add("⚠️ [No crítico] '" + s.getNombre() + "' declarado pero no usado (" + s.getCategoria() + ")");
//                 }
//                 if (s.getCategoria().equals("funcion") && !s.getNombre().equals("main") && !usados.contains(s)) {
//                     advertencias.add("⚠️ [No crítico] Función '" + s.getNombre() + "' nunca llamada");
//                 }
//             }
//             if (s.getCategoria().equals("variable") && !inicializadas.contains(s.getNombre())) {
//                 advertencias.add("⚠️ [No crítico] Variable '" + s.getNombre() + "' no inicializada");
//             }
//         }
//         return advertencias;
//     }

//     private String determinarTipoExpresion(MiLenguajeParser.ExpresionContext ctx) {
//         if (ctx instanceof MiLenguajeParser.ExpEnteroContext) {
//             return "int";
//         } else if (ctx instanceof MiLenguajeParser.ExpDecimalContext) {
//             return "double";
//         } else if (ctx instanceof MiLenguajeParser.ExpCaracterContext) {
//             return "char";
//         } else if (ctx instanceof MiLenguajeParser.ExpCadenaContext) {
//             return "String";
//         } else if (ctx instanceof MiLenguajeParser.ExpVariableContext) {
//             String nombre = ((MiLenguajeParser.ExpVariableContext) ctx).ID().getText();
//             TablaSimbolos.Simbolo s = tablaSimbolos.buscar(nombre);
//             return s != null ? s.getTipo() : "desconocido";
//         } else if (ctx instanceof MiLenguajeParser.ExpFuncionContext) {
//             String nombre = ((MiLenguajeParser.ExpFuncionContext) ctx).ID().getText();
//             TablaSimbolos.Simbolo s = tablaSimbolos.buscar(nombre);
//             return s != null ? s.getTipo() : "desconocido";
//         }
//         return "desconocido";
//     }

//     @Override
//     public void enterDeclaracionFuncion(MiLenguajeParser.DeclaracionFuncionContext ctx) {
//         String nombre = ctx.ID().getText();
//         String tipo = ctx.tipo().getText();
//         int linea = ctx.ID().getSymbol().getLine();
//         int columna = ctx.ID().getSymbol().getCharPositionInLine();

//         TablaSimbolos.Simbolo simbolo = new TablaSimbolos.Simbolo(nombre, tipo, "funcion", linea, columna, "global");

//         if (ctx.parametros() != null) {
//             for (MiLenguajeParser.ParametroContext paramCtx : ctx.parametros().parametro()) {
//                 String tipoParam = paramCtx.tipo().getText();
//                 String nombreParam = paramCtx.ID().getText();

//                 simbolo.addParametro(tipoParam);

//                 TablaSimbolos.Simbolo paramSimbolo = new TablaSimbolos.Simbolo(nombreParam, tipoParam, "parametro", paramCtx.ID().getSymbol().getLine(), paramCtx.ID().getSymbol().getCharPositionInLine(), nombre);

//                 if (!tablaSimbolos.agregar(paramSimbolo)) {
//                     errores.add("Error semántico en línea " + paramCtx.ID().getSymbol().getLine() + ": Parámetro duplicado '" + nombreParam + "'");
//                 }
//             }
//         }

//         if (!tablaSimbolos.agregar(simbolo)) {
//             errores.add("Error semántico en línea " + linea + ": Función '" + nombre + "' ya declarada");
//         }

//         tablaSimbolos.setAmbito(nombre);
//         tipoRetornoActual = tipo;
//     }

//     @Override
//     public void exitDeclaracionFuncion(MiLenguajeParser.DeclaracionFuncionContext ctx) {
//         tablaSimbolos.setAmbito("global");
//         tipoRetornoActual = null;
//     }

//     @Override
//     public void enterDeclaracionVariable(MiLenguajeParser.DeclaracionVariableContext ctx) {
//         String nombre = ctx.ID().getText();
//         String tipo = ctx.tipo().getText();
//         int linea = ctx.ID().getSymbol().getLine();
//         int columna = ctx.ID().getSymbol().getCharPositionInLine();

//         TablaSimbolos.Simbolo simbolo = new TablaSimbolos.Simbolo(nombre, tipo, "variable", linea, columna, tablaSimbolos.getAmbito());

//         if (!tablaSimbolos.agregar(simbolo)) {
//             errores.add("Error semántico en línea " + linea + ": Variable '" + nombre + "' ya declarada en este ámbito");
//         }
//     }

//     @Override
//     public void enterAsignacion(MiLenguajeParser.AsignacionContext ctx) {
//         String nombre = ctx.ID().getText();
//         int linea = ctx.ID().getSymbol().getLine();

//         TablaSimbolos.Simbolo simbolo = tablaSimbolos.buscar(nombre);
//         if (simbolo == null) {
//             errores.add("❌ [Crítico] Variable '" + nombre + "' no declarada (línea " + linea + ")");
//         } else {
//             if (!usados.contains(simbolo)) usados.add(simbolo);
//             inicializadas.add(nombre);

//             String tipoVar = simbolo.getTipo();
//             String tipoExpr = determinarTipoExpresion(ctx.expresion());

//             if (!tipoExpr.equals("desconocido") && !tipoVar.equals(tipoExpr)) {
//                 errores.add("❌ [Crítico] Asignación incompatible: variable '" + nombre + "' es de tipo '" + tipoVar + "' pero se le asigna un '" + tipoExpr + "' (línea " + linea + ")");
//             }
//         }
//     }

//     @Override
//     public void enterExpVariable(MiLenguajeParser.ExpVariableContext ctx) {
//         String nombre = ctx.ID().getText();
//         int linea = ctx.ID().getSymbol().getLine();

//         TablaSimbolos.Simbolo simbolo = tablaSimbolos.buscar(nombre);
//         if (simbolo == null) {
//             errores.add("❌ [Crítico] Identificador '" + nombre + "' no declarado (línea " + linea + ")");
//         } else {
//             if (!usados.contains(simbolo)) usados.add(simbolo);
//         }
//     }

//     @Override
//     public void enterExpFuncion(MiLenguajeParser.ExpFuncionContext ctx) {
//         String nombre = ctx.ID().getText();
//         int linea = ctx.ID().getSymbol().getLine();

//         TablaSimbolos.Simbolo simbolo = tablaSimbolos.buscar(nombre);
//         if (simbolo == null) {
//             errores.add("❌ [Crítico] Función '" + nombre + "' no declarada (línea " + linea + ")");
//         } else {
//             if (!simbolo.getCategoria().equals("funcion")) {
//                 errores.add("❌ [Crítico] '" + nombre + "' no es una función (línea " + linea + ")");
//                 return;
//             }

//             if (linea < simbolo.getLinea()) {
//                 errores.add("❌ [Crítico] Llamada a función '" + nombre + "' antes de su declaración (declarada en línea " + simbolo.getLinea() + ")");
//             }

//             int recibidos = ctx.argumentos() == null ? 0 : ctx.argumentos().expresion().size();
//             int esperados = simbolo.getParametros().size();
//             if (recibidos != esperados) {
//                 errores.add("❌ [Crítico] Función '" + nombre + "' espera " + esperados + " argumentos, pero recibió " + recibidos + " (línea " + linea + ")");
//             }

//             if (!usados.contains(simbolo)) usados.add(simbolo);
//         }
//     }

//     @Override
//     public void enterRetorno(MiLenguajeParser.RetornoContext ctx) {
//         if (tipoRetornoActual == null) {
//             errores.add("Error semántico en línea " + ctx.getStart().getLine() + ": Sentencia return fuera de una función");
//             return;
//         }

//         if (tipoRetornoActual.equals("void") && ctx.expresion() != null) {
//             errores.add("Error semántico en línea " + ctx.getStart().getLine() + ": Las funciones void no deben retornar valores");
//         }

//         if (!tipoRetornoActual.equals("void") && ctx.expresion() == null) {
//             errores.add("Error semántico en línea " + ctx.getStart().getLine() + ": Falta valor de retorno para tipo '" + tipoRetornoActual + "'");
//         }
//     }

//     @Override
//     public void enterSentenciaWhile(MiLenguajeParser.SentenciaWhileContext ctx) {
//         String condicion = ctx.expresion().getText();
//         if (condicion.equals("true") || condicion.equals("1")) {
//             errores.add("⚠️ [No crítico] Bucle potencialmente infinito detectado en línea " + ctx.getStart().getLine());
//         }
//     }

//     @Override
//     public void visitErrorNode(ErrorNode node) {
//         errores.add("Error sintáctico en token: " + node.getText());
//     }
// } 


package com.compilador;

import org.antlr.v4.runtime.tree.ErrorNode;
import java.util.*;

public class SimbolosListener extends MiLenguajeBaseListener {

    private TablaSimbolos tablaSimbolos;
    private List<String> errores;
    private List<TablaSimbolos.Simbolo> usados;
    private Set<String> inicializadas;
    private String tipoRetornoActual;

    public SimbolosListener() {
        this.tablaSimbolos = new TablaSimbolos();
        this.errores = new ArrayList<>();
        this.usados = new ArrayList<>();
        this.inicializadas = new HashSet<>();
        this.tipoRetornoActual = null;
    }

    public TablaSimbolos getTablaSimbolos() {
        return tablaSimbolos;
    }

    public List<String> getErrores() {
        return errores;
    }

    public List<String> obtenerAdvertenciasNoCriticas() {
        List<String> advertencias = new ArrayList<>();
        for (TablaSimbolos.Simbolo s : tablaSimbolos.getSimbolos()) {
            // 1) Declarado pero no usado
            if (s.getCategoria().equals("variable") || s.getCategoria().equals("parametro")) {
                if (!usados.contains(s)) {
                    advertencias.add("[No crítico] '" + s.getNombre() + "' declarado pero no usado (" + s.getCategoria() + ")");
                }
            }
            // 2) Variable no inicializada
            if (s.getCategoria().equals("variable") && !inicializadas.contains(s.getNombre())) {
                advertencias.add("[No crítico] Variable '" + s.getNombre() + "' no inicializada");
            }
            // 3) Funciones no invocadas
            if (s.getCategoria().equals("funcion") && !s.getNombre().equals("main") && !usados.contains(s)) {
                advertencias.add("[No crítico] Función '" + s.getNombre() + "' nunca llamada");
            }
        }
        return advertencias;
    }

    private String determinarTipoExpresion(MiLenguajeParser.ExpresionContext ctx) {
        if (ctx instanceof MiLenguajeParser.ExpEnteroContext) {
            return "int";
        } else if (ctx instanceof MiLenguajeParser.ExpDecimalContext) {
            return "double";
        } else if (ctx instanceof MiLenguajeParser.ExpCaracterContext) {
            return "char";
        } else if (ctx instanceof MiLenguajeParser.ExpCadenaContext) {
            return "String";
        } else if (ctx instanceof MiLenguajeParser.ExpVariableContext) {
            String nombre = ((MiLenguajeParser.ExpVariableContext) ctx).ID().getText();
            TablaSimbolos.Simbolo s = tablaSimbolos.buscar(nombre);
            return s != null ? s.getTipo() : "desconocido";
        } else if (ctx instanceof MiLenguajeParser.ExpFuncionContext) {
            String nombre = ((MiLenguajeParser.ExpFuncionContext) ctx).ID().getText();
            TablaSimbolos.Simbolo s = tablaSimbolos.buscar(nombre);
            return s != null ? s.getTipo() : "desconocido";
        }
        return "desconocido";
    }

    @Override
    public void enterDeclaracionFuncion(MiLenguajeParser.DeclaracionFuncionContext ctx) {
        String nombre = ctx.ID().getText();
        String tipo = ctx.tipo().getText();
        int linea = ctx.ID().getSymbol().getLine();
        int columna = ctx.ID().getSymbol().getCharPositionInLine();

        // Agrego la función como símbolo
        TablaSimbolos.Simbolo funcion = new TablaSimbolos.Simbolo(
            nombre, tipo, "funcion", linea, columna, "global"
        );
        if (!tablaSimbolos.agregar(funcion)) {
            errores.add("Error semántico en línea " + linea + ": Función '" + nombre + "' ya declarada");
        }

        // Parámetros → también son símbolos, y se consideran inicializados
        if (ctx.parametros() != null) {
            for (MiLenguajeParser.ParametroContext p : ctx.parametros().parametro()) {
                String tp = p.tipo().getText();
                String nm = p.ID().getText();
                TablaSimbolos.Simbolo param = new TablaSimbolos.Simbolo(
                    nm, tp, "parametro", 
                    p.ID().getSymbol().getLine(),
                    p.ID().getSymbol().getCharPositionInLine(),
                    nombre
                );
                if (!tablaSimbolos.agregar(param)) {
                    errores.add("Error semántico en línea " + 
                        p.ID().getSymbol().getLine() + ": Parámetro duplicado '" + nm + "'");
                } else {
                    // marco el parámetro como inicializado
                    inicializadas.add(nm);
                }
                funcion.addParametro(tp);
            }
        }

        tablaSimbolos.setAmbito(nombre);
        tipoRetornoActual = tipo;
    }

    @Override
    public void exitDeclaracionFuncion(MiLenguajeParser.DeclaracionFuncionContext ctx) {
        tablaSimbolos.setAmbito("global");
        tipoRetornoActual = null;
    }

    @Override
    public void enterDeclaracionVariable(MiLenguajeParser.DeclaracionVariableContext ctx) {
        String nombre = ctx.ID().getText();
        String tipo = ctx.tipo().getText();
        int linea = ctx.ID().getSymbol().getLine();
        int columna = ctx.ID().getSymbol().getCharPositionInLine();

        TablaSimbolos.Simbolo simbolo = new TablaSimbolos.Simbolo(
            nombre, tipo, "variable", linea, columna, tablaSimbolos.getAmbito()
        );
        if (!tablaSimbolos.agregar(simbolo)) {
            errores.add("Error semántico en línea " + linea + ": Variable '" + nombre + "' ya declarada en este ámbito");
        }

        // ——— Detecto si la declaración incluye inicializador:
        // (p. ej. int x = expr;)
        if (ctx.getChildCount() > 2 && ctx.getChild(2).getText().equals("=")) {
            inicializadas.add(nombre);
        }
    }

    @Override
    public void enterAsignacion(MiLenguajeParser.AsignacionContext ctx) {
        String nombre = ctx.ID().getText();
        int linea = ctx.ID().getSymbol().getLine();

        TablaSimbolos.Simbolo simbolo = tablaSimbolos.buscar(nombre);
        if (simbolo == null) {
            errores.add("❌ [Crítico] Variable '" + nombre + "' no declarada (línea " + linea + ")");
        } else {
            usados.add(siNoContiene(usados, simbolo));
            inicializadas.add(nombre);

            String tipoVar  = simbolo.getTipo();
            String tipoExpr = determinarTipoExpresion(ctx.expresion());
            if (!tipoExpr.equals("desconocido") && !tipoVar.equals(tipoExpr)) {
                errores.add("❌ [Crítico] Asignación incompatible: '" + nombre +
                    "' es '" + tipoVar + "' pero se le asigna '" + tipoExpr +
                    "' (línea " + linea + ")");
            }
        }
    }

    @Override
    public void enterExpVariable(MiLenguajeParser.ExpVariableContext ctx) {
        String nombre = ctx.ID().getText();
        int linea = ctx.ID().getSymbol().getLine();

        TablaSimbolos.Simbolo simbolo = tablaSimbolos.buscar(nombre);
        if (simbolo == null) {
            errores.add("❌ [Crítico] Identificador '" + nombre + "' no declarado (línea " + linea + ")");
        } else {
            usados.add(siNoContiene(usados, simbolo));
        }
    }

    @Override
    public void enterExpFuncion(MiLenguajeParser.ExpFuncionContext ctx) {
        String nombre = ctx.ID().getText();
        int linea = ctx.ID().getSymbol().getLine();

        TablaSimbolos.Simbolo simbolo = tablaSimbolos.buscar(nombre);
        if (simbolo == null) {
            errores.add("❌ [Crítico] Función '" + nombre + "' no declarada (línea " + linea + ")");
        } else {
            if (!simbolo.getCategoria().equals("funcion")) {
                errores.add("❌ [Crítico] '" + nombre + "' no es una función (línea " + linea + ")");
                return;
            }
            // ... verificaciones de número de parámetros ...
            usados.add(siNoContiene(usados, simbolo));
        }
    }

    @Override
    public void enterRetorno(MiLenguajeParser.RetornoContext ctx) {
        if (tipoRetornoActual == null) {
            errores.add("Error semántico en línea " + ctx.getStart().getLine() + ": return fuera de función");
            return;
        }
        // ... validación de tipos de retorno ...
    }

    @Override
    public void enterSentenciaWhile(MiLenguajeParser.SentenciaWhileContext ctx) {
        String c = ctx.expresion().getText();
        if (c.equals("true") || c.equals("1")) {
            errores.add("[No crítico] Bucle potencialmente infinito en línea " + ctx.getStart().getLine());
        }
    }

    @Override
    public void visitErrorNode(ErrorNode node) {
        errores.add("Error sintáctico en token: " + node.getText());
    }

    /**
     * Añade un símbolo a la lista si no existe ya (evita duplicados en 'usados').
     */
    private TablaSimbolos.Simbolo siNoContiene(List<TablaSimbolos.Simbolo> lista,
                                              TablaSimbolos.Simbolo s) {
        return lista.contains(s) ? s : (lista.add(s) ? s : null);
    }
}
