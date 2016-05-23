package by.it.sinkevich.jd01_09.parser;

import by.it.sinkevich.jd01_09.manipulators.Manipulator;
import by.it.sinkevich.jd01_09.variables.MathLabFloat;
import by.it.sinkevich.jd01_09.variables.MathLabVariable;

import java.util.LinkedList;
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
        List<String> result = new LinkedList<>();
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
        String mixedLine = testLine.concat("*").concat(testVector).concat("-").concat(testMatrix);
        System.out.println(mixedLine.matches(Patterns.regexValidateLine));
        Manipulator man = new Manipulator();
        List<String> result = parseLine(testLine);
        for (String x : result) {
            System.out.println(x);
        }
        if (result.get(0).equals("+")) {
            result.remove(0);
        } else {
            Double arg = Double.parseDouble(result.get(1));
            MathLabFloat res = (MathLabFloat) man.multiplication(new MathLabFloat(-1.), new MathLabFloat(arg));
            result.set(1, res.getValue().toString());
            result.remove(0);
        }
        while (result.size() != 1) {
            if (result.contains("*")) {
                int index = result.indexOf("*");
                Double arg1 = Double.parseDouble(result.get(index - 1));
                Double arg2 = Double.parseDouble(result.get(index + 1));
                MathLabVariable res = man.multiplication(new MathLabFloat(arg1), new MathLabFloat(arg2));
                result.set(index, res.getValue().toString());
                result.remove(index - 1);
                result.remove(index);
            } else if (result.contains("/")) {
                int index = result.indexOf("/");
                Double arg1 = Double.parseDouble(result.get(index - 1));
                Double arg2 = Double.parseDouble(result.get(index + 1));
                MathLabVariable res = man.division(new MathLabFloat(arg1), new MathLabFloat(arg2));
                result.set(index, res.getValue().toString());
                result.remove(index - 1);
                result.remove(index);
            } else {
                int index = 1;
                Double arg1 = Double.parseDouble(result.get(index - 1));
                Double arg2 = Double.parseDouble(result.get(index + 1));
                MathLabVariable res ;
                if (result.get(index).equals("+")){
                    res = man.addition(new MathLabFloat(arg1), new MathLabFloat(arg2));
                } else {
                    res = man.subtraction(new MathLabFloat(arg1), new MathLabFloat(arg2));
                }
                result.set(index, res.getValue().toString());
                result.remove(index - 1);
                result.remove(index);
            }
        }
        System.out.println(result);
    }


}
