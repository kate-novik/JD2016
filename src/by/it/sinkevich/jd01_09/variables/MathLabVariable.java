package by.it.sinkevich.jd01_09.variables;

/**
 * Created by Computer on 16.05.2016.
 *
 * @author Sinkevich Denis
 */
public abstract class MathLabVariable implements IVariable {

    @Override
    public Object getValue() {
        return null;
    }

    public void setValue(Object value) {

    }

    @Override
    public void setValue(String strFrom) {

    }

    @Override
    public String toString() {
        return "MathLabVariable{}";
    }
}
