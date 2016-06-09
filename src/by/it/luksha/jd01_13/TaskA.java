package by.it.luksha.jd01_13;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
æ Вариант А. Создать программу с использованием двух типов обработки
исключений, которая:
§ открывает консоль;
§ считывает данные из консоли построчно;
§ переводит каждую строку в число и выводит в консоль данное число и сумму корней
всех ранее введенных чисел, включая введенное;
§ если перевести ввод в число невозможно или невозможно извлечь корень, то
программа обрабатывает ошибку и показывает на русском языке соответствующее
сообщение в консоли;
§ закрывается при вводе в консоль слова END.
 */

/**
 * Created by MMauz on 09.06.2016.
 */
public class TaskA {
    /**
     * Запускает обработчик консоли
     */
    protected static void run() {
        readConsole();
    }

    /**
     * Обрабатывает ввод из консоли
     */
    private static void readConsole() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        double sum = 0;
        do {
            try {
                line = bufferedReader.readLine();
                if (line.equals("END")) {break;} //выход из программы
                double num = Double.parseDouble(line);
                if (num < 0) {throw new ArithmeticException("Нельзя считать корень из отрицательного числа");}
                double sqrt = Math.sqrt(num);
                sum += sqrt;
                System.out.printf("Корень: %.2f\n", sqrt);
                System.out.printf("Сумма корней: %.2f\n", sum);

            } catch (IOException e) {
                System.err.printf("Ошибка ввода" + e);
            } catch (NumberFormatException e) {
                System.err.printf("Едрить ты бестолочь, надо было число вводить\n");
            } catch (ArithmeticException e) {
                System.err.printf(e.getMessage() + "\n");
            }
        } while (true);
    }
}
