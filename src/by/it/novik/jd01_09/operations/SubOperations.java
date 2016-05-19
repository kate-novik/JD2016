package by.it.novik.jd01_09.operations;

import by.it.novik.jd01_09.entity.DoubleValue;
import by.it.novik.jd01_09.entity.MatrixValue;
import by.it.novik.jd01_09.entity.Variable;
import by.it.novik.jd01_09.entity.VectorValue;

/**
 * Created by Kate Novik.
 */
public class SubOperations implements ISubtraction{


    public DoubleValue subtraction(DoubleValue value1, DoubleValue value2) {
        return new DoubleValue(value1.getValue() - value2.getValue());
    }

    public MatrixValue subtraction(MatrixValue value1, DoubleValue value2) {
        MatrixValue sub = new MatrixValue(value1.getValue().length);
        for (int i = 0; i < value1.getValue().length; i++) {
            for (int j = 0; j < value1.getValue().length; j++) {
                sub.getValue()[i][j] = value1.getValue()[i][j] - value2.getValue();
            }
        }
        return sub;
    }
    public MatrixValue subtraction(DoubleValue value1, MatrixValue value2) {
        return new AddOperations ().addition(value1, new MultiOperations().multiplication(new DoubleValue(-1), value2));
    }

    public VectorValue subtraction(VectorValue value1, DoubleValue value2) {
        VectorValue sub = new VectorValue(value1.getValue().length);
        for (int i = 0; i < value1.getValue().length; i++) {
            sub.getValue()[i] = value1.getValue()[i] - value2.getValue();
        }
        return sub;
    }

    public VectorValue subtraction(DoubleValue value1, VectorValue value2) {
        return new AddOperations ().addition(value1, new MultiOperations().multiplication(new DoubleValue(-1), value2));
    }
    public VectorValue subtraction(VectorValue value1, VectorValue value2) {
        VectorValue sub = new VectorValue(value1.getValue().length);
        for (int i = 0; i < value1.getValue().length; i++) {
            sub.getValue()[i] = value1.getValue()[i] - value2.getValue()[i];
        }
        return sub;
    }

    public MatrixValue subtraction(MatrixValue value1, MatrixValue value2) {
        MatrixValue sub = new MatrixValue(value1.getValue().length);
        for (int i = 0; i < value1.getValue().length; i++) {
            for (int j = 0; j < value1.getValue().length; j++) {
                sub.getValue()[i][j] = value1.getValue()[i][j] - value2.getValue()[i][j];
            }
        }
        return sub;
    }

    public Variable subtraction(Variable value1, Variable value2) {
        System.out.print("Вычитание невозможно!");
        return null;
    }
}
