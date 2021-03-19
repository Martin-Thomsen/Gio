import java.util.Map;
import java.util.HashMap;
import java.util;

public class EvalVisitor extends SyntaxAnalysisBaseVisitor<Value>{
    Map<String, Value> memory = new HashMap<String, Value>;

    /* 'function' ID '(' param ')' block 'endFunction' */
    @Override public Value visitFunction(SyntaxAnalysisParser.FunctionContext ctx) {
        String id = ctx.ID().getText();
        List<Value> parameters = visit(ctx.param());
        visit(ctx.block());
        return new Value(0);

        /* NOT FULLY IMPLEMENTED */
    }

    /* 'when' ID '(' param ')' block 'endWhen' */
    @Override public Value visitWhen(SyntaxAnalysisParser.WhenContext ctx) {
        String id = ctx.ID().getText();
        List<Value> parameters = visit(ctx.param());
        visit(ctx.block());
        return new Value(0);

        /* NOT FULLY IMPLEMENTED */
    }

    /* stmt* */
    @Override public Value visitBlk(SyntaxAnalysisParser.BlkContext ctx) {
        /* TO BE IMPLEMENTED */
    }

    /* 'if' '(' expression ')' 'do' block ('else if' '(' expression ')' 'do' block)* ('else do' block)? 'endIf' */
    @Override public Value visitIf(SyntaxAnalysisParser.IfContext ctx) {
        if(visit(ctx.expression(0))) {
            visit(ctx.block(0));
            return new Value(0);
        }
        int i = 1;
        while(true) {
            if (ctx.block(i) == null)
                break;
            if(ctx.expr(i) == null){
                visit(ctx.block(i));
                return new Value(0);
            }
            else if(visit(ctx.expr(i)))
            {
                visit(ctx.block(i));
                return new Value(0);
            }
            i++;
        }

        return new Value(0);
    }

    /* 'repeat' '(' (DIGITS | ID) ')' block 'endRepeat' */
    @Override public Value visitRep(SyntaxAnalysisParser.RepContext ctx) {
        int val;
        if(ctx.ID() != null)
            val = visit(ctx.ID());
        else
            val = visit(ctx.DIGITS());

        for(int i = 0; i < val; i++){
            visit(ctx.block());
        }

        return new Value(0);
    }

    /* 'repeatIf' '(' expression ')' block 'endRepeatIf' */
    @Override public Value visitRep_if(SyntaxAnalysisParser.Rep_ifContext ctx) {
        while(visit(ctx.expr(0))){
            visit(ctx.block(0));
        }
        return new Value(0);
    }

    /* 'repeatUntil' '(' expression ')' block 'endRepeatUntil' */
    @Override public Value visitRep_until(SyntaxAnalysisParser.Rep_untilContext ctx) {
        do {
            visit(ctx.block(0));
        } while(!visit(ctx.expr(0)));
        return new Value(0);
    }

    /* func_Call */
    @Override public Value visitFunc_stmt(SyntaxAnalysisParser.Func_stmtContext ctx) {
        visit(ctx.func_Call(0));
        return new Value(0);
    }

    /* ID '=' (expression | incr_Stmt | decr_Stmt) '.' */
    @Override public Value visitAssign(SyntaxAnalysisParser.AssignContext ctx) {
        String id = ctx.ID().getText();
        Value val;

        if(ctx.expression() != null)
            val = new Value(visit(ctx.expression()));
        else if(ctx.incr_Stmt() != null)
            val = new Value(visit(ctx.incr.Stmt()));
        else
            val = new Value(visit(ctx.decr_Stmt()));

        memory.put(id, val);
        return new Value(0);
    }

    /* incr_Stmt */
    @Override public Value visitIncr(SyntaxAnalysisParser.IncrContext ctx) {
        visit(ctx.incr_Stmt());
        return new Value(0);
    }

    /* decr_Stmt */
    @Override public Value visitDecr(SyntaxAnalysisParser.DecrContext ctx) {
        visit(ctx.decr_Stmt());
        return new Value(0);
    }

    /* '++' ID */
    @Override public Value visitPre_incr(SyntaxAnalysisParser.Pre_incrContex ctx) {
        String id = ctx.ID().getText();
        if(memory.containsKey(id)){
            Value val = new Value(memory.get(id));
            val.value = val.value + 1;
            memory.replace(id, value);
            return value;
        }
        return new Value(0);
    }

    /* ID '++' */
    @Override public Value visitPost_incr(SyntaxAnalysisParser_Post.incrContext ctx) {
        String id = ctx.ID().getText();
        if(memory.containsKey(id)){
            Value val = new Value(memory.get(id));
            memory.replace(id, value + 1);
            return value;
        }
        return new Value(0);
    }

    /* '--' ID */
    @Override public Value visitPre_decr(SyntaxAnalysisParser.Pre_decrContex ctx) {
        String id = ctx.ID().getText();
        if(memory.containsKey(id)){
            Value val = new Value(memory.get(id));
            val.value = val.value - 1;
            memory.replace(id, value);
            return value;
        }
        return new Value(0);
    }

    /* ID '--' */
    @Override public Value visitPost_decr(SyntaxAnalysisParser.Post_decrContext ctx) {
        String id = ctx.ID().getText();
        if(memory.containsKey(id)){
            Value val = new Value(memory.get(id));
            memory.replace(id, value - 1);
            return value;
        }
        return new Value(0);
    }

