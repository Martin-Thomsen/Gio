import java.util.Map;
import java.util.HashMap;

public class EvalVisitor extends SyntaxAnalysisBaseVisitor<Integer, Bool>{

    Map<String, Value> memory = new HashMap<Value>;
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