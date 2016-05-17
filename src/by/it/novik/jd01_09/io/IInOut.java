package by.it.novik.jd01_09.io;

import by.it.novik.jd01_09.entity.Variable;

/**
 * Created by Kate Novik.
 */
public interface IInOut {

    /**
     *
     * @param value1
     * @param value2
     */
    void input(Variable value1, Variable value2);

    /**
     *
     * @param value
     */
    void output(Variable value);
}
