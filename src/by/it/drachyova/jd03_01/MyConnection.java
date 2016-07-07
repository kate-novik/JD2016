package by.it.drachyova.jd03_01;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
    //Корректно держать настройки соединения вне кода (!)
    //Обычно это файлы конфигурации сервера или фреймворка
    //а сам конфиг в этом случае - bean с инициализацией из XML
    //ТАК ЧТО ЭТО ЛИШЬ ПРИМЕР, ТАК НИКОГДА (!) НЕ ДЕЛАЮТ !
    public static final String URL_DB = "jdbc:mysql://127.0.0.1:2016/drachyova" +
            "?useUnicode=true&characterEncoding=UTF-8";
    public static final String USER_DB = "root";
    public static final String PASSWORD_DB = "";
    private static volatile Connection connection = null;

    public static java.sql.Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            synchronized (URL_DB) {
                if (connection == null || connection.isClosed())
                    connection = DriverManager.getConnection(URL_DB, USER_DB, PASSWORD_DB);
            }
        }
        return connection;
    }
}
