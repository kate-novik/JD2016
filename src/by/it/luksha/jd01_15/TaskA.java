package by.it.luksha.jd01_15;

import java.io.*;

public class TaskA {
    private static String src = System.getProperty("user.dir") + "/src/by/it/luksha/jd01_15/data/";

    /**
     * Создает матрицу 4х4 и заполняет пслучайными числами от -15 до 15
     * @return матрица
     */
    protected static int[][] createMatrix4x4() {
        int[][] matrix = new int[4][4];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = (int) (Math.random() * 30 - 15);
            }
        }
        return matrix;
    }

    /**
     * Выводит матрицу в консоль
     * @param matrix матрица
     */
    protected static void printToConsole(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                System.out.printf("%4d", value);
            }
            System.out.printf("\n");
        }
    }

    /**
     * Выводит матрицу в файл
     * @param matrix матрица
     * @param fileName имя файла
     * @throws IOException
     */
    protected static void printToFile(int[][] matrix, String fileName) throws IOException {

        PrintWriter printWriter = null;
        File file = new File(src + fileName);
        try {
            printWriter = new PrintWriter(new FileWriter(file));
            for (int[] row : matrix) {
                for (int value : row) {
                    printWriter.printf("%4s", value);
                }
                printWriter.printf("\n");
            }
        } catch (IOException e) {
            System.err.printf("Ошибка оздания файла %s", e);
        } finally {
            if (printWriter != null) {
                printWriter.close();
            }
        }
    }
}
