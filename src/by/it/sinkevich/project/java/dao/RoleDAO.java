package by.it.sinkevich.project.java.dao;

import by.it.sinkevich.project.java.bean.Role;
import by.it.sinkevich.project.java.connection.Connector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Class for entity Role, contains all CRUD operations with DB
 *
 * @author Sinkevich Denis
 */
public class RoleDAO implements InterfaceDAO<Role> {

    @Override
    public Role read(int id) {
        List<Role> roles = readAll("WHERE id = " + id);
        if (roles.size() > 0) {
            return roles.get(0);
        }
        return null;
    }

    @Override
    public boolean create(Role entity) {
        boolean isCreateOk = false;
        try (Connection connection = Connector.getConnection();
             Statement statement = connection.createStatement()) {
            String query = "INSERT INTO roles (name) " + "values('" + entity.getName() + "');";
            isCreateOk = statement.executeUpdate(query) == 1;
        } catch (SQLException e) {
            System.err.println("Ошибка работы с БД в RoleDAO!");
            e.printStackTrace();
        }
        return isCreateOk;
    }

    @Override
    public boolean update(Role entity) {
        boolean isUpdateOk = false;
        try (Connection connection = Connector.getConnection();
             Statement statement = connection.createStatement()) {
            String query = String.format("UPDATE roles SET name = '%s' WHERE id = %d;",
                    entity.getName(), entity.getId());
            isUpdateOk = statement.executeUpdate(query) == 1;
        } catch (SQLException e) {
            System.err.println("Ошибка работы с БД в RoleDAO!");
            e.printStackTrace();
        }
        return isUpdateOk;
    }

    @Override
    public boolean delete(Role entity) {
        boolean isDeleteOk = false;
        String query = "DELETE FROM roles WHERE roles.ID = " + entity.getId();
        try (Connection connection = Connector.getConnection();
             Statement statement = connection.createStatement()) {
            isDeleteOk = statement.executeUpdate(query) == 1;
        } catch (SQLException e) {
            System.err.println("Ошибка работы с БД в RoleDAO!");
            e.printStackTrace();
        }
        return isDeleteOk;
    }

    @Override
    public List<Role> readAll(String WhereAndOrder) {
        List<Role> roles = new ArrayList<>();
        try (Connection connection = Connector.getConnection();
             Statement statement = connection.createStatement()) {
            String query = "SELECT * FROM roles " + WhereAndOrder + " ;";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                roles.add(new Role(
                        resultSet.getInt("id"),
                        resultSet.getString("name")));
            }
        } catch (SQLException e) {
            System.err.println("Ошибка работы с БД в RoleDAO!");
            e.printStackTrace();
        }
        return roles;
    }
}
