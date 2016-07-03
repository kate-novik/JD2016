package by.it.kust.jd02_05;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Locale;

/**
 * Created by Tanya Kust.
 */
public class ConsoleStart {

    private static String line = "";
    private static String currentLanguage = "en";

    public static void readConsole() {


        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            while (!line.equals("end")) {
                //System.out.println("Выберите язык приветствия: ru, be или en.");
                new LocaleActions(currentLanguage, "instructionMessage");
                line = bufferedReader.readLine();
                if ((line.equals("be") | line.equals("en") | line.equals("ru"))) {
                    currentLanguage = line;
                    new LocaleActions(currentLanguage, "helloMessage");
                } else if (line.equals("end")) {
                    //System.out.println("Вы завершили работу программы.");
                    new LocaleActions(currentLanguage, "breakMessage");
                    break;
                } else if (line.isEmpty()) {
                    //System.out.println("Вы ничего не ввели. Попробуйте еще раз.");
                    new LocaleActions("en", "emptyMessage");
                    continue;
                } else {
                    //System.out.println("Вы ввели некорректные данные. Попробуйте еще раз.");
                    new LocaleActions("en", "errorMessage");
                }
            }
        } catch (IOException e) {
            System.err.println("Ошибка чтения строки " + e);
        }
    }
}
