package by.it.sinkevich.jd01_03;

/**
 * Класс утилит
 */
public class Utils {

    /**
     * Возвращает отсортированный массив типа {@code double}
     * после сортировки пузырьковым методом
     *
     * @param array     массив типа {@code double}, который нужно отсортировать
     * @param direction направление сортировки: {@code true}
     *                  -- по возрастанию, {@code false} по убыванию
     * @return отсортированный массив типа  {@code double}
     */
    public static double[] sortArray(double[] array, boolean direction) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if ((array[j] > array[j + 1] && direction) ||
                        (array[j] < array[j + 1] && !direction)) {
                    double temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        return array;
    }

    /**
     * Возвращает максимальный элемент массива типа {@code double}
     *
     * @param numbers массив чисел типа {@code double}
     * @return максимальный элемент массива типа  {@code double}
     */
    static double getMax(double[] numbers) {
        double max = Double.MIN_VALUE;
        for (double num : numbers) {
            if (max < num) {
                max = num;
            }
        }
        return max;
    }

    /**
     * Возвращает минимальный элемент массива типа {@code double}
     *
     * @param numbers массив чисел типа {@code double}
     * @return минимальный элемент массива типа  {@code double}
     */
    static double getMin(double[] numbers) {
        double min = Double.MAX_VALUE;
        for (double num : numbers) {
            if (min > num) {
                min = num;
            }
        }
        return min;
    }

    /**
     * Возвращает матрицу типа {@code double} -- результат произведения
     * двух матриц
     *
     * @param x матрица типа {@code double}, которую умножаем
     * @param y матрица типа {@code double}, на которую производится умножение
     * @return результат произведения матриц {@code double}
     */
    public static double[][] matrixMul(double[][] x, double[][] y) {
        double[][] matrix = new double[x.length][y[0].length];
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < y[0].length; j++) {
                for (int k = 0; k < y.length; k++) {
                    matrix[i][j] += x[i][k] * y[k][j];
                }
            }
        }
        return matrix;
    }

    /**
     * Возвращает вектор типа {@code double} -- результат произведения
     * матрицы на вектор-столбец
     *
     * @param x матрица типа {@code double}, которую умножаем
     * @param y вектор-столбец типа {@code double}, на который прозводится
     *          умножение
     * @return вектор-столбец типа {@code double}
     */
    public static double[] matrixMul(double[][] x, double[] y) {
        double[] vector = new double[x.length];
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < y.length; j++) {
                vector[i] += x[i][j] * y[j];
            }
        }
        return vector;
    }
}
