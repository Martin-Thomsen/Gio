package RoboBasic;
import java.lang.StringBuilder;
import RoboBasicGen.*;
import org.antlr.v4.runtime.*;
import java.util.Map;
import java.util.HashMap;

public class TranslateVisitor extends SyntaxAnalysisBaseVisitor<String>{
    Integer indentationCount = 0;
    Map<String, SyntaxAnalysisWhenType> wEnv;
    ControlsCollect controlsCollect;

    public TranslateVisitor(Map<String, SyntaxAnalysisWhenType> wEnv, ControlsCollect controlsCollect) {
        this.wEnv = wEnv;
        this.controlsCollect = controlsCollect;
    }

    @Override public String visitProgram(SyntaxAnalysisParser.ProgramContext ctx) {
        StringBuilder op = new StringBuilder();

        op.append("public class RoboBasic {\n");
        indentationCount++;

        for(SyntaxAnalysisParser.FuncContext func : ctx.func()) {
            op.append(visit(func)).append("\n");
        }

        for(SyntaxAnalysisParser.EventHandContext when : ctx.eventHand()) {
            op.append(visit(when)).append("\n");
        }

        op.append("}");

        return op.toString();
    }

    /* 'function' ftype ID '(' fparam ')' block return_Stmt 'endFunction' */
    @Override public String visitFunction(SyntaxAnalysisParser.FunctionContext ctx) {
        String returnType = visit(ctx.ftype());
        String id = ctx.id.getText().equals("run") ? "run" : getIdFromToken(ctx.id);
        String params = visit(ctx.fparam());
        String content = visit(ctx.block());

        content = TranslateControls(content);

        StringBuilder op = new StringBuilder();
        op.append("\t").append("public ").append(returnType).append(" ").append(id).append("(").append(params).append(") {\n").append(content).append("\t").append("}\n");

        return op.toString();
    }

    /* 'when' ID '(' param ')' block 'endWhen' */
    @Override public String visitWhen(SyntaxAnalysisParser.WhenContext ctx) {
        String id = ctx.id.getText();
        String content = visit(ctx.block());

        content = TranslateControls(content);

        if(wEnv.containsKey(id)) {
            SyntaxAnalysisWhenType eventHandler = wEnv.get(ctx.id.getText());
            Map<String, String> params = eventHandler.getTranslatedParameters();
            String eventName = eventHandler.getEventName();

            for(Map.Entry<String, String> param : params.entrySet()) {
                content = content.replace("_" + param.getKey(), param.getValue());
            }

            StringBuilder op = new StringBuilder();
            op.append("\t").append("public void ").append(id).append("(").append(eventName).append(" event) {\n").append(content).append("\t").append("}\n");

            return op.toString();
        }

        return "";
    }

    /* stmt* */
    @Override public String visitBlk(SyntaxAnalysisParser.BlkContext ctx) {
        indentationCount++;
        StringBuilder op = new StringBuilder();

        for(SyntaxAnalysisParser.StmtContext stmt : ctx.stmt()) {
            addIndentation(op);
            op.append(visit(stmt)).append("\n");
        }

        indentationCount--;
        return op.toString();
    }

