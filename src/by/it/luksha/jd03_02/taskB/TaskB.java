package by.it.luksha.jd03_02.taskB;

import by.it.luksha.jd03_02.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by MMauz on 07.07.2016.
 */
public class TaskB {
    public static void joinRolesUsers() {
        String joinSQL = "SELECT users.Login, users.FK_Role, roles.Name FROM users INNER JOIN roles ON users.FK_Role=roles.ID;";
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();
        ) {
            ResultSet resultSet = statement.executeQuery(joinSQL);
            int count = 0;

            while (resultSet.next()) {
                System.out.printf("Пользователь: %s\nПрава: %s\n\n", resultSet.getString("Login"), resultSet.getString("Name"));
                count++;
            }
            System.out.printf("Всего пользователей %d\n", count);

        } catch (SQLException e) {
            System.err.printf("Ошибка TaskB join: %s", e);
        }
    }
}
