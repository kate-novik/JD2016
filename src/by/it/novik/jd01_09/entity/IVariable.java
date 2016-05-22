package by.it.novik.jd01_09.entity;

/**
 * Created by Kate Novik.
 */
public interface IVariable {
    /**
     * Интерфейс действий с переменной
     */

    /**
     * Установить значение переменной
     * @param value Значение переменной типа Object
     */
    void setValue (Object value);

    /**
     * Получить значение переменной
     * @return Значение переменной типа Object
     */
    Object getValue ();

    /**
     * Преобразование значение переменной в строку
     * @return Значение переменной в виде строки
     */
    String toString();
}
