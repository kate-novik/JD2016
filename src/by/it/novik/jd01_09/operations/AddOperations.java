package by.it.novik.jd01_09.operations;

import by.it.novik.jd01_09.entity.DoubleValue;
import by.it.novik.jd01_09.entity.MatrixValue;

/**
 * Created by Катя.
 */
public class AddOperations {

    public static DoubleValue addDoubleAndDouble(DoubleValue value1, DoubleValue value2) {
        DoubleValue add = new DoubleValue();
        add.setValue((Double) value1.getValue() + (Double) value2.getValue());
        return add;
    }

    public static MatrixValue addDoubleAndMatrix(DoubleValue value1, MatrixValue value2) {
        return null;
    }
}
