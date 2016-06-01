package by.it.novik.jd01_09.patterns;

/**
 * Created by Kate Novik.
 */
public class PatternsVar {
    static public String regxMat = "\\{((\\{(-?[0-9\\.,])+\\}),?)+\\}";
    static public String regxVec = "\\{(-?[0-9\\.,])+\\}";
    static public String regxD = "-?[0-9]+(\\.[0-9]+)?";
    static public String regxSc = "\\},\\{";
    static public String regxOper = "[\\+\\-/\\*]";
    static public String regxOr = "("+regxMat+")|("+regxVec+")|("+regxD+")";
    static public String regxPriorityMul = "(("+regxMat+")|("+regxVec+")|("+regxD+"))\\*(("+regxMat+")|("+regxVec+")|("+regxD+"))";
    static public String regxPriorityDiv = "(("+regxMat+")|("+regxVec+")|("+regxD+"))/(("+regxMat+")|("+regxVec+")|("+regxD+"))";
    static public String regxPriorityBrackets= "\\((("+regxMat+")|("+regxVec+")|("+regxD+"))("+regxOper+")(("+regxMat+")|("+regxVec+")|("+regxD+"))\\)";
    static public String regxPriorityFull = "("+regxPriorityMul+")|("+regxPriorityDiv+")|("+regxPriorityBrackets+")";
    static public String regxFull = "("+regxOr+")("+regxOper+")("+regxOr+")";

    static public String regxDandD = "("+regxD+")"+"("+regxOper+")"+"("+regxD+")";
    static public String regxDandV = "("+regxD+")"+"("+regxOper+")"+"("+regxVec+")";
    static public String regxDandM = "("+regxD+")"+"("+regxOper+")"+"("+regxMat+")";

    static public String regxVandD = "("+regxVec+")"+"("+regxOper+")"+"("+regxD+")";
    static public String regxVandV = "("+regxVec+")"+"("+regxOper+")"+"("+regxVec+")";
    static public String regxVandM = "("+regxVec+")"+"("+regxOper+")"+"("+regxMat+")";

    static public String regxMandD = "("+regxMat+")"+"("+regxOper+")"+"("+regxD+")";
    static public String regxMandV = "("+regxMat+")"+"("+regxOper+")"+"("+regxVec+")";
    static public String regxMandM = "("+regxMat+")"+"("+regxOper+")"+"("+regxMat+")";

}
