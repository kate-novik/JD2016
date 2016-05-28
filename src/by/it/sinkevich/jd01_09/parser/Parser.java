package by.it.sinkevich.jd01_09.parser;

import by.it.sinkevich.jd01_09.manipulators.ExpressionSolver;
import by.it.sinkevich.jd01_09.variables.MathLabMatrix;
import by.it.sinkevich.jd01_09.variables.MathLabVariable;

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
        Pattern pattern = Pattern.compile(Patterns.regexAnyMathLabVariable);
        Matcher matcher = pattern.matcher(line);
        List<String> result = new ArrayList<>();
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
                result.add("+");
            }
            end = matcher.end();
            result.add(matcher.group());
        }
        return result;
    }

    public static void main(String[] args) {
        String testLine = "28.5+5.3 - 17 + 100.2/123* 2 - 2 + 5345.3/5*3*66 - 1";
        String testVector = "{1, -321,.2,-64., +12, -1.976}*{1.5, 21,.2, -64., +42, -1.976} - {1, 1.456,.2, -4., +122, -1.96}";
        String testMatrix = "{{2.2, 5.8}, {1.5, 6.2}, {-2.5, 7.4}, {4.2, -2.3}} * {{5.2, 3.2, 3.8}, {6.8, -7.5, -1.9}}/" +
                "{ {1.2, -3.5, 1.8, -2.2, -5.3},  {10, -2.8, 3.2, -2.8, 1.5},{2.3, -6.5, -9.2, 6.5, -1.2}}";
        String simpleVector = "{1, 2, 3} * {1, 2, 3}";
        String simpleMatrix = "{{2.2, 5.8}, {1.5, 6.2}, {-2.5, 7.4}, {4.2, -2.3}} * {{5.2, 3.2, 3.8}, {6.8, -7.5, -1.9}}";
        String mixedLine = testLine.concat("*").concat(testVector).concat("-").concat(testMatrix);
        List<String> result = parseLine(simpleMatrix);
        for (String x : result) {
            System.out.println(x);
        }
        System.out.println(ExpressionSolver.solveExpression(result));
        MathLabVariable mmm = new MathLabMatrix(ExpressionSolver.solveExpression(result).toString());
        System.out.println(mmm.toString());
    }


}
