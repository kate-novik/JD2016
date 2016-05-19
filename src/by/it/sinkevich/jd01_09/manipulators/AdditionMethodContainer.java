package by.it.sinkevich.jd01_09.manipulators;

import by.it.sinkevich.jd01_09.variables.MathLabFloat;
import by.it.sinkevich.jd01_09.variables.MathLabMatrix;
import by.it.sinkevich.jd01_09.variables.MathLabVariable;
import by.it.sinkevich.jd01_09.variables.MathLabVector;

/**
 * @author Sinkevich Denis
 */
class AdditionMethodContainer {

    private static MathLabFloat addition(MathLabFloat aFloat1, MathLabFloat aFloat2) {
        MathLabFloat result = new MathLabFloat();
        result.setValue(aFloat1.getValue() + aFloat2.getValue());
        return result;
    }

    private static MathLabVector addition(MathLabFloat aFloat, MathLabVector vector) {
        return addition(vector, aFloat);
    }

    private static MathLabMatrix addition(MathLabFloat aFloat, MathLabMatrix matrix) {
        System.out.println("Сложение числа и матрицы");
        return new MathLabMatrix();
    }

    private static MathLabVector addition(MathLabVector vector, MathLabFloat aFloat) {
        Double[] result = vector.getValue();
        for (int i = 0; i < result.length; i++) {
            result[i] = result[i] + aFloat.getValue();
        }
        return new MathLabVector(result);
    }

    private static MathLabVector addition(MathLabVector vector1, MathLabVector vector2) {
        Double[] array1 = vector1.getValue();
        Double[] array2 = vector2.getValue();
        if (array1.length == array2.length) {
            Double[] result = new Double[array1.length];
            for (int i = 0; i < result.length; i++) {
                result[i] = array1[i] + array2[i];
            }
            return new MathLabVector(result);
        } else {
            System.out.println("Сложение векторов невозможно, так как они разного размера!");
        }
        return null;
    }

    private static MathLabFloat addition(MathLabVector vector, MathLabMatrix matrix) {
        System.out.println("Сложение вектора и матрицы??? Шта???");
        return null;
    }

    private static MathLabMatrix addition(MathLabMatrix matrix, MathLabFloat aFloat) {
        System.out.println("Сложение матрицы и числа");
        return new MathLabMatrix();
    }

    private static MathLabFloat addition(MathLabMatrix matrix, MathLabVector vector) {
        System.out.println("Сложение матрицы и вектора??? Шта???");
        return null;
    }

    private static MathLabMatrix addition(MathLabMatrix matrix1, MathLabMatrix matrix2) {
        System.out.println("Сложение матриц");
        return new MathLabMatrix();
    }

    static MathLabVariable addition(MathLabVariable first, MathLabVariable second) {
        if (first instanceof MathLabFloat) {
            if (second instanceof MathLabFloat) {
                return addition((MathLabFloat) first, (MathLabFloat) second);
            } else if (second instanceof MathLabVector) {
                return addition((MathLabFloat) first, (MathLabVector) second);
            } else {
                return addition((MathLabFloat) first, (MathLabMatrix) second);
            }
        } else if (first instanceof MathLabVector) {
            if (second instanceof MathLabFloat) {
                return addition((MathLabVector) first, (MathLabFloat) second);
            } else if (second instanceof MathLabVector) {
                return addition((MathLabVector) first, (MathLabVector) second);
            } else {
                return addition((MathLabVector) first, (MathLabMatrix) second); //УЗНАТЬ ЕСТЬ ЛИ ТАКАЯ ОПЕРАЦИЯ
            }
        } else if (first instanceof MathLabMatrix) {
            if (second instanceof MathLabFloat) {
                return addition((MathLabMatrix) first, (MathLabFloat) second);
            } else if (second instanceof MathLabVector) {
                return addition((MathLabMatrix) first, (MathLabVector) second); //УЗНАТЬ ЕСТЬ ЛИ ТАКАЯ ОПЕРАЦИЯ
            } else {
                return addition((MathLabMatrix) first, (MathLabMatrix) second);
            }
        }
        return null;
    }
}
