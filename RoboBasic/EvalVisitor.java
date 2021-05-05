package RoboBasic;
import java.util.*;
import RoboBasicGen.*;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.Vocabulary;
import org.antlr.v4.runtime.tree.TerminalNode;

public class EvalVisitor extends SyntaxAnalysisBaseVisitor<SyntaxAnalysisType>{
    Map<String, SyntaxAnalysisType> varEnv;
    Map<String, SyntaxAnalysisFuncType> fEnv;
    Vocabulary tokenVocabulary = SyntaxAnalysisLexer.VOCABULARY;
    List<String> errors = new ArrayList<>();

    public EvalVisitor(Map<String, SyntaxAnalysisFuncType> fEnv) {
        this.fEnv = fEnv;
    }

    public List<String> getErrors() {
        return errors;
    }

    /* 'function' ftype ID '(' fparam ')' block 'endFunction' */
    @Override public SyntaxAnalysisType visitFunction(SyntaxAnalysisParser.FunctionContext ctx) {
        varEnv = new HashMap<>();
        visit(ctx.fparam());
        visit(ctx.block());

        return new SyntaxAnalysisVoid();
    }

    /* 'when' ID '(' param ')' block 'endWhen' */
    @Override public SyntaxAnalysisType visitWhen(SyntaxAnalysisParser.WhenContext ctx) {
        varEnv = new HashMap<>();
        visit(ctx.fparam());
        visit(ctx.block());

        return new SyntaxAnalysisVoid();
    }

    /* stmt* */
    @Override public SyntaxAnalysisType visitBlk(SyntaxAnalysisParser.BlkContext ctx) {
        boolean funcReturnCheck = false;
        for(SyntaxAnalysisParser.StmtContext stmt : ctx.stmt()) {
            visit(stmt);
            if(stmt.getStart().getText().equals("return")) {
                funcReturnCheck = true;
            }
        }

        if(ctx.getParent() instanceof SyntaxAnalysisParser.FunctionContext
                && !(visit(((SyntaxAnalysisParser.FunctionContext)ctx.getParent()).ftype()) instanceof SyntaxAnalysisVoid)
                && !funcReturnCheck) {
            addError(ctx.getParent(), "Return value expected");
        }

        return new SyntaxAnalysisVoid();
    }

    /* 'if' '(' expression ')' 'do' block ('else if' '(' expression ')' 'do' block)* ('else do' block)? 'endIf' */
    @Override public SyntaxAnalysisType visitIf(SyntaxAnalysisParser.IfContext ctx) {
        for(SyntaxAnalysisParser.ExpressionContext expr : ctx.expression()) {
            if(!(visit(expr) instanceof SyntaxAnalysisBool)) {
                addError(ctx, expr, "BOOL");
            }
        }

        for(SyntaxAnalysisParser.BlockContext block : ctx.block()) {
            if(!(visit(block) instanceof SyntaxAnalysisVoid)) {
                addError(ctx, block, "VOID");
            }
        }

        return new SyntaxAnalysisVoid();
    }

    /* 'repeat' '(' (DIGITS | ID) ')' block 'endRepeat' */
    @Override public SyntaxAnalysisType visitRep(SyntaxAnalysisParser.RepContext ctx) {
        if(ctx.ID() != null) {
            SyntaxAnalysisType type = getIDFromToken(ctx, ctx.id);
            if (!(type instanceof SyntaxAnalysisNum)) {
                addError(ctx, "NUM", type.getTypeName());
            }
        }

        if(!(visit(ctx.block()) instanceof SyntaxAnalysisVoid)) {
            addError(ctx, ctx.block(), "VOID");
        }

        return new SyntaxAnalysisVoid();
    }

    /* 'repeatIf' '(' expression ')' block 'endRepeatIf' */
    @Override public SyntaxAnalysisType visitRep_if(SyntaxAnalysisParser.Rep_ifContext ctx) {
        if(!(visit(ctx.expression()) instanceof SyntaxAnalysisBool)) {
            addError(ctx, ctx.expression(), "BOOL");
        }

        if(!(visit(ctx.block()) instanceof SyntaxAnalysisVoid)) {
            addError(ctx, ctx.block(), "VOID");
        }

        return new SyntaxAnalysisVoid();
    }

