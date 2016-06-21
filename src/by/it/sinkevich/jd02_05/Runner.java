package by.it.sinkevich.jd02_05;

import by.it.sinkevich.jd02_05.resources.Resources;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Main class for task jd02_05
 *
 * @author Sinkevich Denis
 */
public class Runner {

    public static void main(String[] args) {
        Resources resources;
        Locale argsLocale;
        if (args.length == 2) {
            argsLocale = new Locale(args[0], args[1]);
            resources = Resources.getInstance(argsLocale);
        } else {
            argsLocale = new Locale("en", "US");
            resources = Resources.getInstance();
        }
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, argsLocale);
        System.out.println(resources.getString("helloMessage"));
        System.out.println(dateFormat.format(new Date()));
    }
}
