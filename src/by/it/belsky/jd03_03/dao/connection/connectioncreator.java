package by.it.belsky.jd03_03.dao.connection;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by misha on 12.07.2016.
 */
public class connectioncreator {//Памятка. Корректно держать настройки соединения вне кода (!)
    private static final String URL_DB =
            "jdbc:mysql://127.0.0.1:2016/it_academy"
                    +"?useUnicode=true&characterEncoding=UTF-8";
    private static final String USER_DB = "root";
    private static final String PASSWORD_DB = "";

    //аналог синглтона на случай множественного обращения
    private static volatile Connection connection = null;

    public static Connection getConnection() throws SQLException {
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

