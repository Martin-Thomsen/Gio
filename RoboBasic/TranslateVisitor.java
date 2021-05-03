package RoboBasic;
import java.lang.StringBuilder;
import RoboBasicGen.*;

public class TranslateVisitor extends SyntaxAnalysisBaseVisitor<String>{

    /* 'function' ftype ID '(' fparam ')' block return_Stmt 'endFunction' */
    @Override public String visitFunction(SyntaxAnalysisParser.FunctionContext ctx) {
        String returnType = visit(ctx.ftype());
        String id = visit(ctx.ID());
        String params = visit(ctx.fparam());
        String content = visit(ctx.block());

        StringBuilder op = new StringBuilder();
        op.append(returnType).append(id).append("(").append(params).append(") {\n").append(content).append("}\n");

        return op.toString();
    }

    /* 'when' ID '(' param ')' block 'endWhen' */
    @Override public String visitWhen(SyntaxAnalysisParser.WhenContext ctx) {
        String id = visit(ctx.ID());
        String params = visit(ctx.fparam());
        String content = visit(ctx.block());

        StringBuilder op = new StringBuilder();
        op.append("public void ").append(id).append("(").append(params).append(") {\n").append(content).append("}\n");

        return op.toString();
    }

    /* stmt* */
    @Override public String visitBlk(SyntaxAnalysisParser.BlkContext ctx) {
        StringBuilder op = new StringBuilder();

        for(SyntaxAnalysisParser.StmtContext stmt : ctx.stmt()) {
            op.append(visit(stmt));
        }

        return op.toString();
    }

    /* 'if' '(' expression ')' 'do' block ('else if' '(' expression ')' 'do' block)* ('else do' block)? 'endIf' */
    @Override public String visitIf(SyntaxAnalysisParser.IfContext ctx) {
        StringBuilder op = new StringBuilder();
        op.append("if(");

        String expr1 = visit(ctx.expression(0));
        op.append(expr1).append(") {\n");

        String block1 = visit(ctx.block(0));
        op.append(block1).append("}\n");

        int exprAmount = 1;
        int blockAmount = 1;

        while(true) {
            if (ctx.expression(exprAmount) != null) {
                String expr = visit(ctx.expression(exprAmount));
                String block = visit(ctx.block(blockAmount));

                op.append("else if(").append(expr).append(") {\n").append(block).append("}\n");
                exprAmount++;
                blockAmount++;
            }
            else if(ctx.block(blockAmount) != null) {
                String block = visit(ctx.block(blockAmount));

                op.append("else {\n").append(block).append("}\n");
                break;
            }
            else {
                break;
            }
        }

        return op.toString();
    }

    /* 'repeat' '(' (DIGITS | ID) ')' block 'endRepeat' */
    @Override public String visitRep(SyntaxAnalysisParser.RepContext ctx) {
        StringBuilder op = new StringBuilder();
        op.append("for(int i = 0; i < ");

        if(ctx.ID() != null) {
            op.append(visit(ctx.ID()));
        }
        else {
            op.append(visit(ctx.DIGITS()));
        }

        op.append("; i++) {\n");

        String content = visit(ctx.block());
        op.append(content).append("}\n");

        return op.toString();
    }

    /* 'repeatIf' '(' expression ')' block 'endRepeatIf' */
    @Override public String visitRep_if(SyntaxAnalysisParser.Rep_ifContext ctx) {
        StringBuilder op = new StringBuilder();
        op.append("while(");

        String expr = visit(ctx.expression());
        op.append(expr).append(") {\n");

        String block = visit(ctx.block());
        op.append(block).append("}\n");

        return op.toString();
    }

    /* 'repeat' block 'until' '(' expression ')' */
    @Override public String visitRep_until(SyntaxAnalysisParser.Rep_untilContext ctx) {
        StringBuilder op = new StringBuilder();
        op.append("do {");

        String block = visit(ctx.block());
        op.append(block).append("} while (");

        String expr = visit(ctx.expression());
        op.append(expr).append(")\n");

        return op.toString();
    }

    /* func_Call */
    @Override public String visitFunc_stmt(SyntaxAnalysisParser.Func_stmtContext ctx) {
        return visit(ctx.func_Call());
    }

