import java.util.HashMap;
import java.util.Map;

public class SyntaxAnalysisFuncType extends SyntaxAnalysisType {
    private Map<String, SyntaxAnalysisType> _params;
    private SyntaxAnalysisType _returnType;

    public SyntaxAnalysisFuncType(){
        _params = new HashMap<String, SyntaxAnalysisType>();
    }

    public void setReturnType(SyntaxAnalysisType returnType) {
        _returnType = returnType;
    }

    public SyntaxAnalysisType getReturnType() {
        return _returnType;
    }

    public void addParameter(String name, SyntaxAnalysisType param) {
        if(_params.containsKey(name)) {
            // Handle name clash
        } else {
            _params.put(name, param);
        }
    }

    public Map<String, SyntaxAnalysisType> getParameters() {
        return _params;
    }
}