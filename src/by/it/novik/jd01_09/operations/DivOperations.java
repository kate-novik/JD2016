package by.it.novik.jd01_09.operations;

import by.it.novik.jd01_09.entity.DoubleValue;

/**
 * Created by Катя.
 */
public class DivOperations {

    /**
     * Перегружаем метод division
     */
    public static DoubleValue divDoubleAndDouble(DoubleValue valueOne, DoubleValue valueTwo) {
        DoubleValue div = new DoubleValue();
        try {
            div.setValue((Double) valueOne.getValue() / (Double) valueTwo.getValue());
        } catch (Exception ex) {
            System.out.println("Division on null");
        }
        return div;
    }
}
