package by.it.sergeev.jd03_01;

import java.sql.*;

public class Create {

    public static void main(String[] args) {

        try(Connection connection = DriverManager.getConnection(CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
            Statement statement = connection.createStatement()) {

            Queries_DB.createTable(statement);
            Queries_DB.insertData(statement);

            System.out.println("База Данных готова");


        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}