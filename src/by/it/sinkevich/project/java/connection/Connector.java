package by.it.sinkevich.project.java.connection;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Class singleton for DB connection
 *
 * @author Sinkevich Denis
 */
public class Connector {

    private static final String DB_URL = "jdbc:mysql://localhost:2016/sinkevich" +
            "?useUnicode=true&characterEncoding=UTF-8";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "";

    static {
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private static volatile Connection connection;

    private Connector() {

    }

    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            synchronized (DB_URL) {
                if (connection == null || connection.isClosed()) {
                    connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
                }
            }
        }
        return connection;
    }
}
