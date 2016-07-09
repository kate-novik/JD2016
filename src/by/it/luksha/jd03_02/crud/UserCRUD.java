package by.it.luksha.jd03_02.crud;

import by.it.luksha.jd03_02.ConnectionCreator;
import by.it.luksha.jd03_02.beans.User;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserCRUD {
    /**
     * Добавляет в БД нового пользователя
     *
     * @param user bean
     * @return bean с юзером и id=id(БД)
     * @throws SQLException
     */
    public User create(User user) throws SQLException {
        boolean okCreate = false;
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();
        ) {
            String createUserSQL = String.format("insert into users(Login, Password, Email, FK_Role) values('%s','%s','%s',%d);",
                    user.getLogin(), user.getPassword(), user.getEmail(), user.getFk_role());
            if (statement.executeUpdate(createUserSQL) == 1) {
                ResultSet resultSet = statement.executeQuery("SELECT LAST_INSERT_ID();");
                if (resultSet.next()) {
                    user.setId(resultSet.getInt(1));
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

    /**
     * Читает пользователя из БД по id и создает на основе записи bean
     *
     * @param id уникальный номер читаемого пользователя
     * @return созданный bean на основе данных из БД
     * @throws SQLException
     */
    public User read(int id) throws SQLException {
        User userResult = null;
        String readUserSQL = "SELECT * FROM users where ID=" + id;
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();
        ) {
            ResultSet resultSet = statement.executeQuery(readUserSQL);
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

    /**
     * Обновляет сведения записи в таблице users
     *
     * @param user bean с новыми данными
     * @return bean на основе измененных данных
     * @throws SQLException
     */
    public User update(User user) throws SQLException {
        User userResult = null;
        String updateUserSQL = String.format(
                "UPDATE users SET Login = '%s', Password = '%s', Email = '%s', FK_Role=%d WHERE users.ID = %d",
                user.getLogin(), user.getPassword(), user.getEmail(), user.getFk_role(), user.getId()
        );
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();
        ) {
            if (statement.executeUpdate(updateUserSQL) == 1)
                userResult = user;
        } catch (SQLException e) {
            throw e;
        }
        return userResult;
    }

    /**
     * Удаление записи о пользователе из талицы users
     *
     * @param user пользователь
     * @return результат удаления true/false
     * @throws SQLException
     */
    public boolean delete(User user) throws SQLException {
        String deleteUserSQL = String.format("DELETE FROM users WHERE users.ID = %d", user.getId());
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();
        ) {
            return (statement.executeUpdate(deleteUserSQL) == 1);
        } catch (SQLException e) {
            throw e;
        }
    }
}
