package by.it.luksha.jd01_12.tasks.taskA.taskA2;


import java.util.HashSet;
import java.util.Random;

public class TaskA2 {
    /**
     * Создает множество и заполняет псевдо-случайными числами от 1 до 100
     * @return множество
     */
    public static HashSet<Integer> createSet() {
        HashSet<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < 30; i++) {
            set.add(new Random().nextInt(100));
        }
        return set;
    }

    /**
     * Выводит в консоль множество
     * @param set множество
     */
    public static void printSet(HashSet<Integer> set) {
        for (Integer element: set) {
            System.out.println(element);
        }
        System.out.println();
    }
}
