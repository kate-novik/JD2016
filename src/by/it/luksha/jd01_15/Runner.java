package by.it.luksha.jd01_15;

import java.io.IOException;

public class Runner {
    public static void main(String[] args) throws IOException {
        //TaskA
        int[][] matrix = TaskA.createMatrix4x4();
        TaskA.printToConsole(matrix);
        TaskA.printToFile(matrix, "matrix.txt");

        //TaskB
        TaskB.doSomething();

        //TaskC
        TaskC commander = new TaskC();
        commander.run();
    }
}
