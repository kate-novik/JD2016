package by.it.novik.jd01_09.operations;

import by.it.novik.jd01_09.entity.DoubleValue;
import by.it.novik.jd01_09.entity.MatrixValue;
import by.it.novik.jd01_09.entity.Variable;
import by.it.novik.jd01_09.entity.VectorValue;
import by.it.novik.jd01_09.errors.ErrorOperations;

/**
 * Created by Kate Novik.
 */
public class MultiOperations implements IMultiplication{

    /**
     * Override метода Умножение переменных
     * @param value1 Переменная 1
     * @param value2 Переменная 1
     * @return Результат вычисления
     */
    public Variable multiplication(Variable value1, Variable value2) {
        new ErrorOperations().error("Умножение невозможно");
        return null;
    }

    // Перегрузки метода multiplication при различных входных переменных

    public DoubleValue multiplication(DoubleValue value1, DoubleValue value2) {
        return new DoubleValue(value1.getValue() * value2.getValue());
    }

    public MatrixValue multiplication(DoubleValue value1, MatrixValue value2) {
        MatrixValue multi = new MatrixValue(value2.getValue().length);
        for (int i = 0; i < value2.getValue().length; i++) {
            for (int j = 0; j < value2.getValue().length; j++) {
                multi.getValue()[i][j] = value1.getValue() * value2.getValue()[i][j];
            }
        }
        return multi;
    }

    public MatrixValue multiplication(MatrixValue value1, DoubleValue value2) {
        return multiplication(value2, value1);
    }

    public VectorValue multiplication(DoubleValue value1, VectorValue value2) {
        VectorValue multi = new VectorValue(value2.getValue().length);
        for (int i = 0; i < value2.getValue().length; i++) {
            multi.getValue()[i] = value1.getValue() * value2.getValue()[i];
        }
        return multi;
    }

    public VectorValue multiplication(VectorValue value1, DoubleValue value2) {
        return multiplication(value2, value1);
    }

    public DoubleValue multiplication(VectorValue value1, VectorValue value2) {
        DoubleValue multi = new DoubleValue();
        double m = 0;
        for (int i = 0; i < value1.getValue().length; i++) {
            m += value1.getValue()[i] * value2.getValue()[i];
        }
        multi.setValue(m);
        return multi;
    }

    public MatrixValue multiplication(MatrixValue value1, MatrixValue value2) {
        MatrixValue multi = new MatrixValue(value1.getValue().length);
        for (int i = 0; i < value1.getValue().length; i++) {
            for (int j = 0; j < value2.getValue() [0].length; j++) {
                for (int k = 0; k < value2.getValue().length; k++) {
                    multi.getValue()[i][j] = multi.getValue()[i][j] + value1.getValue()[i][k] * value2.getValue()[k][j];
                }
            }
        }
        return multi;
    }

    public VectorValue multiplication(MatrixValue value1, VectorValue value2) {
        VectorValue multi = new VectorValue(value1.getValue().length);
        for (int i = 0; i < value1.getValue().length; i++) {
            for (int j = 0; j < value2.getValue().length; j++) {
                    multi.getValue()[i] = multi.getValue()[i] + value1.getValue()[i][j] * value2.getValue()[j];
            }
        }
        return multi;
    }

}
