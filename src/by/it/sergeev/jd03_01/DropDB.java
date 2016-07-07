package by.it.sergeev.jd03_01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;


public class DropDB {

    public static void main(String[] args) {

        try(Connection connection = DriverManager.getConnection(CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
            Statement statement = connection.createStatement()) {

            statement.executeUpdate("drop table user;");
            statement.executeUpdate("drop table role;");
            statement.executeUpdate("drop table ad;");
            //statement.executeUpdate("drop database searchhost_java;");

            System.out.println("База данных удалена");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}