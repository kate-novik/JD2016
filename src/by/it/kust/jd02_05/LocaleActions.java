package by.it.kust.jd02_05;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by Tanya Kust.
 */
public class LocaleActions {
    private static final String PATH_RESOURCE = "by.it.kust.jd02_05.resources.str";
    private static Locale current;
    private static String language = null;
    private static String country;
    private static ResourceBundle resourceBundle;
    private static String dateFormat;

    public LocaleActions(String language, String message) {
        setLanguage(language);
        current = setLocale(language, country);
        resourceBundle = setResources(current);
        dateFormat = setDateFormat(current);
        message = getMessage(resourceBundle, message);
        showMessageAndDate(message, current);
    }

    static void setLanguage(String lan) {
        switch (lan) {
            case "ru":
                language = "ru";
                country = "RU";
                break;
            case "be":
                language = "be";
                country = "BY";
                break;
            case "en":
                language = "en";
                country = "US";
                break;
        }
    }

    static Locale setLocale(String language, String country) {
        current = new Locale(language, country);
        return current;
    }

    static ResourceBundle setResources(Locale current) {
        ResourceBundle rb = ResourceBundle.getBundle(PATH_RESOURCE, current);
        return rb;
    }

    static String setDateFormat(Locale current) {
        DateFormat df = DateFormat.getDateInstance(DateFormat.FULL, current);
        Date now = new Date();
        return df.format(now);
    }

    static String getMessage(ResourceBundle resourceBundle, String message) {
        return resourceBundle.getString(message);
    }

    static void showMessageAndDate(String msg, Locale current) {
        System.out.println(setDateFormat(current) + "\t" + msg);
    }
}



