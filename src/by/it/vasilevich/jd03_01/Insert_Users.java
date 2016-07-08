package by.it.vasilevich.jd03_01;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;


public class Insert_Users {

    public static final String URL_DB = "jdbc:mysql://127.0.0.1:2016/vasilevich" +
            "?useUnicode=true&amp;characterEncoding=UTF-8";
    public static final String USER_DB = "root";
    public static final String PASSWORD_DB = "";

    public static void main(String[ ] args) {
        try {

            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {e.printStackTrace();}
        try (Connection connection=
                     DriverManager.getConnection
                             (URL_DB, USER_DB, PASSWORD_DB);
             Statement statement=connection.createStatement()) {
            //вставляем пользователей
            statement.executeUpdate(
                    "insert into users(Login,Password,Email,FK_Role)"+
                            " values('user','user','user@gmail.com',3);"
            );
            statement.executeUpdate(
                    "insert into users(Login,Password,Email,FK_Role)"+
                            " values('moder','moder','moder@gmail.com',2);"
            );

        }
        catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("New users are added!");

    }
}
