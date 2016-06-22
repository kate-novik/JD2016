package by.it.sinkevich.jd01_09.manipulators;

import by.it.sinkevich.jd01_09.exceptions.MathLabException;
import by.it.sinkevich.jd01_09.variables.MathLabFloat;
import by.it.sinkevich.jd01_09.variables.MathLabMatrix;
import by.it.sinkevich.jd01_09.variables.MathLabVariable;
import by.it.sinkevich.jd01_09.variables.MathLabVector;

/**
 * Created by Computer on 19.05.2016.
 *
 * @author Sinkevich Denis
 */
class SubtractionMethodContainer {

    static MathLabFloat subtraction(MathLabFloat aFloat1, MathLabFloat aFloat2) {
        MathLabFloat result = new MathLabFloat();
        result.setValue(aFloat1.getValue() - aFloat2.getValue());
        return result;
    }

    static MathLabVector subtraction(MathLabFloat aFloat, MathLabVector vector) {
        MathLabVector result = subtraction(vector, aFloat);
        result = MultiplicationMethodContainer.multiplication(result, new MathLabFloat("-1"));
        return result;
    }

    static MathLabMatrix subtraction(MathLabFloat aFloat, MathLabMatrix matrix) {
        MathLabMatrix result = subtraction(matrix, aFloat);
        result = MultiplicationMethodContainer.multiplication(result, new MathLabFloat("-1"));
        return result;
    }

    static MathLabVector subtraction(MathLabVector vector, MathLabFloat aFloat) {
        Double[] result = vector.getValue();
        for (int i = 0; i < result.length; i++) {
            result[i] = result[i] - aFloat.getValue();
        }
        return new MathLabVector(result);
    }

    static MathLabVector subtraction(MathLabVector vector1, MathLabVector vector2) throws MathLabException {
        if (vector1.getSize() != vector2.getSize()) {
            throw new MathLabException("Недопустимый размер векторов! Вычитать можно только векторы одинаковой длины!");
        }
        Double[] array1 = vector1.getValue();
        Double[] array2 = vector2.getValue();
        Double[] result = new Double[array1.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = array1[i] - array2[i];
        }
        return new MathLabVector(result);
    }

    static MathLabVariable subtraction(MathLabVector vector, MathLabMatrix matrix) throws MathLabException {
        throw new MathLabException("Недопустимая операция! Вычитание матрицы из вектора невозможно!");
    }

    static MathLabMatrix subtraction(MathLabMatrix matrix, MathLabFloat aFloat) {
        Double[][] result = matrix.getValue();
        for (int row = 0; row < result.length; row++) {
            for (int col = 0; col < result[row].length; col++) {
                result[row][col] -= aFloat.getValue();
            }
        }
        return new MathLabMatrix(result);
    }

    static MathLabVariable subtraction(MathLabMatrix matrix, MathLabVector vector) throws MathLabException {
        throw new MathLabException("Недопустимая операция! Вычитание вектора из матрицы невозможно!");
    }

    static MathLabMatrix subtraction(MathLabMatrix matrix1, MathLabMatrix matrix2) throws MathLabException {
        if (matrix1.getRows() != matrix2.getRows() || matrix1.getColumns() != matrix2.getColumns()) {
            throw new MathLabException("Недопустимый размер матриц! Вычитать можно только матрицы одинакового размера!");
        }
        Double[][] temp1 = matrix1.getValue();
        Double[][] temp2 = matrix2.getValue();
        Double[][] result = new Double[temp1.length][temp1[0].length];
        for (int row = 0; row < result.length; row++) {
            for (int col = 0; col < result[row].length; col++) {
                result[row][col] = temp1[row][col] - temp2[row][col];
            }
        }
        return new MathLabMatrix(result);
    }
}
