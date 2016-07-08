package by.it.kust.jd03_01;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

/**
 * Created by Tanya Kust.
 */
public class Insert_Roles {
    public static void main(String[] args) {
        // загружаем драйвер
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            System.out.println("драйвер зарегистрирован");
        } catch (SQLException e) {
            System.out.println("Ошибка регистрации драйера");
        }

        // установка соединения
        try(Connection connection= DriverManager.getConnection(CN.URL_DB,CN.USER_DB,CN.PASSWORD_DB)) {
            if (!connection.isClosed()){System.out.println("соединение установлено");}
            // создание объекта запроса
            Statement statement = connection.createStatement();
            String role1 = "INSERT INTO roles(ID, Role) VALUES (1,'admin');";
            String role2 = "INSERT INTO roles(ID, Role) VALUES (1,'user');";
            statement.executeUpdate(role1);
            statement.executeUpdate(role2);
            connection.close();
            if (connection.isClosed()){
                System.out.println("соединение прервано");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
