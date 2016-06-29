package by.it.belsky.jd01_02.TaskC;

/**
 * Created by misha on 26.06.2016.
 */
public class Trans {
    public static void Transporting(int[][] matrix) {
        int [][]a = new int[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                a[i][j] = matrix[j][i];
                System.out.print(a[i][j]+"\t");
            }
            System.out.println();
        }

    }

}