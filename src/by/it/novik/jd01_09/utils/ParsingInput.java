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
     * Парсинг входной строки для выделения массива переменных
     * @param line Строка ввода
     * @return Массив переменных
     */
    public static List<Variable> parsingVariables (String line) {
        line=line.trim(); //удаление пробелов в начале и в конце строки
        String[] elemString=line.split(regxOper); //преобразование строки в массив
        int count=elemString.length; //найдем длину массива
        List<Variable> vars = new ArrayList<>();
        for (int i=0; i<elemString.length; i++) {
            if (Pattern.compile(regxD).matcher(elemString[i]).matches()){
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
}
