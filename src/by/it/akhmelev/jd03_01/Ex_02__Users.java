package by.it.akhmelev.jd03_01;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class Ex_02__Users {


    public static void main(String[ ] args) {
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {e.printStackTrace();}
        try (Connection connection=
                     DriverManager.getConnection
                             (CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement=connection.createStatement();) {
            //вставляем пользователей
            statement.executeUpdate(
                    "insert into users(Login,Password,Email,Role)"+
                            " values('admin2','admin2','admin2@tut.by','administrator');"
            );
            statement.executeUpdate(
                    "insert into users(Login,Password,Email,Role)"+
                            " values('avkhmeleva','pavkhmeleva','avkhmeleva@tut.by','administrator');"
            );
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
