package by.it.novik.jd01_09.operations;

import by.it.novik.jd01_09.entity.DoubleValue;

/**
 * Created by Катя.
 */
public class MultiOperations {

    /**
     * метод multiplication
     */
    public static DoubleValue multipleDoubleAndDouble(DoubleValue valueOne, DoubleValue valueTwo) {
        DoubleValue mul = new DoubleValue();
        mul.setValue((Double) valueOne.getValue() * (Double) valueTwo.getValue());
        return mul;
    }
}