    /* 'repeatUntil' '(' expression ')' block 'endRepeatUntil' */
    @Override public SyntaxAnalysisType visitRep_until(SyntaxAnalysisParser.Rep_untilContext ctx) {
        if(!(visit(ctx.expression()) instanceof SyntaxAnalysisBool)) {
            addError(ctx, ctx.expression(), "BOOL");
        }

        if(!(visit(ctx.block()) instanceof SyntaxAnalysisVoid)) {
            addError(ctx, ctx.block(), "VOID");
        }

        return new SyntaxAnalysisVoid();
    }

    /* func_Call */
    @Override public SyntaxAnalysisType visitFunc_stmt(SyntaxAnalysisParser.Func_stmtContext ctx) {
        visit(ctx.func_Call());
        return new SyntaxAnalysisVoid();
    }

    /* type ID '=' (expression | incr_Stmt | decr_Stmt) '.' */
    @Override public SyntaxAnalysisType visitVar_decl(SyntaxAnalysisParser.Var_declContext ctx) {
        String assignType = visit(ctx.type()).getTypeName();
        String id = ctx.id.getText();
        SyntaxAnalysisType dType = new SyntaxAnalysisVoid();

        if(varEnv.containsKey(id)) {
            addError(ctx, "Variable with name " + id + " already exists");
        }

        if(ctx.expression() != null)
            dType = visit(ctx.expression());
        else if(ctx.incr_Stmt() != null)
            dType = visit(ctx.incr_Stmt());
        else if(ctx.decr_Stmt() != null)
            dType = visit(ctx.decr_Stmt());
        else {
            addError(ctx, "Expected an expression to be assigned");
        }

        if(!(dType.getTypeName().equals(assignType))) {
            addError(ctx, dType.getTypeName(), assignType);
        }

        varEnv.put(id, dType);
        return new SyntaxAnalysisNum();
    }

    /* ID '=' (expression | incr_Stmt | decr_Stmt) '.' */
    @Override public SyntaxAnalysisType visitAssign(SyntaxAnalysisParser.AssignContext ctx) {
        String assignType = getIDFromToken(ctx, ctx.id).getTypeName();
        SyntaxAnalysisType aType = new SyntaxAnalysisVoid();

        if(ctx.expression() != null)
            aType = visit(ctx.expression());
        else if(ctx.incr_Stmt() != null)
            aType = visit(ctx.incr_Stmt());
        else if(ctx.decr_Stmt() != null)
            aType = visit(ctx.decr_Stmt());
        else {
            addError(ctx, "Expected an expression to be assigned");
        }

        if(!(aType.getTypeName().equals(assignType))) {
            addError(ctx, aType.getTypeName(), assignType);
        }

        return aType;
    }

    /* incr_Stmt */
    @Override public SyntaxAnalysisType visitIncr(SyntaxAnalysisParser.IncrContext ctx) {
        return visit(ctx.incr_Stmt());
    }

    /* decr_Stmt */
    @Override public SyntaxAnalysisType visitDecr(SyntaxAnalysisParser.DecrContext ctx) {
        return visit(ctx.decr_Stmt());
    }

    /* 'return' expression */
    @Override public SyntaxAnalysisType visitReturnStmt(SyntaxAnalysisParser.ReturnStmtContext ctx) {
        String funcID = ((SyntaxAnalysisParser.FunctionContext)ctx.getParent().getParent().getParent()).ID().getText();
        SyntaxAnalysisFuncType func = fEnv.get(funcID);
        String returnType = func.getReturnType().getTypeName();

        if(!(visit(ctx.expression()).getTypeName().equals(returnType))) {
            addError(ctx, ctx.expression(), returnType);
        }

        return visit(ctx.expression());
    }

    /* '++' ID */
    @Override public SyntaxAnalysisType visitPre_incr(SyntaxAnalysisParser.Pre_incrContext ctx) {
        SyntaxAnalysisType type = getIDFromToken(ctx, ctx.id);
        if (!(type instanceof SyntaxAnalysisNum)) {
            addError(ctx, "NUM", type.getTypeName());
        }
        return new SyntaxAnalysisNum();
    }

