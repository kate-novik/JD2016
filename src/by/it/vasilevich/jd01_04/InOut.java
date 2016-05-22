package by.it.vasilevich.jd01_04;


import java.io.IOException;
import java.util.Scanner;

public class InOut {
    public static void main(String[] args) throws IOException {
        System.out.println("Введите числа для одномерного массива:");
        Scanner in = new Scanner(System.in);
        String line2 = in.nextLine();
        //строка ввода из консоли;
        double array[] = Utils.lineToIntArray(line2);
        //преобразуем строку в массив;
        System.out.print("Создан одномерный массив со следующими значениями:\n{");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i]);
            //выводим все элементы массива;
            if (i < array.length - 1)
                System.out.print(", ");
            else
                System.out.print("}");
        }

        System.out.println("\nВведите размер двумерной матрицы типа N*N:");
        Scanner n = new Scanner(System.in);
        int size = n.nextInt();
        //устанавливаем размер матрицы;
        double array2[][] = new double[size][size];
        System.out.print("Введите двумерный массив:\n");
        for (int i = 0; i < array2.length; i++)
            for (int j = 0; j < array2.length; j++) {
                System.out.println("Введите [" + i + "][" + j + "]-ый компонент массива");
                array2[i][j] = n.nextInt();
            }
        System.out.print("Создана двумерная матрица со следующими значениями:\n");
        for (double[] anArr2 : array2) {
            for (int j = 0; j < array2.length; j++) {
                System.out.print(anArr2[j]);
                //выводим все элементы массива;
                if (j < array2.length - 1)
                    System.out.print(", ");
                else
                    System.out.println("");

            }
        }

//        double mA[]=Utils.findRoot(array2,array,false);
//        System.out.println(mA);
    }
    double[] vectorY = {1,14,32,23};
//    Utils.printArray(vectorY,"x");
}
