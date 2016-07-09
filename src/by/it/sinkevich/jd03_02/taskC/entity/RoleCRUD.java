package by.it.sinkevich.jd03_02.taskC.entity;

import by.it.sinkevich.jd03_02.taskC.Connector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Class contains all CRUD operations for Class Role
 *
 * @author Sinkevich Denis
 */
public class RoleCRUD {

    public Role create(Role role) throws SQLException {
        boolean okCreate = false;
        try (Connection connection = Connector.getConnection();
             Statement statement = connection.createStatement()) {
            String query = String.format("INSERT INTO roles (name) " + "values('%s');", role.getName());
            if (statement.executeUpdate(query) == 1) {
                ResultSet resultSet = statement.executeQuery("SELECT LAST_INSERT_ID();");
                if (resultSet.next()) {
                    role.setId(resultSet.getInt(1));
                    okCreate = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        if (okCreate) {
            return role;
        } else {
            return null;
        }
    }

    public Role update(Role role) throws SQLException {
        try (Connection connection = Connector.getConnection();
             Statement statement = connection.createStatement()) {
            String query = String.format("UPDATE roles SET name = '%s', WHERE id = %d;",
                    role.getName(), role.getId());
            if (statement.executeUpdate(query) == 1) {
                return role;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return null;
    }

    public Role read(int id) throws SQLException {
        Role result = null;
        try (Connection connection = Connector.getConnection();
             Statement statement = connection.createStatement()) {
            String query = String.format("SELECT * FROM roles WHERE id = %d", id);
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                result = new Role(id, resultSet.getString("name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return result;
    }

    public boolean delete(Role role) throws SQLException {
        String query = String.format("DELETE FROM roles WHERE roles.ID = %d", role.getId());
        try (Connection connection = Connector.getConnection();
             Statement statement = connection.createStatement()) {
            return (statement.executeUpdate(query) == 1);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public List<Role> readAll() throws SQLException {
        List<Role> result = new ArrayList<>();
        try (Connection connection = Connector.getConnection();
             Statement statement = connection.createStatement()) {
            String query = "SELECT * FROM roles;";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                result.add(new Role(resultSet.getInt("id"), resultSet.getString("name")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return result;
    }
}
