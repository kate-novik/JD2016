package by.it.novik.jd01_09.entity;

/**
 * Created by Kate Novik.
 */
public abstract class Variable implements IVariable {
    /**
     * Абстрактный класс всех переменных Matlab
     */
    // Объявим переменную типа Variable
    private Object value;

    public Variable() {
        this.value = null;
    }
    public Variable(Object value) {
        this.value = value;
    }

    @Override
    public Object getValue() {
        return value;
    }

    @Override
    public void setValue(Object value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value.toString();
    }

    @Override
    public void setValueFromString(String value) {  }
}
