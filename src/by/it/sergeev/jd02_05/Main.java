package by.it.sergeev.jd02_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

public class Main {
    public static void main(String[] args) throws IOException {
        String input = "";
        Locale.setDefault(Locale.US);
        for (int i = 0; i < 3; i++) {
            switch (i){
                case (1):{
                    Hello.hello("ru");
                    break;
                }
                case (2):{
                    Hello.hello("be");
                    break;
                }
                default:{
                    Hello.hello("");
                }
            }
        }
        while (!"exit".equals(input)){
            System.out.println("Введите язык приветствия или введите \"exit\" для выхода.");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            input = bufferedReader.readLine();
            if (!"exit".equals(input))
                Hello.hello(input);
        }
    }
}