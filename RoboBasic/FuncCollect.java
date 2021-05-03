package RoboBasic;
import java.util.HashMap;
import java.util.Map;
import RoboBasicGen.*;
import org.antlr.v4.runtime.tree.TerminalNode;

public class FuncCollect extends SyntaxAnalysisBaseVisitor<Map<String, SyntaxAnalysisFuncType>> {
    Map<String, SyntaxAnalysisFuncType> fEnv = new HashMap<>();
    EvalVisitor evalVis = new EvalVisitor(fEnv);

    public Map<String, SyntaxAnalysisFuncType> getEnvironment() {
        return fEnv;
    }

    @Override public Map<String, SyntaxAnalysisFuncType> visitFunction(SyntaxAnalysisParser.FunctionContext ctx) {
        String id = ctx.ID().getText();
        SyntaxAnalysisType returnType = evalVis.visit(ctx.ftype());

        if(!fEnv.containsKey(id)) {
            SyntaxAnalysisFuncType func = new SyntaxAnalysisFuncType();
            func.setReturnType(returnType);
            fEnv.put(id, func);
        }
        else {
            evalVis.addError(ctx, "Function with name " + id + " already exists");
        }

        return visit(ctx.fparam());
    }

    @Override public Map<String, SyntaxAnalysisFuncType> visitFparameters(SyntaxAnalysisParser.FparametersContext ctx) {
        String id = ((SyntaxAnalysisParser.FunctionContext)ctx.getParent()).ID().getText();
        SyntaxAnalysisFuncType func = fEnv.get(id);

        int i = 0;
        for(TerminalNode param : ctx.ID()) {
            SyntaxAnalysisType type = evalVis.visit(ctx.type(i));
            func.addParameter(param.getText(), type);
            i++;
        }

        fEnv.replace(id, func);

        return fEnv;
    }
}