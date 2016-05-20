package by.it.sinkevich.jd01_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Набор утилит для задания jd01_05.
 *
 * @author Sinkevich Denis
 */
class Util {

    static double getDoubleFromConsole() throws IOException {
        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String line = consoleReader.readLine();
        return Double.parseDouble(line);
    }

    //Вывод результатов табулирования функции на консоль: double[][] matrix -- матрица состоящая из 2-х строк!!!
    //Первая строка -- аргументы, вторая строка результат функции; String functionName -- название функции, int cols --
    //количество колонок для вывода
    static void printFunctionTable(double[][] matrix, String functionName, int cols) {
        for (int i = 0; i < matrix[0].length; i++) {
            System.out.printf("| %S[%-4.1f]=%-7.2f |", functionName, matrix[0][i], matrix[1][i]);
            if ((i + 1) % cols == 0 || i == matrix[0].length - 1) {
                System.out.println();
            }
        }
    }

    //Вывод одномерного массива для задание номер 6
    static void printFunctionForTask6(double[] array, String arrayName) {
        System.out.println("━━━━━━━━━━━━━━━━━━━━");
        System.out.println("Array : " + arrayName + ".");
        System.out.println("━━━━━━━━━━━━━━━━━━━━");
        for (int index = 0; index < array.length; index++) {
            System.out.println(String.format("%-1s%-1s%-1s%3s%-20s", "[", index, "]", "= ", array[index]));
        }
    }
}
