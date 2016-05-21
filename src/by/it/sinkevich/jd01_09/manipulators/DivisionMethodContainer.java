package by.it.sinkevich.jd01_09.manipulators;

import by.it.sinkevich.jd01_09.variables.MathLabFloat;
import by.it.sinkevich.jd01_09.variables.MathLabMatrix;
import by.it.sinkevich.jd01_09.variables.MathLabVariable;
import by.it.sinkevich.jd01_09.variables.MathLabVector;

/**
 * Created by Computer on 19.05.2016.
 *
 * @author Sinkevich Denis
 */
class DivisionMethodContainer {

    static MathLabFloat division(MathLabFloat aFloat1, MathLabFloat aFloat2) {
        MathLabFloat result = new MathLabFloat();
        result.setValue(aFloat1.getValue() / aFloat2.getValue());
        return result;
    }

    static MathLabVariable division(MathLabFloat aFloat, MathLabVector vector) {
        System.out.println("Деление числа на вектор невозможно!");
        return null;
    }

    static MathLabVariable division(MathLabFloat aFloat, MathLabMatrix matrix) {
        System.out.println("Деление числа на матрицу невозможно!");
        return null;
    }

    static MathLabVector division(MathLabVector vector, MathLabFloat aFloat) {
        Double[] result = vector.getValue();
        for (int i = 0; i < result.length; i++) {
            result[i] = result[i] / aFloat.getValue();
        }
        return new MathLabVector(result);
    }

    static MathLabVariable division(MathLabVector vector1, MathLabVector vector2) {
        System.out.println("Деление вектора на вектор невозможно!");
        return null;
    }

    static MathLabFloat division(MathLabVector vector, MathLabMatrix matrix) {
        System.out.println("Деление вектора на матрицу невозможно!");
        return null;
    }

    static MathLabMatrix division(MathLabMatrix matrix, MathLabFloat aFloat) {
        Double[][] result = matrix.getValue();
        for (int row = 0; row < result.length; row++) {
            for (int col = 0; col < result[row].length; col++) {
                result[row][col] /= aFloat.getValue();
            }
        }
        return new MathLabMatrix(result);
    }

    static MathLabVariable division(MathLabMatrix matrix, MathLabVector vector) {
        System.out.println("Деление матрицы на вектор невозможно!");
        return null;
    }

    static MathLabVariable division(MathLabMatrix matrix1, MathLabMatrix matrix2) {
        System.out.println("Деление матрицы на матрицу невозможно!");
        return null;
    }
}
