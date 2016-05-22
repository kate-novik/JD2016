package by.it.novik.jd01_09.errors;

/**
 * Created by Kate Novik.
 */
public class ErrorOperations extends Exception {
    /**
     * Метод для вывода типа ошибки при вычислениях
     * @param typeError Тип ошибки вычисления
     */
    public void error (String typeError) {
        System.out.println("Error: ".concat(typeError));
    }
}
