package by.it.kust.jd03_01;

/**
 * Created by Tanya Kust.
 */
public class CN {
    //Корректно держать настройки соединения вне кода (!)
    //Обычно это файлы конфигурации сервера или фреймворка
    //а сам конфиг в этом случае - bean с инициализацией из XML
    //ТАК ЧТО ЭТО ЛИШЬ ПРИМЕР, ТАК НИКОГДА (!) НЕ ДЕЛАЮТ !

    // URL для MySQL
    public final static String URL_DB = "jdbc:mysql://localhost:2016/kust"+
            "?useUnicode=true&amp;characterEncoding=UTF-8";
    public final static String USER_DB = "root";   // имя пользователя
    public final static String PASSWORD_DB = "";   // пароль
}
