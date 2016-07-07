package by.it.sergeev.jd01_05.qvar16;

import by.it.sergeev.jd01_05.qvar16.TaskA.*;

public class Main {
    public static void main(String[] args) {
        // A1
        System.out.println("Контрольное задание №1");
        double x = 1.095961246;
        System.out.println("Результат уравнения разбитого на части:");
        System.out.println(A1.equationInPart(x));
        System.out.println("Результат полного уравнения:");
        System.out.println(A1.equationFull(x));

        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=- \n Контрольное задание №2");

        // A2
        System.out.println(A2.calculate(0.1,0.2));
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=- \n Контрольное задание №3");

        //A3
        A3.printTable();
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=- \n Контрольное задание №4");

        //A4
        System.out.println(A4.calculate());
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=- \n Контрольное задание №5");

        //A5
        A5.calculate();
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=- \n Контрольное задание №6");

        //A6
        double a[] = Task6.getArray();
        Task6 task6 = new Task6();
        task6.printArray(a, "testname", true);
        System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
        double b[] = task6.getEveryThirdElement(a);
        task6.printArray(b, "array", true);
        }
    }
