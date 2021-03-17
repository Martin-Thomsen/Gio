// Generated from C:/Users/Jonas/Documents/GitHub/Gio\SyntaxAnalysis.g4 by ANTLR 4.9.1
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link SyntaxAnalysisParser}.
 */
public interface SyntaxAnalysisListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link SyntaxAnalysisParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(SyntaxAnalysisParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link SyntaxAnalysisParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(SyntaxAnalysisParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link SyntaxAnalysisParser#func}.
	 * @param ctx the parse tree
	 */
	void enterFunc(SyntaxAnalysisParser.FuncContext ctx);
	/**
	 * Exit a parse tree produced by {@link SyntaxAnalysisParser#func}.
	 * @param ctx the parse tree
	 */
	void exitFunc(SyntaxAnalysisParser.FuncContext ctx);
	/**
	 * Enter a parse tree produced by {@link SyntaxAnalysisParser#eventHand}.
	 * @param ctx the parse tree
	 */
	void enterEventHand(SyntaxAnalysisParser.EventHandContext ctx);
	/**
	 * Exit a parse tree produced by {@link SyntaxAnalysisParser#eventHand}.
	 * @param ctx the parse tree
	 */
	void exitEventHand(SyntaxAnalysisParser.EventHandContext ctx);
	/**
	 * Enter a parse tree produced by {@link SyntaxAnalysisParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(SyntaxAnalysisParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link SyntaxAnalysisParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(SyntaxAnalysisParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link SyntaxAnalysisParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(SyntaxAnalysisParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SyntaxAnalysisParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(SyntaxAnalysisParser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SyntaxAnalysisParser#funcCall_Stmt}.
	 * @param ctx the parse tree
	 */
	void enterFuncCall_Stmt(SyntaxAnalysisParser.FuncCall_StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SyntaxAnalysisParser#funcCall_Stmt}.
	 * @param ctx the parse tree
	 */
	void exitFuncCall_Stmt(SyntaxAnalysisParser.FuncCall_StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SyntaxAnalysisParser#incr_Stmt}.
	 * @param ctx the parse tree
	 */
	void enterIncr_Stmt(SyntaxAnalysisParser.Incr_StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SyntaxAnalysisParser#incr_Stmt}.
	 * @param ctx the parse tree
	 */
	void exitIncr_Stmt(SyntaxAnalysisParser.Incr_StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SyntaxAnalysisParser#decr_Stmt}.
	 * @param ctx the parse tree
	 */
	void enterDecr_Stmt(SyntaxAnalysisParser.Decr_StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link SyntaxAnalysisParser#decr_Stmt}.
	 * @param ctx the parse tree
	 */
	void exitDecr_Stmt(SyntaxAnalysisParser.Decr_StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link SyntaxAnalysisParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(SyntaxAnalysisParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link SyntaxAnalysisParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(SyntaxAnalysisParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link SyntaxAnalysisParser#primary}.
	 * @param ctx the parse tree
	 */
	void enterPrimary(SyntaxAnalysisParser.PrimaryContext ctx);
	/**
	 * Exit a parse tree produced by {@link SyntaxAnalysisParser#primary}.
	 * @param ctx the parse tree
	 */
	void exitPrimary(SyntaxAnalysisParser.PrimaryContext ctx);
}