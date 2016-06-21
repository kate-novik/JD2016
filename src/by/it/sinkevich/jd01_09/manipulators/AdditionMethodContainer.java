package by.it.sinkevich.jd01_09.manipulators;

import by.it.sinkevich.jd01_09.exceptions.MathLabException;
import by.it.sinkevich.jd01_09.variables.MathLabFloat;
import by.it.sinkevich.jd01_09.variables.MathLabMatrix;
import by.it.sinkevich.jd01_09.variables.MathLabVariable;
import by.it.sinkevich.jd01_09.variables.MathLabVector;
/**
 * @author Sinkevich Denis
 */
class AdditionMethodContainer {

    static MathLabFloat addition(MathLabFloat aFloat1, MathLabFloat aFloat2) {
        MathLabFloat result = new MathLabFloat();
        result.setValue(aFloat1.getValue() + aFloat2.getValue());
        return result;
    }

    static MathLabVector addition(MathLabFloat aFloat, MathLabVector vector) {
        return addition(vector, aFloat);
    }

    static MathLabMatrix addition(MathLabFloat aFloat, MathLabMatrix matrix) {
        return addition(matrix, aFloat);
    }

    static MathLabVector addition(MathLabVector vector, MathLabFloat aFloat) {
        Double[] result = vector.getValue();
        for (int i = 0; i < result.length; i++) {
            result[i] = result[i] + aFloat.getValue();
        }
        return new MathLabVector(result);
    }

    static MathLabVector addition(MathLabVector vector1, MathLabVector vector2) throws MathLabException {
        if (vector1.getSize() != vector2.getSize()) {
            throw new MathLabException("Недопустимый размер векторов! Складывать можно только векторы одинаковой длины!");
        }
        Double[] array1 = vector1.getValue();
        Double[] array2 = vector2.getValue();
        Double[] result = new Double[array1.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = array1[i] + array2[i];
        }
        return new MathLabVector(result);
    }

    static MathLabVariable addition(MathLabVector vector, MathLabMatrix matrix) throws MathLabException {
        throw new MathLabException("Недопустимая операция! Сложение вектора и матрицы невозможно!");
    }

    static MathLabMatrix addition(MathLabMatrix matrix, MathLabFloat aFloat) {
        Double[][] result = matrix.getValue();
        for (int row = 0; row < result.length; row++) {
            for (int col = 0; col < result[row].length; col++) {
                result[row][col] += aFloat.getValue();
            }
        }
        return new MathLabMatrix(result);
    }

    static MathLabVariable addition(MathLabMatrix matrix, MathLabVector vector) throws MathLabException {
        throw new MathLabException("Недопустимая операция! Сложение матрицы и вектора невозможно!");
    }

    static MathLabMatrix addition(MathLabMatrix matrix1, MathLabMatrix matrix2) throws MathLabException {
        if (matrix1.getRows() != matrix2.getRows() || matrix1.getColumns() != matrix2.getColumns()) {
            throw new MathLabException("Недопустимый размер матриц! Складывать можно только матрицы одинакового размера!");
        }
        Double[][] temp1 = matrix1.getValue();
        Double[][] temp2 = matrix2.getValue();
        Double[][] result = new Double[temp1.length][temp1[0].length];
        for (int row = 0; row < result.length; row++) {
            for (int col = 0; col < result[row].length; col++) {
                result[row][col] = temp1[row][col] + temp2[row][col];
            }
        }
        return new MathLabMatrix(result);
    }
}
