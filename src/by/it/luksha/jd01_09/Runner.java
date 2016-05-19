package by.it.luksha.jd01_09;

import by.it.luksha.jd01_09.io.Parser;

import java.io.IOException;


public class Runner {
    public static  void main(String[] args) throws IOException {
        System.out.println("Калькулятор");

        Test.run();

        /*
        System.out.println("Для прекращения выполнения программы введите пустую строку...");
        //Reader.startReadConsole();
        Parser.checkOperation("-1.0+-1.0");
        Parser.checkOperation("{{0.57,14.11},{-2.4,0.37}}+-1.0");
        Parser.checkOperation("{{0.57,14.11},{-2.4,0.37}}*{0.0,4.94,-7.03}");
        */

    }
}
