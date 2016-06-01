package by.it.sinkevich.jd01_09.variables;


import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by Computer on 01.06.2016.
 *
 * @author Sinkevich Denis
 */
public class VariablesStorage {

    private final static Map<String, MathLabVariable> variablesStorage = new HashMap<>();

    public static void add(String variableName, MathLabVariable variableValue) {
        variablesStorage.put(variableName, variableValue);
    }

    public static MathLabVariable get(String variableName) {
        return variablesStorage.get(variableName);
    }

    public static void printVariables() {
        System.out.println(variablesStorage);
    }

    public static void printSortedvariables() {
        Map<String, MathLabVariable> sortedMap = new TreeMap<>(variablesStorage);
        System.out.println(sortedMap);
    }
}
