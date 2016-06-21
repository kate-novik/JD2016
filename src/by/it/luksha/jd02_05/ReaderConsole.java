package by.it.luksha.jd02_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by MMauz on 21.06.2016.
 */
public class ReaderConsole {
    BufferedReader reader;

    public ReaderConsole() {
        this.reader = new BufferedReader(new InputStreamReader(System.in));
    }

    /**
     * Читает строку из консоли
     * @return строка
     */
    public String read() {
        String result = "Введите локаль";
        try {
            result = this.reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
