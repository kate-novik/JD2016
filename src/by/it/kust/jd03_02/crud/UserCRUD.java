package by.it.kust.jd03_02.crud;

import by.it.kust.jd03_02.ConnectionCreator;
import by.it.kust.jd03_02.beans.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Tanya Kust.
 */
public class UserCRUD {

    public User create(User user) throws SQLException {
        String createUserSQL = String.format("INSERT INTO users (ID, Name, Login, Password, Email, " +
                "Address, Discount, FK_Role) VALUES('%d','%s','%s','%s','%s','%s','%d','%d')",
                user.getID(),user.getName(),user.getLogin(),user.getPassword(),user.getEmail(),
                user.getAddress(),user.getDiscount(),user.getFK_Role());
        try (Connection connection = ConnectionCreator.getConnection(); // соединение с базой
             Statement statement = connection.createStatement();  // объект для обращения к базе
             ){
            int res = statement.executeUpdate(createUserSQL);
            if (res==1){   // если добавлено, узнаем последний ID
                ResultSet resultSet = statement.executeQuery("SELECT LAST_INSERT_ID();");
                // извлечем ID и установим его для текущего объекта user
                if (resultSet.next()){
                    user.setID(resultSet.getInt(1));
                }
            }
        } catch (SQLException e) {
           throw e;
        }
        return user;
    }

    public User read(int id) throws SQLException {
        User userResult = null;
        String readUserSQL = "SELECT * FROM users WHERE ID=" + id;
        try (Connection connection = ConnectionCreator.getConnection(); // соединение с базой
             Statement statement = connection.createStatement();  // объект для обращения к базе
        ){
          final ResultSet resultSet = statement.executeQuery(readUserSQL);
            if (resultSet.next()){
                userResult = new User(
                        resultSet.getInt("ID"),
                        resultSet.getString("Name"),
                        resultSet.getString("Login"),
                        resultSet.getString("Password"),
                        resultSet.getString("Email"),
                        resultSet.getString("Address"),
                        resultSet.getInt("Discount"),
                        resultSet.getInt("FK_Role")
                );
            }
        } catch (SQLException e) {
            throw e;
        }
        return userResult;
    }

    public User update(User user) throws SQLException {
        User userResult = null;
        String updateUserSQL = String.format("UPDATE users SET Name='%s', Login='%s', Password='%s', Email='%s'," +
                        "Address='%s', Discount='%d', FK_Role='%d' WHERE users.ID='%d'",
                user.getName(),user.getLogin(),user.getPassword(),user.getEmail(),
                user.getAddress(),user.getDiscount(),user.getFK_Role(),user.getID());
        try (Connection connection = ConnectionCreator.getConnection(); // соединение с базой
             Statement statement = connection.createStatement();  // объект для обращения к базе
        ){
            int res = statement.executeUpdate(updateUserSQL);
            if (res==1){   // если добавлено
                userResult = user;
            }
        } catch (SQLException e) {
            throw e;
        }
        return userResult;
    }

    public boolean delete(User user) throws SQLException {
        String deleteUserSQL = String.format("DELETE FROM users WHERE users.ID='%d'", user.getID());
        boolean result = false;
        try (Connection connection = ConnectionCreator.getConnection(); // соединение с базой
             Statement statement = connection.createStatement();  // объект для обращения к базе
        ){
            int res = statement.executeUpdate(deleteUserSQL);
            if (res==1){   // если удалено
                result = true;
            }
        } catch (SQLException e) {
            throw e;
        }
        return result;
    }
}
