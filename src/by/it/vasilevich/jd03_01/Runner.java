package by.it.vasilevich.jd03_01;


import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Runner {

    public static final String URL_DB = "jdbc:mysql://127.0.0.1:2016/ss" +
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
                             (URL_DB, USER_DB, PASSWORD_DB)){
            if (!connection.isClosed())
                System.out.println("Соединение установлено");
            connection.close();
            if (connection.isClosed())
                System.out.println("Соединение прервано");
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }


}
