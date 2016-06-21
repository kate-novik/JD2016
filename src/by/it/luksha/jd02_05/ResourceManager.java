package by.it.luksha.jd02_05;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * Created by MMauz on 21.06.2016.
 */
public enum ResourceManager {
    INSTANCE;
    private ResourceBundle resourceBundle;
    private final String resourceName = "by.it.luksha.jd02_05.res.strings";

    private ResourceManager() {
        resourceBundle = ResourceBundle.getBundle(resourceName, Locale.getDefault());
    }

    /**
     * Изменяет текущую локаль
     * @param locale локаль
     */
    public void changeResource(Locale locale) {
        resourceBundle = ResourceBundle.getBundle(resourceName, locale);
    }

    /**
     * Возвращает строку из ресурсов по ключу
     * @param key ключ
     * @return строка
     */
    public String getString(String key) {
        return resourceBundle.getString(key);
    }
}
