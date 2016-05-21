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
            //TODO: Распарсить строку
            line = reader.readLine();
        }
    }

}
