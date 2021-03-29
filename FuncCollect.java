import java.util.HashMap;
import java.util.Map;

public class FuncCollect extends SyntaxAnalysisBaseVisitor<Map<String, SyntaxAnalysisFuncType>> {
    Map<String, SyntaxAnalysisFuncType> fEnv = new HashMap<String, SyntaxAnalysisFuncType>();

    @Override public Map<String, SyntaxAnalysisFuncType> visitFunction(SyntaxAnalysisParser.FunctionContext ctx) {
        String id = ctx.ID().getText();
        SyntaxAnalysisType returnType = visit(ctx.ftype());

        if(!fEnv.containsKey(id)) {
            SyntaxAnalysisFuncType func = new SyntaxAnalysisFuncType();
            func.setReturnType(returnType);
            fEnv.put(id, func);
        }
        else {
            // Handle name clash
        }

        return visit(ctx.fparams());
    }

    @Override public Map<String, SyntaxAnalysisFuncType> visitFparameters(SyntaxAnalysisParser.FparametersContext ctx) {
        String id = ctx.getParent().ID().getText();
        SyntaxAnalysisFuncType func = fEnv.get(id);

        int i = 0;
        for(SyntaxAnalysisParser.IdContext param : ctx.ID()) {
            SyntaxAnalysisType type = visit(ctx.type(i));
            func.addParameter(param, type);
            i++;
        }

        fEnv.replace(id, func);

        return fEnv;
    }
}