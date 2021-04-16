import java.util.HashMap;
import java.util.Map;
import gen.*;

public class WhenCollect extends SyntaxAnalysisBaseVisitor<Map<String, SyntaxAnalysisFuncType>> {
    private Map<String, WhenMethod> _methods = new HashMap<String, WhenMethod>();

    public Map<String, WhenMethod> getMethods() {
        return _methods;
    }
}