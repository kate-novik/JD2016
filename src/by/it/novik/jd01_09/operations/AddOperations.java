package by.it.novik.jd01_09.operations;

import by.it.novik.jd01_09.entity.DoubleValue;
import by.it.novik.jd01_09.entity.MatrixValue;
import by.it.novik.jd01_09.entity.Variable;
import by.it.novik.jd01_09.entity.VectorValue;

/**
 * Created by Kate Novik.
 */
public class AddOperations implements IAddition{

    public DoubleValue addition(DoubleValue value1, DoubleValue value2) {
        return new DoubleValue(value1.getValue() + value2.getValue());
    }

    public MatrixValue addition(DoubleValue value1, MatrixValue value2) {
        MatrixValue add = new MatrixValue(value2.getValue().length);
        for (int i = 0; i < value2.getValue().length; i++) {
            for (int j = 0; j < value2.getValue().length; j++) {
                add.getValue()[i][j] = value1.getValue() + value2.getValue()[i][j];
            }
        }
        return add;
    }

    public MatrixValue addition(MatrixValue value1, DoubleValue value2) {
        return addition(value2, value1);
    }

    public VectorValue addition(DoubleValue value1, VectorValue value2) {
        VectorValue add = new VectorValue(value2.getValue().length);
        for (int i = 0; i < value2.getValue().length; i++) {
            add.getValue()[i] = value1.getValue() + value2.getValue()[i];
        }
        return add;
    }
    public VectorValue addition(VectorValue value1, DoubleValue value2) {
        return addition( value2, value1);
    }

    public VectorValue addition(VectorValue value1, VectorValue value2) {
        VectorValue add = new VectorValue(value1.getValue().length);
        for (int i = 0; i < value1.getValue().length; i++) {
            add.getValue()[i] = value1.getValue()[i] + value2.getValue()[i];
        }
        return add;
    }
    public MatrixValue addition(MatrixValue value1, MatrixValue value2) {
        MatrixValue add = new MatrixValue(value1.getValue().length);
        for (int i = 0; i < value1.getValue().length; i++) {
            for (int j = 0; j < value1.getValue().length; j++) {
                add.getValue()[i][j] = value1.getValue()[i][j] + value2.getValue()[i][j];
            }
        }
        return add;
    }
    public Variable addition(Variable value1, Variable value2) {
        System.out.print("Сложение невозможно!");
        return null;
    }
}
