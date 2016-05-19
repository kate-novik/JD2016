<<<<<<< Updated upstream
package by.it.sereda.jd01_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Util {
    //чтение одной строки с консоли
    public static String consoleReadLine() throws IOException {
        InputStreamReader iStreamReader=new InputStreamReader(System.in);
        BufferedReader line=new BufferedReader(iStreamReader);
        String out=line.readLine();
        //line.close();
        return out;
    }

    static double[] lineToDoubleArray(String line) {
        //деление строки на элементы массива по пробелам
        String[] strArray = line.split(" ");
        //создаем и заполняем массив числе
        double[] array = new double[strArray.length];
        for (int j = 0; j < strArray.length; j++) {
            array[j] = Float.parseFloat(strArray[j]);
        }
        return array;
    }

    //преобразование одной строки в массив чисел
    static int[] lineToIntArray(String line) {
        //деление строки на элементы массива по пробелам
        String[] strArray = line.split(" ");
        //создаем и заполняем массив числе
        int[] array = new int[strArray.length];
        for (int j = 0; j < strArray.length; j++) {
            array[j] = Integer.parseInt(strArray[j]);
        }
        return array;
    }
    //преобразование одной строки в массив чисел
    public static void arrayPrint (double[] mas, String name, int cols) {
        int col=0;
        for (int i = 0; i < mas.length; i++) {
            System.out.print(name);                             //печатаем имя массива
            System.out.printf("[% -3d]=%-9.2f ", i, mas[i]);     //печатаем значения
            col++;
            if ((0==col%cols)                                   //если конец колонки
                    || (mas.length-1==i))                              //или конец массива
            {
                System.out.println();               //тогда печатаем перевод строки
            }
        }
    }
    public static void printArrayA (double[] array){
        int coll=1;
        System.out.println("Массив A");
        //System.out.println("");
        for (int i=0;i<array.length;i++){
            System.out.format(" A[%2d]=%3.2f",i,array[i]);
            if (coll%5==0 || coll==array.length)//Вывод массива в 5 столбцов
            {
                System.out.println("");
            }
            coll++;
        }
        System.out.println("");
    }



=======
package by.it.sereda.jd01_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Util {
    //чтение одной строки с консоли
    public static String consoleReadLine() throws IOException {
        InputStreamReader iStreamReader=new InputStreamReader(System.in);
        BufferedReader line=new BufferedReader(iStreamReader);
        String out=line.readLine();
        //line.close();
        return out;
    }

    static double[] lineToDoubleArray(String line) {
        //деление строки на элементы массива по пробелам
        String[] strArray = line.split(" ");
        //создаем и заполняем массив числе
        double[] array = new double[strArray.length];
        for (int j = 0; j < strArray.length; j++) {
            array[j] = Float.parseFloat(strArray[j]);
        }
        return array;
    }

    //преобразование одной строки в массив чисел
    static int[] lineToIntArray(String line) {
        //деление строки на элементы массива по пробелам
        String[] strArray = line.split(" ");
        //создаем и заполняем массив числе
        int[] array = new int[strArray.length];
        for (int j = 0; j < strArray.length; j++) {
            array[j] = Integer.parseInt(strArray[j]);
        }
        return array;
    }
    //преобразование одной строки в массив чисел

>>>>>>> Stashed changes
}