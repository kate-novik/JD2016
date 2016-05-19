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
class MultiplicationMethodContainer {

    private static MathLabFloat multiplication(MathLabFloat aFloat1, MathLabFloat aFloat2) {
        MathLabFloat result = new MathLabFloat();
        result.setValue(aFloat1.getValue() * aFloat2.getValue());
        return result;
    }

    private static MathLabVector multiplication(MathLabFloat aFloat, MathLabVector vector) {
        return multiplication(vector, aFloat);
    }

    private static MathLabMatrix multiplication(MathLabFloat aFloat, MathLabMatrix matrix) {
        return multiplication(matrix, aFloat);
    }

    static MathLabVector multiplication(MathLabVector vector, MathLabFloat aFloat) {
        Double[] result = vector.getValue();
        for (int i = 0; i < result.length; i++) {
            result[i] = result[i] * aFloat.getValue();
        }
        return new MathLabVector(result);
    }

    private static MathLabFloat multiplication(MathLabVector vector1, MathLabVector vector2) {
        if (vector1.getSize() != vector2.getSize()) {
            System.out.println("Умножение векторов невозможно, так как они разного размера!");
            return null;
        }
        Double[] array1 = vector1.getValue();
        Double[] array2 = vector2.getValue();
        Double result = 0d;
        for (int i = 0; i < array1.length; i++) {
            result += array1[i] * array2[i];
        }
        return new MathLabFloat(result);
    }

    private static MathLabVariable multiplication(MathLabVector vector, MathLabMatrix matrix) {
        System.out.println("Умножение слева вектора-стобца на матрицу невозможно!");
        return null;
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

    private static MathLabVector multiplication(MathLabMatrix matrix, MathLabVector vector) {
        if (matrix.getColumns() != vector.getSize()) {
            System.out.println("Умножение матрицы на вектор невозможно, из-за неподходящих размеров!");
            return null;
        }
        Double[][] tempMatrix = matrix.getValue();
        Double[] tempVector = vector.getValue();
        Double[] result = new Double[tempVector.length];
        for (int row = 0; row < tempMatrix.length; row++) {
            result[row] = 0d;
            for (int col = 0; col < tempVector.length; col++) {
                result[row] += tempMatrix[row][col] * tempVector[col];
            }
        }
        return new MathLabVector(result);
    }

    private static MathLabMatrix multiplication(MathLabMatrix matrix1, MathLabMatrix matrix2) {
        if (matrix1.getColumns() != matrix2.getRows()) {
            System.out.println("Умножение матриц невозможно, так как они разного размера!");
            return null;
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

    static MathLabVariable multiplication(MathLabVariable first, MathLabVariable second) {
        if (first instanceof MathLabFloat) {
            if (second instanceof MathLabFloat) {
                return multiplication((MathLabFloat) first, (MathLabFloat) second);
            } else if (second instanceof MathLabVector) {
                return multiplication((MathLabFloat) first, (MathLabVector) second);
            } else {
                return multiplication((MathLabFloat) first, (MathLabMatrix) second);
            }
        } else if (first instanceof MathLabVector) {
            if (second instanceof MathLabFloat) {
                return multiplication((MathLabVector) first, (MathLabFloat) second);
            } else if (second instanceof MathLabVector) {
                return multiplication((MathLabVector) first, (MathLabVector) second);
            } else {
                return multiplication((MathLabVector) first, (MathLabMatrix) second); //УЗНАТЬ ЕСТЬ ЛИ ТАКАЯ ОПЕРАЦИЯ
            }
        } else if (first instanceof MathLabMatrix) {
            if (second instanceof MathLabFloat) {
                return multiplication((MathLabMatrix) first, (MathLabFloat) second);
            } else if (second instanceof MathLabVector) {
                return multiplication((MathLabMatrix) first, (MathLabVector) second); //УЗНАТЬ ЕСТЬ ЛИ ТАКАЯ ОПЕРАЦИЯ
            } else if (second instanceof MathLabMatrix) {
                return multiplication((MathLabMatrix) first, (MathLabMatrix) second);
            }
        }
        return null;
    }
}
