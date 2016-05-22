package by.it.luksha.jd01_09.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reader {

    public static void startReadConsole() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        while(!line.isEmpty())
        {
            analysisLine(line);
            line = reader.readLine();
        }
    }

    private static void analysisLine(String line) {
        //TODO: в зависимости от того какая строка приходит (команда или выражение) вызывать метод для обработки.
    }

}
