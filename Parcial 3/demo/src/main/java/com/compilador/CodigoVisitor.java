package com.compilador;

import java.util.ArrayList;
import java.util.List;

public class CodigoVisitor extends MiLenguajeBaseVisitor<String> {
    private GeneradorCodigo generador;
    private TablaSimbolos tabla;

    public CodigoVisitor(TablaSimbolos tabla) {
        this.generador = new GeneradorCodigo();
        this.tabla = tabla;
        System.out.println("🎯 VISITOR: Iniciado con tabla de símbolos");
    }

    public GeneradorCodigo getGenerador() {
        return generador;
    }

    // Comparación: etiqueta en la gramática: #expComparacion
    @Override
    public String visitExpComparacion(MiLenguajeParser.ExpComparacionContext ctx) {
        // Gramática: expresion comparadorBinario expresion
        if (ctx.comparadorBinario() != null) {
            String operador = ctx.comparadorBinario().getText();
            System.out.println("🎯 VISITOR: Encontré comparación -> operador " + operador);
            String left = visit(ctx.expresion(0));
            String right = visit(ctx.expresion(1));
            return generador.genOperacionBinaria(operador, left, right);
        } else {
            // Aunque la etiqueta #expComparacion sugiere que siempre habrá comparadorBinario,
            // si en su gramática permite sin comparador, use solo el sub-nodo:
            // Por seguridad, devolvemos la subexpresión completa:
            return visit(ctx.expresion(0));
        }
    }

    // Operaciones aritméticas/lógicas binaria: etiqueta #expBinaria
    @Override
    public String visitExpBinaria(MiLenguajeParser.ExpBinariaContext ctx) {
        String operador = ctx.getChild(1).getText(); // '+' '-' '*' '/' '%'
        System.out.println("🎯 VISITOR: Encontré expresión binaria con operador " + operador);
        String left = visit(ctx.expresion(0));
        String right = visit(ctx.expresion(1));

        // Chequeo de restas encadenadas
        if ("-".equals(operador)) {
            if (ctx.expresion(1) instanceof MiLenguajeParser.ExpBinariaContext) {
                MiLenguajeParser.ExpBinariaContext child = (MiLenguajeParser.ExpBinariaContext) ctx.expresion(1);
                String subOp = child.getChild(1).getText();
                if ("-".equals(subOp) || "+".equals(subOp)) {
                    System.out.println("⚠️ VISITOR: Precaución en restas encadenadas: (a - b) - c");
                }
            }
        }
        // Chequeo de división por cero
        else if ("/".equals(operador)) {
            if (ctx.expresion(1) instanceof MiLenguajeParser.ExpEnteroContext) {
                String literal = ctx.expresion(0).getText();
                if ("0".equals(literal)) {
                    System.err.println("⚠️ COMPILACIÓN: División por cero detectada: " + left + " / 0");
                }
            } else {
                System.out.println("🎯 VISITOR: Generando chequeo de división por cero en tiempo de ejecución para " + right);
                generador.genCheckDivision(right);
            }
        }

        System.out.println("🎯 VISITOR: Generando operación binaria...");
        return generador.genOperacionBinaria(operador, left, right);
    }

    // Negación lógica: etiqueta #expNegacion en la gramática (NOT expresion)
    @Override
    public String visitExpNegacion(MiLenguajeParser.ExpNegacionContext ctx) {
        System.out.println("🎯 VISITOR: Encontré negación lógica");
        String operand = visit(ctx.expresion());
        return generador.genNegacion(operand);
    }

    // Llamada a función: etiqueta #expFuncion
    @Override
    public String visitExpFuncion(MiLenguajeParser.ExpFuncionContext ctx) {
        String nombre = ctx.ID().getText();
        System.out.println("🎯 VISITOR: Llamada a función -> " + nombre);
        List<String> argsTemps = new ArrayList<>();
        if (ctx.argumentos() != null) {
            for (MiLenguajeParser.ExpresionContext argCtx : ctx.argumentos().expresion()) {
                String t = visit(argCtx);
                argsTemps.add(t);
            }
        }
        // Generar parámetros antes de la llamada
        for (String t : argsTemps) {
            generador.getCodigo().add("param " + t);
        }
        String tempResultado = generador.newTemp();
        generador.getCodigo().add(tempResultado + " = call " + nombre + ", " + argsTemps.size());
        return tempResultado;
    }

    // Entero: #expEntero
    @Override
    public String visitExpEntero(MiLenguajeParser.ExpEnteroContext ctx) {
        String literal = ctx.INTEGER().getText();
        System.out.println("🎯 VISITOR: Encontré número entero -> " + literal);
        String temp = generador.newTemp();
        generador.getCodigo().add(temp + " = " + literal);
        return temp;
    }

