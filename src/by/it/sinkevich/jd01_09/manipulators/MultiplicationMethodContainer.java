package by.it.sinkevich.jd01_09.manipulators;

import by.it.sinkevich.jd01_09.variables.MathLabFloat;
import by.it.sinkevich.jd01_09.variables.MathLabMatrix;
import by.it.sinkevich.jd01_09.variables.MathLabVariable;
import by.it.sinkevich.jd01_09.variables.MathLabVector;

/**
 * Created by Computer on 19.05.2016.
 * @author Sinkevich Denis
 */
class MultiplicationMethodContainer {

    private static MathLabFloat multiplication(MathLabFloat aFloat1, MathLabFloat aFloat2) {
        MathLabFloat result = new MathLabFloat();
        result.setValue(aFloat1.getValue() * aFloat2.getValue());
        return result;
    }

    private static MathLabVector multiplication(MathLabFloat aFloat, MathLabVector vector) {
        System.out.println("Сложение числа и вектора");
        return new MathLabVector();
    }

    private static MathLabMatrix multiplication(MathLabFloat aFloat, MathLabMatrix matrix) {
        System.out.println("Сложение числа и матрицы");
        return new MathLabMatrix();
    }

    private static MathLabVector multiplication(MathLabVector vector1, MathLabFloat aFloat) {
        System.out.println("Сложение вектор и числа");
        return new MathLabVector();
    }

    private static MathLabVector multiplication(MathLabVector vector1, MathLabVector vector2) {
        System.out.println("Сложение векторов");
        return new MathLabVector();
    }

    private static MathLabFloat multiplication(MathLabVector vector, MathLabMatrix matrix) {
        System.out.println("Сложение вектора и матрицы??? Шта???");
        return null;
    }

    private static MathLabMatrix multiplication(MathLabMatrix matrix, MathLabFloat aFloat) {
        System.out.println("Сложение матрицы и числа");
        return new MathLabMatrix();
    }

    private static MathLabFloat multiplication(MathLabMatrix matrix, MathLabVector vector) {
        System.out.println("Сложение матрицы и вектора??? Шта???");
        return null;
    }

    private static MathLabMatrix multiplication(MathLabMatrix matrix1, MathLabMatrix matrix2) {
        System.out.println("Сложение матриц");
        return new MathLabMatrix();
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
                return multiplication( (MathLabMatrix) first, (MathLabVector) second); //УЗНАТЬ ЕСТЬ ЛИ ТАКАЯ ОПЕРАЦИЯ
            } else if (second instanceof MathLabMatrix) {
                return multiplication((MathLabMatrix) first, (MathLabMatrix) second);
            }
        }
        return null;
    }
}
