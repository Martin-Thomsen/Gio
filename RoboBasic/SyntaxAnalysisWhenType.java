package RoboBasic;
import java.util.HashMap;
import java.util.Map;

public class SyntaxAnalysisWhenType extends SyntaxAnalysisType {
    private Map<String, SyntaxAnalysisType> _params;
    private Map<String, String> _translatedParams;

    public SyntaxAnalysisWhenType(){
        _params = new HashMap<>();
        _translatedParams = new HashMap<>();
    }

    public void addParameter(String name, SyntaxAnalysisType param, String translatedParam, String variablePrefix) {
        if(_params.containsKey(name)) {
            // Handle name clash
        } else {
            _params.put(name, param);
            _translatedParams.put(name, variablePrefix + "." + translatedParam);
        }
    }

    public Map<String, SyntaxAnalysisType> getParameters() {
        return _params;
    }

    public Map<String, String> getTranslatedParameters() {
        return _translatedParams;
    }

    @Override public String getTypeName() {
        return "EVENT";
    }
}