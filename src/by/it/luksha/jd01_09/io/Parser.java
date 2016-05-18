package by.it.luksha.jd01_09.io;

import by.it.luksha.jd01_09.vars.Matrix;
import by.it.luksha.jd01_09.vars.Scalar;
import by.it.luksha.jd01_09.vars.Var;
import by.it.luksha.jd01_09.vars.Vector;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    /**
     * Метод парсит строку в объект типа Var
     * @param var строка, которую необходимо преобразовать
     * @return ссылка на объект типа Var
     */
    public static Var toVar(String var) {
        //возвращаемое значение пока не определено
        Var operand = null;

        //паттерн для скаляра
        String floatDigitWithMinus = "-?[0-9]+\\.[0-9]{1,}";
        Pattern patternScalar = Pattern.compile(floatDigitWithMinus);
        Matcher matcherScalar = patternScalar.matcher(var);

        //паттерн для вектора
        String vector = "[{]{1}(-?[0-9]+\\.[0-9]{1,}){1}(,-?[0-9]+\\.[0-9]{1,}){1,}[}]{1}";
        Pattern patternVector = Pattern.compile(vector);
        Matcher matcherVector = patternVector.matcher(var);

        //паттерн для матрицы
        Pattern patternMatrix = Pattern.compile("[{]{1}([{]{1}(-?[0-9]+\\.[0-9]{1,}){1}(,-?[0-9]+\\.[0-9]{1,}){1,}[}]{1}){1}(,[{]{1}(-?[0-9]+\\.[0-9]{1,}){1}(,-?[0-9]+\\.[0-9]{1,}){1,}[}]{1}){1,}[}]{1}");
        Matcher matcherMatrix = patternMatrix.matcher(var);

        //определение типа переменной
        if (matcherMatrix.find()) {
            System.out.println("Это матрица!");
            operand = new Matrix(var);
        }
        else if (matcherVector.find()) {
            System.out.println("Это вектор!");
            operand = new Vector(var);
        }
        else if (matcherScalar.find()) {
            System.out.println("Это скаляр!");
            operand = new Scalar(var);
        }
        else {
            System.out.println("Данный формат ввода не поддерживается!");
        }

        return operand;
    }

    public static Var[] toVars(String string) {
        String[] vars = string.split("\\*|\\+|/|[^0-9]-[^0-9]");
        return null;
    }
}
