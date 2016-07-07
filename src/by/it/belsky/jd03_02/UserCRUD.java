package by.it.belsky.jd03_02;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

/**
 * Created by misha on 06.07.2016.
 */
public class UserCRUD {
    public User create(User user) throws SQLException {
        boolean okCreate = false;
        // формирование стоки sql  по данным bean user;
        String createUserSQL = String.format("insert into users(Login,Password,Email, FK_Role)" +
                " values('%s', '%s','%s', '%d');",
                user.getLogin(), user.getPassword(), user.getEmail(), user.getFK_Role());
        try (
                Connection connection = Connector.getConnection(); //создаем соединение с базой
                Statement statement = connection.createStatement(); // cоздаем объект для обращения к базе
        ) {

           // выполняем добавление в базу, должна быть добавлена одна запись. Провери это.
            if (statement.executeUpdate(createUserSQL) == 1) {
                // если все добавлено, то узнаем последний ID
                ResultSet resultSet = statement.executeQuery("SELECT LAST_INSERT_ID();");
                if (resultSet.next()) {
                    user.setID(resultSet.getInt(1));
                    okCreate = true;
                }
            }
        } catch (SQLException e) {
           throw e;
        }
        if (okCreate) {

            return user;
        } else {
            return null;
        }
    }

    public User read(int ID) throws SQLException {
        User userResult = null;
        String readUserSQL = "SELECT * FROM users where ID=" + ID;
        try (
                Connection connection = Connector.getConnection();
                Statement statement = connection.createStatement();
        ) {
            final ResultSet resultSet = statement.executeQuery(readUserSQL);
            if (resultSet.next()) {
                userResult = new User(
                        resultSet.getInt("ID"),
                        resultSet.getString("Login"),
                        resultSet.getString("Email"),
                        resultSet.getString("Password"),
                        resultSet.getInt("FK_Role"));
            }
        } catch (SQLException e) {
            throw e;
        }
        return userResult;
    }

    public User update (User user)  throws SQLException{
        User userResult = null;
        String updateUserSQL = String.format(
                "UPDATE users SET Login = '%s', Password = '%s', Email = '%s', FK_Role=%d WHERE users.ID = %d",
                user.getLogin(), user.getPassword(), user.getEmail(), user.getFK_Role(), user.getID()
        );
        try (
                Connection connection = Connector.getConnection();
                Statement statement = connection.createStatement();
        ) {
            if (statement.executeUpdate(updateUserSQL) == 1)
                userResult = user;
        } catch (SQLException e) {
            throw e;
        }
        return userResult;
    }

    public boolean delete (User user) throws SQLException {
        String deleteUserSQL = String.format("Delete from users Where users.ID = %d", user.getID());
        try  (
                Connection connection = Connector.getConnection();
               Statement statement = connection.createStatement();
        ) {
            return (statement.executeUpdate(deleteUserSQL)==1);
        } catch (SQLException e) {
            throw e;
        }

    }
}
