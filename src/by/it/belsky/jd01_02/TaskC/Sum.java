package by.it.belsky.jd01_02.TaskC;

/**
 * Created by misha on 23.06.2016.
 */
public class Sum {
    public static void GetSum(int[][] matrix) {

        //int n;
        // int matrix[][] = new int[n][n];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] > 0) {
                    int sum = 0;
                    for (int x = j+1; x < matrix[i].length; x++) {
                        if (matrix[i][x] < 0) {
                            sum = sum + matrix[i][x];

                        }else if  (matrix[i][x]>=0 || x==matrix.length) {

                            break;

                        }
                        System.out.println("Сумма: "+sum);
                    }

                }

            }

        }

    }

}