    /* 'if' '(' expression ')' 'do' block ('else if' '(' expression ')' 'do' block)* ('else do' block)? 'endIf' */
    @Override public String visitIf(SyntaxAnalysisParser.IfContext ctx) {
        StringBuilder op = new StringBuilder();
        op.append("if(");

        String expr1 = visit(ctx.expression(0));
        op.append(expr1).append(") {\n");

        String block1 = visit(ctx.block(0));
        op.append(block1);
        addIndentation(op);
        op.append("}");

        int exprAmount = 1;
        int blockAmount = 1;

        while(true) {
            if (ctx.expression(exprAmount) != null) {
                String expr = visit(ctx.expression(exprAmount));
                String block = visit(ctx.block(blockAmount));

                op.append("\nelse if(").append(expr).append(") {\n").append(block);
                addIndentation(op);
                op.append("}");
                exprAmount++;
                blockAmount++;
            }
            else if(ctx.block(blockAmount) != null) {
                String block = visit(ctx.block(blockAmount));

                op.append("\nelse {\n").append(block);
                addIndentation(op);
                op.append("}");
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
            op.append(getIdFromToken(ctx.id));
        }
        else {
            op.append(visit(ctx.DIGITS()));
        }

        op.append("; i++) {\n");

        String content = visit(ctx.block());
        op.append(content);
        addIndentation(op);
        op.append("}");

        return op.toString();
    }

    /* 'repeatIf' '(' expression ')' block 'endRepeatIf' */
    @Override public String visitRep_if(SyntaxAnalysisParser.Rep_ifContext ctx) {
        StringBuilder op = new StringBuilder();
        op.append("while(");

        String expr = visit(ctx.expression());
        op.append(expr).append(") {\n");

        String block = visit(ctx.block());
        op.append(block);
        addIndentation(op);
        op.append("}");

        return op.toString();
    }

    /* 'repeat' block 'until' '(' expression ')' */
    @Override public String visitRep_until(SyntaxAnalysisParser.Rep_untilContext ctx) {
        StringBuilder op = new StringBuilder();
        op.append("do {\n");

        String block = visit(ctx.block());
        op.append(block);
        addIndentation(op);
        op.append("} while(");

        String expr = visit(ctx.expression());
        op.append(expr).append(")");

        return op.toString();
    }

    /* func_Call */
    @Override public String visitFunc_stmt(SyntaxAnalysisParser.Func_stmtContext ctx) {
        return visit(ctx.func_Call());
    }

    /* type ID '=' (expression | incr_Stmt | decr_Stmt) '.' */
    @Override public String visitVar_decl(SyntaxAnalysisParser.Var_declContext ctx) {
        String type = visit(ctx.type());
        String id = getIdFromToken(ctx.id);

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
        String id = getIdFromToken(ctx.id);

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

    @Override public String visitRet(SyntaxAnalysisParser.RetContext ctx) {
        return visit(ctx.return_Stmt());
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
        op.append("++");

        String id = getIdFromToken(ctx.id);
        op.append(id).append(";");

        return op.toString();
    }

    /* ID '++' */
    @Override public String visitPost_incr(SyntaxAnalysisParser.Post_incrContext ctx) {
        StringBuilder op = new StringBuilder();

        String id = getIdFromToken(ctx.id);
        op.append(id).append("++;");

        return op.toString();
    }

    /* '--' ID */
    @Override public String visitPre_decr(SyntaxAnalysisParser.Pre_decrContext ctx) {
        StringBuilder op = new StringBuilder();
        op.append("--");

        String id = getIdFromToken(ctx.id);
        op.append(id).append(";");

        return op.toString();
    }

    /* ID '--' */
    @Override public String visitPost_decr(SyntaxAnalysisParser.Post_decrContext ctx) {
        StringBuilder op = new StringBuilder();

        String id = getIdFromToken(ctx.id);
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
        op.append("!").append(expr);

        return op.toString();
    }

    /* expression bop=('*'|'/'|'%') expression */
    @Override public String visitMul_div_mod(SyntaxAnalysisParser.Mul_div_modContext ctx) {
        StringBuilder op = new StringBuilder();

        String expr1 = visit(ctx.expression(0));
        op.append(expr1).append(" ").append(ctx.bop.getText()).append(" ");

        String expr2 = visit(ctx.expression(1));
        op.append(expr2);

        return op.toString();
    }

    /* expression bop=('+'|'-') expression */
    @Override public String visitAdd_sub(SyntaxAnalysisParser.Add_subContext ctx) {
        StringBuilder op = new StringBuilder();

        String expr1 = visit(ctx.expression(0));
        op.append(expr1).append(" ").append(ctx.bop.getText()).append(" ");

        String expr2 = visit(ctx.expression(1));
        op.append(expr2);

        return op.toString();
    }

    /* expression bop=('<=' | '>=' | '<' | '>') expression */
    @Override public String visitLe_ge_lt_gt(SyntaxAnalysisParser.Le_ge_lt_gtContext ctx) {
        StringBuilder op = new StringBuilder();

        String expr1 = visit(ctx.expression(0));
        op.append(expr1).append(" ").append(ctx.bop.getText()).append(" ");

        String expr2 = visit(ctx.expression(1));
        op.append(expr2);

        return op.toString();
    }

    /* expression bop=('==' | '!=') expression */
    @Override public String visitEqual_notequal(SyntaxAnalysisParser.Equal_notequalContext ctx) {
        StringBuilder op = new StringBuilder();

        String expr1 = visit(ctx.expression(0));
        op.append(expr1).append(" ").append(ctx.bop.getText()).append(" ");

        String expr2 = visit(ctx.expression(1));
        op.append(expr2);

        return op.toString();
    }

    /* expression bop='&&' expression */
    @Override public String visitLogical_and(SyntaxAnalysisParser.Logical_andContext ctx) {
        StringBuilder op = new StringBuilder();

        String expr1 = visit(ctx.expression(0));
        op.append(expr1).append(" ").append(ctx.bop.getText()).append(" ");

        String expr2 = visit(ctx.expression(1));
        op.append(expr2);

        return op.toString();
    }

    /* expression bop='||' expression */
    @Override public String visitLogical_or(SyntaxAnalysisParser.Logical_orContext ctx) {
        StringBuilder op = new StringBuilder();

        String expr1 = visit(ctx.expression(0));
        op.append(expr1).append(" ").append(ctx.bop.getText()).append(" ");

        String expr2 = visit(ctx.expression(1));
        op.append(expr2);

        return op.toString();
    }

    /* <assoc=right> expression bop='?' expression ':' expression */
    @Override public String visitTernary(SyntaxAnalysisParser.TernaryContext ctx) {
        StringBuilder op = new StringBuilder();

        String expr1 = visit(ctx.expression(0));
        op.append(expr1).append(" ").append(ctx.bop.getText()).append(" ");

        String expr2 = visit(ctx.expression(1));
        op.append(expr2).append(" : ");

        String expr3 = visit(ctx.expression(2));
        op.append(expr3);

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

        String writtenID = ctx.id.getText();
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

        String id = getIdFromToken(ctx.id);
        op.append(id).append("(");

        String params = visit(ctx.param());
        op.append(params).append(");");

        return op.toString();
    }

    /* (type ID (',' type ID)*)? */
    @Override public String visitFparameters(SyntaxAnalysisParser.FparametersContext ctx) {
        StringBuilder op = new StringBuilder();

        int i = 0;
        for(SyntaxAnalysisParser.TypeContext type : ctx.type()) {
            if(i > 0)
                op.append(", ");

            String id = ctx.ID(i).getText();

            op.append(visit(type)).append(" _").append(id);

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

    String getIdFromToken(Token idToken) {
        StringBuilder op = new StringBuilder();

        String writtenID = idToken.getText();
        op.append("_").append(writtenID);

        return op.toString();
    }

    StringBuilder addIndentation(StringBuilder op) {
        for(int i = 0; i < indentationCount; i++) {
            op.append("\t");
        }

        return op;
    }

    String TranslateControls(String content) {
        String returnContent = content;

        Map<String, String> controlFunctions = controlsCollect.getTranslatedControlFuncs();
        for(Map.Entry<String, String> controlFunc : controlFunctions.entrySet()) {
            returnContent = returnContent.replace("_" + controlFunc.getKey() + "(", controlFunc.getValue());
        }

        Map<String, String> controlVariables = controlsCollect.getTranslatedControlVars();
        for(Map.Entry<String, String> controlVar : controlVariables.entrySet()) {
            if(controlVar.getValue().contains("(d)")) {
                int index = returnContent.indexOf("_" + controlVar.getKey());
                while(index != -1) {
                    int lastIndex = returnContent.substring(0, index).lastIndexOf("int");
                    returnContent = returnContent.substring(0, lastIndex) + "double" + returnContent.substring(lastIndex + 3).replaceFirst("_" + controlVar.getKey(), controlVar.getValue().replace("(d)", ""));

                    index = returnContent.indexOf("_" + controlVar.getKey());
                }
            } else {
                returnContent = returnContent.replace("_" + controlVar.getKey(), controlVar.getValue());
            }
        }

        return returnContent;
    }
}