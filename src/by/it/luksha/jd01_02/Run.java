package by.it.luksha.jd01_02;

import java.io.IOException;

public class Run {
    //Спасибо Анне Кушаль за правки и поломаный код!
    public static void main(String[] args) throws IOException {

        //TaskA1
        System.out.println("                                                                            Task A...");
        //String line = Util.getLine();
        String line = "123 654 44 789456 12 3579 555 1";
        int[] array = Util.stringToArrayInt(line);

        System.out.println("========================================================================================================");
        System.out.println("1. Найти самое короткое и самое длинное число. Вывести найденные числа и их длину.");
        System.out.print("Массив: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
        int minNumber = TaskA.minLength(array);
        System.out.println("Самое короткое число - " + minNumber + ", его длинна - " + String.valueOf(minNumber).length() + ".");
        int maxNumber = TaskA.maxLength(array);
        System.out.println("Самое длинное число - " + maxNumber + ", его длинна - " + String.valueOf(maxNumber).length() + ".");
        System.out.println("========================================================================================================");

        System.out.println("2. Вывести на консоль те числа, длина которых меньше среднего арифметического.");
        TaskA.lessThanMean(array);
        System.out.println();
        System.out.println("========================================================================================================");

        System.out.println("3. Найти число, состоящее только из различных цифр. Если таких чисел несколько, найти первое из них (находит все числа).");
        TaskA.differentNums(array);
        System.out.println();
        System.out.println("========================================================================================================");
        System.out.println();

        //TaskB
        System.out.println("                                                                            Task B...");
        System.out.println("========================================================================================================");
        System.out.println("1. Определить принадлежность некоторого значения k интервалу [n, m].");
        int number = 88;
        int n = 5, m = 90;
        TaskB.includeNumber(number, n, m);
        System.out.println("========================================================================================================");

        System.out.println("2. Вывести числа от 1 до k в виде матрицы N x N слева направо и сверху вниз.");
        number = 89;
        TaskB.matrix(number);
        System.out.println("========================================================================================================");


        System.out.println("3. Найти корни квадратного уравнения. Параметры уравнения передавать с командной строкой.");
        TaskB.quadEq();
        System.out.println();
        System.out.println("========================================================================================================");

        System.out.println("4. Ввести число от 1 до 12. Вывести на консоль название месяца, соответствующего данному числу. Осуществить проверку корректности ввода чисел.");
        //номер месяца
        int month = 3;
        TaskB.numberOfMonth(month);
        System.out.println("========================================================================================================");




        //TaskC
        System.out.println("                                                                            Task C...");
        System.out.println("========================================================================================================");
        System.out.println("Ввести с консоли n-размерность матрицы a [n] [n].\nЗадать значения элементов матрицы в интервале значений от -n до n c помощью датчика случайных чисел.");
        int sizeOfMatrix = 4;
        System.out.println("Размер матрицы - " + sizeOfMatrix);
        int[][] matrix = TaskC.createMatrix(sizeOfMatrix);

        int[][] matrixNanQuad = TaskC.createMatrix(2, 3); //неквадратная матрица
        int[][] matrixTest = {
                {3, 0, 0},
                {0, 5, 4},
                {5, 1, 0},
        };

        Util.outArray2D(matrix);
        System.out.println("========================================================================================================");

        System.out.println("1. Найти сумму элементов матрицы, расположенных между первым и вторым положительными элементами каждой строки.");
        TaskC.searchSum(matrix);
        System.out.println("========================================================================================================");

        System.out.println("2. Транспонировать матрицу.");
        Util.outArray2D(TaskC.transposeMatrix(matrix));
        System.out.println("========================================================================================================");

        System.out.println("3. Повернуть матрицу на 90 градусов против часовой стрелки.");
        Util.outArray2D(TaskC.rotate90right(matrix));
        System.out.println("========================================================================================================");

        /*Тесты для неквадратной матрицы 2 и 3
        Util.outArray2D(matrixNanQuad);
        System.out.println();
        Util.outArray2D(TaskC.transposeMatrix(matrixNanQuad));
        System.out.println();
        Util.outArray2D(TaskC.rotate90right(matrixNanQuad));
        System.out.println();
        */

        System.out.println("4. Построить матрицу, вычитая из элементов каждой строки матрицы ее среднее арифметическое.");
        Util.outArray2D(TaskC.newSubMeanMatrix(matrix));
        System.out.println();
        System.out.println("========================================================================================================");



        System.out.println("5. Найти максимальный элемент(ы) в матрице и удалить из матрицы все строки и столбцы, его содержащие.");
        Util.outArray2D(matrixTest);
        TaskC.matrixWithoutMax(matrixTest);
        System.out.println();
        Util.outArray2D(matrixNanQuad);
        TaskC.matrixWithoutMax(matrixNanQuad);
        System.out.println();
        System.out.println("========================================================================================================");

    }
}
