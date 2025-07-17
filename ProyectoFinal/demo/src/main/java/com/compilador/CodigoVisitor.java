package com.compilador;

import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;
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
    
    /**
     * Obtiene el generador de código
     */
    public GeneradorCodigo getGenerador() {
        return generador;
    }
    
    @Override
    public String visitPrograma(MiLenguajeParser.ProgramaContext ctx) {
        System.out.println("🎯 VISITOR: Iniciando recorrido del programa");
        
        for (MiLenguajeParser.SentenciaContext sentencia : ctx.sentencia()) {
            System.out.println("🎯 VISITOR: Procesando una sentencia...");
            visit(sentencia);
        }
        
        System.out.println("🎯 VISITOR: Programa completado");
        return null;
    }
    
    @Override
    public String visitDeclaracionFuncion(MiLenguajeParser.DeclaracionFuncionContext ctx) {
        String nombreFuncion = ctx.ID().getText();
        System.out.println("🎯 VISITOR: Encontré función -> " + nombreFuncion);
        
        // Generar etiqueta para la función
        generador.genLabel("func_" + nombreFuncion);
        
        // Cambiar ámbito (simulado)
        System.out.println("🎯 VISITOR: Cambiando al ámbito de " + nombreFuncion);
        
        // Procesar el bloque de código
        System.out.println("🎯 VISITOR: Procesando cuerpo de la función...");
        visit(ctx.bloque());
        
        System.out.println("🎯 VISITOR: Función " + nombreFuncion + " completada");
        return null;
    }
    
    @Override
    public String visitBloque(MiLenguajeParser.BloqueContext ctx) {
        System.out.println("🎯 VISITOR: Procesando bloque con " + ctx.sentenciaInterior().size() + " sentencias");
        
        for (MiLenguajeParser.SentenciaInteriorContext sentencia : ctx.sentenciaInterior()) {
            visit(sentencia);
        }
        
        return null;
    }
    
@Override
public String visitAsignacion(MiLenguajeParser.AsignacionContext ctx) {
    String nombre = ctx.ID().getText();

    // ¿Hay índice? (asignación a arreglo)
    if (ctx.getChildCount() > 3 && ctx.getChild(1).getText().equals("[")) {
        // ctx.expresion(0) → índice, ctx.expresion(1) → valor
        String indice = visit(ctx.expresion(0));
        String valor  = visit(ctx.expresion(1));
        System.out.println("🎯 VISITOR: Asignación a arreglo -> " 
                           + nombre + "[" + indice + "] = " + valor);
        generador.genAsignacionArray(nombre, indice, valor);
    } else {
        // asignación normal
        String valor  = visit(ctx.expresion(0));
        System.out.println("🎯 VISITOR: Asignación simple -> " 
                           + nombre + " = " + valor);
        generador.genAsignacion(nombre, valor);
    }
    return null;
}

    
    @Override
    public String visitSentenciaIf(MiLenguajeParser.SentenciaIfContext ctx) {
        System.out.println("🎯 VISITOR: Encontré sentencia IF");
        
        // Evaluar la condición
        System.out.println("🎯 VISITOR: Evaluando condición del IF...");
        String condicion = visit(ctx.expresion());
        
        // Crear etiquetas
        String labelElse = generador.newLabel();
        String labelFin = generador.newLabel();
        
        // Generar salto condicional
        System.out.println("🎯 VISITOR: Si condición es falsa, saltar a " + labelElse);
        generador.genIfFalse(condicion, labelElse);
        
        // Procesar bloque IF
        System.out.println("🎯 VISITOR: Procesando bloque IF...");
        visit(ctx.bloque(0));
        
        // Si hay ELSE
        if (ctx.ELSE() != null) {
            System.out.println("🎯 VISITOR: Hay ELSE, saltando al final...");
            generador.genGoto(labelFin);
            generador.genLabel(labelElse);
            
            System.out.println("🎯 VISITOR: Procesando bloque ELSE...");
            visit(ctx.bloque(1));
            
            generador.genLabel(labelFin);
        } else {
            generador.genLabel(labelElse);
        }
        
        System.out.println("🎯 VISITOR: IF completado");
        return null;
    }
    
