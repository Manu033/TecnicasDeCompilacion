package com.compilador;

import org.antlr.v4.runtime.tree.ErrorNode;
import java.util.*;

public class SimbolosListener extends MiLenguajeBaseListener {

    private TablaSimbolos tablaSimbolos;
    private List<String> errores;
    private List<String> advertencias;
    private List<TablaSimbolos.Simbolo> usados;
    private Set<String> inicializadas;
    private Set<String> constantes;
    private Set<String> imports;
    private String tipoRetornoActual;
    private int mainLinea = -1;

    public SimbolosListener() {
        this.tablaSimbolos = new TablaSimbolos();
        this.errores = new ArrayList<>();
        this.advertencias = new ArrayList<>();
        this.usados = new ArrayList<>();
        this.inicializadas = new HashSet<>();
        this.constantes = new HashSet<>();
        this.imports = new HashSet<>();
        this.tipoRetornoActual = null;
    }

    public TablaSimbolos getTablaSimbolos() { return tablaSimbolos; }
    public List<String> getErrores() { return errores; }
    public List<String> getAdvertencias() {
        advertencias.clear();
        // Variables y parámetros no usados
        for (TablaSimbolos.Simbolo s : tablaSimbolos.getSimbolos()) {
            if ((s.getCategoria().equals("variable") || s.getCategoria().equals("parametro")) && !usados.contains(s)) {
                advertencias.add("[No crítico] '" + s.getNombre() + "' declarado pero no usado");
            }
            if (s.getCategoria().equals("variable") && !inicializadas.contains(s.getNombre())) {
                advertencias.add("[No crítico] Variable '" + s.getNombre() + "' no inicializada");
            }
            if (s.getCategoria().equals("funcion") && !s.getNombre().equals("main") && !usados.contains(s)) {
                advertencias.add("[No crítico] Función '" + s.getNombre() + "' nunca llamada");
            }
        }
        // Imports no usados
        for (String imp : imports) {
            if (!codeReferencesImport(imp)) {
                advertencias.add("[No crítico] Import '" + imp + "' no usado");
            }
        }
        return advertencias;
    }

