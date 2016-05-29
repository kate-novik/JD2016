package by.it.sinkevich.jd01_12.TaskA;

/**
 * Main class for testing tasks N1, N2, N3.
 *
 * @author Sinkevich Denis
 */
class Main {

    public static void main(String[] args) {

        System.out.println("Задание №1: ");
        TaskA1 taskA1 = new TaskA1();
        taskA1.initListWithRandomMarks(0, 10);
        taskA1.printList();
        taskA1.deleteUnsatisfactoryMarks();
        taskA1.printList();
    }
}
