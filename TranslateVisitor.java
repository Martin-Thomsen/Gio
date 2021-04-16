import java.util.Map;
import java.util.HashMap;
import java.util.List;
import gen.*;

public class TranslateVisitor extends SyntaxAnalysisBaseVisitor<String>{

    /* 'function' ftype ID '(' fparam ')' block return_Stmt 'endFunction' */
    @Override public String visitFunction(SyntaxAnalysisParser.FunctionContext ctx) {
        String returnType = visit(ctx.ftype());
        String id = visit(ctx.ID());
        String params = visit(ctx.fparam());
        String content = visit(ctx.block());
        String returnStmt = visit(ctx.return_Stmt());

        String output = ftype + id + "(" + params + ") {\n" + content + returnStmt + "}\n";

        return output;
    }

    /* 'when' ID '(' param ')' block 'endWhen' */
    @Override public String visitWhen(SyntaxAnalysisParser.WhenContext ctx) {
        String id = visit(ctx.ID());
        String params = visit(ctx.param());
        String content = visit(ctx.block());

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

        int exprAmount = 1;
        int blockAmount = 1;

        while(true) {
            if (ctx.expr(exprAmount) != null) {
                String expr = visit(ctx.expression(exprAmount));
                String block = visit(ctx.block(blockAmount));

                output += "else if(" + expr + ") {\n" + block + "}\n";
                expr++;
                block++;
            }
            else if(ctx.block(blockAmount) != null) {
                String block = visit(ctx.block(blockAmount));

                output += "else {\n" + block + "}\n";
                break;
            }
            else {
                break;
            }
        }
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
        String output = "while(";

        String expr = visit(ctx.expression());
        output += expr + ") {\n";

        String block = visit(ctx.block());
        output += block + "}\n";

        return output;
    }

    /* 'repeat' block 'until' '(' expression ')' */
    @Override public String visitRep_until(SyntaxAnalysisParser.Rep_untilContext ctx) {
        String output = "do {";

        String block = visit(ctx.block());
        output += block + "} while (";

        String expr = visit(ctx.expression());
        output += expr + ")\n";

        return output;
    }

    /* func_Call */
    @Override public String visitFunc_stmt(SyntaxAnalysisParser.Func_stmtContext ctx) {
        return visit(ctx.func_Call());
    }

    /* type ID '=' (expression | incr_Stmt | decr_Stmt) '.' */
    @Override public String visitAssign(SyntaxAnalysisParser.AssignContext ctx) {
        String type = visit(ctx.type());
        String id = visit(ctx.ID());

        String output = type + " " + id + " = ";

        if(ctx.incr_Stmt() != null)
            output += visit(ctx.incr_Stmt()) + ";";
        else if(ctx.decr_Stmt() != null)
            output += visit(ctx.decr_Stmt()) + ";";
        else
            output += visit(ctx.expression()) + ";";

        return output;
    }

    /* incr_Stmt */
    @Override public String visitIncr(SyntaxAnalysisParser.IncrContext ctx) {
        return visit(ctx.incr_Stmt());
    }

    /* decr_Stmt */
    @Override public String visitDecr(SyntaxAnalysisParser.DecrContext ctx) {
        return visit(ctx.decr_Stmt());
    }

    /* 'return' expression */
    @Override public String visitReturnStmt(SyntaxAnalysisParser.ReturnStmtContext ctx) {
        String output = "return ";

        String expr = visit(ctx.expression());
        output += expr + ";";

        return output;
    }

    /* '++' ID */
    @Override public String visitPre_incr(SyntaxAnalysisParser.Pre_incrContex ctx) {
        String output = "++ ";

        String id = visit(ctx.ID());
        output += id + ";";

        return output;
    }

    /* ID '++' */
    @Override public String visitPost_incr(SyntaxAnalysisParser_Post.incrContext ctx) {
        String output = "";

        String id = visit(ctx.ID());
        output += id + "++;";

        return output;
    }

    /* '--' ID */
    @Override public String visitPre_decr(SyntaxAnalysisParser.Pre_decrContex ctx) {
        String output = "-- ";

        String id = visit(ctx.ID());
        output += id + ";";

        return output;
    }

    /* ID '--' */
    @Override public String visitPost_decr(SyntaxAnalysisParser.Post_decrContext ctx) {
        String output = "";

        String id = visit(ctx.ID());
        output += id + "--;";

        return output;
    }

    /* primary */
    @Override public String visitPrim(SyntaxAnalysisParser.PrimContext ctx) {
        return visit(ctx.primary());
    }

    /* func_Call */
    @Override public String visitFunc_expr(SyntaxAnalysisParser.Func_exprContext ctx) {
        return visit(ctx.func_Call());
    }

    /* expression bop=('*'|'/'|'%') expression */
    @Override public String visitMul_div_mod(SyntaxAnalysisParser.Mul_div_modContex ctx) {
        String output = "";

        String expr1 = visit(ctx.expression(0));
        output += expr1 + " " + ctx.bop + " ";

        String expr2 = visit(ctx.expression(1));
        output += expr2 + ";";

        return output;
    }

