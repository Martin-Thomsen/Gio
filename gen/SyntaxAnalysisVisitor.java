// Generated from C:/Users/Jonas/Documents/GitHub/Gio\SyntaxAnalysis.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SyntaxAnalysisParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SyntaxAnalysisVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SyntaxAnalysisParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(SyntaxAnalysisParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link SyntaxAnalysisParser#func}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc(SyntaxAnalysisParser.FuncContext ctx);
	/**
	 * Visit a parse tree produced by {@link SyntaxAnalysisParser#eventHand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEventHand(SyntaxAnalysisParser.EventHandContext ctx);
	/**
	 * Visit a parse tree produced by {@link SyntaxAnalysisParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(SyntaxAnalysisParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link SyntaxAnalysisParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(SyntaxAnalysisParser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SyntaxAnalysisParser#funcCall_Stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncCall_Stmt(SyntaxAnalysisParser.FuncCall_StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SyntaxAnalysisParser#incr_Stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIncr_Stmt(SyntaxAnalysisParser.Incr_StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SyntaxAnalysisParser#decr_Stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecr_Stmt(SyntaxAnalysisParser.Decr_StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link SyntaxAnalysisParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(SyntaxAnalysisParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link SyntaxAnalysisParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimary(SyntaxAnalysisParser.PrimaryContext ctx);
}