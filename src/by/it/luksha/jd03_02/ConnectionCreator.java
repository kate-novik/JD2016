package by.it.luksha.jd03_02;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class ConnectionCreator {
    //Памятка. Корректно держать настройки соединения вне кода (!)
    private static final String URL_DB =
            "jdbc:mysql://127.0.0.1:2016/luksha"
                    + "?useUnicode=true&characterEncoding=UTF-8";
    private static final String USER_DB = "root";
    private static final String PASSWORD_DB = "";

    static {
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    //аналог синглтона на случай множественного обращения
    private static volatile Connection connection = null;

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            synchronized (URL_DB) {
                if (connection == null || connection.isClosed())
                    connection = DriverManager.getConnection(URL_DB, USER_DB, PASSWORD_DB);
            }
        }
        return connection;
    }

}