    /* ID '++' */
    @Override public SyntaxAnalysisType visitPost_incr(SyntaxAnalysisParser.Post_incrContext ctx) {
        SyntaxAnalysisType type = getIDFromToken(ctx, ctx.id);
        if (!(type instanceof SyntaxAnalysisNum)) {
            addError(ctx, "NUM", type.getTypeName());
        }
        return new SyntaxAnalysisNum();
    }

    /* '--' ID */
    @Override public SyntaxAnalysisType visitPre_decr(SyntaxAnalysisParser.Pre_decrContext ctx) {
        SyntaxAnalysisType type = getIDFromToken(ctx, ctx.id);
        if (!(type instanceof SyntaxAnalysisNum)) {
            addError(ctx, "NUM", type.getTypeName());
        }
        return new SyntaxAnalysisNum();
    }

    /* ID '--' */
    @Override public SyntaxAnalysisType visitPost_decr(SyntaxAnalysisParser.Post_decrContext ctx) {
        SyntaxAnalysisType type = getIDFromToken(ctx, ctx.id);
        if (!(type instanceof SyntaxAnalysisNum)) {
            addError(ctx, "NUM", type.getTypeName());
        }
        return new SyntaxAnalysisNum();
    }

    /* primary */
    @Override public SyntaxAnalysisType visitPrim(SyntaxAnalysisParser.PrimContext ctx) {
        return visit(ctx.primary());
    }

    /* func_Call */
    @Override public SyntaxAnalysisType visitFunc_expr(SyntaxAnalysisParser.Func_exprContext ctx) {
        return visit(ctx.func_Call());
    }

    /* '!' expression */
    @Override public SyntaxAnalysisType visitNot(SyntaxAnalysisParser.NotContext ctx) {
        if(!(visit(ctx.expression()) instanceof SyntaxAnalysisBool)) {
            addError(ctx, ctx.expression(), "BOOL");
        }

        return new SyntaxAnalysisBool();
    }

    /* expression bop=('*'|'/'|'%') expression */
    @Override public SyntaxAnalysisType visitMul_div_mod(SyntaxAnalysisParser.Mul_div_modContext ctx) {
        if(!(visit(ctx.expression(0)) instanceof SyntaxAnalysisNum)) {
            addError(ctx, ctx.expression(0), "NUM");
        }

        if(!(visit(ctx.expression(1)) instanceof SyntaxAnalysisNum)) {
            addError(ctx, ctx.expression(1), "NUM");
        }

        return new SyntaxAnalysisNum();
    }

    /* expression bop=('+'|'-') expression */
    @Override public SyntaxAnalysisType visitAdd_sub(SyntaxAnalysisParser.Add_subContext ctx) {
        if(!(visit(ctx.expression(0)) instanceof SyntaxAnalysisNum)) {
            addError(ctx, ctx.expression(0), "NUM");
        }

        if(!(visit(ctx.expression(1)) instanceof SyntaxAnalysisNum)) {
            addError(ctx, ctx.expression(1), "NUM");
        }

        return new SyntaxAnalysisNum();
    }

    /* expression bop=('<=' | '>=' | '<' | '>') expression */
    @Override public SyntaxAnalysisType visitLe_ge_lt_gt(SyntaxAnalysisParser.Le_ge_lt_gtContext ctx) {
        if(!(visit(ctx.expression(0)) instanceof SyntaxAnalysisNum)) {
            addError(ctx, ctx.expression(0), "NUM");
        }

        if(!(visit(ctx.expression(1)) instanceof SyntaxAnalysisNum)) {
            addError(ctx, ctx.expression(1), "NUM");
        }

        return new SyntaxAnalysisBool();
    }

    /* expression bop=('==' | '!=') expression */
    @Override public SyntaxAnalysisType visitEqual_notequal(SyntaxAnalysisParser.Equal_notequalContext ctx) {
        SyntaxAnalysisType expr1 = visit(ctx.expression(0));
        SyntaxAnalysisType expr2 = visit(ctx.expression(1));

        if(!(expr1 instanceof SyntaxAnalysisNum) && !(expr1 instanceof SyntaxAnalysisBool)) {
            addError(ctx, ctx.expression(0), "BOOL");
        }

        if(!(expr2 instanceof SyntaxAnalysisNum) && !(expr2 instanceof SyntaxAnalysisBool)) {
            addError(ctx, ctx.expression(1), "BOOL");
        }

        return new SyntaxAnalysisBool();
    }

