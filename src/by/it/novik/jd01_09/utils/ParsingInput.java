package by.it.novik.jd01_09.utils;

import by.it.novik.jd01_09.entity.DoubleValue;
import by.it.novik.jd01_09.entity.MatrixValue;
import by.it.novik.jd01_09.entity.Variable;
import by.it.novik.jd01_09.entity.VectorValue;
import by.it.novik.jd01_09.operations.*;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static by.it.novik.jd01_09.patterns.PatternsVar.*;

/**
 * Created by Kate Novik.
 */
public class ParsingInput {

    /**
     * Парсинг введенной строки для выделения массива переменных
     * @param line Строка ввода
     * @return Массив переменных
     */
    public static List<Variable> parsingVariables (String line) {
        List<Variable> vars = new ArrayList<>();
        String[] elemString = new String [2];
        if (line.contains("(") && line.contains("(")) {
            line = line.substring(1,line.length()-1);
        }
        if (!Pattern.compile(regxOr).matcher(line).matches()) {
            elemString = line.split(regxOper); //преобразование строки в массив
        }
        else {
            elemString [0] = line;
        }
            for (int i = 0; i < elemString.length; i++) {
                if (Pattern.compile(regxD).matcher(elemString[i]).matches()) {
                    vars.add(new DoubleValue(elemString[i]));
                } else if (Pattern.compile(regxVec).matcher(elemString[i]).matches()) {
                    vars.add(new VectorValue(elemString[i]));
                } else if (Pattern.compile(regxMat).matcher(elemString[i]).matches()) {
                    vars.add(new MatrixValue(elemString[i]));
                }
            }

        return vars;
    }

    /**
     * Парсинг операции в выражении
     * @param line Строка ввода
     * @return Строку с названием операции
     */
    public static String parsingOperation (String line) {
        Matcher m = Pattern.compile(regxOper).matcher(line);
        String operation = null;
        while (m.find()) {
            operation = m.group();
        }
        return operation;
    }


    public static String checkPriorityParsing (String line) {
        Matcher m = Pattern.compile(regxPriorityFull).matcher(line);
        String priorityExp = null;
        if (m.find()) {
            priorityExp = m.group();
           // priorityExp = priorityExp.substring(1,priorityExp.length()-1);
        }
        return priorityExp;
    }

    public static List<String> parsingExp (String lineExp) {
        String[] elemString=lineExp.split(regxOper); //преобразование строки в массив
        List<String> exp = new ArrayList<>();
        for (int i=0; i<elemString.length; i++) {

            exp.add (elemString[i]);
        }
        return exp;
    }
}
