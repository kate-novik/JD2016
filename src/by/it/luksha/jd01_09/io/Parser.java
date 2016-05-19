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
    static public String exOper="[-+*/]{1}";
    //выражение целиком
    static public String exFull= "("+exAny+")"+
            "(" +exOper+")"+
            "(" +exAny +")";

    /**
     * Метод парсит строку в объект типа Var
     * @param var строка, которую необходимо преобразовать
     * @return ссылка на объект типа Var
     */
    public static Var toVar(String var) {
        //возвращаемое значение пока не определено
        Var operand = null;

        //паттерн для скаляра
        Pattern patternScalar = Pattern.compile(exScalar);
        Matcher matcherScalar = patternScalar.matcher(var);

        //паттерн для вектора
        Pattern patternVector = Pattern.compile(exVector);
        Matcher matcherVector = patternVector.matcher(var);

        //паттерн для матрицы
        Pattern patternMatrix = Pattern.compile(exMatrix);
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
        String[] varsString = string.split(checkOperation(string));
        Var[] vars = new Var[varsString.length];
        for (int i = 0; i < varsString.length; i++) {
            //TODO: Преобразование из строки в определенный тип Var (Scalar|Vector|Matrix).
        }
        return vars;
    }

    /**
     * Определяет знак операции выражения
     * @param string строка-выражение
     * @return строка-знак
     */
    public static String checkOperation(String string) {
        //StringBuilder для преобразований
        StringBuilder text = new StringBuilder(string);

        //удаление матриц из строки
        Pattern patternMatrix = Pattern.compile(exMatrix);
        Matcher matcherMatrix = patternMatrix.matcher(text);
        while (matcherMatrix.find())
        {
            int start = matcherMatrix.start();
            int end = matcherMatrix.end();
            text.delete(start, end);
            matcherMatrix.reset();
        }

        //удаление векторов из строки
        Pattern patternVector = Pattern.compile(exVector);
        Matcher matcherVector = patternVector.matcher(text);
        while (matcherVector.find())
        {
            int start = matcherVector.start();
            int end = matcherVector.end();
            text.delete(start, end);
            matcherVector.reset();
        }

        //удаление скаляров из строки
        Pattern patternScalar = Pattern.compile(exScalar);
        Matcher matcherScalar = patternScalar.matcher(text);
        while (matcherScalar.find())
        {
            int start = matcherScalar.start();
            int end = matcherScalar.end();
            text.delete(start, end);
            matcherScalar.reset();
        }

        String sign = text.toString();
        System.out.println(sign);

        return sign;
    }

}
