package by.it.vasilevich.jd03_01;


import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

public class Insert_Ad {

    public static final String URL_DB = "jdbc:mysql://127.0.0.1:2016/ss" +
            "?useUnicode=true&amp;characterEncoding=UTF-8";
    public static final String USER_DB = "root";
    public static final String PASSWORD_DB = "";

    public static void main(String[ ] args) {

        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try (Connection connection =
                     DriverManager.getConnection
                             (URL_DB, USER_DB, PASSWORD_DB);

             Statement statement = connection.createStatement()) {

            //вставляем объявления
            statement.executeUpdate(
                    "insert into ad(ID, Price, Brand, Model, Type, Year, Engine, Transmission, Drive_unit, Mileage, Color, FK_Users)" +
                            "values (NULL, 14000, 'BMW', '535', 'sedan', 2008, 'petrol', 'automatic', 'rear', 180000, 'grey', 5);"
            );
            statement.executeUpdate(
                    "insert into ad(ID, Price, Brand, Model, Type, Year, Engine, Transmission, Drive_unit, Mileage, Color, FK_Users)" +
                            "values (NULL, 10500, 'Volkswagen', 'Passat B6', 'avant', 2006, 'diesel', 'manual', 'front', 350000, 'blue', 6);");
            statement.executeUpdate(
                    "insert into ad(ID, Price, Brand, Model, Type, Year, Engine, Transmission, Drive_unit, Mileage, Color, FK_Users)" +
                            "values (NULL, 9300, 'Kia', 'Rio', 'sedan', '2011', 'petrol', 'manual', 'front', '90000', 'red', 21);");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