    /* expression bop='&&' expression */
    @Override public SyntaxAnalysisType visitLogical_and(SyntaxAnalysisParser.Logical_andContext ctx) {
        if(!(visit(ctx.expression(0)) instanceof SyntaxAnalysisBool)) {
            addError(ctx, ctx.expression(0), "BOOL");
        }

        if(!(visit(ctx.expression(1)) instanceof SyntaxAnalysisBool)) {
            addError(ctx, ctx.expression(1), "BOOL");
        }

        return new SyntaxAnalysisBool();
    }

    /* expression bop='||' expression */
    @Override public SyntaxAnalysisType visitLogical_or(SyntaxAnalysisParser.Logical_orContext ctx) {
        if(!(visit(ctx.expression(0)) instanceof SyntaxAnalysisBool)) {
            addError(ctx, ctx.expression(0), "BOOL");
        }

        if(!(visit(ctx.expression(1)) instanceof SyntaxAnalysisBool)) {
            addError(ctx, ctx.expression(1), "BOOL");
        }

        return new SyntaxAnalysisBool();
    }

    /* <assoc=right> expression bop='?' expression ':' expression */
    @Override public SyntaxAnalysisType visitTertiary(SyntaxAnalysisParser.TertiaryContext ctx) {
        if(!(visit(ctx.expression(0)) instanceof SyntaxAnalysisBool)) {
            addError(ctx, ctx.expression(0), "BOOL");
        }

        SyntaxAnalysisType type = new SyntaxAnalysisVoid();

        if(ctx.getParent() instanceof SyntaxAnalysisParser.Var_declContext)
            type = visit(((SyntaxAnalysisParser.Var_declContext)ctx.getParent()).type());
        else if (ctx.getParent() instanceof SyntaxAnalysisParser.AssignContext)
            type = getIDFromToken(ctx, ((SyntaxAnalysisParser.AssignContext)ctx.getParent()).id);
        else
            addError(ctx, "Ternary expression can not be placed anywhere but in a declaration or assignment");

        if(!(visit(ctx.expression(1)).getTypeName().equals(type.getTypeName()))) {
            addError(ctx, ctx.expression(1), type.getTypeName());
        }

        if(!(visit(ctx.expression(2)).getTypeName().equals(type.getTypeName()))) {
            addError(ctx, ctx.expression(2), type.getTypeName());
        }

        return type;
    }

    /* '(' expression ')' */
    @Override public SyntaxAnalysisType visitParens(SyntaxAnalysisParser.ParensContext ctx) {
        if(!(visit(ctx.expression()) instanceof SyntaxAnalysisNum)) {
            addError(ctx, ctx.expression(), "NUM");
        }

        return new SyntaxAnalysisVoid();
    }

    /* DIGITS */
    @Override public SyntaxAnalysisType visitDigits(SyntaxAnalysisParser.DigitsContext ctx) {
        return new SyntaxAnalysisNum();
    }

    /* ID */
    @Override public SyntaxAnalysisType visitId(SyntaxAnalysisParser.IdContext ctx) {
        String id = ctx.ID().getText();
        if(varEnv.containsKey(id)) {
            return varEnv.get(id);
        }

        addError(ctx, "Variable " + id + " not found. Please assign a variable before attempting to use it");

        return new SyntaxAnalysisVoid();
    }

    /* BOOL */
    @Override public SyntaxAnalysisType visitBool(SyntaxAnalysisParser.BoolContext ctx) {
        return new SyntaxAnalysisBool();
    }

    /* ID '(' param ')' '.' */
    @Override public SyntaxAnalysisType visitFuncCall(SyntaxAnalysisParser.FuncCallContext ctx) {
        visit(ctx.param());

        if(fEnv.containsKey(ctx.id.getText()))
            return fEnv.get(ctx.id.getText()).getReturnType();
        else
            return new SyntaxAnalysisVoid();
    }