    /* primary */
    @Override public Value visitPrim(SyntaxAnalysisParser.PrimContext ctx) {
        visit(ctx.primary());
        return new Value(0);
    }

    /* expression '[' expression ']' */
    @Override public Value visitArray(SyntaxAnalysisParser.ArrayContext ctx) {
        /* TO BE IMPLEMENTED */
    }

    /* func_Call */
    @Override public Value visitFunc_expr(SyntaxAnalysisParser.Func_exprContext ctx) {
        visit(ctx.func_Call(0));
        return new Value(0);
    }

    /* expression bop=('*'|'/'|'%') expression */
    @Override public Value visitMul_div_mod(SyntaxAnalysisParser.Mul_div_modContex ctx) {
        int left = visit(ctx.expression(0));
        int right = visit(ctx.expression(1));
        if (ctx.bop.getType() == SyntaxAnalysisParser.MUL ) return left * right;
        else if (ctx.bop.getType() == SyntaxAnalysisParser.DIV) return left / right;
        return left % right;
    }

    /* expression bop=('+'|'-') expression */
    @Override public Value visitAdd_sub(SyntaxAnalysisParser.Add_subContext ctx) {
        int left = visit(ctx.expression(0));
        int right = visit(ctx.expression(1));
        if (ctx.bop.getType() == SyntaxAnalysisParser.ADD ) return left + right;
        return left - right;
    }

    /* expression bop=('<=' | '>=' | '<' | '>') expression */
    @Override public Value visitLe_ge_lt_gt(SyntaxAnalysisParser.Le_ge_lt_gtContext ctx) {
        int left = visit(ctx.expression(0));
        int right = visit(ctx.expression(1));
        if (ctx.bop.getType() == SyntaxAnalysisParser.LE ) return left <= right;
        else if (ctx.bop.getType() == SyntaxAnalysisParser.GE) return left >= right;
        else if (ctx.bop.getType() == SyntaxAnalysisParser.LT) return left < right;
        return left > right;
    }

    /* expression bop=('==' | '!=') expression */
    @Override public Value visitEqual_notequal(SyntaxAnalysisParser.Equal_notequalContext ctx) {
        int left = visit(ctx.expression(0));
        int right = visit(ctx.expression(1));
        if (ctx.bop.getType() == SyntaxAnalysisParser.EQUALS ) return left == right;
        return left != right;
    }

    /* expression bop='&&' expression */
    @Override public Value visitLogical_and(SyntaxAnalysisParser.Logical_andContext ctx) {
        int left = visit(ctx.expression(0));
        int right = visit(ctx.expression(1));
        return left && right;
    }

    /* expression bop='||' expression */
    @Override public Value visitLogical_or(SyntaxAnalysisParser.Logical_orContext ctx) {
        int left = visit(ctx.expression(0));
        int right = visit(ctx.expression(1));
        return left || right;
    }

    /* <assoc=right> expression bop='?' expression ':' expression */
    @Override public Value visitTertiary(SyntaxAnalysisParser.TertiaryContext ctx) {
        if(visit(ctx.expression(0)))
            return visit(ctx.expression(1));
        else
            return visit(ctx.expression(2));
    }

    /* '(' expression ')' */
    @Override public Value visitParens(SyntaxAnalysisParser.ParensContext ctx) {
        visit(ctx.expression());
        return new Value(0);
    }

    /* DIGITS */
    @Override public Value visitDigits(SyntaxAnalysisParser.DigitsContext ctx) {
        return new Value(Integer.valueOf(ctx.DIGITS().getText()));
    }

    /* ID */
    @Override public Value visitId(SyntaxAnalysisParser.IdContex ctx) {
        String id = ctx.ID().getText();
        if(memory.containsKey(id)) return memory.get(id);
        return new Value(0);
    }

    /* BOOL */
    @Override public Value visitBool(SyntaxAnalysisParser.BoolContext ctx) {
        String text = ctx.BOOL().getText();
        if(text == "true") return new Value(true);
        return new Value(false);
    }

    /* ID '(' param ')' '.' */
    @Override public Value visitFuncCall(SyntaxAnalysisParser.FuncCallContext ctx) {
        /* TO BE IMPLEMENTED */
    }

    /* (expression (',' expression)*)? */
    @Override public Value visitParameters(SyntaxAnalysisParser.ParametersContext ctx) {
        List<Value> params = new List<Value>();
        int i = 0;
        while(true) {
            if(ctx.expr(i) == null)
                break;
            parameters.Add(visit(ctx.expr(i)));
            i++;
        }

        /* NOT FULLY IMPLEMENTED */
    }
}

public class Value {
    private Object value;

    public Value(Object object) {
        this.value = object
        if (!(isBoolean() || isInteger))
            throw new IllegalArgumentException();
    }


    public boolean isBoolean() {
        return value instanceof Boolean;
    }
    public Boolean asBoolean() {
        return (Boolean) value;
    }

    public boolean isInteger() {
        return value instanceof Integer;
    }

    public Integer asInteger() {
        return (Integer) value;
    }


    @Override
    public int hashCode() {
        // generate hascode
    }

    @Override
    public boolean equals(Object object) {
        // equals
    }
}