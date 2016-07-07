package by.it.sinkevich.jd03_02.taskA;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Class contains all CRUD operations for Clsss User
 *
 * @author Sinkevich Denis
 */
class UserCRUD {

    public User create(User user) throws SQLException {
        boolean okCreate = false;
        try (Connection connection = Connector.getConnection();
             Statement statement = connection.createStatement()) {
            String query = String.format("insert into users (name, dateOfBirth, email, fk_role, login, password) " +
                    "values('%s', '%s', '%s', %d, '%s', '%s');", user.getName(), user.getDateOfBirth(),  user.getEmail(), user.getFk_role(), user.getLogin(), user.getPassword());
            if (statement.executeUpdate(query) == 1) {
                ResultSet resultSet = statement.executeQuery("select LAST_INSERT_ID();");
                if (resultSet.next()) {
                    user.setId(resultSet.getInt(1));
                    okCreate = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        if (okCreate) {
            return user;
        } else {
            return null;
        }
    }
}
