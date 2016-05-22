package by.it.sinkevich.jd01_09.parser;

import by.it.sinkevich.jd01_09.manipulators.Manipulator;
import by.it.sinkevich.jd01_09.variables.MathLabFloat;

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
        Pattern pattern = Pattern.compile(Patterns.newRegexFloat);
        Matcher matcher = pattern.matcher(line);
        /*
        List<String> variables = new ArrayList<>();
        List<String> operators = new ArrayList<>();
        while (matcher.find()) {
            variables.add(matcher.group());
        }
        String[] operatorsArray = line.split(Patterns.newRegexFloat);
        for (String operator : operatorsArray) {
            if (operator.isEmpty()) {
                operators.add("+");
            } else {
                operators.add(operator.trim());
            }
        }
        */
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
        Manipulator man = new Manipulator();
        List<String> result = parseLine("-5 + 3 * 2 / 2 --10+5");
        System.out.println(result);
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
                MathLabFloat res = (MathLabFloat) man.multiplication(new MathLabFloat(arg1), new MathLabFloat(arg2));
                result.set(index, res.getValue().toString());
                result.remove(index - 1);
                result.remove(index);
            } else if (result.contains("/")) {
                int index = result.indexOf("/");
                Double arg1 = Double.parseDouble(result.get(index - 1));
                Double arg2 = Double.parseDouble(result.get(index + 1));
                MathLabFloat res = (MathLabFloat) man.division(new MathLabFloat(arg1), new MathLabFloat(arg2));
                result.set(index, res.getValue().toString());
                result.remove(index - 1);
                result.remove(index);
            } else {
                int index = 1;
                Double arg1 = Double.parseDouble(result.get(index - 1));
                Double arg2 = Double.parseDouble(result.get(index + 1));
                MathLabFloat res ;
                if (result.get(index).equals("+")){
                    res = (MathLabFloat) man.addition(new MathLabFloat(arg1), new MathLabFloat(arg2));
                } else {
                    res = (MathLabFloat) man.subtraction(new MathLabFloat(arg1), new MathLabFloat(arg2));
                }
                result.set(index, res.getValue().toString());
                result.remove(index - 1);
                result.remove(index);
            }
        }
        System.out.println(result);
    }
}
