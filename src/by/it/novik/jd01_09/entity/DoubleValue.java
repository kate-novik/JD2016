package by.it.novik.jd01_09.entity;

/**
 * Created by Kate Novik.
 */
public class DoubleValue extends Variable {

    // Поле double
    private double valueD;

    public DoubleValue() {

        this.valueD = 0;
    }

    public DoubleValue(double valueD) {

        this.valueD = valueD;
    }

    public DoubleValue(String valueD) {

        this.valueD = Double.valueOf(valueD);
    }

    @Override
    public Double getValue() {
        return this.valueD;
    }

    /**
     * Перегрузка метода setValue - установить значение поля valueV
     * @param valueD Параметр типа Double
     */
    public void setValue(Double valueD) {
        this.valueD = valueD;
    }

    @Override
    public String toString() {
        return ((Double)valueD).toString();
    }
}