    // Variable: #expVariable
    @Override
    public String visitExpVariable(MiLenguajeParser.ExpVariableContext ctx) {
        String variable = ctx.ID().getText();
        System.out.println("🎯 VISITOR: Encontré variable -> " + variable);
        return variable;
    }

    // Decimal: #expDecimal
    @Override
    public String visitExpDecimal(MiLenguajeParser.ExpDecimalContext ctx) {
        String literal = ctx.DECIMAL().getText();
        System.out.println("🎯 VISITOR: Encontré número decimal -> " + literal);
        String temp = generador.newTemp();
        generador.getCodigo().add(temp + " = " + literal);
        return temp;
    }

    // Cadena: #expCadena
    @Override
    public String visitExpCadena(MiLenguajeParser.ExpCadenaContext ctx) {
        String literal = ctx.STRING_LITERAL().getText();
        System.out.println("🎯 VISITOR: Encontré cadena -> " + literal);
        String temp = generador.newTemp();
        generador.getCodigo().add(temp + " = " + literal);
        return temp;
    }

    // Carácter: #expCaracter
    @Override
    public String visitExpCaracter(MiLenguajeParser.ExpCaracterContext ctx) {
        String literal = ctx.CHARACTER().getText();
        System.out.println("🎯 VISITOR: Encontré carácter -> " + literal);
        String temp = generador.newTemp();
        generador.getCodigo().add(temp + " = " + literal);
        return temp;
    }

    // Paréntesis: #expParentizada
    @Override
    public String visitExpParentizada(MiLenguajeParser.ExpParentizadaContext ctx) {
        System.out.println("🎯 VISITOR: Encontré expresión entre paréntesis");
        return visit(ctx.expresion());
    }

    // Si tiene AND/OR en la gramática, puede agregar overrides para #expAnd y #expOr si desea manejo especial:
    @Override
    public String visitExpAnd(MiLenguajeParser.ExpAndContext ctx) {
        // Expresión lógica AND: visit left y right, luego genOperacionBinaria con "&&"
        String left = visit(ctx.expresion(0));
        String right = visit(ctx.expresion(1));
        System.out.println("🎯 VISITOR: Encontré AND lógico");
        return generador.genOperacionBinaria("&&", left, right);
    }
    @Override
    public String visitExpOr(MiLenguajeParser.ExpOrContext ctx) {
        String left = visit(ctx.expresion(0));
        String right = visit(ctx.expresion(1));
        System.out.println("🎯 VISITOR: Encontré OR lógico");
        return generador.genOperacionBinaria("||", left, right);
    }

    // Visit programa, declaraciones, asignaciones, if, etc., como ya tenga implementados.
    @Override
    public String visitPrograma(MiLenguajeParser.ProgramaContext ctx) {
        System.out.println("🎯 VISITOR: Iniciando recorrido del programa");
        for (MiLenguajeParser.SentenciaContext s : ctx.sentencia()) {
            visit(s);
        }
        System.out.println("🎯 VISITOR: Programa completado");
        return null;
    }

    @Override
    public String visitAsignacion(MiLenguajeParser.AsignacionContext ctx) {
        String variable = ctx.ID().getText();
        System.out.println("🎯 VISITOR: Encontré asignación -> " + variable);
        String resultado = visit(ctx.expresion());
        System.out.println("🎯 VISITOR: Generando asignación final...");
        generador.genAsignacion(variable, resultado);
        return null;
    }

    @Override
    public String visitDeclaracionVariable(MiLenguajeParser.DeclaracionVariableContext ctx) {
        String variable = ctx.ID().getText();
        String tipo = ctx.tipo().getText();
        System.out.println("🎯 VISITOR: Declaración de variable " + tipo + " " + variable);
        if (ctx.expresion() != null) {
            String exprTemp = visit(ctx.expresion());
            generador.genAsignacion(variable, exprTemp);
        }
        return null;
    }

    @Override
    public String visitSentenciaIf(MiLenguajeParser.SentenciaIfContext ctx) {
        System.out.println("🎯 VISITOR: Encontré sentencia IF");
        String condicionTemp = visit(ctx.expresion());
        String labelElse = generador.newLabel();
        String labelFin = generador.newLabel();
        generador.genIfFalse(condicionTemp, labelElse);
        visit(ctx.bloque(0));
        if (ctx.ELSE() != null) {
            generador.genGoto(labelFin);
            generador.genLabel(labelElse);
            visit(ctx.bloque(1));
            generador.genLabel(labelFin);
        } else {
            generador.genLabel(labelElse);
        }
        System.out.println("🎯 VISITOR: IF completado");
        return null;
    }

    // ... demás overrides (visitDeclaracionFuncion, visitBloque, visitRetorno, etc.) ...
}
