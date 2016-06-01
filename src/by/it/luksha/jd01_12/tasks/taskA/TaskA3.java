package by.it.luksha.jd01_12.tasks.taskA;


import java.util.ArrayList;
import java.util.Random;

public class TaskA3 {
    /**
     * Создает список из 30 псевдо-случайных чисел от -10 до 10
     * @return список
     */
    public static ArrayList<Integer> createList() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            arrayList.add((new Random().nextInt(20) - 10));
        }
        return arrayList;
    }

    /**
     * Печатает список в консоль
     * @param list список
     */
    public static void printArrayList(ArrayList<Integer> list) {
        for (Integer element: list) {
            System.out.println(element);
        }
        System.out.println();
    }
}
