package by.it.novik.jd01_09.entity;

/**
 * Created by Kate Novik.
 */
public interface IVariable {
    /**
     * Интерфейс действий с переменной
     */

    void setValue (Object value);
    void setValueFromString (String value);
    Object getValue ();
    String toString();
}
