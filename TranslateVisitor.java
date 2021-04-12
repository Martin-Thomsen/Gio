import java.util.Map;
import java.util.HashMap;
import java.util.List;
import gen.*;

public class TranslateVisitor extends SyntaxAnalysisBaseVisitor<String>{

    /* 'function' ftype ID '(' fparam ')' block return_Stmt 'endFunction' */
    @Override public String visitFunction(SyntaxAnalysisParser.FunctionContext ctx) {
        String returnType = visit(ctx.ftype());
        string id = ctx.ID().getText();
        String params = visit(ctx.fparam());
        String content = visit(ctx.block());
        String returnStmt = visit(ctx.return_Stmt());

        String output = ftype + id + "(" + params + ") {\n" + content + returnStmt + "}\n";

        return output;
    }

    /* 'when' ID '(' param ')' block 'endWhen' */
    @Override public String visitWhen(SyntaxAnalysisParser.WhenContext ctx) {
        String id = ctx.ID().getText();
        String params = visit(ctx.param());
        string content = visit(ctx.block());

        String output = "public void " + id + "(" + params + ") {\n" + content + "}\n";
    }

    /* stmt* */
    @Override public String visitBlk(SyntaxAnalysisParser.BlkContext ctx) {
        String output = "";

        for(SyntaxAnalysisParser.StmtContext stmt : ctx.stmt()) {
            output += visit(stmt);
        }

        return output;
    }

    /* 'if' '(' expression ')' 'do' block ('else if' '(' expression ')' 'do' block)* ('else do' block)? 'endIf' */
    @Override public String visitIf(SyntaxAnalysisParser.IfContext ctx) {
        String output = "if(";

        String expr1 = visit(ctx.expression(0));
        output += expr1 + ") {\n";

        String block1 = visit(ctx.block(0));
        output += block1 + "}\n";

        // Implement further when we know how to check for else if and else
    }

    /* 'repeat' '(' (DIGITS | ID) ')' block 'endRepeat' */
    @Override public String visitRep(SyntaxAnalysisParser.RepContext ctx) {
        String output = "for(int i = 0; i < ";

        if(ctx.ID() != null) {
            output += visit(ctx.ID());
        }
        else {
            output += visit(ctx.DIGITS());
        }

        output += "; i++) {\n";

        String content = visit(ctx.block());
        output += content + "}\n";

        return output;
    }

    /* 'repeatIf' '(' expression ')' block 'endRepeatIf' */
    @Override public String visitRep_if(SyntaxAnalysisParser.Rep_ifContext ctx) {
        
    }

    /* 'repeatUntil' '(' expression ')' block 'endRepeatUntil' */
    @Override public String visitRep_until(SyntaxAnalysisParser.Rep_untilContext ctx) {

    }

    /* func_Call */
    @Override public String visitFunc_stmt(SyntaxAnalysisParser.Func_stmtContext ctx) {

    }

    /* type ID '=' (expression | incr_Stmt | decr_Stmt) '.' */
    @Override public String visitAssign(SyntaxAnalysisParser.AssignContext ctx) {

    }

    /* incr_Stmt */
    @Override public String visitIncr(SyntaxAnalysisParser.IncrContext ctx) {

    }

    /* decr_Stmt */
    @Override public String visitDecr(SyntaxAnalysisParser.DecrContext ctx) {

    }

    /* 'return' expression */
    @Override public String visitReturnStmt(SyntaxAnalysisParser.ReturnStmtContext ctx) {

    }

    /* '++' ID */
    @Override public String visitPre_incr(SyntaxAnalysisParser.Pre_incrContex ctx) {

    }

    /* ID '++' */
    @Override public String visitPost_incr(SyntaxAnalysisParser_Post.incrContext ctx) {

    }

    /* '--' ID */
    @Override public String visitPre_decr(SyntaxAnalysisParser.Pre_decrContex ctx) {

    }

    /* ID '--' */
    @Override public String visitPost_decr(SyntaxAnalysisParser.Post_decrContext ctx) {

    }

    /* primary */
    @Override public String visitPrim(SyntaxAnalysisParser.PrimContext ctx) {

    }

    /* func_Call */
    @Override public String visitFunc_expr(SyntaxAnalysisParser.Func_exprContext ctx) {

    }

    /* expression bop=('*'|'/'|'%') expression */
    @Override public String visitMul_div_mod(SyntaxAnalysisParser.Mul_div_modContex ctx) {

    }

    /* expression bop=('+'|'-') expression */
    @Override public String visitAdd_sub(SyntaxAnalysisParser.Add_subContext ctx) {

    }

    /* expression bop=('<=' | '>=' | '<' | '>') expression */
    @Override public String visitLe_ge_lt_gt(SyntaxAnalysisParser.Le_ge_lt_gtContext ctx) {

    }

    /* expression bop=('==' | '!=') expression */
    @Override public String visitEqual_notequal(SyntaxAnalysisParser.Equal_notequalContext ctx) {

    }

    /* expression bop='&&' expression */
    @Override public String visitLogical_and(SyntaxAnalysisParser.Logical_andContext ctx) {

    }

    /* expression bop='||' expression */
    @Override public String visitLogical_or(SyntaxAnalysisParser.Logical_orContext ctx) {

    }

    /* <assoc=right> expression bop='?' expression ':' expression */
    @Override public String visitTertiary(SyntaxAnalysisParser.TertiaryContext ctx) {

    }

    /* '(' expression ')' */
    @Override public String visitParens(SyntaxAnalysisParser.ParensContext ctx) {

    }

    /* DIGITS */
    @Override public String visitDigits(SyntaxAnalysisParser.DigitsContext ctx) {

    }

    /* ID */
    @Override public String visitId(SyntaxAnalysisParser.IdContex ctx) {

    }

    /* BOOL */
    @Override public String visitBool(SyntaxAnalysisParser.BoolContext ctx) {

    }

    /* ID '(' param ')' '.' */
    @Override public String visitFuncCall(SyntaxAnalysisParser.FuncCallContext ctx) {

    }

    /* (type ID (',' type ID)*)? */
    @Override public String visitFparameters(SyntaxAnalysisParser.FparametersContext ctx) {

    }

    /* (expression (',' expression)*)? */
    @Override public String visitParameters(SyntaxAnalysisParser.ParametersContext ctx) {

    }

    /* 'void' */
    @Override public String visitVoid_ftype(SyntaxAnalysisParser.Void_ftypeContext ctx) {

    }

    /* type */
    @Override public String visitType_ftype(SyntaxAnalysisParser.Type_ftypeContext ctx) {

    }

    /* 'num' */
    @Override public String visitNum_type(SyntaxAnalysisParser.Num_typeContext ctx) {

    }

    /* 'bool' */
    @Override public String visitBool_type(SyntaxAnalysisParser.Bool_typeContext ctx) {

    }
}