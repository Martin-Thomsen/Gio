package RoboBasic;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import RoboBasicGen.*;
import org.antlr.v4.runtime.tree.TerminalNode;

public class FuncCollect extends SyntaxAnalysisBaseVisitor<Map<String, SyntaxAnalysisFuncType>> {
    Map<String, SyntaxAnalysisFuncType> fEnv = new HashMap<>();
    EvalVisitor evalVis = new EvalVisitor(new HashMap<>(), new HashMap<>(), new ControlsCollect(), new ArrayList<>());

    public Map<String, SyntaxAnalysisFuncType> getEnvironment() {
        return fEnv;
    }

    public List<String> getErrors() {
        return evalVis.getErrors();
    }

    @Override public Map<String, SyntaxAnalysisFuncType> visitProgram(SyntaxAnalysisParser.ProgramContext ctx) {
        visitChildren(ctx);

        boolean runCheck = false;

        for(Map.Entry<String, SyntaxAnalysisFuncType> function : fEnv.entrySet()) {
            if(function.getKey().equals("run"))
                runCheck = true;
        }

        if(!runCheck) {
            evalVis.addError(ctx, "No function named run discovered. Please add a function named run");
        }

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
        if(ctx.getParent() instanceof SyntaxAnalysisParser.WhenContext) {
            return fEnv;
        }

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

    public void addFunctionToEnvironment(String id, SyntaxAnalysisFuncType func) {
        fEnv.put(id, func);
    }
}