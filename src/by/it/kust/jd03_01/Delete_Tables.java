package by.it.kust.jd03_01;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

/**
 * Created by Tanya Kust.
 */
public class Delete_Tables {
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
           String query = "select name, FK_Role from users";
            ResultSet result = statement.executeQuery(query);
            System.out.println("Перечень пользователей с их ролями:");
            while (result.next()){
                System.out.println(
                        result.getString(1) + " " + result.getString(2));
            }

            String deleteUsers = "delete from users;";
            String deleteTours = "delete from tours;";
            statement.executeUpdate(deleteUsers);
            statement.executeUpdate(deleteTours);
            System.out.println("таблицы очищены");


            statement.executeUpdate("DROP TABLE IF EXISTS roles");
            statement.executeUpdate("DROP TABLE IF EXISTS tours");
            statement.executeUpdate("DROP TABLE IF EXISTS users");
            System.out.println("Таблицы удалены");
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
