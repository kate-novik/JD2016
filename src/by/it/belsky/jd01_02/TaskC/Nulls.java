package by.it.belsky.jd01_02.TaskC;

/**
 * Created by misha on 26.06.2016.
 */
public class Nulls {
    public static void GetNulls(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                for (int k = 0; k < matrix.length - 1; k++) {
                    boolean ok;
                    do {
                        ok=true;
                        if ((matrix[i][k] == 0)&&((matrix[i][k+1] != 0)) ) {
                            matrix[i][k] = matrix[i][k + 1];
                            matrix[i][k + 1] = 0;
                            ok = false;
                        }
                    }
                    while (ok == false);
                }
                System.out.print(matrix[i][j] + "  ");
            }
            System.out.println();
        }
    }
}