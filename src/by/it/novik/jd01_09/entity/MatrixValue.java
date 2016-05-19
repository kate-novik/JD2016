package by.it.novik.jd01_09.entity;



/**
 * Created by Kate Novik.
 */
public class MatrixValue extends Variable {
    // Значение поля
    private double[][] valueM;


    public MatrixValue(double [][] valueV) {

        this.valueM = new double [valueV.length] [valueV.length];
        this.valueM = valueV.clone();
    }

    public MatrixValue(int length) {

        this.valueM = new double [length] [length];
    }


    @Override
    public double[][] getValue() {
        return this.valueM;
    }

    /**
     * Перегрузка метода setValue - установить значение поля valueV
     * @param valueM Массив double[]
     */
    public void setValue(double[][] valueM) {
        this.valueM = new double [valueM.length][valueM.length];
        this.valueM = valueM.clone();
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder("{{");
        int k = 0;
        for (double[] v : valueM) {
            for (Double m : v) {
                k++;
                s = s.append(m.toString());
                if (k % valueM.length != 0) {
                    s.append(", ");
                } else if (k != valueM.length * valueM.length) {
                    s.append("},{");
                } else {
                    s.append("}}");
                }
            }
        }
        return s.toString();
    }
}
