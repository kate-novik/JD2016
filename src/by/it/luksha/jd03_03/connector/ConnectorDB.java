package by.it.luksha.jd03_03.connector;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Класс для получение объекта Connection подключения к БД
 */
public class ConnectorDB {
    //экземпляр класса объекта Connection
    private static volatile Connection connection;

    private ConnectorDB() {
    }

    /**
     * Получает connection к БД
     * @return connection
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            synchronized (ConnectorDB.class) {
                if (connection == null || connection.isClosed()) {
                    Driver driver = new FabricMySQLDriver();
                    DriverManager.registerDriver(driver);

                    ResourceBundle resource = ResourceBundle.getBundle("by.it.luksha.jd03_03.resource.database");
                    String url = resource.getString("db.url");
                    String user = resource.getString("db.user");
                    String pass = resource.getString("db.password");

                    connection = DriverManager.getConnection(url, user, pass);
                }
            }
        }
        return connection;
    }
}
