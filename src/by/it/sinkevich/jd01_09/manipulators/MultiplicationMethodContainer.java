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
class MultiplicationMethodContainer {

    static MathLabFloat multiplication(MathLabFloat aFloat1, MathLabFloat aFloat2) {
        MathLabFloat result = new MathLabFloat();
        result.setValue(aFloat1.getValue() * aFloat2.getValue());
        return result;
    }

    static MathLabVector multiplication(MathLabFloat aFloat, MathLabVector vector) {
        return multiplication(vector, aFloat);
    }

    static MathLabMatrix multiplication(MathLabFloat aFloat, MathLabMatrix matrix) {
        return multiplication(matrix, aFloat);
    }

    static MathLabVector multiplication(MathLabVector vector, MathLabFloat aFloat) {
        Double[] result = vector.getValue();
        for (int i = 0; i < result.length; i++) {
            result[i] = result[i] * aFloat.getValue();
        }
        return new MathLabVector(result);
    }

    static MathLabFloat multiplication(MathLabVector vector1, MathLabVector vector2) throws MathLabException {
        if (vector1.getSize() != vector2.getSize()) {
            throw new MathLabException("Недопустимый размер векторов! Умножать можно только векторы одинаковой длины!");
        }
        Double[] array1 = vector1.getValue();
        Double[] array2 = vector2.getValue();
        Double result = 0d;
        for (int i = 0; i < array1.length; i++) {
            result += array1[i] * array2[i];
        }
        return new MathLabFloat(result);
    }

    static MathLabVariable multiplication(MathLabVector vector, MathLabMatrix matrix) throws MathLabException {
        throw new MathLabException("Недопустимая операция! Умножение вектора на матрицу невозможно!");
    }

    static MathLabMatrix multiplication(MathLabMatrix matrix, MathLabFloat aFloat) {
        Double[][] result = matrix.getValue();
        for (int row = 0; row < result.length; row++) {
            for (int col = 0; col < result[row].length; col++) {
                result[row][col] *= aFloat.getValue();
            }
        }
        return new MathLabMatrix(result);
    }

    static MathLabVector multiplication(MathLabMatrix matrix, MathLabVector vector) throws MathLabException {
        if (matrix.getColumns() != vector.getSize()) {
            throw new MathLabException("Недопустимый размер матрицы и вектора! Умножать матрицу на вектор-столбец справа " +
                    "только если количество столбцов матрицы равно длине вектора!");
        }
        Double[][] tempMatrix = matrix.getValue();
        Double[] tempVector = vector.getValue();
        Double[] result = new Double[tempMatrix.length];
        for (int row = 0; row < tempMatrix.length; row++) {
            result[row] = 0d;
            for (int col = 0; col < tempVector.length; col++) {
                result[row] += tempMatrix[row][col] * tempVector[col];
            }
        }
        return new MathLabVector(result);
    }

    static MathLabMatrix multiplication(MathLabMatrix matrix1, MathLabMatrix matrix2) throws MathLabException {
        if (matrix1.getColumns() != matrix2.getRows()) {
            throw new MathLabException("Недопустимый размер матриц! Умножать матрицу на матрицу можно только если " +
                    "количество столбцов матрицы слева равно количеству строк матрицы справа!");
        }
        Double[][] temp1 = matrix1.getValue();
        Double[][] temp2 = matrix2.getValue();
        Double[][] result = new Double[matrix1.getRows()][matrix2.getColumns()];
        for (int row = 0; row < result.length; row++) {
            for (int col = 0; col < result[0].length; col++) {
                result[row][col] = 0d;
                for (int inside = 0; inside < temp2.length; inside++) {
                    result[row][col] += temp1[row][inside] * temp2[inside][col];
                }
            }
        }
        return new MathLabMatrix(result);
    }
}
