package by.it.luksha.jd01_09.io;

import by.it.luksha.jd01_09.vars.Matrix;
import by.it.luksha.jd01_09.vars.Scalar;
import by.it.luksha.jd01_09.vars.Var;
import by.it.luksha.jd01_09.vars.Vector;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser  {

    //RegEx
    //числа
    static public String exScalar ="-?[0-9]+\\.[0-9]{1,}";
    //вектора
    static public String exVector ="[{]{1}(-?[0-9]+\\.[0-9]{1,}){1}(,-?[0-9]+\\.[0-9]{1,}){1,}[}]{1}";
    //матрицы
    static public String exMatrix ="[{]{1}([{]{1}(-?[0-9]+\\.[0-9]{1,}){1}(,-?[0-9]+\\.[0-9]{1,}){1,}[}]{1}){1}(,[{]{1}(-?[0-9]+\\.[0-9]{1,}){1}(,-?[0-9]+\\.[0-9]{1,}){1,}[}]{1}){1,}[}]{1}";
    //одно из...
    static public String exAny="("+ exMatrix +")|("+ exVector +")|("+ exScalar +")";
    //операция
    static public String exOper="((\\s-\\s){1})|((\\s\\+\\s){1})|((\\s\\*\\s){1})|((\\s/\\s){1})|((\\s=\\s){1})";
    //выражение целиком
    static public String exFull= "("+exAny+")"+
            "(" +exOper+")"+
            "(" +exAny +")";

    /**
     * Ищет в строке вектор и преобразует в массив double
     * @param line строка
     * @return массив double
     */
    public static double[] findVector(String line) {
        double[] arrayForVector = new double[line.split(",").length];
        Matcher matcherVector = Pattern.compile(exScalar).matcher(line);
        int i = 0;
        while (matcherVector.find()) {
            arrayForVector[i] = Double.parseDouble(matcherVector.group());
            i++;
        }

        return arrayForVector;
    }

    /**
     * Парсит строку на массив с элементами типа Var
     * @param string строка
     * @return массив
     */
    public static Var[] toVars(String string) {
        String[] varsString = string.split(exOper);
        Var[] vars = new Var[varsString.length];
        for (int i = 0; i < varsString.length; i++) {
            //матрица
            Pattern patternMatrix = Pattern.compile(exMatrix);
            Matcher matcherMatrix = patternMatrix.matcher(varsString[i]);
            //вектор
            Pattern patternVector = Pattern.compile(exVector);
            Matcher matcherVector = patternVector.matcher(varsString[i]);
            //скаляр
            Pattern patternScalar = Pattern.compile(exScalar);
            Matcher matcherScalar = patternScalar.matcher(varsString[i]);

            if (matcherMatrix.find()) {
                int start = matcherMatrix.start();
                int end = matcherMatrix.end();
                String matrix = varsString[i].substring(start, end).trim();
                Matrix mx = new Matrix(matrix);
                vars[i] = mx;
                matcherMatrix.reset();
            }
            else if (matcherVector.find()) {
                int start = matcherVector.start();
                int end = matcherVector.end();
                String vector = varsString[i].substring(start, end).trim();
                Vector vc = new Vector(vector);
                vars[i] = vc;
                matcherVector.reset();
            }
            else if (matcherScalar.find()) {
                int start = matcherScalar.start();
                int end = matcherScalar.end();
                String scalar = varsString[i].substring(start, end).trim();
                Scalar sc = new Scalar(scalar);
                vars[i] = sc;
                matcherScalar.reset();
            }
            else {System.out.println("Переменные не найдены");}
        }
        return vars;
    }

    /**
     * Определяет знак операции выражения
     * @param string строка-выражение
     * @return строка-знак
     */
    public static String checkOperation(String string) {
        String sign = "";
        Pattern patternOperation = Pattern.compile(exOper);
        Matcher matcherOperation = patternOperation.matcher(string);
        if (matcherOperation.find()) {
            int start = matcherOperation.start();
            int end = matcherOperation.end();
            sign = string.substring(start, end).trim();
        }
        else
        {
            System.out.println("Невозможно определить знак операции");
        }

        return sign;
    }

}
