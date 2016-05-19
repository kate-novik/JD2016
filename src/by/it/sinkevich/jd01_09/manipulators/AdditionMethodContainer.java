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
        System.out.println("Сложение числа и вектора");
        return new MathLabVector();
    }

    private static MathLabMatrix addition(MathLabFloat aFloat, MathLabMatrix matrix) {
        System.out.println("Сложение числа и матрицы");
        return new MathLabMatrix();
    }

    private static MathLabVector addition(MathLabVector vector1, MathLabFloat aFloat) {
        System.out.println("Сложение вектор и числа");
        return new MathLabVector();
    }

    private static MathLabVector addition(MathLabVector vector1, MathLabVector vector2) {
        System.out.println("Сложение векторов");
        return new MathLabVector();
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
                return addition( (MathLabMatrix) first, (MathLabVector) second); //УЗНАТЬ ЕСТЬ ЛИ ТАКАЯ ОПЕРАЦИЯ
            } else {
                return addition((MathLabMatrix) first, (MathLabMatrix) second);
            }
        }
        return null;
    }
}
