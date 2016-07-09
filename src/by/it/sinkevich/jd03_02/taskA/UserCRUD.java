package by.it.sinkevich.jd03_02.taskA;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Class contains all CRUD operations for Class User
 *
 * @author Sinkevich Denis
 */
class UserCRUD {

    public User create(User user) throws SQLException {
        boolean okCreate = false;
        try (Connection connection = Connector.getConnection();
             Statement statement = connection.createStatement()) {
            String query = String.format("insert into users (name, dateOfBirth, email, fk_role, login, password) " +
                    "values('%s', '%s', '%s', %d, '%s', '%s');", user.getName(), user.getDateOfBirth(), user.getEmail(), user.getFk_role(), user.getLogin(), user.getPassword());
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

    public User update(User user) throws SQLException {
        try (Connection connection = Connector.getConnection();
             Statement statement = connection.createStatement()) {
            String query = String.format("UPDATE users SET name = '%s', dateOfBirth = '%s', email = '%s', " +
                            "fk_role = %d, login = '%s', password = '%s' WHERE id = %d;",
                    user.getName(), user.getDateOfBirth(), user.getEmail(), user.getFk_role(), user.getLogin(), user.getPassword(), user.getId());
            if (statement.executeUpdate(query) == 1) {
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return null;
    }

    public User read(int id) throws SQLException {
        User result = null;
        try (Connection connection = Connector.getConnection();
             Statement statement = connection.createStatement()) {
            String query = String.format("SELECT * FROM users WHERE id = %d", id);
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                result = new User(id,
                        resultSet.getString("name"),
                        resultSet.getDate("dateOfBirth"),
                        resultSet.getString("email"),
                        resultSet.getInt("fk_role"),
                        resultSet.getString("login"),
                        resultSet.getString("password"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return result;
    }

    public boolean delete(User user) throws SQLException {
        String deleteUserSQL = String.format("DELETE FROM users WHERE users.ID = %d", user.getId());
        try (Connection connection = Connector.getConnection();
             Statement statement = connection.createStatement()) {
            return (statement.executeUpdate(deleteUserSQL) == 1);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }
}
