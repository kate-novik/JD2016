package by.it.drachyova.jd01_09;


import by.it.drachyova.jd01_09.Variables.VariableDouble;
import by.it.drachyova.jd01_09.Variables.VariableVector;
import by.it.drachyova.jd01_09.Variables.VariableMatrix;

/**
 * Разработать и реализовать набор интерфейсов и классов для консольного прототипа MatLab
 *
 */
public class MatLabRunner {

    public static void main(String[] args) {
        System.out.println(" Task A: ");
        System.out.println("3.8 + 26.2 = "+ new VariableDouble("3.8").addition(new VariableDouble("26.2")));
        System.out.println("87.4 - 23.1 = " + new VariableDouble("87.4").subtraction(new VariableDouble("23.1")));
        System.out.println("1.04 * 5.9 = "+ new VariableDouble("1.04").multiplication(new VariableDouble("5.9")));
        System.out.println("12.7 * 5 = "+ new VariableDouble("12.7").multiplication(new VariableDouble("5")));
        System.out.println("-6 + 12 = "+ new VariableDouble("-6").addition(new VariableDouble("12")));
        System.out.println("-7 * 3.1 = "+ new VariableDouble("-7").multiplication(new VariableDouble("3.1")));
        System.out.println("-4 / 8 = "+ new VariableDouble("-4").division(new VariableDouble("8")));
        System.out.println("-9 - 0.9 = " + new VariableDouble("-9").subtraction(new VariableDouble("0.9")));
        System.out.println();
        System.out.println(" Task B: ");
        System.out.println("{2,3,4} * 2 = "+ new VariableVector("{2,3,4").multiplication(new VariableDouble("2")));
        System.out.println("{2,3,4} / 3 = "+ new VariableVector("{2,3,4").division(new VariableDouble("3")));
        System.out.println("{2,3,4} - 5 = " + new VariableVector("{2,3,4").subtraction(new VariableDouble("5")));
        System.out.println("-4 + {2,3,4} = "+ new VariableDouble("-4").addition(new VariableVector("{2,3,4}")));
        System.out.println("{2,3,4} + {5,6,7} = "+ new VariableVector("{2,3,4").addition(new VariableVector("{5,6,7}")));
        System.out.println("{2,3,4} - {5,6,7} = " + new VariableVector("{2,3,4").subtraction(new VariableVector("{5,6,7}")));
        System.out.println();
        System.out.println("Task C");
        System.out.println("{{1,2},{8,3}}+2 = " + new VariableMatrix("{{1,2},{8,3}}").addition(new VariableDouble("2")));
        System.out.println("{{1,2},{8,3}}+{{1,2},{8,3}} = " + new VariableMatrix("{{1,2},{8,3}}").addition(new VariableMatrix("{{1,2},{8,3}}")));
        System.out.println("{{3,2},{8,3}}-{{1,1},{4,3}} = " + new VariableMatrix("{{3,2},{8,3}}").subtraction(new VariableMatrix("{{1,1},{4,3}}")));
    }
}