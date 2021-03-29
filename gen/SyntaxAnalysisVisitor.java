// Generated from C:/Users/m-s-t/Documents/GitHub/Gio\SyntaxAnalysis.g4 by ANTLR 4.9.1
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
	 * Visit a parse tree produced by the {@code function}
	 * labeled alternative in {@link SyntaxAnalysisParser#func}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunction(SyntaxAnalysisParser.FunctionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code when}
	 * labeled alternative in {@link SyntaxAnalysisParser#eventHand}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhen(SyntaxAnalysisParser.WhenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code blk}
	 * labeled alternative in {@link SyntaxAnalysisParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlk(SyntaxAnalysisParser.BlkContext ctx);
	/**
	 * Visit a parse tree produced by the {@code if}
	 * labeled alternative in {@link SyntaxAnalysisParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIf(SyntaxAnalysisParser.IfContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rep}
	 * labeled alternative in {@link SyntaxAnalysisParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRep(SyntaxAnalysisParser.RepContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rep_if}
	 * labeled alternative in {@link SyntaxAnalysisParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRep_if(SyntaxAnalysisParser.Rep_ifContext ctx);
	/**
	 * Visit a parse tree produced by the {@code rep_until}
	 * labeled alternative in {@link SyntaxAnalysisParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRep_until(SyntaxAnalysisParser.Rep_untilContext ctx);
	/**
	 * Visit a parse tree produced by the {@code func_stmt}
	 * labeled alternative in {@link SyntaxAnalysisParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc_stmt(SyntaxAnalysisParser.Func_stmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code assign}
	 * labeled alternative in {@link SyntaxAnalysisParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign(SyntaxAnalysisParser.AssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code incr}
	 * labeled alternative in {@link SyntaxAnalysisParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIncr(SyntaxAnalysisParser.IncrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code decr}
	 * labeled alternative in {@link SyntaxAnalysisParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecr(SyntaxAnalysisParser.DecrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pre_incr}
	 * labeled alternative in {@link SyntaxAnalysisParser#incr_Stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPre_incr(SyntaxAnalysisParser.Pre_incrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code post_incr}
	 * labeled alternative in {@link SyntaxAnalysisParser#incr_Stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPost_incr(SyntaxAnalysisParser.Post_incrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pre_decr}
	 * labeled alternative in {@link SyntaxAnalysisParser#decr_Stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPre_decr(SyntaxAnalysisParser.Pre_decrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code post_decr}
	 * labeled alternative in {@link SyntaxAnalysisParser#decr_Stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPost_decr(SyntaxAnalysisParser.Post_decrContext ctx);
	/**
	 * Visit a parse tree produced by the {@code returnStmt}
	 * labeled alternative in {@link SyntaxAnalysisParser#return_Stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnStmt(SyntaxAnalysisParser.ReturnStmtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code logical_or}
	 * labeled alternative in {@link SyntaxAnalysisParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogical_or(SyntaxAnalysisParser.Logical_orContext ctx);
	/**
	 * Visit a parse tree produced by the {@code prim}
	 * labeled alternative in {@link SyntaxAnalysisParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrim(SyntaxAnalysisParser.PrimContext ctx);
	/**
	 * Visit a parse tree produced by the {@code le_ge_lt_gt}
	 * labeled alternative in {@link SyntaxAnalysisParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLe_ge_lt_gt(SyntaxAnalysisParser.Le_ge_lt_gtContext ctx);
	/**
	 * Visit a parse tree produced by the {@code logical_and}
	 * labeled alternative in {@link SyntaxAnalysisParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogical_and(SyntaxAnalysisParser.Logical_andContext ctx);
	/**
	 * Visit a parse tree produced by the {@code func_expr}
	 * labeled alternative in {@link SyntaxAnalysisParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc_expr(SyntaxAnalysisParser.Func_exprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code array}
	 * labeled alternative in {@link SyntaxAnalysisParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray(SyntaxAnalysisParser.ArrayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code equal_notequal}
	 * labeled alternative in {@link SyntaxAnalysisParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqual_notequal(SyntaxAnalysisParser.Equal_notequalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code tertiary}
	 * labeled alternative in {@link SyntaxAnalysisParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTertiary(SyntaxAnalysisParser.TertiaryContext ctx);
	/**
	 * Visit a parse tree produced by the {@code add_sub}
	 * labeled alternative in {@link SyntaxAnalysisParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdd_sub(SyntaxAnalysisParser.Add_subContext ctx);
	/**
	 * Visit a parse tree produced by the {@code mul_div_mod}
	 * labeled alternative in {@link SyntaxAnalysisParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMul_div_mod(SyntaxAnalysisParser.Mul_div_modContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parens}
	 * labeled alternative in {@link SyntaxAnalysisParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParens(SyntaxAnalysisParser.ParensContext ctx);
	/**
	 * Visit a parse tree produced by the {@code digits}
	 * labeled alternative in {@link SyntaxAnalysisParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDigits(SyntaxAnalysisParser.DigitsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code id}
	 * labeled alternative in {@link SyntaxAnalysisParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId(SyntaxAnalysisParser.IdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bool}
	 * labeled alternative in {@link SyntaxAnalysisParser#primary}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool(SyntaxAnalysisParser.BoolContext ctx);
	/**
	 * Visit a parse tree produced by the {@code funcCall}
	 * labeled alternative in {@link SyntaxAnalysisParser#func_Call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFuncCall(SyntaxAnalysisParser.FuncCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code fparameters}
	 * labeled alternative in {@link SyntaxAnalysisParser#fparam}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFparameters(SyntaxAnalysisParser.FparametersContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parameters}
	 * labeled alternative in {@link SyntaxAnalysisParser#param}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameters(SyntaxAnalysisParser.ParametersContext ctx);
	/**
	 * Visit a parse tree produced by the {@code void_ftype}
	 * labeled alternative in {@link SyntaxAnalysisParser#ftype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVoid_ftype(SyntaxAnalysisParser.Void_ftypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code type_ftype}
	 * labeled alternative in {@link SyntaxAnalysisParser#ftype}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType_ftype(SyntaxAnalysisParser.Type_ftypeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code num_type}
	 * labeled alternative in {@link SyntaxAnalysisParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNum_type(SyntaxAnalysisParser.Num_typeContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bool_type}
	 * labeled alternative in {@link SyntaxAnalysisParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool_type(SyntaxAnalysisParser.Bool_typeContext ctx);
}