    /* expression bop=('+'|'-') expression */
    @Override public String visitAdd_sub(SyntaxAnalysisParser.Add_subContext ctx) {
        String output = "";

        String expr1 = visit(ctx.expression(0));
        output += expr1 + " " + ctx.bop + " ";

        String expr2 = visit(ctx.expression(1));
        output += expr2 + ";";

        return output;
    }

    /* expression bop=('<=' | '>=' | '<' | '>') expression */
    @Override public String visitLe_ge_lt_gt(SyntaxAnalysisParser.Le_ge_lt_gtContext ctx) {
        String output = "";

        String expr1 = visit(ctx.expression(0));
        output += expr1 + " " + ctx.bop + " ";

        String expr2 = visit(ctx.expression(1));
        output += expr2 + ";";

        return output;
    }

    /* expression bop=('==' | '!=') expression */
    @Override public String visitEqual_notequal(SyntaxAnalysisParser.Equal_notequalContext ctx) {
        String output = "";

        String expr1 = visit(ctx.expression(0));
        output += expr1 + " " + ctx.bop + " ";

        String expr2 = visit(ctx.expression(1));
        output += expr2 + ";";

        return output;
    }

    /* expression bop='&&' expression */
    @Override public String visitLogical_and(SyntaxAnalysisParser.Logical_andContext ctx) {
        String output = "";

        String expr1 = visit(ctx.expression(0));
        output += expr1 + " " + ctx.bop + " ";

        String expr2 = visit(ctx.expression(1));
        output += expr2 + ";";

        return output;
    }

    /* expression bop='||' expression */
    @Override public String visitLogical_or(SyntaxAnalysisParser.Logical_orContext ctx) {
        String output = "";

        String expr1 = visit(ctx.expression(0));
        output += expr1 + " " + ctx.bop + " ";

        String expr2 = visit(ctx.expression(1));
        output += expr2 + ";";

        return output;
    }

    /* <assoc=right> expression bop='?' expression ':' expression */
    @Override public String visitTertiary(SyntaxAnalysisParser.TertiaryContext ctx) {
        String output = "";

        String expr1 = visit(ctx.expression(0));
        output += expr1 + " " + ctx.bop + " ";

        String expr2 = visit(ctx.expression(1));
        output += expr2 + " : ";

        String expr3 = visit(ctx.expression(2));
        output += expr3 + ";";

        return output;
    }

    /* '(' expression ')' */
    @Override public String visitParens(SyntaxAnalysisParser.ParensContext ctx) {
        String output = "(";

        String expr = visit(ctx.expression());
        output += expr + ")";

        return output;
    }

    /* DIGITS */
    @Override public String visitDigits(SyntaxAnalysisParser.DigitsContext ctx) {
        return ctx.DIGITS().getText();
    }

    /* ID */
    @Override public String visitId(SyntaxAnalysisParser.IdContext ctx) {
        String writtenID = ctx.ID().getText();
        String newID = "_" + writtenID;

        return newID;
    }

    /* BOOL */
    @Override public String visitBool(SyntaxAnalysisParser.BoolContext ctx) {
        return ctx.BOOL().getText();
    }

    /* ID '(' param ')' '.' */
    @Override public String visitFuncCall(SyntaxAnalysisParser.FuncCallContext ctx) {
        String output = "";

        String id = visit(ctx.ID());
        output += id + "(";

        String params = visit(ctx.param());
        output += params + ")";

        return output;
    }

    /* (type ID (',' type ID)*)? */
    @Override public String visitFparameters(SyntaxAnalysisParser.FparametersContext ctx) {
        String output = "";

        int i = 0;
        for(SyntaxAnalysisParser.TypeContext type : ctx.type()) {
            if(i > 0)
                output += ", ";

            String id = visit(ctx.ID(i));

            output += type.getText() + " " + id;

            i++;
        }

        return output;
    }

    /* (expression (',' expression)*)? */
    @Override public String visitParameters(SyntaxAnalysisParser.ParametersContext ctx) {
        String output = "";

        int i = 0;
        for(SyntaxAnalysisParser.ExpressionContext expression : ctx.expression()) {
            if(i > 0)
                output += ", ";

            String expr = visit(expression);

            output += expr;

            i++;
        }

        return output;
    }

    /* 'void' */
    @Override public String visitVoid_ftype(SyntaxAnalysisParser.Void_ftypeContext ctx) {
        return "void";
    }

    /* type */
    @Override public String visitType_ftype(SyntaxAnalysisParser.Type_ftypeContext ctx) {
        return visit(ctx.type());
    }

    /* 'num' */
    @Override public String visitNum_type(SyntaxAnalysisParser.Num_typeContext ctx) {
        return "int";
    }

    /* 'bool' */
    @Override public String visitBool_type(SyntaxAnalysisParser.Bool_typeContext ctx) {
        return "bool";
    }
}