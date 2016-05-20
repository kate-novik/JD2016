package by.it.kushel.jd01_05;

import java.io.IOException;

/**
 * Created by Diomn on 05.05.2016.
 */
public class Runner {
    public  static void main(String[] arg) throws IOException {
        System.out.println("Task 1");
        System.out.println("option A. Y= " + Task1.optionA(234.1));
        System.out.println("option B. Y= "+ Task1.optionB(234.1));
        System.out.println();
        System.out.println("Task 2");
        System.out.println("Y= "+ Task2.findOfY(0.3, -21.17));
        System.out.println();
        System.out.println("Scanner Input");
        System.out.println("Y= "+Task2.findOfY());
        System.out.println();
        System.out.println("InputStreamReader");
        System.out.println("Y= "+Task2.coordinator());
        System.out.println();
        System.out.println("Task 3");
        Task3.printTable();
        System.out.println();
        System.out.println("Task 4");
        Task4.calculationY();
        System.out.println();
        System.out.println("Task 5");
        Task5.calculationBeta();


    }
}
