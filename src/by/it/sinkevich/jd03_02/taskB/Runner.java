package by.it.sinkevich.jd03_02.taskB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Main class for jd03_02taskB
 *
 * @author Sinkevich Denis
 */
class Runner {

    public static void main(String[] args) {
        try (Connection connection = Connector.getConnection();
             Statement statement = connection.createStatement()) {
            String query = "SELECT * FROM users INNER JOIN roles ON users.fk_role = roles.id;";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1) + "\t" + resultSet.getString(2) + "\t" +
                        resultSet.getString(3) + "\t" + resultSet.getString(4) + "\t" + resultSet.getString(6) + "\t" +
                        resultSet.getString(7) + "\t" + resultSet.getString(9));
            }

            String usersCountQuery = "SELECT COUNT(*) FROM users;";
            resultSet = statement.executeQuery(usersCountQuery);
            int usersCount = 0;
            if (resultSet.next()) {
                 usersCount = resultSet.getInt(1);
            }

            String rolesCountQuery = "SELECT COUNT(*) FROM roles;";
            resultSet = statement.executeQuery(rolesCountQuery);
            int rolesCount = 0;
            if (resultSet.next()) {
                rolesCount = resultSet.getInt(1);
            }
            System.out.println("Количество пользователей равно: " + usersCount + " . Количество ролей: " + rolesCount + ".");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
