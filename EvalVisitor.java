import java.util.Map;
import java.util.HashMap;
import java.util.List;
import gen.*;

public class EvalVisitor extends SyntaxAnalysisBaseVisitor<SyntaxAnalysisType>{
    Map<String, SyntaxAnalysisType> memory = new HashMap<String, SyntaxAnalysisType>;
    Map<String, SyntaxAnalysisType> varEnv;
    Map<String, SyntaxAnalysisFuncType> fEnv;
    Vocabulary tokenVocabulary = SyntaxAnalysisLexer.getVocabulary();
    List<String> errors = new List<String>();

    public EvalVisitor(Map<String, SyntaxAnalysisFuncType> fEnv) {
        this.fEnv = fEnv;
    }

    /* 'function' ftype ID '(' fparam ')' block return_Stmt 'endFunction' */
    @Override public SyntaxAnalysisType visitFunction(SyntaxAnalysisParser.FunctionContext ctx) {
        varEnv = new HashMap<String, SyntaxAnalysisType>;
        visit(ctx.fparam());
        visit(ctx.block());
        visit(ctx.return_Stmt());
    }

    /* 'when' ID '(' param ')' block 'endWhen' */
    @Override public SyntaxAnalysisType visitWhen(SyntaxAnalysisParser.WhenContext ctx) {
        varEnv = new HashMap<String, SyntaxAnalysisType>;
        visit(ctx.param());
        visit(ctx.block());
    }

    /* stmt* */
    @Override public SyntaxAnalysisType visitBlk(SyntaxAnalysisParser.BlkContext ctx) {
        for(SyntaxAnalysisParser.StmtContext stmt : ctx.stmt()) {
            visit(stmt);
        }

        return new SyntaxAnalysisVoid();
    }

    /* 'if' '(' expression ')' 'do' block ('else if' '(' expression ')' 'do' block)* ('else do' block)? 'endIf' */
    @Override public SyntaxAnalysisType visitIf(SyntaxAnalysisParser.IfContext ctx) {
        for(SyntaxAnalysisParser.ExpressionContext expr : ctx.expression()) {
            if(!visit(expr) instanceof SyntaxAnalysisBool) {
                int line = ctx.getStart().getLine();
                int charPos = ctx.getStart().getCharPositionInLine();
                String type = tokenVocabulary.getSymbolicName(ctx.type().getStart().getType());
                if(type == "")
                    type = tokenVocabulary.getLiteralName(ctx.type().getStart().getType());

                errors.add("Syntax error at line " + line + "." + charPos + ": Expected type BOOL but got type " + type ".");
            }
        }

        for(SyntaxAnalysisParser.BlockContext block : ctx.block()) {
            if(!visit(block) instanceof SyntaxAnalysisVoid) {
                int line = ctx.getStart().getLine();
                int charPos = ctx.getStart().getCharPositionInLine();
                String type = tokenVocabulary.getSymbolicName(ctx.type().getStart().getType());
                if(type == "")
                    type = tokenVocabulary.getLiteralName(ctx.type().getStart().getType());

                errors.add("Syntax error at line " + line + "." + charPos + ": Expected type VOID but got type " + type ".");
            }
        }

        return new SyntaxAnalysisVoid();
    }

    /* 'repeat' '(' (DIGITS | ID) ')' block 'endRepeat' */
    @Override public SyntaxAnalysisType visitRep(SyntaxAnalysisParser.RepContext ctx) {
        if(ctx.ID() != null) {
            if (!visit(ctx.ID()) instanceof SyntaxAnalysisNum) {
                int line = ctx.getStart().getLine();
                int charPos = ctx.getStart().getCharPositionInLine();
                String type = tokenVocabulary.getSymbolicName(ctx.type().getStart().getType());
                if(type == "")
                    type = tokenVocabulary.getLiteralName(ctx.type().getStart().getType());

                errors.add("Syntax error at line " + line + "." + charPos + ": Expected type NUM but got type " + type ".");
            }
        }
        else {
            if(!visit(ctx.DIGITS()) instanceof SyntaxAnalysisNum) {
                int line = ctx.getStart().getLine();
                int charPos = ctx.getStart().getCharPositionInLine();
                String type = tokenVocabulary.getSymbolicName(ctx.type().getStart().getType());
                if(type == "")
                    type = tokenVocabulary.getLiteralName(ctx.type().getStart().getType());

                errors.add("Syntax error at line " + line + "." + charPos + ": Expected type NUM but got type " + type ".");
            }
        }

        if(!visit(block) instanceof SyntaxAnalysisVoid) {
            int line = ctx.getStart().getLine();
            int charPos = ctx.getStart().getCharPositionInLine();
            String type = tokenVocabulary.getSymbolicName(ctx.type().getStart().getType());
            if(type == "")
                type = tokenVocabulary.getLiteralName(ctx.type().getStart().getType());

            errors.add("Syntax error at line " + line + "." + charPos + ": Expected type VOID but got type " + type ".");
        }

        return new SyntaxAnalysisVoid();
    }

