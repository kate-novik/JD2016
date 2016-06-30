package by.it.belsky.jd01_02.TaskC;


import static by.it.belsky.jd01_02.TaskC.Nulls.GetNulls;
import static by.it.belsky.jd01_02.TaskC.Sum.GetSum;
import static by.it.belsky.jd01_02.TaskC.Trans.Transporting;
import static sun.misc.Version.print;
/**
 * Created by misha on 22.06.2016.
 */
public class Main {
    public static void main(String[] args) {
       int [][] matrix = Matrix.printMatrix();
        GetSum(matrix);
        System.out.println("Транспонированная матрица:");
        Transporting(matrix);
        System.out.println("Нули:");
        GetNulls(matrix);

    }
}
