package by.it.luksha.jd01_09.vars;

public class Scalar extends Var {
    /**
     * Значение скаляра
     */
    private double value;

    public Scalar(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    /**
     * Конструктор преобразующий строку в объект типа Scalar
     * @param scalar строка
     */
    public Scalar(String scalar) {
        this.value = Double.valueOf(scalar);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
