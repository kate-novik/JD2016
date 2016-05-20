package by.it.sinkevich.jd01_05;

import java.io.IOException;

/**
 * Runner для здания jd01_05.
 *
 * @author Sinkevich Denis
 */
public class MathRunner {

    public static void main(String[] args) throws IOException {
        TaskA taskA = new TaskA();
        // Задание 1, второй параметр в методе указывает на расчёт выражения полностью(true) либо по частям(false)
        double x = 234.1;
        System.out.println("Результат задания №1: ");
        taskA.task1(x, true);
        taskA.task1(x, false);
        System.out.println();
        //Задание 2, второй параметр в методе указывает на ручной ввод переменных и вывод результата(true)
        // либо присвоение переменных и вывод результата программой в методе(false)
        System.out.println("Результат задания №2: ");
        taskA.task2(false);
        System.out.println("z = " + taskA.task2(true));
        System.out.println();
        //Задание 3
        taskA.task3();
        System.out.println();
        //Задание 4
        taskA.task4();
        System.out.println();
        //Задание 5
        TaskB taskB = new TaskB();
        taskB.task1();
        System.out.println();
        //Задание 6
        taskB.task2();
        System.out.println();
        //Задание 7
        new TaskC().task();
    }
}
