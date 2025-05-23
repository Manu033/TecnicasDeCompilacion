// Generated from com\compilador\MiLenguaje.g4 by ANTLR 4.9.3
package com.compilador;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MiLenguajeParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MiLenguajeVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MiLenguajeParser#programa}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrograma(MiLenguajeParser.ProgramaContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiLenguajeParser#s}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitS(MiLenguajeParser.SContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiLenguajeParser#t}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitT(MiLenguajeParser.TContext ctx);
	/**
	 * Visit a parse tree produced by {@link MiLenguajeParser#e}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitE(MiLenguajeParser.EContext ctx);
}