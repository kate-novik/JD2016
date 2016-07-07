package by.it.sinkevich.jd03_02.taskA;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Поиск индекса роли по имени
 *
 * @author Sinkevich Denis
 */
public class RoleIndex {

    static int findIndexByRole(String role) {
        try (Connection connection = Connector.getConnection();
             Statement statement = connection.createStatement()) {
            String query = "SELECT roles.id FROM sinkevich.roles WHERE roles.name = '" + role + "'";
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                return resultSet.getInt("id");
            }
        } catch (SQLException e) {
            System.err.println("Ощибка работы с БД!");
        }
        return 0;
    }
}
