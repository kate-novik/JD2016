package by.it.novik.jd01_09.patterns;

/**
 * Created by Kate Novik.
 */
public class PatternsVar {
    public static String regxMat = "[\\{\\[](([\\{\\[](-?[0-9\\.,])+[\\}\\]]),?)+[\\}\\]]";
    public static String regxVec = "[\\{\\[](-?[0-9\\.,])+[\\}\\]]";
    public static String regxD = "-?[0-9]+(\\.[0-9]+)?";
    public static String regxSc = "[\\}\\]],[\\{\\[]";
    public static String regxOper = "\\s[\\+\\-/\\*]\\s";
    public static String regxEq = "\\s=\\s";
    public static String regxOr = "("+regxMat+")|("+regxVec+")|("+regxD+")";
    public static String regxPriorityMul = "(("+regxMat+")|("+regxVec+")|("+regxD+"))\\s\\*\\s(("+regxMat+")|("+regxVec+")|("+regxD+"))";
    public static String regxPriorityDiv = "(("+regxMat+")|("+regxVec+")|("+regxD+"))\\s/\\s(("+regxMat+")|("+regxVec+")|("+regxD+"))";
    public static String regxPriorityBrackets= "\\(\\(*("+regxOr+")(("+regxOper+")\\(?("+regxOr+")\\)?)+\\)";
    public static String regxPriorityFull = "("+regxPriorityMul+")|("+regxPriorityDiv+")|("+regxPriorityBrackets+")";
    public static String regxFull = "\\(?("+regxOr+")("+regxOper+")("+regxOr+")\\)?";
    public static String regxFullEq = "(\\w("+regxEq+"))?\\(*("+regxOr+")(("+regxOper+")\\(*("+regxOr+")\\)*)*";



}
