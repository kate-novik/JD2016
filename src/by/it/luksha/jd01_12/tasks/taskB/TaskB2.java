package by.it.luksha.jd01_12.tasks.taskB;


import java.util.ArrayList;
import java.util.LinkedList;

public class TaskB2 {
    /**
     * Удаляет каждый второй элемент из ArrayList размером n, пока не останется один элемент
     * @param n размер исходного ArrayList
     */
    public static void processArray(int n) {
        //Создание ArrayList размером n
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(1+i);
        }

        //начало процесса удаления
        long start = System.currentTimeMillis();
        //Удаление каждого второго элемента, пока не останется 1
        while(list.size() > 1) {
            int k = list.size();
            for (int i = 0; i < k/2; i++) {
                list.remove(1+i);
            }

        }
        //конец процесса удаления
        long finish = System.currentTimeMillis();

        long deltaTime = finish - start;

        System.out.printf("Время потраченное на удаление с использованием ArrayList из %d элементов: %d мс\n", n, deltaTime);
    }

    /**
     * Удаляет каждый второй элемент из LinkedList размером n, пока не останется один элемент
     * @param n размер исходного LinkedList
     */
    public static void processLinked(int n) {
        //Создание LinkedList размером n
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(1+i);
        }

        //начало процесса удаления
        long start = System.currentTimeMillis();
        //Удаление каждого второго элемента, пока не останется 1
        while(list.size() > 1) {
            int k = list.size();
            for (int i = 0; i < k/2; i++) {
                list.remove(1+i);
            }

        }
        //конец процесса удаления
        long finish = System.currentTimeMillis();

        long deltaTime = finish - start;

        System.out.printf("Время потраченное на удаление с использованием LinkedList из %d элементов: %d мс\n", n, deltaTime);
    }
}
