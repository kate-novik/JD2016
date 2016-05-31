package by.it.novik.jd01_09.utils;

import by.it.novik.jd01_09.entity.Variable;
import by.it.novik.jd01_09.operations.AddOperations;
import by.it.novik.jd01_09.operations.DivOperations;
import by.it.novik.jd01_09.operations.MultiOperations;
import by.it.novik.jd01_09.operations.SubOperations;
import by.it.novik.jd01_09.patterns.PatternsVar;


import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Kate Novik.
 */
public class Calculate {

    /**
     * Метод вычисления выражения
     * @param line Строка ввода
     * @return Результат выражения типа String
     */
    public String calculateExp (String line) {
        List<Variable> var;
        String exp = ParsingInput.checkPriorityParsing(line);
        String op;
        Variable result;
        while (exp!=null) {
            var = ParsingInput.parsingVariables(exp);
            op = ParsingInput.parsingOperation(exp);
            result = switchOperation(op, var.get(0), var.get(1));
            String sub = ParsingInput.parsingExp(exp).get(0)+op+ParsingInput.parsingExp(exp).get(1);
            line = line.replace(sub,result.toString());
            exp = ParsingInput.checkPriorityParsing(line);
        }
        Matcher m = Pattern.compile(PatternsVar.regxFull).matcher(line);
        while (m.find()) {
            String s = m.group();
            var = ParsingInput.parsingVariables(s);
            op = ParsingInput.parsingOperation(s);
            result = switchOperation(op, var.get(0), var.get(1));
            if (result!=null) {
            String sub = ParsingInput.parsingExp(s).get(0)+op+ParsingInput.parsingExp(s).get(1);
            String l = line.replace(sub,result.toString());
            line=l;
            m.reset(l);}
            else {
                line = null;
                break;
            }

        }

    return line;
    }

    private Variable switchOperation (String operation, Variable var1, Variable var2) {
        AddOperations operAdd = new AddOperations();
        SubOperations operSub = new SubOperations();
        MultiOperations operMulti = new MultiOperations();
        DivOperations operDiv = new DivOperations();
        Variable result = null;
        switch (operation) {
            case "+": {
                result = operAdd.addition(var1, var2);
                break;
            }
            case "-": {
                result = operSub.subtraction (var1, var2);
                break;
            }
            case "*": {
                result = operMulti.multiplication(var1, var2);
                break;
            }
            case "/": {
                result = operDiv.division(var1, var2);
                break;
            }
        }
        return result;
    }
}
