package by.it.luksha.jd02_05;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by MMauz on 21.06.2016.
 */
public class Runner {
    public static void main(String[] args) {
        ReaderConsole readerConsole = new ReaderConsole();

        String command = "";
        do {
            Locale locale = new Locale("en", "US");
            command = readerConsole.read();
            if (command.equals("end")) {
                break;
            }
            if (command.equals("ru")) {
                locale = new Locale("ru", "RU");
            } else if (command.equals("be")) {
                locale = new Locale("be", "BY");
            } else if (command.equals("en")) {
                locale = new Locale("en", "US");
            } else if (!command.isEmpty()) {
                System.out.println("Введена чушь");
            }
            printData(locale);
        } while (true);
    }

    /**
     * Печатает даные на языке локали
     * @param locale локаль
     */
    private static void printData(Locale locale) {
        ResourceManager resourceManager = ResourceManager.INSTANCE;
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.FULL, locale);
        String date = dateFormat.format(new Date());
        resourceManager.changeResource(locale);
        System.out.println(resourceManager.getString("string1") + "   " + date);
    }
}