    private boolean codeReferencesImport(String imp) {
        // TODO: implementar búsqueda en AST
        return false;
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
        if (nombre.equals("main")) mainLinea = linea;

        TablaSimbolos.Simbolo funcion = new TablaSimbolos.Simbolo(
            nombre, tipo, "funcion", linea,
            ctx.ID().getSymbol().getCharPositionInLine(), "global"
        );
        if (!tablaSimbolos.agregar(funcion)) {
            TablaSimbolos.Simbolo previo = tablaSimbolos.buscar(nombre);
            if (!previo.getTipo().equals(tipo)) {
                errores.add("❌ [Crítico] Función '" + nombre + "' redeclarada con tipo diferente (línea " + linea + ")");
            } else {
                errores.add("❌ [Crítico] Función '" + nombre + "' ya declarada (línea " + linea + ")");
            }
        }
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
                    errores.add("❌ [Crítico] Parámetro duplicado '" + nm + "' (línea " + p.ID().getSymbol().getLine() + ")");
                }
                // usados.add(param);
                inicializadas.add(nm);
                funcion.addParametro(tp);
            }
        }
        tablaSimbolos.setAmbito(nombre);
        tipoRetornoActual = tipo;
    }

    @Override
    public void exitDeclaracionFuncion(MiLenguajeParser.DeclaracionFuncionContext ctx) {
        // tablaSimbolos.setAmbito("global");
        // tipoRetornoActual = null;
            String funcName = ctx.ID().getText();
    // Revisa cada parámetro de esta función
    for (TablaSimbolos.Simbolo s : tablaSimbolos.getSimbolos()) {
        if (s.getCategoria().equals("parametro")
            && s.getAmbito().equals(funcName)
            && !usados.contains(s)) {
            advertencias.add(
                "[No crítico] Parámetro '" + s.getNombre() +
                "' nunca usado en función '" + funcName +
                "' (declarado línea " + s.getLinea() + ")"
            );
        }
    }
    tablaSimbolos.setAmbito("global");
    tipoRetornoActual = null;
    }

    @Override
    public void enterDeclaracionVariable(MiLenguajeParser.DeclaracionVariableContext ctx) {
        String nombre = ctx.ID().getText();
        String tipo = ctx.tipo().getText();
        int linea = ctx.ID().getSymbol().getLine();
        TablaSimbolos.Simbolo simbolo = new TablaSimbolos.Simbolo(
            nombre, tipo, "variable", linea,
            ctx.ID().getSymbol().getCharPositionInLine(),
            tablaSimbolos.getAmbito()
        );
        if (!tablaSimbolos.agregar(simbolo)) {
            TablaSimbolos.Simbolo prev = tablaSimbolos.buscar(nombre);
            if (!prev.getTipo().equals(tipo)) {
                errores.add("❌ [Crítico] Variable '" + nombre + "' redeclarada con tipo diferente (línea " + linea + ")");
            } else {
                errores.add("❌ [Crítico] Variable '" + nombre + "' ya declarada (línea " + linea + ")");
            }
        }
        if (ctx.getChildCount() > 2 && "=".equals(ctx.getChild(2).getText())) {
            inicializadas.add(nombre);
        }
    }

    @Override
    public void enterAsignacion(MiLenguajeParser.AsignacionContext ctx) {
        String nombre = ctx.ID().getText();
        int linea = ctx.ID().getSymbol().getLine();
        TablaSimbolos.Simbolo s = tablaSimbolos.buscar(nombre);
        if (s == null) {
            errores.add("❌ [Crítico] Asignación a variable no definida '" + nombre + "' (línea " + linea + ")");
        } else {
            if (constantes.contains(nombre)) {
                errores.add("❌ [Crítico] Reasignación de constante '" + nombre + "' (línea " + linea + ")");
            }
            usados.add(s);
            inicializadas.add(nombre);
            String tipoVar = s.getTipo();
            String tipoExpr = determinarTipoExpresion(ctx.expresion());
            if (!tipoExpr.equals("desconocido") && !tipoVar.equals(tipoExpr)) {
                errores.add("❌ [Crítico] Asignación incompatible: '" + nombre + "' (" + tipoVar + ") = (" + tipoExpr + ") (línea " + linea + ")");
            }
        }
    }

    @Override
    public void enterExpVariable(MiLenguajeParser.ExpVariableContext ctx) {
        String nombre = ctx.ID().getText();
        int linea = ctx.ID().getSymbol().getLine();
        TablaSimbolos.Simbolo s = tablaSimbolos.buscar(nombre);
        if (s == null) {
            errores.add("❌ [Crítico] Identificador '" + nombre + "' no declarado (línea " + linea + ")");
        } else {
        // ** NUEVO: detectar variable no inicializada **
        if (!inicializadas.contains(nombre)) {
            advertencias.add("[No crítico] Variable '" + nombre + "' no inicializada (línea " + linea + ")");
        }
        usados.add(s);
    }
    }

    @Override
    public void enterExpFuncion(MiLenguajeParser.ExpFuncionContext ctx) {
        String nombre = ctx.ID().getText();
        int linea = ctx.ID().getSymbol().getLine();
        TablaSimbolos.Simbolo f = tablaSimbolos.buscar(nombre);
        if (f == null) {
            errores.add("❌ [Crítico] Función '" + nombre + "' no definida (línea " + linea + ")");
        } else {
            if (!f.getCategoria().equals("funcion")) {
                errores.add("❌ [Crítico] '" + nombre + "' no es función (línea " + linea + ")");
                return;
            }
            if (mainLinea > 0 && linea < mainLinea && f.getLinea() > mainLinea) {
                errores.add("❌ [Crítico] Llamada a función '" + nombre + "' antes de main (línea " + linea + ")");
            }
            int recibidos = ctx.argumentos() == null
                   ? 0
                   : ctx.argumentos().expresion().size();
    int esperados = f.getParametros().size();
    if (recibidos != esperados) {
        errores.add("❌ [Crítico] Función '" + nombre +
                   "' espera " + esperados + " args, recibió " + recibidos +
                   " (línea " + linea + ")");
    }
            usados.add(f);
        }
    }

    @Override
    public void enterRetorno(MiLenguajeParser.RetornoContext ctx) {
        int linea = ctx.getStart().getLine();
        if (tipoRetornoActual == null) {
            errores.add("❌ [Crítico] Sentencia return fuera de función (línea " + linea + ")");
            return;
        }
        if (ctx.expresion() == null && !tipoRetornoActual.equals("void")) {
            errores.add("❌ [Crítico] Falta valor de retorno para tipo '" + tipoRetornoActual + "' (línea " + linea + ")");
        } else if (ctx.expresion() != null) {
            String tipoExpr = determinarTipoExpresion(ctx.expresion());
            if (tipoRetornoActual.equals("void")) {
                errores.add("❌ [Crítico] Función void no debe retornar valor (línea " + linea + ")");
            } else if (!tipoRetornoActual.equals(tipoExpr) && !tipoExpr.equals("desconocido")) {
                errores.add("❌ [Crítico] Retorno tipo '" + tipoExpr + "' != '" + tipoRetornoActual + "' (línea " + linea + ")");
            }
        }
    }

    @Override
    public void enterSentenciaWhile(MiLenguajeParser.SentenciaWhileContext ctx) {
        String cond = ctx.expresion().getText();
        if (cond.equals("true") || cond.equals("1")) {
            advertencias.add("[No crítico] Bucle potencialmente infinito (línea " + ctx.getStart().getLine() + ")");
        }
    }

    @Override
    public void visitErrorNode(ErrorNode node) {
        errores.add("Error sintáctico en token: " + node.getText());
    }

    
}
