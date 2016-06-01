package by.it.sinkevich.jd01_09.parser;

/**
 * Created by Computer on 21.05.2016.
 *
 * @author Sinkevich Denis
 */
public class Patterns {

    public static String regexFloat = "[+-]?(((([1-9][0-9]*)|0)\\.[0-9]+)|(([1-9][0-9]*)|0)|((([1-9][0-9]*)|0)\\.)|(\\.[0-9]+))";
    public static String regexVector = "\\{( *" + regexFloat + ",)( *" + regexFloat + ",?)+\\}";
    public static String regexMatrix = "\\{( *" + regexVector + ",)( *" + regexVector + ",?)+\\}";
    public static String regexAnyMathLabVariable = "(" + regexFloat + ")|(" + regexVector + ")|(" + regexMatrix + ")";
    public static String regexBrackets = "[\\(\\)]";
    public static String regexForParser = "(" + regexAnyMathLabVariable + ")|(" + regexBrackets +")";
    public static String regexOperators = "[+-/*]";

}
