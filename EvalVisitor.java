import java.util.Map;
import java.util.HashMap;
import gen.*;

public class EvalVisitor extends SyntaxAnalysisBaseVisitor<SyntaxAnalysisType>{
    Map<String, SyntaxAnalysisType> memory = new HashMap<String, SyntaxAnalysisType>;
    Map<String, SyntaxAnalysisType> varEnv;
    Map<String, SyntaxAnalysisFuncType> fEnv;

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
                // error
            }
        }

        for(SyntaxAnalysisParser.BlockContext block : ctx.block()) {
            if(!visit(block) instanceof SyntaxAnalysisVoid) {
                // error
            }
        }

        return new SyntaxAnalysisVoid();
    }

    /* 'repeat' '(' (DIGITS | ID) ')' block 'endRepeat' */
    @Override public SyntaxAnalysisType visitRep(SyntaxAnalysisParser.RepContext ctx) {
        int val;
        if(ctx.ID() != null)
            visit(ctx.ID());
        else
            visit(ctx.DIGITS());

        visit(ctx.block());

        return new SyntaxAnalysisVoid();
    }

    /* 'repeatIf' '(' expression ')' block 'endRepeatIf' */
    @Override public SyntaxAnalysisType visitRep_if(SyntaxAnalysisParser.Rep_ifContext ctx) {

        visit(ctx.block());

        return new SyntaxAnalysisVoid();
    }

    /* 'repeatUntil' '(' expression ')' block 'endRepeatUntil' */
    @Override public SyntaxAnalysisType visitRep_until(SyntaxAnalysisParser.Rep_untilContext ctx) {
        do {
            visit(ctx.block(0));
        } while(!visit(ctx.expr(0)));
        return new SyntaxAnalysisVoid();
    }

    /* func_Call */
    @Override public SyntaxAnalysisType visitFunc_stmt(SyntaxAnalysisParser.Func_stmtContext ctx) {
        visit(ctx.func_Call(0));
        return new SyntaxAnalysisVoid();
    }

    /* ID '=' (expression | incr_Stmt | decr_Stmt) '.' */
    @Override public SyntaxAnalysisType visitAssign(SyntaxAnalysisParser.AssignContext ctx) {
        String id = ctx.ID().getText();
        Value val;

        if(ctx.expression() != null)
            val = new Value(visit(ctx.expression()));
        else if(ctx.incr_Stmt() != null)
            val = new Value(visit(ctx.incr.Stmt()));
        else
            val = new Value(visit(ctx.decr_Stmt()));

        memory.put(id, val);
        return new SyntaxAnalysisVoid();
    }

    /* incr_Stmt */
    @Override public SyntaxAnalysisType visitIncr(SyntaxAnalysisParser.IncrContext ctx) {
        return visit(ctx.incr_Stmt());
    }

    /* decr_Stmt */
    @Override public SyntaxAnalysisType visitDecr(SyntaxAnalysisParser.DecrContext ctx) {
        return visit(ctx.decr_Stmt());
    }

    /* '++' ID */
    @Override public SyntaxAnalysisType visitPre_incr(SyntaxAnalysisParser.Pre_incrContex ctx) {
        String id = ctx.ID().getText();
        if(memory.containsKey(id)){
            Value val = new Value(memory.get(id));
            val.value = val.value + 1;
            memory.replace(id, value);
            return value;
        }
        return new SyntaxAnalysisVoid();
    }

    /* ID '++' */
    @Override public SyntaxAnalysisType visitPost_incr(SyntaxAnalysisParser_Post.incrContext ctx) {
        String id = ctx.ID().getText();
        if(memory.containsKey(id)){
            Value val = new Value(memory.get(id));
            memory.replace(id, value + 1);
            return value;
        }
        return new SyntaxAnalysisVoid();
    }

    /* 'return' expression */
    @Override public SyntaxAnalysisType visitReturnStmt(SyntaxAnalysisParser.ReturnStmtContext ctx) {
        String funcID = ctx.getParent().ID().getText();
        SyntaxAnalysisFuncType func = fEnv.get(funcID);
        SyntaxAnalysisType returnType = func.getReturnType();

        if(!visit(ctx.expression()) instanceof returnType) {
            // error
        }

        return new SyntaxAnalysisVoid();
    }

    /* '--' ID */
    @Override public SyntaxAnalysisType visitPre_decr(SyntaxAnalysisParser.Pre_decrContex ctx) {
        String id = ctx.ID().getText();
        if(memory.containsKey(id)){
            Value val = new Value(memory.get(id));
            val.value = val.value - 1;
            memory.replace(id, value);
            return value;
        }
        return new SyntaxAnalysisVoid();
    }

    /* ID '--' */
    @Override public SyntaxAnalysisType visitPost_decr(SyntaxAnalysisParser.Post_decrContext ctx) {
        String id = ctx.ID().getText();
        if(memory.containsKey(id)){
            Value val = new Value(memory.get(id));
            memory.replace(id, value - 1);
            return value;
        }
        return new SyntaxAnalysisVoid();
    }

    /* primary */
    @Override public SyntaxAnalysisType visitPrim(SyntaxAnalysisParser.PrimContext ctx) {
        visit(ctx.primary());
        return new SyntaxAnalysisVoid();
    }

    /* expression '[' expression ']' */
    @Override public SyntaxAnalysisType visitArray(SyntaxAnalysisParser.ArrayContext ctx) {
        /* TO BE IMPLEMENTED */
    }

    /* func_Call */
    @Override public SyntaxAnalysisType visitFunc_expr(SyntaxAnalysisParser.Func_exprContext ctx) {
        visit(ctx.func_Call(0));
        return new SyntaxAnalysisVoid();
    }

    /* expression bop=('*'|'/'|'%') expression */
    @Override public SyntaxAnalysisType visitMul_div_mod(SyntaxAnalysisParser.Mul_div_modContex ctx) {
        int left = visit(ctx.expression(0));
        int right = visit(ctx.expression(1));
        if (ctx.bop.getType() == SyntaxAnalysisParser.MUL ) return left * right;
        else if (ctx.bop.getType() == SyntaxAnalysisParser.DIV) return left / right;
        return left % right;
    }

    /* expression bop=('+'|'-') expression */
    @Override public SyntaxAnalysisType visitAdd_sub(SyntaxAnalysisParser.Add_subContext ctx) {
        int left = visit(ctx.expression(0));
        int right = visit(ctx.expression(1));
        if (ctx.bop.getType() == SyntaxAnalysisParser.ADD ) return left + right;
        return left - right;
    }

    /* expression bop=('<=' | '>=' | '<' | '>') expression */
    @Override public SyntaxAnalysisType visitLe_ge_lt_gt(SyntaxAnalysisParser.Le_ge_lt_gtContext ctx) {
        int left = visit(ctx.expression(0));
        int right = visit(ctx.expression(1));
        if (ctx.bop.getType() == SyntaxAnalysisParser.LE ) return left <= right;
        else if (ctx.bop.getType() == SyntaxAnalysisParser.GE) return left >= right;
        else if (ctx.bop.getType() == SyntaxAnalysisParser.LT) return left < right;
        return left > right;
    }

    /* expression bop=('==' | '!=') expression */
    @Override public SyntaxAnalysisType visitEqual_notequal(SyntaxAnalysisParser.Equal_notequalContext ctx) {
        int left = visit(ctx.expression(0));
        int right = visit(ctx.expression(1));
        if (ctx.bop.getType() == SyntaxAnalysisParser.EQUALS ) return left == right;
        return left != right;
    }

    /* expression bop='&&' expression */
    @Override public SyntaxAnalysisType visitLogical_and(SyntaxAnalysisParser.Logical_andContext ctx) {
        int left = visit(ctx.expression(0));
        int right = visit(ctx.expression(1));
        return left && right;
    }

    /* expression bop='||' expression */
    @Override public SyntaxAnalysisType visitLogical_or(SyntaxAnalysisParser.Logical_orContext ctx) {
        int left = visit(ctx.expression(0));
        int right = visit(ctx.expression(1));
        return left || right;
    }

    /* <assoc=right> expression bop='?' expression ':' expression */
    @Override public SyntaxAnalysisType visitTertiary(SyntaxAnalysisParser.TertiaryContext ctx) {
        if(visit(ctx.expression(0)))
            return visit(ctx.expression(1));
        else
            return visit(ctx.expression(2));
    }

    /* '(' expression ')' */
    @Override public SyntaxAnalysisType visitParens(SyntaxAnalysisParser.ParensContext ctx) {
        visit(ctx.expression());
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

        // Error

        return new SyntaxAnalysisVoid();
    }

    /* BOOL */
    @Override public SyntaxAnalysisType visitBool(SyntaxAnalysisParser.BoolContext ctx) {
        return new SyntaxAnalysisBool();
    }

    /* ID '(' param ')' '.' */
    @Override public SyntaxAnalysisType visitFuncCall(SyntaxAnalysisParser.FuncCallContext ctx) {
        /* TO BE IMPLEMENTED */
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
        for(SyntaxAnalysisParser.ExpressionContext expr : ctx.expression()) {
            visit(expr);
        }

        return new SyntaxAnalysisVoid();
    }
}