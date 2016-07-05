package by.it.belsky.jd03_01;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by misha on 05.07.2016.
 */
public class DeleteForm {
    public static void main(String[] args) {
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try (java.sql.Connection connection =
                     DriverManager.getConnection
                             (CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement = connection.createStatement();) {

            statement.executeUpdate("delete from form where id>=10;");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
