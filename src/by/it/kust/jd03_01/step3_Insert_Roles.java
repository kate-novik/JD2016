package by.it.kust.jd03_01;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

/**
 * Created by Tanya Kust.
 */
public class step3_Insert_Roles {
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
            String roles = "INSERT INTO roles (ID, Role) VALUES\n" +
                    "(1, 'admin'),\n" +
                    "(2, 'user');";
            int res = statement.executeUpdate(roles);
            if (res>0) System.out.println("Роли добавлены.");
            statement.close();
            connection.close();
            if (connection.isClosed()){
                System.out.println("соединение прервано");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