    /* (type ID (',' type ID)*)? */
    @Override public SyntaxAnalysisType visitFparameters(SyntaxAnalysisParser.FparametersContext ctx) {
        int i = 0;
        for(TerminalNode fparam : ctx.ID()) {
            SyntaxAnalysisType type = visit(ctx.type(i));
            varEnv.put(fparam.getText(), type);
            i++;
        }

        return new SyntaxAnalysisVoid();
    }

    /* (expression (',' expression)*)? */
    @Override public SyntaxAnalysisType visitParameters(SyntaxAnalysisParser.ParametersContext ctx) {
        String funcID;
        if(ctx.getParent() instanceof SyntaxAnalysisParser.FuncCallContext) {
            funcID = ((SyntaxAnalysisParser.FuncCallContext)ctx.getParent()).ID().getText();
        }
        else {
            funcID = ((SyntaxAnalysisParser.FunctionContext)ctx.getParent()).ID().getText();
        }
        SyntaxAnalysisFuncType func = fEnv.get(funcID);
        Collection<SyntaxAnalysisType> funcParams = func.getParameters().values();
        Iterator<SyntaxAnalysisType> itr = funcParams.iterator();

        for(SyntaxAnalysisParser.ExpressionContext expr : ctx.expression()) {
            if(!itr.hasNext()) {
                addError(ctx, "Too many parameters");
            }

            String expectedType = itr.next().getTypeName();
            String actualType = visit(expr).getTypeName();
            if(!(actualType.equals(expectedType))) {
                addError(ctx, expectedType, actualType);
            }
        }

        return new SyntaxAnalysisVoid();
    }

    /* 'void' */
    @Override public SyntaxAnalysisType visitVoid_ftype(SyntaxAnalysisParser.Void_ftypeContext ctx) {
        return new SyntaxAnalysisVoid();
    }

    /* type */
    @Override public SyntaxAnalysisType visitType_ftype(SyntaxAnalysisParser.Type_ftypeContext ctx) {
        return visit(ctx.type());
    }

    /* 'num' */
    @Override public SyntaxAnalysisType visitNum_type(SyntaxAnalysisParser.Num_typeContext ctx) {
        return new SyntaxAnalysisNum();
    }

    /* 'bool' */
    @Override public SyntaxAnalysisType visitBool_type(SyntaxAnalysisParser.Bool_typeContext ctx) {
        return new SyntaxAnalysisBool();
    }

    SyntaxAnalysisType getIDFromToken(ParserRuleContext ctx, Token idToken) {
        String id = idToken.getText();
        if(varEnv.containsKey(id)) {
            return varEnv.get(id);
        }

        addError(ctx, "Variable " + id + " not found. Please assign a variable before attempting to use it");

        return new SyntaxAnalysisVoid();
    }

    public void addError(ParserRuleContext ctx, String message) {
        int line = ctx.getStart().getLine();
        int charPos = ctx.getStart().getCharPositionInLine();

        errors.add("Syntax error at line " + line + "." + charPos + ": " + message + ".");
    }

    void addError(ParserRuleContext ctx, String expected, String actual) {
        int line = ctx.getStart().getLine();
        int charPos = ctx.getStart().getCharPositionInLine();

        errors.add("Syntax error at line " + line + "." + charPos + ": Expected type " + expected + " but got type " + actual + ".");
    }

    void addError(ParserRuleContext ctx, ParserRuleContext tokenCtx, String expected) {
        int line = ctx.getStart().getLine();
        int charPos = ctx.getStart().getCharPositionInLine();
        String type = tokenVocabulary.getSymbolicName(tokenCtx.getStart().getType());
        if(type.equals(""))
            type = tokenVocabulary.getLiteralName(tokenCtx.getStart().getType());
        else if(type.equals("ID")) {
            errors.add("Syntax error at line " + line + "." + charPos + ": Expected type " + expected + " but got type " + getIDFromToken(ctx, tokenCtx.getStart()).getTypeName() + ".");
            return;
        }

        errors.add("Syntax error at line " + line + "." + charPos + ": Expected type " + expected + " but got type " + type + ".");
    }
}