import java.util.Map;
import java.util.HashMap;

public class WhenMethod extends SyntaxAnalysisType {
    private SyntaxAnalysisType _returnType;
    private String _translation;

    public WhenMethod(SyntaxAnalysisType returnType, String translation) {
        _returnType = returnType;
        _translation = translation;
    }

    public String getTranslation() {
        return _translation;
    }

    public SyntaxAnalysisType getReturnType() {
        return _returnType;
    }
}