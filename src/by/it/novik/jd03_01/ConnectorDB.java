package by.it.novik.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Created by Kate Novik.
 */
public class ConnectorDB {

    /**
     * Получение соединения с базой данных
     * @return Объект Connection
     * @throws SQLException
     */
    public static Connection getConnection () throws SQLException {
        //Используем файл ресурсов для создания подключения
        ResourceBundle resourceBundle = ResourceBundle.getBundle("by.it.novik.jd03_01.resources.connection");
        String url = resourceBundle.getString("db.url");
        String user = resourceBundle.getString("db.user");
        String pass = resourceBundle.getString("db.password");
        return DriverManager.getConnection(url,user,pass);
    }
}
