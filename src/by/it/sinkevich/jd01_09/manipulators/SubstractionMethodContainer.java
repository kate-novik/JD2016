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
class SubstractionMethodContainer {

    static MathLabFloat substraction(MathLabFloat aFloat1, MathLabFloat aFloat2) {
        MathLabFloat result = new MathLabFloat();
        result.setValue(aFloat1.getValue() - aFloat2.getValue());
        return result;
    }

    static MathLabVector substraction(MathLabFloat aFloat, MathLabVector vector) {
        MathLabVector result = substraction(vector, aFloat);
        result = MultiplicationMethodContainer.multiplication(result, new MathLabFloat("-1"));
        return result;
    }

    static MathLabMatrix substraction(MathLabFloat aFloat, MathLabMatrix matrix) {
        MathLabMatrix result = substraction(matrix, aFloat);
        result = MultiplicationMethodContainer.multiplication(result, new MathLabFloat("-1"));
        return result;
    }

    static MathLabVector substraction(MathLabVector vector, MathLabFloat aFloat) {
        Double[] result = vector.getValue();
        for (int i = 0; i < result.length; i++) {
            result[i] = result[i] - aFloat.getValue();
        }
        return new MathLabVector(result);
    }

    static MathLabVector substraction(MathLabVector vector1, MathLabVector vector2) {
        if (vector1.getSize() != vector2.getSize()) {
            System.out.println("Вычитание векторов невозможно, так как они разного размера!");
            return null;
        }
        Double[] array1 = vector1.getValue();
        Double[] array2 = vector2.getValue();
        Double[] result = new Double[array1.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = array1[i] - array2[i];
        }
        return new MathLabVector(result);
    }

    static MathLabVariable substraction(MathLabVector vector, MathLabMatrix matrix) {
        System.out.println("Вычитание матрицы из вектора невозможно!");
        return null;
    }

    static MathLabMatrix substraction(MathLabMatrix matrix, MathLabFloat aFloat) {
        Double[][] result = matrix.getValue();
        for (int row = 0; row < result.length; row++) {
            for (int col = 0; col < result[row].length; col++) {
                result[row][col] -= aFloat.getValue();
            }
        }
        return new MathLabMatrix(result);
    }

    static MathLabVariable substraction(MathLabMatrix matrix, MathLabVector vector) {
        System.out.println("Вычитание вектора из матрицы невозможно!");
        return null;
    }

    static MathLabMatrix substraction(MathLabMatrix matrix1, MathLabMatrix matrix2) {
        if (matrix1.getRows() != matrix2.getRows() || matrix1.getColumns() != matrix2.getColumns()) {
            System.out.println("Вычитание матриц невозможно, так как они разного размера!");
            return null;
        }
        Double[][] temp1 = matrix1.getValue();
        Double[][] temp2 = matrix2.getValue();
        Double[][] result = new Double[temp1.length][temp1[0].length];
        for (int row = 0; row < result.length; row++) {
            for (int col = 0; col < result.length; col++) {
                result[row][col] = temp1[row][col] - temp2[row][col];
            }
        }
        return new MathLabMatrix(result);
    }
}
