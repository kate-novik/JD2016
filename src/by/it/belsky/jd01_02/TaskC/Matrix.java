package by.it.belsky.jd01_02.TaskC;

import java.util.Scanner;

/**
 * Created by misha on 22.06.2016.
 */
public class Matrix {
    public static int[][] printMatrix() {
        Scanner s = new Scanner(System.in);
        int n;
        System.out.println("Введите размерность матрицы n: ");
        n = s.nextInt();
        System.out.println("Получена матрица: ");
        int[][] matrix = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <n; j++) {
                matrix[i][j] = (int) (Math.random() * 9 -4);
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
        return matrix;
    }

}