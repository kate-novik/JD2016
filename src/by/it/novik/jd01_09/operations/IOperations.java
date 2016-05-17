package by.it.novik.jd01_09.operations;

import by.it.novik.jd01_09.entity.Variable;

/**
 * Created by Kate Novik.
 */
public interface IOperations {
    /**
     * Интерфейс, описывающий операции с переменными
     */

    /**
     * Операция сложения Addition
     * @param valueOne Первое слагаемое
     * @param valueTwo Второе слагаемое
     * @return Сумма
     */
    Variable addition (Variable valueOne, Variable valueTwo);

    /**
     * Операция вычитания Subtraction
     * @param valueOne Первый параметр
     * @param valueTwo Второй параметр
     * @return Результат вычитания
     */
    Variable subtraction (Variable valueOne, Variable valueTwo);

    /**
     * Операция умножения Multiplication
     * @param valueOne Первый множитель
     * @param valueTwo Второй множитель
     * @return Результат умножения
     */
    Variable multiplication (Variable valueOne, Variable valueTwo);

    /**
     * Операция деления Division
     * @param valueOne Делимое
     * @param valueTwo Делитель
     * @return Результат деления
     */
    Variable division (Variable valueOne, Variable valueTwo);

}
