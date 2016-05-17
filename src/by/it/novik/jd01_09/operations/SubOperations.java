package by.it.novik.jd01_09.operations;

import by.it.novik.jd01_09.entity.DoubleValue;

/**
 * Created by Катя.
 */
public class SubOperations {

    /**
     * Перегружаем метод subtraction
     */
    public static DoubleValue subDoubleAndDouble(DoubleValue valueOne, DoubleValue valueTwo) {
        DoubleValue sub = new DoubleValue();
        sub.setValue((Double) valueOne.getValue() - (Double) valueTwo.getValue());
        return sub;
    }
}