    /* type ID '=' (expression | incr_Stmt | decr_Stmt) '.' */
    @Override public String visitVar_decl(SyntaxAnalysisParser.Var_declContext ctx) {
        String type = visit(ctx.type());
        String id = visit(ctx.ID());

        StringBuilder op = new StringBuilder();
        op.append(type).append(" ").append(id).append(" = ");

        if(ctx.incr_Stmt() != null)
            op.append(visit(ctx.incr_Stmt())).append(";");
        else if(ctx.decr_Stmt() != null)
            op.append(visit(ctx.decr_Stmt())).append(";");
        else
            op.append(visit(ctx.expression())).append(";");

        return op.toString();
    }

    /* ID '=' (expression | incr_Stmt | decr_Stmt) '.' */
    @Override public String visitAssign(SyntaxAnalysisParser.AssignContext ctx) {
        String id = visit(ctx.ID());

        StringBuilder op = new StringBuilder();
        op.append(id).append(" = ");

        if(ctx.incr_Stmt() != null)
            op.append(visit(ctx.incr_Stmt())).append(";");
        else if(ctx.decr_Stmt() != null)
            op.append(visit(ctx.decr_Stmt())).append(";");
        else
            op.append(visit(ctx.expression())).append(";");

        return op.toString();
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
        StringBuilder op = new StringBuilder();
        op.append("return ");

        String expr = visit(ctx.expression());
        op.append(expr).append(";");

        return op.toString();
    }

    /* '++' ID */
    @Override public String visitPre_incr(SyntaxAnalysisParser.Pre_incrContext ctx) {
        StringBuilder op = new StringBuilder();
        op.append("++ ");

        String id = visit(ctx.ID());
        op.append(id).append(";");

        return op.toString();
    }

    /* ID '++' */
    @Override public String visitPost_incr(SyntaxAnalysisParser.Post_incrContext ctx) {
        StringBuilder op = new StringBuilder();

        String id = visit(ctx.ID());
        op.append(id).append("++;");

        return op.toString();
    }

    /* '--' ID */
    @Override public String visitPre_decr(SyntaxAnalysisParser.Pre_decrContext ctx) {
        StringBuilder op = new StringBuilder();
        op.append("-- ");

        String id = visit(ctx.ID());
        op.append(id).append(";");

        return op.toString();
    }

    /* ID '--' */
    @Override public String visitPost_decr(SyntaxAnalysisParser.Post_decrContext ctx) {
        StringBuilder op = new StringBuilder();

        String id = visit(ctx.ID());
        op.append(id).append("--;");

        return op.toString();
    }

    /* primary */
    @Override public String visitPrim(SyntaxAnalysisParser.PrimContext ctx) {
        return visit(ctx.primary());
    }

    /* func_Call */
    @Override public String visitFunc_expr(SyntaxAnalysisParser.Func_exprContext ctx) {
        return visit(ctx.func_Call());
    }

    /* '!' expression */
    @Override public String visitNot(SyntaxAnalysisParser.NotContext ctx) {
        StringBuilder op = new StringBuilder();

        String expr = visit(ctx.expression());
        op.append("!").append(expr).append(";");

        return op.toString();
    }

    /* expression bop=('*'|'/'|'%') expression */
    @Override public String visitMul_div_mod(SyntaxAnalysisParser.Mul_div_modContext ctx) {
        StringBuilder op = new StringBuilder();

        String expr1 = visit(ctx.expression(0));
        op.append(expr1).append(" ").append(ctx.bop).append(" ");

        String expr2 = visit(ctx.expression(1));
        op.append(expr2).append(";");

        return op.toString();
    }

    /* expression bop=('+'|'-') expression */
    @Override public String visitAdd_sub(SyntaxAnalysisParser.Add_subContext ctx) {
        StringBuilder op = new StringBuilder();

        String expr1 = visit(ctx.expression(0));
        op.append(expr1).append(" ").append(ctx.bop).append(" ");

        String expr2 = visit(ctx.expression(1));
        op.append(expr2).append(";");

        return op.toString();
    }

