package by.it.sinkevich.jd01_12.TaskC;

/**
 * Main class for testing tasks №1, №2, №3
 *
 * @author Sinkevich Denis
 */
class Main {

    public static void main(String[] args) {

        System.out.println("Задание №1: ");
        TaskC1 taskC1 = new TaskC1();
        System.out.println("Отсортированный список с наименованиями объектов: ");
        taskC1.fillMapWithObjectNames();
        taskC1.printMap();
        System.out.println("\nОтсортированный список без повторяющихся наименований объектов: ");
        taskC1.compressList();
        taskC1.printMap();
    }
}
