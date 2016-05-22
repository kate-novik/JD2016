package by.it.sinkevich.jd01_09;

import by.it.sinkevich.jd01_09.manipulators.Manipulator;
import by.it.sinkevich.jd01_09.variables.MathLabFloat;
import by.it.sinkevich.jd01_09.variables.MathLabMatrix;
import by.it.sinkevich.jd01_09.variables.MathLabVector;

/**
 * @author Sinkevich Denis
 */
public class ConsoleRunner {

    public static void main(String[] args) {
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
    }
}
