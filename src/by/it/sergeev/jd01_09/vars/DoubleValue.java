package by.it.sergeev.jd01_09.vars;

import by.it.sergeev.jd01_09.interfaces.IVariable;

public class DoubleValue extends Variable implements IVariable {

    private double value;


    public DoubleValue(String str) {                     //когда получили строку
        setFromString(str);
    }

    public DoubleValue(double value) {                    //когда получили число
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    @Override
    public Variable add(Variable var) {
        if (var instanceof DoubleValue) //проверка (аргумент - скаляр?)
            return new DoubleValue(this.value + ((DoubleValue) var).value); //результат
        return var.add(this);//если арнумент не скаляр, то меняем местами.
    }

    @Override
    public Variable sub(Variable var) {
        if (var instanceof DoubleValue)
            return new DoubleValue(this.value - ((DoubleValue) var).value);
        DoubleValue minus = new DoubleValue(-1);
        return minus.mul(var.sub(this));
    }

    @Override
    public Variable mul(Variable var) {
        if (var instanceof DoubleValue)
            return new DoubleValue(this.value * ((DoubleValue) var).value);
        return var.mul(this);
    }

    @Override
    public Variable div(Variable var) {
        if (var instanceof DoubleValue)
            return new DoubleValue(this.value / ((DoubleValue) var).value);
        return super.div(var);//если аргемент не скаляр - деление невозможно.
    }

    @Override
    public String toString() {
        return ((Double)value).toString();
    }

    @Override
    public void setFromString(String str) {
        value = Double.valueOf(str);
    }
}

