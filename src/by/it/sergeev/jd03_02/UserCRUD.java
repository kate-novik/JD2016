package by.it.sergeev.jd03_02;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserCRUD {

    public User create(User user) throws SQLException
    {
        boolean okCreate=false;
        try (

                Connection connection = Connector.getConnection(); //создаэм соединения с базой
                Statement statement = connection.createStatement();//создаэм объект для обращения к базе
        ) {
            //формирование строки createUserSQL по данным bean user
            String sql = String.format("insert into user(Login,Password,Name,Email,FK_Role) values('%s','%s','%s','%s','%d');",
                    user.getLogin(), user.getPassword(), user.getEmail(),user.getName(), user.getFk_role());
            //выполняем добавление в базу. Должна быть добавлена одна запись.
            if (statement.executeUpdate(sql) == 1) {
                //если всё добавлена то узнаем последний ID
                ResultSet resultSet = statement.executeQuery("SELECT LAST_INSERT_ID();");
                if (resultSet.next())
                    user.setId(resultSet.getInt(1));
                okCreate=true;
            }
        } catch (SQLException e) {
            throw e;
        }
        return user;
    }
}




