package by.it.novik.jd01_09.entity;

/**
 * Created by Kate Novik.
 */
public class DoubleValue extends Variable {

    // Поле значение переменной
    private double valueD;

    public DoubleValue() {
        this.valueD = 0;
    }

    public DoubleValue(double valueD) {
        this.valueD = valueD;
    }

    public DoubleValue(String valueD) {
        setValue (valueD);
    }

    /**
     * Override метода получить значение переменной
     * @return Значение переменной
     */
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

    /**
     * Override метода toString
     * @return Значение переменной в виде строки
     */
    @Override
    public String toString() {
        return ((Double)valueD).toString();
    }

    /**
     * Override метода преобразование значение переменной со строки в переменную типа double
     * @param value Переданная строка
     */
    @Override
    public void setValue(String value) {
        this.valueD = Double.valueOf(value);

    }
}
