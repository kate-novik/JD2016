package by.it.luksha.jd01_14;


import java.io.File;
import java.io.IOException;

public class Runner {
    public static void main(String[] args) throws IOException {
        //Task A
        File file = TaskA.createFileWith20Numbers("myFile.dat");
        TaskA.readFile(file);

        //Task B
        TaskB.readTxtFile("text.txt");

        //Task C
        TaskC.printDir();
    }
}
