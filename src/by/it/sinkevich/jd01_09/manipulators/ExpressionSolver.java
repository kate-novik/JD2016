package by.it.sinkevich.jd01_09.manipulators;

import by.it.sinkevich.jd01_09.variables.MathLabFloat;
import by.it.sinkevich.jd01_09.variables.MathLabMatrix;
import by.it.sinkevich.jd01_09.variables.MathLabVariable;
import by.it.sinkevich.jd01_09.variables.MathLabVector;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Computer on 28.05.2016.
 *
 * @author Sinkevich Denis
 */
public class ExpressionSolver {

    private static Manipulator manipulator = new Manipulator();

    public static MathLabVariable solveExpression(List<String> parsedLine) {
        List<String> tempList = new ArrayList<>(parsedLine);
        for (int indexOperators = 2; indexOperators < tempList.size(); indexOperators = indexOperators + 2) {
            String operator = tempList.get(indexOperators);
            if (operator.equals("*") || operator.equals("/")) {
                MathLabVariable leftVariable = getVariableFromString(tempList.get(indexOperators - 1));
                MathLabVariable rightVariable = getVariableFromString(tempList.get(indexOperators + 1));
                tempList.set(indexOperators - 1, "0");
                tempList.set(indexOperators, "+");
                if (operator.equals("*")) {
                    MathLabVariable temp = manipulator.multiplication(leftVariable, rightVariable);
                    tempList.set(indexOperators + 1, temp.toString());
                } else {
                    MathLabVariable temp = manipulator.division(leftVariable, rightVariable);
                    tempList.set(indexOperators + 1, temp.toString());
                }
            }
        }
        MathLabVariable result = new MathLabFloat(0.);
        for (int indexOperators = 0; indexOperators < tempList.size(); indexOperators = indexOperators + 2) {
            MathLabVariable rightVariable = getVariableFromString(tempList.get(indexOperators + 1));
            if (tempList.get(indexOperators).equals("+")) {
                result = manipulator.addition(result, rightVariable);
            } else {
                result = manipulator.subtraction(result, rightVariable);
            }
        }
        return result;
    }

    private static MathLabVariable getVariableFromString(String strValue) {
        MathLabVariable result;
        if (!strValue.contains("{")) {
            result = new MathLabFloat(strValue);
        } else {
            int index = strValue.indexOf("{");
            if (strValue.indexOf("{", index + 1) == -1) {
                result = new MathLabVector(strValue);
            } else {
                result = new MathLabMatrix(strValue);
            }
        }
        return result;
    }
}
