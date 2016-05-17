package by.it.luksha.jd01_09.vars;

public class Scalar extends Var {
    /**
     * Значение скаляра
     */
    private double value;

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
