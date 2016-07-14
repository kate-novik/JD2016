package by.it.kust.jd03_02.crud;

import by.it.kust.jd03_02.ConnectionCreator;
import by.it.kust.jd03_02.beans.Role;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Tanya Kust.
 */
public class RoleCrud {
    public Role create(Role role) throws SQLException {
        String createRoleSQL = String.format("INSERT INTO roles (ID, Role) VALUES('%d','%s')",
                role.getId(),role.getRole());
        try (Connection connection = ConnectionCreator.getConnection(); // соединение с базой
             Statement statement = connection.createStatement();  // объект для обращения к базе
        ){
            int res = statement.executeUpdate(createRoleSQL);
            if (res==1){   // если добавлено, узнаем последний ID
                ResultSet resultSet = statement.executeQuery("SELECT LAST_INSERT_ID();");
                // извлечем ID и установим его для текущего объекта role
                if (resultSet.next()){
                    role.setId(resultSet.getInt(1));
                }
            }
        } catch (SQLException e) {
            throw e;
        }
        return role;
    }

    public Role read(int id) throws SQLException {
        Role roleResult = null;
        String readRoleSQL = "SELECT * FROM roles WHERE ID=" + id;
        try (Connection connection = ConnectionCreator.getConnection(); // соединение с базой
             Statement statement = connection.createStatement();  // объект для обращения к базе
        ){
            final ResultSet resultSet = statement.executeQuery(readRoleSQL);
            if (resultSet.next()){
                roleResult = new Role(
                        resultSet.getInt("ID"),
                        resultSet.getString("Role")
                );
            }
        } catch (SQLException e) {
            throw e;
        }
        return roleResult;
    }

    public Role update(Role role) throws SQLException {
        Role roleResult = null;
        String updateRoleSQL = String.format("UPDATE roles SET Role='%s' WHERE roles.ID='%d'",
                role.getRole(),role.getId());
        try (Connection connection = ConnectionCreator.getConnection(); // соединение с базой
             Statement statement = connection.createStatement();  // объект для обращения к базе
        ){
            int res = statement.executeUpdate(updateRoleSQL);
            if (res==1){   // если добавлено
                roleResult = role;
            }
        } catch (SQLException e) {
            throw e;
        }
        return roleResult;
    }

    public boolean delete(Role role) throws SQLException {
        String deleteRoleSQL = String.format("DELETE FROM roles WHERE roles.ID='%d'", role.getId());
        boolean result = false;
        try (Connection connection = ConnectionCreator.getConnection(); // соединение с базой
             Statement statement = connection.createStatement();  // объект для обращения к базе
        ){
            int res = statement.executeUpdate(deleteRoleSQL);
            if (res==1){   // если удалено
                result = true;
            }
        } catch (SQLException e) {
            throw e;
        }
        return result;
    }
}
