package by.it.sinkevich.jd01_09.variables;

import by.it.sinkevich.jd01_09.parser.Patterns;

/**
 * Created by Computer on 16.05.2016.
 *
 * @author Sinkevich Denis
 */
public class MathLabVector extends MathLabVariable {

    private Double[] value;

    public MathLabVector() {
        value = new Double[5];
    }

    public MathLabVector(int size) {
        if (size > 0) {
            value = new Double[size];
        } else {
            System.out.println("Размерность вектора меньше нуля");
        }
    }

    public MathLabVector(Double[] value) {
        this.value = new Double[value.length];
        System.arraycopy(value, 0, this.value, 0, value.length);
    }

    public MathLabVector(String vector) {
        setValue(vector);
    }

    public MathLabVector(MathLabVector vector) {
        value = new Double[vector.value.length];
        System.arraycopy(vector.value, 0, value, 0, vector.value.length);
    }

    public int getSize() {
        return value.length;
    }

    @Override
    public Double[] getValue() {
        return value.clone();
    }

    @Override
    public void setValue(Object value) {
        if (value instanceof Double[]) {
            Double[] temp = (Double[]) value;
            System.arraycopy(temp, 0, this.value, 0, temp.length);
        } else {
            System.out.println("Запись значения невозможна!");
        }
    }

    @Override
    public void setValue(String strFrom) {
        if (!strFrom.trim().matches(Patterns.regexVector)) {
            System.out.println("Запись значения невозможна");
            return;
        }
        String replaced = strFrom.replaceAll("[\\}\\{,]", " ");
        String[] valuesStr = replaced.trim().split(" +");
        value = new Double[valuesStr.length];
        for (int i = 0; i < valuesStr.length; i++) {
            value[i] = Double.parseDouble(valuesStr[i]);
        }
    }

    @Override
    public String toString() {
        String result = "{";
        for (int i = 0; i < value.length; i++) {
            String formatStr;
            if (i != value.length - 1) {
                formatStr = String.format("% 7.2f,", value[i]);
            } else {
                formatStr = String.format("% 7.2f}", value[i]);
            }
            result = result.concat(formatStr);
        }
        return result;
    }

}
