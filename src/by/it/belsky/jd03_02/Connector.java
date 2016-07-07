package by.it.belsky.jd03_02;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by misha on 06.07.2016.
 */
public class Connector {
    private static final String URL_DB = "jdbc:mysql://127.0.0.1:2016/belsky" +
            "?useUnicode=true&characterEncoding=UTF-8";
    private static final String USER_DB = "root";
    private static final String PASSWORD = "";

    static {
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.deregisterDriver(driver);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static volatile Connection connection;

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            synchronized (URL_DB) {
                connection = DriverManager.getConnection(URL_DB, USER_DB, PASSWORD);
            }
        }
        return connection;
    }
}