    /* expression bop=('<=' | '>=' | '<' | '>') expression */
    @Override public String visitLe_ge_lt_gt(SyntaxAnalysisParser.Le_ge_lt_gtContext ctx) {
        StringBuilder op = new StringBuilder();

        String expr1 = visit(ctx.expression(0));
        op.append(expr1).append(" ").append(ctx.bop).append(" ");

        String expr2 = visit(ctx.expression(1));
        op.append(expr2).append(";");

        return op.toString();
    }

    /* expression bop=('==' | '!=') expression */
    @Override public String visitEqual_notequal(SyntaxAnalysisParser.Equal_notequalContext ctx) {
        StringBuilder op = new StringBuilder();

        String expr1 = visit(ctx.expression(0));
        op.append(expr1).append(" ").append(ctx.bop).append(" ");

        String expr2 = visit(ctx.expression(1));
        op.append(expr2).append(";");

        return op.toString();
    }

    /* expression bop='&&' expression */
    @Override public String visitLogical_and(SyntaxAnalysisParser.Logical_andContext ctx) {
        StringBuilder op = new StringBuilder();

        String expr1 = visit(ctx.expression(0));
        op.append(expr1).append(" ").append(ctx.bop).append(" ");

        String expr2 = visit(ctx.expression(1));
        op.append(expr2).append(";");

        return op.toString();
    }

    /* expression bop='||' expression */
    @Override public String visitLogical_or(SyntaxAnalysisParser.Logical_orContext ctx) {
        StringBuilder op = new StringBuilder();

        String expr1 = visit(ctx.expression(0));
        op.append(expr1).append(" ").append(ctx.bop).append(" ");

        String expr2 = visit(ctx.expression(1));
        op.append(expr2).append(";");

        return op.toString();
    }

    /* <assoc=right> expression bop='?' expression ':' expression */
    @Override public String visitTertiary(SyntaxAnalysisParser.TertiaryContext ctx) {
        StringBuilder op = new StringBuilder();

        String expr1 = visit(ctx.expression(0));
        op.append(expr1).append(" ").append(ctx.bop).append(" ");

        String expr2 = visit(ctx.expression(1));
        op.append(expr2).append(" : ");

        String expr3 = visit(ctx.expression(2));
        op.append(expr3).append(";");

        return op.toString();
    }

    /* '(' expression ')' */
    @Override public String visitParens(SyntaxAnalysisParser.ParensContext ctx) {
        StringBuilder op = new StringBuilder();
        op.append("(");

        String expr = visit(ctx.expression());
        op.append(expr).append(")");

        return op.toString();
    }

    /* DIGITS */
    @Override public String visitDigits(SyntaxAnalysisParser.DigitsContext ctx) {
        return ctx.DIGITS().getText();
    }

    /* ID */
    @Override public String visitId(SyntaxAnalysisParser.IdContext ctx) {
        StringBuilder op = new StringBuilder();

        String writtenID = ctx.ID().getText();
        op.append("_").append(writtenID);

        return op.toString();
    }

    /* BOOL */
    @Override public String visitBool(SyntaxAnalysisParser.BoolContext ctx) {
        return ctx.BOOL().getText();
    }

    /* ID '(' param ')' '.' */
    @Override public String visitFuncCall(SyntaxAnalysisParser.FuncCallContext ctx) {
        StringBuilder op = new StringBuilder();

        String id = visit(ctx.ID());
        op.append(id).append("(");

        String params = visit(ctx.param());
        op.append(params).append(")");

        return op.toString();
    }

    /* (type ID (',' type ID)*)? */
    @Override public String visitFparameters(SyntaxAnalysisParser.FparametersContext ctx) {
        StringBuilder op = new StringBuilder();

        int i = 0;
        for(SyntaxAnalysisParser.TypeContext type : ctx.type()) {
            if(i > 0)
                op.append(", ");

            String id = visit(ctx.ID(i));

            op.append(type.getText()).append(" ").append(id);

            i++;
        }

        return op.toString();
    }

    /* (expression (',' expression)*)? */
    @Override public String visitParameters(SyntaxAnalysisParser.ParametersContext ctx) {
        StringBuilder op = new StringBuilder();

        int i = 0;
        for(SyntaxAnalysisParser.ExpressionContext expression : ctx.expression()) {
            if(i > 0)
                op.append(", ");

            String expr = visit(expression);
            op.append(expr);

            i++;
        }

        return op.toString();
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