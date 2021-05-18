package RoboBasic;
import java.util.HashMap;
import java.util.Map;

public class SyntaxAnalysisWhenType extends SyntaxAnalysisType {
    private Map<String, SyntaxAnalysisType> _params;
    private Map<String, String> _translatedParams;
    private String _eventName;

    public SyntaxAnalysisWhenType(){
        _params = new HashMap<>();
        _translatedParams = new HashMap<>();
    }

    public void addParameter(String name, SyntaxAnalysisType param, String translatedParam) {
        if(_params.containsKey(name)) {
            // Handle name clash
        } else {
            _params.put(name, param);
            _translatedParams.put(name, "event." + translatedParam);
        }
    }

    public Map<String, SyntaxAnalysisType> getParameters() {
        return _params;
    }

    public Map<String, String> getTranslatedParameters() {
        return _translatedParams;
    }

    public void setEventName(String eventName) {
        _eventName = eventName;
    }

    public String getEventName() {
        return _eventName;
    }

    @Override public String getTypeName() {
        return "EVENT";
    }
}