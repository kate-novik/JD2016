package by.it.vasilevich.jd01_05;

import by.it.vasilevich.jd01_05.math.Task1;
import by.it.vasilevich.jd01_05.math.Task2;
import by.it.vasilevich.jd01_05.math.Task3;
import by.it.vasilevich.jd01_05.math.Task4;

/**
 * Created by user_2 on 08.06.2016.
 */
public class Main {
    public static void main (String [] args){
        System.out.println("Задание 1");
        double x = 12.6453;
        System.out.println(Task1.optionA(x));
        System.out.println(Task1.optionB(x));
        System.out.println();


        System.out.println("Задание 2");
        double a = 0.3;
        double b = -21.17;
        System.out.println(Task2.optionA(a, b));
        System.out.println();


        System.out.println("Задание 3");
        x = 3.67;
        Task3.printTable(x);
        System.out.println();


        System.out.println("Задание 4");
        System.out.print(Task4.prod());


    }
}
