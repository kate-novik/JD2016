package by.it.sinkevich.jd01_09.variables;

import by.it.sinkevich.jd01_09.parser.Patterns;

/**
 * Created by Computer on 16.05.2016.
 *
 * @author Sinkevich Denis
 */
public class MathLabFloat extends MathLabVariable {

    private Double value;

    public MathLabFloat() {
        value = 0.0;
    }

    public MathLabFloat(Double value) {
        this.value = value;
    }

    public MathLabFloat(String value) {
        this.value = Double.valueOf(value);
    }

    public MathLabFloat(MathLabFloat value) {
        this.value = value.getValue();
    }

    @Override
    public Double getValue() {
        return value;
    }

    @Override
    public void setValue(Object value) {
        if (value instanceof Double) {
            this.value = (Double) value;
        } else {
            System.out.println("Запись значения невозможна!");
        }
    }

    @Override
    public void setValue(String strFrom) {
        if (strFrom.trim().matches(Patterns.regexFloat)) {
            value = Double.valueOf(strFrom);
        } else {
            System.out.println("Запись числа невозможна!");
        }
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
