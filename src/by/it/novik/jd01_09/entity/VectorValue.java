package by.it.novik.jd01_09.entity;

import by.it.novik.jd01_09.patterns.PatternsVar;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Kate Novik.
 */
public class VectorValue extends Variable {
    // Поле массив double
    private double[] valueV;


    public VectorValue(double [] valueV) {

        this.valueV = new double [valueV.length];
        this.valueV = valueV.clone();
    }

    public VectorValue(int length) {

        this.valueV = new double [length];
    }

    public VectorValue(String valueV) {

        setValueFromString(valueV);
    }


    @Override
    public double[] getValue() {
        return this.valueV;
    }

    /**
     * Перегрузка метода setValue - установить значение поля valueV
     * @param valueV Массив double[]
     */
    public void setValue(double[] valueV) {
        this.valueV = new double [valueV.length];
        this.valueV = valueV.clone();
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("{");
        int k = 0;
        for (Double v : valueV) {
            k++;
           s = s.append(v.toString());
            if (k != valueV.length) {
                s.append(", ");
            } else { s.append("}"); }
        }
        return s.toString();
    }

    @Override
    public void setValueFromString(String value) {
        String[] elem=value.split(",");
        valueV=new double[elem.length];
        Matcher mat= Pattern.compile(PatternsVar.regxD).matcher(value);
        int i=0;
        while (mat.find()) {
            valueV[i]=Double.parseDouble(mat.group());
            i++;
        }
    }
}
