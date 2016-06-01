package by.it.luksha.jd01_12.tasks.taskC.TaskC2;

import java.util.HashSet;
import java.util.Random;

public class TaskC2 {
    /**
     * Создает множество и заполняет строками
     * @return множество
     */
    public static HashSet<String> createSet() {
        HashSet<String> set = new HashSet<String>();
        for (int i = 0; i < 30; i++) {
            set.add("String " + new Random().nextInt(100));
        }
        return set;
    }

    /**
     * Выводит в консоль множество с произвольным типом данных
     * @param set множество
     */
    public static void printSet(HashSet<?> set) {
        for (Object element: set) {
            System.out.println(element);
        }
        System.out.println();
    }
}
