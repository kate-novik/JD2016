package by.it.kushel.jd01_08;

/**
 * Created by Diomn on 21.05.2016.
 */
public class VectorVariable implements IVariable {
    private Double[] value;


    public VectorVariable() {

    }
    public VectorVariable(Double[] var1, Double[] var2) {

        this.value = value;

    }
    /*public VectorVariable(String string) {
        this.value = Double.valueOf(string);
    }*/

    @Override
    public void setValue(Object value) {
        this.value = (Double[])value;
    }

    public Double[] getValue() {
        return value;
    }




}
