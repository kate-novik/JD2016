package by.it.luksha.jd01_09;

import by.it.luksha.jd01_09.io.Parser;
import by.it.luksha.jd01_09.vars.Var;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Runner {
    public static  void main(String[] args) throws IOException {
        System.out.println("Калькулятор");

        /*
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        */
        String scalar = "-3.14";
        String vector = "{0.0,4.94,-7.03}";
        String matrix = "{{0.57,14.11},{-2.4,0.37}}";

        Var a = Parser.toVar(scalar);
        Var b = Parser.toVar(vector);
        Var c = Parser.toVar(matrix);

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);



    }
}