@Override
public String visitExpAccesoArreglo(MiLenguajeParser.ExpAccesoArregloContext ctx) {
    String nombre = ctx.ID().getText();
    String indice = visit(ctx.expresion());
    System.out.println("🎯 VISITOR: Expresión arreglo -> " 
                       + nombre + "[" + indice + "]");
    return generador.genLoadArray(nombre, indice);
}

    @Override
    public String visitExpBinaria(MiLenguajeParser.ExpBinariaContext ctx) {
        String operador = ctx.getChild(1).getText();
        System.out.println("🎯 VISITOR: Encontré expresión binaria con operador " + operador);
        
        // Evaluar operando izquierdo
        System.out.println("🎯 VISITOR: Evaluando operando izquierdo...");
        String left  = visit(ctx.expresion(0));
        
        // Evaluar operando derecho
        System.out.println("🎯 VISITOR: Evaluando operando derecho...");
        String right = visit(ctx.expresion(1));
        
        // Generar la operación
        System.out.println("🎯 VISITOR: Generando operación binaria...");
        return generador.genOperacionBinaria(operador, left, right);
    }
    
    @Override
    public String visitExpVariable(MiLenguajeParser.ExpVariableContext ctx) {
        String variable = ctx.ID().getText();
        System.out.println("🎯 VISITOR: Encontré variable -> " + variable);
        return variable;
    }
    
    @Override
    public String visitExpEntero(MiLenguajeParser.ExpEnteroContext ctx) {
        String numero = ctx.INTEGER().getText();
        System.out.println("🎯 VISITOR: Encontré número -> " + numero);
        return numero;
    }
    
    @Override
    public String visitExpParentizada(MiLenguajeParser.ExpParentizadaContext ctx) {
        System.out.println("🎯 VISITOR: Encontré expresión entre paréntesis");
        return visit(ctx.expresion());
    }
   
        @Override
    public String visitExpDecimal(MiLenguajeParser.ExpDecimalContext ctx) {
        return ctx.DECIMAL().getText();
    }

    @Override
    public String visitExpCaracter(MiLenguajeParser.ExpCaracterContext ctx) {
        return ctx.CHARACTER().getText();
    }
    
    @Override
    public String visitExpCadena(MiLenguajeParser.ExpCadenaContext ctx) {
        // Dependiendo de cómo quieras representarlo en tres direcciones...
        // Por simplicidad lo devolvemos tal cual:
        return ctx.STRING_LITERAL().getText();
    }
    
@Override
public String visitExpFuncion(MiLenguajeParser.ExpFuncionContext ctx) {
    // Mismo código que en visitExpLlamada:
    String funcName = ctx.ID().getText();
    List<String> args = new ArrayList<>();
    // Si usas la regla 'argumentos' tendrás que visitarla:
    if (ctx.argumentos() != null) {
        for (MiLenguajeParser.ExpresionContext aCtx : ctx.argumentos().expresion()) {
            args.add(visit(aCtx));
        }
    }
    return generador.genCall(funcName, args);
}


    // Métodos adicionales simplificados
    @Override
    public String visitDeclaracionVariable(MiLenguajeParser.DeclaracionVariableContext ctx) {
        String variable = ctx.ID().getText();
        String tipo = ctx.tipo().getText();
        System.out.println("🎯 VISITOR: Declaración de variable " + tipo + " " + variable);
        // En versión básica, no generamos código para declaraciones
        return null;
    }
    
    @Override
    public String visitRetorno(MiLenguajeParser.RetornoContext ctx) {
        System.out.println("🎯 VISITOR: Encontré return");
        if (ctx.expresion() != null) {
            String valor = visit(ctx.expresion());
            generador.getCodigo().add("return " + valor);
        } else {
            generador.getCodigo().add("return");
        }
        return null;
    }
}
