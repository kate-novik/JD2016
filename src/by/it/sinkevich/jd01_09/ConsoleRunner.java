package by.it.sinkevich.jd01_09;

import by.it.sinkevich.jd01_09.manipulators.ExpressionSolver;
import by.it.sinkevich.jd01_09.parser.Parser;
import by.it.sinkevich.jd01_09.variables.VariablesStorage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author Sinkevich Denis
 */
public class ConsoleRunner {

    public static void main(String[] args) throws IOException {
        /*
        Manipulator manipulator = new Manipulator();
        System.out.println("Проверка операций со скалярами: ");
        Double number = 2d;
        System.out.println(manipulator.addition(new MathLabFloat("1"), new MathLabFloat(number)));
        System.out.println(manipulator.subtraction(new MathLabFloat("9"), new MathLabFloat("7")));
        System.out.println(manipulator.multiplication(new MathLabFloat("1.5"), new MathLabFloat(number)));
        System.out.println(manipulator.division(new MathLabFloat("-4"), new MathLabFloat("-1")));

        System.out.println("\nПроверка операций с вектором слева и скаляром справа: ");
        Double[] vector = {1., 2., 3.};
        System.out.println(manipulator.addition(new MathLabVector(vector), new MathLabFloat("2")));
        System.out.println(manipulator.subtraction(new MathLabVector(vector), new MathLabFloat("1")));
        System.out.println(manipulator.multiplication(new MathLabVector(vector), new MathLabFloat("2")));
        System.out.println(manipulator.division(new MathLabVector(vector), new MathLabFloat("1")));

        System.out.println("\nПроверка операций с вектором справа и скаляром слева: ");
        System.out.println(manipulator.addition(new MathLabFloat("1"), new MathLabVector(vector)));
        System.out.println(manipulator.subtraction(new MathLabFloat("2"), new MathLabVector(vector)));
        System.out.println(manipulator.multiplication(new MathLabFloat("1"), new MathLabVector(vector)));
        System.out.println(manipulator.division(new MathLabFloat("2"), new MathLabVector(vector)));

        System.out.println("\nПроверка операций с двумя векторами: ");
        System.out.println(manipulator.addition(new MathLabVector(vector), new MathLabVector(vector)));
        System.out.println(manipulator.subtraction(new MathLabVector(vector), new MathLabVector(vector)));
        System.out.println(manipulator.multiplication(new MathLabVector(vector), new MathLabVector(vector)));
        System.out.println(manipulator.division(new MathLabVector(vector), new MathLabVector(vector)));

        System.out.println("Проверка операций с матрицей слева: ");
        Double[][] matrix = {{1., 2., 3.}, {1., 2., 3.}, {1., 2., 3.}};
        System.out.println(manipulator.addition(new MathLabMatrix(matrix), new MathLabVector(vector)));
        System.out.println(manipulator.subtraction(new MathLabMatrix(matrix), new MathLabFloat("2")));
        System.out.println(manipulator.multiplication(new MathLabMatrix(matrix), new MathLabVector(vector)));
        System.out.println(manipulator.division(new MathLabMatrix(matrix), new MathLabFloat("-2")));

        System.out.println("Матрица на матрицу: ");
        Double[][] matrix1 = {{2.2, 5.8}, {1.5, 6.2}, {-2.5, 7.4}, {4.2, -2.3}};
        Double[][] matrix2 = {{5.2, 3.2, 3.8}, {6.8, -7.5, -1.9}};
        System.out.println(manipulator.multiplication(new MathLabMatrix(matrix1), new MathLabMatrix(matrix2)));

        String testForSetValue = "{{2.2, 5.8}, {1.5, 6.2}, {-2.5, 7.4}, {4.2, -2.3}}";
        MathLabVariable x = new MathLabMatrix(testForSetValue);
        System.out.println(x);
        */
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        while (!(line.equals("-exit") || line.equals(""))) {
            if (line.equals("printvar")) {
                VariablesStorage.printVariables();
                line = reader.readLine();
                continue;
            }
            if (line.equals("sortvar")) {
                VariablesStorage.printSortedvariables();
                line = reader.readLine();
                continue;
            }
            new ExpressionSolver().solveExpression(Parser.parseLine(line));
            line = reader.readLine();
        }
    }
}
