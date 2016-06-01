package by.it.sinkevich.jd01_09.parser;

import by.it.sinkevich.jd01_09.manipulators.ExpressionSolver;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Computer on 21.05.2016.
 *
 * @author Sinkevich Denis
 */
public class Parser {

    public static List<String> parseLine(String line) {
        List<String> result = new ArrayList<>();
        if (checkLineForEqualitySign(line)) {
            int indexOfEqualSign = line.indexOf("=");
            String variableName = line.substring(0, indexOfEqualSign).trim();
            result.add(variableName);
            result.add("=");
            line = line.substring(indexOfEqualSign + 1).trim();
            /*
            List<String> parsedLine = parseLine(line.substring(indexOfEqualSign + 1).trim());
            MathLabVariable variableValue = ExpressionSolver.solveExpression(parsedLine);
            VariablesStorage.add(variableName, variableValue);
            */
        }
        Pattern pattern = Pattern.compile(Patterns.regexForParser);
        Matcher matcher = pattern.matcher(line);
        int start;
        int end = 0;
        while (matcher.find()) {
            start = matcher.start();
            if (start > end) {
                String operand = line.substring(end, start).trim();
                if (operand.isEmpty()) {
                    result.add("+");
                } else {
                    result.add(operand);
                }
            } else {
                if (!matcher.group().matches(Patterns.regexBrackets)) {
                    result.add("+");
                }
            }
            end = matcher.end();
            result.add(matcher.group());
        }
        return result;
    }

    public static void main(String[] args) {
        String testLine = "a=(28.5+5.3) - ((17))() + (100.2/(123* 2 - 2) + 5345.3/5*3*66) - 1";
        String testVector = " {1, -321,.2,-64., +12, -1.976}*{1.5, 21,.2, -64., +42, -1.976} - {1, 1.456,.2, -4., +122, -1.96}";
        String testMatrix = "{{2.2, 5.8}, {1.5, 6.2}, {-2.5, 7.4}, {4.2, -2.3}} * {{5.2, 3.2, 3.8}, {6.8, -7.5, -1.9}}/" +
                "{ {1.2, -3.5, 1.8, -2.2, -5.3},  {10, -2.8, 3.2, -2.8, 1.5},{2.3, -6.5, -9.2, 6.5, -1.2}}";
        String simpleVector = "{1, 2, 3} * {1, 2, 3}";
        String simpleMatrix = "{{2.2, 5.8}, {1.5, 6.2}, {-2.5, 7.4}, {4.2, -2.3}} * {{5.2, 3.2, 3.8}, {6.8, -7.5, -1.9}}";
        String simmplLine = "2 * (35 - 5) * (-1/30)";
        String mixedLine = testLine.concat("*").concat(testVector).concat("-").concat(testMatrix);
        List<String> result = parseLine(simmplLine);

        for (String x : result) {
            System.out.println(x);
        }
        ExpressionSolver solver = new ExpressionSolver();
        System.out.println(solver.solveExpression(result));
    }

    private static boolean checkLineForEqualitySign(String line) {
        if (line.contains("=")) {
            int indexOfEqualitySign = line.indexOf("=");
            indexOfEqualitySign = line.indexOf("=", indexOfEqualitySign + 1);
            if (indexOfEqualitySign == -1) {
                return true;
            } else {
                System.out.println("Неверно записано выражение, в нём присутствует более одного знака присвоения!");
                System.out.println("Ошибка в символе " + indexOfEqualitySign);
            }
        }
        return false;
    }
}
