package by.it.belsky.jd03_01;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

/**
 * Created by misha on 05.07.2016.
 */
public class InsertUser {
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

                statement.executeUpdate(
                        "insert into users(Login,Password,Email, Fk_Role)\n" +
                                "       values('TANK','a3567a','AVTO@mail.ru', 1);");
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

