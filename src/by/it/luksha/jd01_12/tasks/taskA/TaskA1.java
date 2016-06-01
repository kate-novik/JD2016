package by.it.luksha.jd01_12.tasks.taskA;

import java.util.ArrayList;
import java.util.Random;

public class TaskA1 {
    /**
     * Создает ArrayList из 25 элементов и заполняет его числами от 1 до 10
     * @return ArrayList
     */
    public static ArrayList<Integer> createTableMarks() {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < 25; i++) {
            arrayList.add(randomMark());
        }
        return arrayList;
    }

    /**
     * Генерирует псевдослучайный Integer от 1 до 10
     * @return Integer
     */
    private static Integer randomMark() {
        Integer mark = new Random().nextInt(10) + 1;
        return mark;
    }

    /**
     * Удаляет из ArrayList числа меньше 4
     * @param array
     * @return ArrayList без чисел меньше 4
     */
    public static ArrayList<Integer> deleteBadMarks(ArrayList<Integer> array) {
        ArrayList<Integer> arrayWithoutBadMarks = new ArrayList<>(array);
        for (int i = 0; i < arrayWithoutBadMarks.size();) {
            if (arrayWithoutBadMarks.get(i) < 4) {
                arrayWithoutBadMarks.remove(i);
            }
            else {
                i++;
            }
        }
        return arrayWithoutBadMarks;
    }

    /**
     * Печатает ArrayList
     * @param array
     */
    public static void printTable(ArrayList<Integer> array) {
        int count = 1;
        for (Integer element: array) {
            System.out.println("Оценка " + count + ": " + element);
            count++;
        }
        System.out.println();
    }
}
