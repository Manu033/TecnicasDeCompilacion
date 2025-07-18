// Generated from com\compilador\MiLenguaje.g4 by ANTLR 4.9.3
package com.compilador;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MiLenguajeParser}.
 */
public interface MiLenguajeListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MiLenguajeParser#programa}.
	 * @param ctx the parse tree
	 */
	void enterPrograma(MiLenguajeParser.ProgramaContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiLenguajeParser#programa}.
	 * @param ctx the parse tree
	 */
	void exitPrograma(MiLenguajeParser.ProgramaContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiLenguajeParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void enterSentencia(MiLenguajeParser.SentenciaContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiLenguajeParser#sentencia}.
	 * @param ctx the parse tree
	 */
	void exitSentencia(MiLenguajeParser.SentenciaContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiLenguajeParser#sentenciaInterior}.
	 * @param ctx the parse tree
	 */
	void enterSentenciaInterior(MiLenguajeParser.SentenciaInteriorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiLenguajeParser#sentenciaInterior}.
	 * @param ctx the parse tree
	 */
	void exitSentenciaInterior(MiLenguajeParser.SentenciaInteriorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiLenguajeParser#sentenciaBreak}.
	 * @param ctx the parse tree
	 */
	void enterSentenciaBreak(MiLenguajeParser.SentenciaBreakContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiLenguajeParser#sentenciaBreak}.
	 * @param ctx the parse tree
	 */
	void exitSentenciaBreak(MiLenguajeParser.SentenciaBreakContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiLenguajeParser#sentenciaContinue}.
	 * @param ctx the parse tree
	 */
	void enterSentenciaContinue(MiLenguajeParser.SentenciaContinueContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiLenguajeParser#sentenciaContinue}.
	 * @param ctx the parse tree
	 */
	void exitSentenciaContinue(MiLenguajeParser.SentenciaContinueContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiLenguajeParser#sentenciaIf}.
	 * @param ctx the parse tree
	 */
	void enterSentenciaIf(MiLenguajeParser.SentenciaIfContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiLenguajeParser#sentenciaIf}.
	 * @param ctx the parse tree
	 */
	void exitSentenciaIf(MiLenguajeParser.SentenciaIfContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiLenguajeParser#bloque}.
	 * @param ctx the parse tree
	 */
	void enterBloque(MiLenguajeParser.BloqueContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiLenguajeParser#bloque}.
	 * @param ctx the parse tree
	 */
	void exitBloque(MiLenguajeParser.BloqueContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiLenguajeParser#declaracionFuncion}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracionFuncion(MiLenguajeParser.DeclaracionFuncionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiLenguajeParser#declaracionFuncion}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracionFuncion(MiLenguajeParser.DeclaracionFuncionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiLenguajeParser#sentenciaWhile}.
	 * @param ctx the parse tree
	 */
	void enterSentenciaWhile(MiLenguajeParser.SentenciaWhileContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiLenguajeParser#sentenciaWhile}.
	 * @param ctx the parse tree
	 */
	void exitSentenciaWhile(MiLenguajeParser.SentenciaWhileContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiLenguajeParser#sentenciaFor}.
	 * @param ctx the parse tree
	 */
	void enterSentenciaFor(MiLenguajeParser.SentenciaForContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiLenguajeParser#sentenciaFor}.
	 * @param ctx the parse tree
	 */
	void exitSentenciaFor(MiLenguajeParser.SentenciaForContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiLenguajeParser#parametros}.
	 * @param ctx the parse tree
	 */
	void enterParametros(MiLenguajeParser.ParametrosContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiLenguajeParser#parametros}.
	 * @param ctx the parse tree
	 */
	void exitParametros(MiLenguajeParser.ParametrosContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiLenguajeParser#parametro}.
	 * @param ctx the parse tree
	 */
	void enterParametro(MiLenguajeParser.ParametroContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiLenguajeParser#parametro}.
	 * @param ctx the parse tree
	 */
	void exitParametro(MiLenguajeParser.ParametroContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiLenguajeParser#declaracionVariable}.
	 * @param ctx the parse tree
	 */
	void enterDeclaracionVariable(MiLenguajeParser.DeclaracionVariableContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiLenguajeParser#declaracionVariable}.
	 * @param ctx the parse tree
	 */
	void exitDeclaracionVariable(MiLenguajeParser.DeclaracionVariableContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiLenguajeParser#asignacion}.
	 * @param ctx the parse tree
	 */
	void enterAsignacion(MiLenguajeParser.AsignacionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiLenguajeParser#asignacion}.
	 * @param ctx the parse tree
	 */
	void exitAsignacion(MiLenguajeParser.AsignacionContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiLenguajeParser#retorno}.
	 * @param ctx the parse tree
	 */
	void enterRetorno(MiLenguajeParser.RetornoContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiLenguajeParser#retorno}.
	 * @param ctx the parse tree
	 */
	void exitRetorno(MiLenguajeParser.RetornoContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiLenguajeParser#tipo}.
	 * @param ctx the parse tree
	 */
	void enterTipo(MiLenguajeParser.TipoContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiLenguajeParser#tipo}.
	 * @param ctx the parse tree
	 */
	void exitTipo(MiLenguajeParser.TipoContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expComparacion}
	 * labeled alternative in {@link MiLenguajeParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExpComparacion(MiLenguajeParser.ExpComparacionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expComparacion}
	 * labeled alternative in {@link MiLenguajeParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExpComparacion(MiLenguajeParser.ExpComparacionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expNegacion}
	 * labeled alternative in {@link MiLenguajeParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExpNegacion(MiLenguajeParser.ExpNegacionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expNegacion}
	 * labeled alternative in {@link MiLenguajeParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExpNegacion(MiLenguajeParser.ExpNegacionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expDecimal}
	 * labeled alternative in {@link MiLenguajeParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExpDecimal(MiLenguajeParser.ExpDecimalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expDecimal}
	 * labeled alternative in {@link MiLenguajeParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExpDecimal(MiLenguajeParser.ExpDecimalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expBinaria}
	 * labeled alternative in {@link MiLenguajeParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExpBinaria(MiLenguajeParser.ExpBinariaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expBinaria}
	 * labeled alternative in {@link MiLenguajeParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExpBinaria(MiLenguajeParser.ExpBinariaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExpLlamada}
	 * labeled alternative in {@link MiLenguajeParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExpLlamada(MiLenguajeParser.ExpLlamadaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExpLlamada}
	 * labeled alternative in {@link MiLenguajeParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExpLlamada(MiLenguajeParser.ExpLlamadaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expOr}
	 * labeled alternative in {@link MiLenguajeParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExpOr(MiLenguajeParser.ExpOrContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expOr}
	 * labeled alternative in {@link MiLenguajeParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExpOr(MiLenguajeParser.ExpOrContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expAccesoArreglo}
	 * labeled alternative in {@link MiLenguajeParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExpAccesoArreglo(MiLenguajeParser.ExpAccesoArregloContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expAccesoArreglo}
	 * labeled alternative in {@link MiLenguajeParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExpAccesoArreglo(MiLenguajeParser.ExpAccesoArregloContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expFuncion}
	 * labeled alternative in {@link MiLenguajeParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExpFuncion(MiLenguajeParser.ExpFuncionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expFuncion}
	 * labeled alternative in {@link MiLenguajeParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExpFuncion(MiLenguajeParser.ExpFuncionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expVariable}
	 * labeled alternative in {@link MiLenguajeParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExpVariable(MiLenguajeParser.ExpVariableContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expVariable}
	 * labeled alternative in {@link MiLenguajeParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExpVariable(MiLenguajeParser.ExpVariableContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expCadena}
	 * labeled alternative in {@link MiLenguajeParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExpCadena(MiLenguajeParser.ExpCadenaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expCadena}
	 * labeled alternative in {@link MiLenguajeParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExpCadena(MiLenguajeParser.ExpCadenaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expAnd}
	 * labeled alternative in {@link MiLenguajeParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExpAnd(MiLenguajeParser.ExpAndContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expAnd}
	 * labeled alternative in {@link MiLenguajeParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExpAnd(MiLenguajeParser.ExpAndContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expParentizada}
	 * labeled alternative in {@link MiLenguajeParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExpParentizada(MiLenguajeParser.ExpParentizadaContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expParentizada}
	 * labeled alternative in {@link MiLenguajeParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExpParentizada(MiLenguajeParser.ExpParentizadaContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expCaracter}
	 * labeled alternative in {@link MiLenguajeParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExpCaracter(MiLenguajeParser.ExpCaracterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expCaracter}
	 * labeled alternative in {@link MiLenguajeParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExpCaracter(MiLenguajeParser.ExpCaracterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code expEntero}
	 * labeled alternative in {@link MiLenguajeParser#expresion}.
	 * @param ctx the parse tree
	 */
	void enterExpEntero(MiLenguajeParser.ExpEnteroContext ctx);
	/**
	 * Exit a parse tree produced by the {@code expEntero}
	 * labeled alternative in {@link MiLenguajeParser#expresion}.
	 * @param ctx the parse tree
	 */
	void exitExpEntero(MiLenguajeParser.ExpEnteroContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiLenguajeParser#argumentos}.
	 * @param ctx the parse tree
	 */
	void enterArgumentos(MiLenguajeParser.ArgumentosContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiLenguajeParser#argumentos}.
	 * @param ctx the parse tree
	 */
	void exitArgumentos(MiLenguajeParser.ArgumentosContext ctx);
	/**
	 * Enter a parse tree produced by {@link MiLenguajeParser#comparadorBinario}.
	 * @param ctx the parse tree
	 */
	void enterComparadorBinario(MiLenguajeParser.ComparadorBinarioContext ctx);
	/**
	 * Exit a parse tree produced by {@link MiLenguajeParser#comparadorBinario}.
	 * @param ctx the parse tree
	 */
	void exitComparadorBinario(MiLenguajeParser.ComparadorBinarioContext ctx);
}