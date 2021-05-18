package RoboBasic;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Map;
import java.util.HashMap;
import java.io.IOException;

public class EventCollect {
    Map<String, SyntaxAnalysisWhenType> wEnv = new HashMap<>();

    public Map<String, SyntaxAnalysisWhenType> getEnvironment() {
        return wEnv;
    }

    public void CollectEvents() throws IOException {
        BufferedReader csvReader = new BufferedReader(new FileReader("C:\\Users\\m-s-t\\Documents\\GitHub\\Gio\\Events.csv"));
        String line = "";
        while((line = csvReader.readLine()) != null) {
            SyntaxAnalysisWhenType event = new SyntaxAnalysisWhenType();
            String[] splitLine = line.split(",");
            String id = splitLine[0];
            event.setEventName(splitLine[1]);

            for(int i = 2; i < splitLine.length; i++) {
                String[] variable = splitLine[i].split(":");
                event.addParameter(variable[1], getTypeFromString(variable[0]), variable[2]);
            }

            wEnv.put(id, event);
        }

        csvReader.close();
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
