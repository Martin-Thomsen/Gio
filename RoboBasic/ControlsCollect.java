package RoboBasic;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Map;
import java.util.HashMap;
import java.io.IOException;

public class ControlsCollect {
    Map<String, SyntaxAnalysisFuncType> controlFunctions = new HashMap<>();
    Map<String, String> translatedControlFuncs = new HashMap<>();
    Map<String, SyntaxAnalysisType> controlVariables = new HashMap<>();
    Map<String, String> translatedControlVars = new HashMap<>();

    public void CollectControls() throws IOException {
        BufferedReader csvReader = new BufferedReader(new FileReader("C:\\Users\\m-s-t\\Documents\\GitHub\\Gio\\DefaultControls.csv"));
        String line = "";
        while((line = csvReader.readLine()) != null) {
            String[] splitLine = line.split(",");

            for(int i = 0; i < splitLine.length; i++) {
                String[] variable = splitLine[i].split(":");
                String type = variable[0];
                String id = variable[1];
                String translation = variable[2];

                if(id.contains("(")) {
                    SyntaxAnalysisFuncType func = new SyntaxAnalysisFuncType();
                    func.setReturnType(getTypeFromString(type));
                    SyntaxAnalysisType paramType = getTypeFromString(id.substring(id.indexOf("(") + 1, id.indexOf(")")));
                    if(!(paramType.getTypeName().equals("VOID"))) {
                        func.addParameter("", paramType);
                    }
                    controlFunctions.put(id.substring(0, id.indexOf("(")), func);
                    translatedControlFuncs.put(id.substring(0, id.indexOf("(")), translation);
                } else {
                    controlVariables.put(id, getTypeFromString(type));
                    translatedControlVars.put(id, translation);
                }
            }
        }

        csvReader.close();
    }

    public Map<String, SyntaxAnalysisFuncType> getControlFunctions() {
        return controlFunctions;
    }

    public Map<String, String> getTranslatedControlFuncs() {
        return translatedControlFuncs;
    }

    public Map<String, SyntaxAnalysisType> getControlVariables() {
        return controlVariables;
    }

    public Map<String, String> getTranslatedControlVars() {
        return translatedControlVars;
    }

    SyntaxAnalysisType getTypeFromString(String input) {
        switch(input) {
            case "num":
                return new SyntaxAnalysisNum();
            case "bool":
                return new SyntaxAnalysisBool();
            default:
                return new SyntaxAnalysisVoid();
        }
    }
}
