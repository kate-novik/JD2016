package by.it.novik.jd01_09.entity;

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
}