    /* 'repeatIf' '(' expression ')' block 'endRepeatIf' */
    @Override public SyntaxAnalysisType visitRep_if(SyntaxAnalysisParser.Rep_ifContext ctx) {
        if(!visit(expr) instanceof SyntaxAnalysisBool) {
            int line = ctx.getStart().getLine();
            int charPos = ctx.getStart().getCharPositionInLine();
            String type = tokenVocabulary.getSymbolicName(ctx.type().getStart().getType());
            if(type == "")
                type = tokenVocabulary.getLiteralName(ctx.type().getStart().getType());

            errors.add("Syntax error at line " + line + "." + charPos + ": Expected type BOOL but got type " + type ".");
        }

        if(!visit(block) instanceof SyntaxAnalysisVoid) {
            int line = ctx.getStart().getLine();
            int charPos = ctx.getStart().getCharPositionInLine();
            String type = tokenVocabulary.getSymbolicName(ctx.type().getStart().getType());
            if(type == "")
                type = tokenVocabulary.getLiteralName(ctx.type().getStart().getType());

            errors.add("Syntax error at line " + line + "." + charPos + ": Expected type VOID but got type " + type ".");
        }

        return new SyntaxAnalysisVoid();
    }

    /* 'repeatUntil' '(' expression ')' block 'endRepeatUntil' */
    @Override public SyntaxAnalysisType visitRep_until(SyntaxAnalysisParser.Rep_untilContext ctx) {
        if(!visit(expr) instanceof SyntaxAnalysisBool) {
            int line = ctx.getStart().getLine();
            int charPos = ctx.getStart().getCharPositionInLine();
            String type = tokenVocabulary.getSymbolicName(ctx.type().getStart().getType());
            if(type == "")
                type = tokenVocabulary.getLiteralName(ctx.type().getStart().getType());

            errors.add("Syntax error at line " + line + "." + charPos + ": Expected type BOOL but got type " + type ".");
        }

        if(!visit(block) instanceof SyntaxAnalysisVoid) {
            int line = ctx.getStart().getLine();
            int charPos = ctx.getStart().getCharPositionInLine();
            String type = tokenVocabulary.getSymbolicName(ctx.type().getStart().getType());
            if(type == "")
                type = tokenVocabulary.getLiteralName(ctx.type().getStart().getType());

            errors.add("Syntax error at line " + line + "." + charPos + ": Expected type VOID but got type " + type ".");
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
        SyntaxAnalysisType assignType = ctx.type();
        String id = ctx.ID().getText();
        SyntaxAnalysisType type;

        if(memory.containsKey(id)) {
            int line = ctx.getStart().getLine();
            int charPos = ctx.getStart().getCharPositionInLine();
            errors.add("Syntax error at line " + line + "." + charPos + ": Variable with name " + id + " already exists.");
        }

        if(ctx.expression() != null)
            type = visit(ctx.expression());
        else if(ctx.incr_Stmt() != null)
            type = visit(ctx.incr.Stmt());
        else if(ctx.decr_Stmt() != null)
            type = visit(ctx.decr_Stmt());
        else {
            int line = ctx.getStart().getLine();
            int charPos = ctx.getStart().getCharPositionInLine();
            String type = tokenVocabulary.getSymbolicName(ctx.type().getStart().getType());
            if(type == "")
                type = tokenVocabulary.getLiteralName(ctx.type().getStart().getType());

            errors.add("Syntax error at line " + line + "." + charPos + ": Expected type NUM or BOOL but got type " + type ".");
        }

        if(!type instanceof assignType) {
            int line = ctx.getStart().getLine();
            int charPos = ctx.getStart().getCharPositionInLine();
            errors.add("Syntax error at line " + line + "." + charPos + ": Expected type " + assignType.getTypeName() + " but got type " + type.getTypeName() ".");
        }

        memory.put(id, type);
        return new SyntaxAnalysisNum();
    }

    /* ID '=' (expression | incr_Stmt | decr_Stmt) '.' */
    @Override public SyntaxAnalysisType visitAssign(SyntaxAnalysisParser.AssignContext ctx) {
        SyntaxAnalysisType assignType = visit(ctx.ID());
        String id = ctx.ID().getText();
        SyntaxAnalysisType type;

        if(ctx.expression() != null)
            type = visit(ctx.expression());
        else if(ctx.incr_Stmt() != null)
            type = visit(ctx.incr.Stmt());
        else if(ctx.decr_Stmt() != null)
            type = visit(ctx.decr_Stmt());
        else {
            int line = ctx.getStart().getLine();
            int charPos = ctx.getStart().getCharPositionInLine();
            String type = tokenVocabulary.getSymbolicName(ctx.type().getStart().getType());
            if(type == "")
                type = tokenVocabulary.getLiteralName(ctx.type().getStart().getType());

            errors.add("Syntax error at line " + line + "." + charPos + ": Expected type NUM or BOOL but got type " + type ".");
        }

        if(!type instanceof assignType) {
            int line = ctx.getStart().getLine();
            int charPos = ctx.getStart().getCharPositionInLine();
            errors.add("Syntax error at line " + line + "." + charPos + ": Expected type " + assignType.getTypeName() + " but got type " + type.getTypeName() ".");
        }

        return assignType;
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
        String funcID = ctx.getParent().ID().getText();
        SyntaxAnalysisFuncType func = fEnv.get(funcID);
        SyntaxAnalysisType returnType = func.getReturnType();

        if(!visit(ctx.expression()) instanceof returnType) {
            int line = ctx.getStart().getLine();
            int charPos = ctx.getStart().getCharPositionInLine();
            String type = tokenVocabulary.getSymbolicName(ctx.type().getStart().getType());
            if(type == "")
                type = tokenVocabulary.getLiteralName(ctx.type().getStart().getType());

            errors.add("Syntax error at line " + line + "." + charPos + ": Expected type " + returnType.getTypeName() + " but got type " + type ".");
        }

        return visit(ctx.expression());
    }

    /* '++' ID */
    @Override public SyntaxAnalysisType visitPre_incr(SyntaxAnalysisParser.Pre_incrContex ctx) {
        if(!visit(ctx.ID()) instanceof SyntaxAnalysisNum) {
            int line = ctx.getStart().getLine();
            int charPos = ctx.getStart().getCharPositionInLine();
            String type = tokenVocabulary.getSymbolicName(ctx.type().getStart().getType());
            if(type == "")
                type = tokenVocabulary.getLiteralName(ctx.type().getStart().getType());

            errors.add("Syntax error at line " + line + "." + charPos + ": Expected type NUM but got type " + type ".");
        }
        return new SyntaxAnalysisNum();
    }

    /* ID '++' */
    @Override public SyntaxAnalysisType visitPost_incr(SyntaxAnalysisParser_Post.incrContext ctx) {
        if(!visit(ctx.ID()) instanceof SyntaxAnalysisNum) {
            int line = ctx.getStart().getLine();
            int charPos = ctx.getStart().getCharPositionInLine();
            String type = tokenVocabulary.getSymbolicName(ctx.type().getStart().getType());
            if(type == "")
                type = tokenVocabulary.getLiteralName(ctx.type().getStart().getType());

            errors.add("Syntax error at line " + line + "." + charPos + ": Expected type NUM but got type " + type ".");
        }
        return new SyntaxAnalysisNum();
    }

    /* '--' ID */
    @Override public SyntaxAnalysisType visitPre_decr(SyntaxAnalysisParser.Pre_decrContex ctx) {
        if(!visit(ctx.ID()) instanceof SyntaxAnalysisNum) {
            int line = ctx.getStart().getLine();
            int charPos = ctx.getStart().getCharPositionInLine();
            String type = tokenVocabulary.getSymbolicName(ctx.type().getStart().getType());
            if(type == "")
                type = tokenVocabulary.getLiteralName(ctx.type().getStart().getType());

            errors.add("Syntax error at line " + line + "." + charPos + ": Expected type NUM but got type " + type ".");
        }
        return new SyntaxAnalysisNum();
    }

    /* ID '--' */
    @Override public SyntaxAnalysisType visitPost_decr(SyntaxAnalysisParser.Post_decrContext ctx) {
        if(!visit(ctx.ID()) instanceof SyntaxAnalysisNum) {
            int line = ctx.getStart().getLine();
            int charPos = ctx.getStart().getCharPositionInLine();
            String type = tokenVocabulary.getSymbolicName(ctx.type().getStart().getType());
            if(type == "")
                type = tokenVocabulary.getLiteralName(ctx.type().getStart().getType());

            errors.add("Syntax error at line " + line + "." + charPos + ": Expected type NUM but got type " + type ".");
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
        if(!visit(ctx.expression()) instanceof SyntaxAnalysisBool) {
            int line = ctx.getStart().getLine();
            int charPos = ctx.getStart().getCharPositionInLine();
            String type = tokenVocabulary.getSymbolicName(ctx.type().getStart().getType());
            if(type == "")
                type = tokenVocabulary.getLiteralName(ctx.type().getStart().getType());

            errors.add("Syntax error at line " + line + "." + charPos + ": Expected type BOOL but got type " + type ".");
        }

        return new SyntaxAnalysisBool();
    }

    /* expression bop=('*'|'/'|'%') expression */
    @Override public SyntaxAnalysisType visitMul_div_mod(SyntaxAnalysisParser.Mul_div_modContex ctx) {
        if(!visit(ctx.expression(0) instanceof SyntaxAnalysisNum) {
            int line = ctx.getStart().getLine();
            int charPos = ctx.getStart().getCharPositionInLine();
            String type = tokenVocabulary.getSymbolicName(ctx.type().getStart().getType());
            if(type == "")
                type = tokenVocabulary.getLiteralName(ctx.type().getStart().getType());

            errors.add("Syntax error at line " + line + "." + charPos + ": Expected type NUM but got type " + type ".");
        }

        if(!visit(ctx.expression(1) instanceof SyntaxAnalysisNum) {
            int line = ctx.getStart().getLine();
            int charPos = ctx.getStart().getCharPositionInLine();
            String type = tokenVocabulary.getSymbolicName(ctx.type().getStart().getType());
            if(type == "")
                type = tokenVocabulary.getLiteralName(ctx.type().getStart().getType());

            errors.add("Syntax error at line " + line + "." + charPos + ": Expected type NUM but got type " + type ".");
        }

        return new SyntaxAnalysisNum();
    }

    /* expression bop=('+'|'-') expression */
    @Override public SyntaxAnalysisType visitAdd_sub(SyntaxAnalysisParser.Add_subContext ctx) {
        if(!visit(ctx.expression(0) instanceof SyntaxAnalysisNum) {
            int line = ctx.getStart().getLine();
            int charPos = ctx.getStart().getCharPositionInLine();
            String type = tokenVocabulary.getSymbolicName(ctx.type().getStart().getType());
            if(type == "")
                type = tokenVocabulary.getLiteralName(ctx.type().getStart().getType());

            errors.add("Syntax error at line " + line + "." + charPos + ": Expected type NUM but got type " + type ".");
        }

        if(!visit(ctx.expression(1) instanceof SyntaxAnalysisNum) {
            int line = ctx.getStart().getLine();
            int charPos = ctx.getStart().getCharPositionInLine();
            String type = tokenVocabulary.getSymbolicName(ctx.type().getStart().getType());
            if(type == "")
                type = tokenVocabulary.getLiteralName(ctx.type().getStart().getType());

            errors.add("Syntax error at line " + line + "." + charPos + ": Expected type NUM but got type " + type ".");
        }

        return new SyntaxAnalysisNum();
    }

    /* expression bop=('<=' | '>=' | '<' | '>') expression */
    @Override public SyntaxAnalysisType visitLe_ge_lt_gt(SyntaxAnalysisParser.Le_ge_lt_gtContext ctx) {
        if(!visit(ctx.expression(0) instanceof SyntaxAnalysisNum) {
            int line = ctx.getStart().getLine();
            int charPos = ctx.getStart().getCharPositionInLine();
            String type = tokenVocabulary.getSymbolicName(ctx.type().getStart().getType());
            if(type == "")
                type = tokenVocabulary.getLiteralName(ctx.type().getStart().getType());

            errors.add("Syntax error at line " + line + "." + charPos + ": Expected type NUM but got type " + type ".");
        }

        if(!visit(ctx.expression(1) instanceof SyntaxAnalysisNum) {
            int line = ctx.getStart().getLine();
            int charPos = ctx.getStart().getCharPositionInLine();
            String type = tokenVocabulary.getSymbolicName(ctx.type().getStart().getType());
            if(type == "")
                type = tokenVocabulary.getLiteralName(ctx.type().getStart().getType());

            errors.add("Syntax error at line " + line + "." + charPos + ": Expected type NUM but got type " + type ".");
        }

        return new SyntaxAnalysisBool();
    }

    /* expression bop=('==' | '!=') expression */
    @Override public SyntaxAnalysisType visitEqual_notequal(SyntaxAnalysisParser.Equal_notequalContext ctx) {
        SyntaxAnalysisType expr1 = visit(ctx.expression(0));
        SyntaxAnalysisType expr2 = visit(ctx.expression(1));

        if(!expr1 instanceof SyntaxAnalysisNum || !expr1 instanceof SyntaxAnalysisBool) {
            int line = ctx.getStart().getLine();
            int charPos = ctx.getStart().getCharPositionInLine();
            String type = tokenVocabulary.getSymbolicName(ctx.type().getStart().getType());
            if(type == "")
                type = tokenVocabulary.getLiteralName(ctx.type().getStart().getType());

            errors.add("Syntax error at line " + line + "." + charPos + ": Expected type BOOL but got type " + type ".");
        }

        if(!expr2 instanceof SyntaxAnalysisNum || !expr2 instanceof SyntaxAnalysisBool) {
            int line = ctx.getStart().getLine();
            int charPos = ctx.getStart().getCharPositionInLine();
            String type = tokenVocabulary.getSymbolicName(ctx.type().getStart().getType());
            if(type == "")
                type = tokenVocabulary.getLiteralName(ctx.type().getStart().getType());

            errors.add("Syntax error at line " + line + "." + charPos + ": Expected type BOOL but got type " + type ".");
        }

        return new SyntaxAnalysisBool();
    }

    /* expression bop='&&' expression */
    @Override public SyntaxAnalysisType visitLogical_and(SyntaxAnalysisParser.Logical_andContext ctx) {
        if(!visit(ctx.expression(0) instanceof SyntaxAnalysisBool) {
            int line = ctx.getStart().getLine();
            int charPos = ctx.getStart().getCharPositionInLine();
            String type = tokenVocabulary.getSymbolicName(ctx.type().getStart().getType());
            if(type == "")
                type = tokenVocabulary.getLiteralName(ctx.type().getStart().getType());

            errors.add("Syntax error at line " + line + "." + charPos + ": Expected type BOOL but got type " + type ".");
        }

        if(!visit(ctx.expression(1) instanceof SyntaxAnalysisBool) {
            int line = ctx.getStart().getLine();
            int charPos = ctx.getStart().getCharPositionInLine();
            String type = tokenVocabulary.getSymbolicName(ctx.type().getStart().getType());
            if(type == "")
                type = tokenVocabulary.getLiteralName(ctx.type().getStart().getType());

            errors.add("Syntax error at line " + line + "." + charPos + ": Expected type BOOL but got type " + type ".");
        }

        return new SyntaxAnalysisBool();
    }

    /* expression bop='||' expression */
    @Override public SyntaxAnalysisType visitLogical_or(SyntaxAnalysisParser.Logical_orContext ctx) {
        if(!visit(ctx.expression(0) instanceof SyntaxAnalysisBool) {
            int line = ctx.getStart().getLine();
            int charPos = ctx.getStart().getCharPositionInLine();
            String type = tokenVocabulary.getSymbolicName(ctx.type().getStart().getType());
            if(type == "")
                type = tokenVocabulary.getLiteralName(ctx.type().getStart().getType());

            errors.add("Syntax error at line " + line + "." + charPos + ": Expected type BOOL but got type " + type ".");
        }

        if(!visit(ctx.expression(1) instanceof SyntaxAnalysisBool) {
            int line = ctx.getStart().getLine();
            int charPos = ctx.getStart().getCharPositionInLine();
            String type = tokenVocabulary.getSymbolicName(ctx.type().getStart().getType());
            if(type == "")
                type = tokenVocabulary.getLiteralName(ctx.type().getStart().getType());

            errors.add("Syntax error at line " + line + "." + charPos + ": Expected type BOOL but got type " + type ".");
        }

        return new SyntaxAnalysisBool();
    }

    /* <assoc=right> expression bop='?' expression ':' expression */
    @Override public SyntaxAnalysisType visitTertiary(SyntaxAnalysisParser.TertiaryContext ctx) {
        if(!visit(ctx.expression(0) instanceof SyntaxAnalysisBool) {
            int line = ctx.getStart().getLine();
            int charPos = ctx.getStart().getCharPositionInLine();
            String type = tokenVocabulary.getSymbolicName(ctx.type().getStart().getType());
            if(type == "")
                type = tokenVocabulary.getLiteralName(ctx.type().getStart().getType());

            errors.add("Syntax error at line " + line + "." + charPos + ": Expected type BOOL but got type " + type ".");
        }

        if(!visit(ctx.expression(1) instanceof SyntaxAnalysisType) {
            int line = ctx.getStart().getLine();
            int charPos = ctx.getStart().getCharPositionInLine();
            String type = tokenVocabulary.getSymbolicName(ctx.type().getStart().getType());
            if(type == "")
                type = tokenVocabulary.getLiteralName(ctx.type().getStart().getType());

            errors.add("Syntax error at line " + line + "." + charPos + ": Expected type NUM, BOOL or VOID but got type " + type ".");
        }

        if(!visit(ctx.expression(2) instanceof SyntaxAnalysisType) {
            int line = ctx.getStart().getLine();
            int charPos = ctx.getStart().getCharPositionInLine();
            String type = tokenVocabulary.getSymbolicName(ctx.type().getStart().getType());
            if(type == "")
                type = tokenVocabulary.getLiteralName(ctx.type().getStart().getType());

            errors.add("Syntax error at line " + line + "." + charPos + ": Expected type NUM, BOOL or VOID but got type " + type ".");
        }

        return new SyntaxAnalysisVoid();
    }

    /* '(' expression ')' */
    @Override public SyntaxAnalysisType visitParens(SyntaxAnalysisParser.ParensContext ctx) {
        if(!visit(ctx.expression()) instanceof SyntaxAnalysisNum) {
            int line = ctx.getStart().getLine();
            int charPos = ctx.getStart().getCharPositionInLine();
            String type = tokenVocabulary.getSymbolicName(ctx.type().getStart().getType());
            if(type == "")
                type = tokenVocabulary.getLiteralName(ctx.type().getStart().getType());
            
            errors.add("Syntax error at line " + line + "." + charPos + ": Expected type NUM but got type " + type ".");
        }

        return new SyntaxAnalysisVoid();
    }

    /* DIGITS */
    @Override public SyntaxAnalysisType visitDigits(SyntaxAnalysisParser.DigitsContext ctx) {
        return new SyntaxAnalysisNum();
    }

    /* ID */
    @Override public SyntaxAnalysisType visitId(SyntaxAnalysisParser.IdContex ctx) {
        String id = ctx.ID().getText();
        if(memory.containsKey(id)) {
            return memory.get(id);
        }

        int line = ctx.getStart().getLine();
        int charPos = ctx.getStart().getCharPositionInLine();
        errors.add("Syntax error at line " + line + "." + charPos + ": Variable " + id + " not found. Please assign a variable before attempting to use it.");

        return new SyntaxAnalysisVoid();
    }

    /* BOOL */
    @Override public SyntaxAnalysisType visitBool(SyntaxAnalysisParser.BoolContext ctx) {
        return new SyntaxAnalysisBool();
    }

    /* ID '(' param ')' '.' */
    @Override public SyntaxAnalysisType visitFuncCall(SyntaxAnalysisParser.FuncCallContext ctx) {
        visit(param);
        return new SyntaxAnalysisVoid();
    }

    /* (type ID (',' type ID)*)? */
    @Override public SyntaxAnalysisType visitFparameters(SyntaxAnalysisParser.FparametersContext ctx) {
        for(SyntaxAnalysisParser.IdContext fparam : ctx.ID()) {
            SyntaxAnalysisType type = visit(ctx.type());
            varEnv.put(fparam, type);
        }

        return new SyntaxAnalysisVoid();
    }

    /* (expression (',' expression)*)? */
    @Override public SyntaxAnalysisType visitParameters(SyntaxAnalysisParser.ParametersContext ctx) {
        String funcID = ctx.getParent().ID().getText();
        SyntaxAnalysisFuncType func = fEnv.get(funcID);
        List funcParams = func.getParameters().values();
        int i = 0;

        for(SyntaxAnalysisParser.ExpressionContext expr : ctx.expression()) {
            if(!visit(expr) instanceof funcParams(i)) {
                int line = ctx.getStart().getLine();
                int charPos = ctx.getStart().getCharPositionInLine();
                String type = tokenVocabulary.getSymbolicName(ctx.type().getStart().getType());
                if(type == "")
                    type = tokenVocabulary.getLiteralName(ctx.type().getStart().getType());
                
                errors.add("Syntax error at line " + line + "." + charPos + ": Expected type " + funcParams(i).getTypeName() + " but got type " + type ".");
            }
            i++;
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
}