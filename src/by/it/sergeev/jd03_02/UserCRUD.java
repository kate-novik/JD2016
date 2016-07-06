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
                Connection connection = Connector.getConnection();
                Statement statement = connection.createStatement();
        ) {
            String sql = String.format("insert into users(Login,Password,Email,FK_Role) values('%s','%s','%s',%d);",
                    user.getLogin(), user.getPassword(), user.getEmail(), user.getFk_role());
            if (statement.executeUpdate(sql) == 1) {
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




