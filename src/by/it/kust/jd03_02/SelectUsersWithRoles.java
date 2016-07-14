package by.it.kust.jd03_02;

import java.sql.*;

/**
 * Created by Tanya Kust.
 */
public class SelectUsersWithRoles {

    public static void doSelection() throws SQLException {
        int countUsers = 0;
        String selectUsersSQL = "SELECT users.name,roles.Role FROM users INNER JOIN roles ON users.FK_Role=roles.ID";
        String countRoles = "SELECT COUNT(*) FROM roles";
        try (Connection connection = ConnectionCreator.getConnection(); // соединение с базой
             Statement statement = connection.createStatement();  // объект для обращения к базе
        ) {
            ResultSet resultSet1 = statement.executeQuery(selectUsersSQL);
            while (resultSet1.next()) {
                countUsers++;
                ResultSetMetaData resultSetMetaData = resultSet1.getMetaData();
                int columns = resultSetMetaData.getColumnCount();
                for (int i=1; i<=columns; i++){
                    System.out.print(resultSetMetaData.getColumnLabel(i) + ": "
                            + resultSet1.getString(i) + "\t");
                }
                System.out.println();
            }
            System.out.print("Общее кол-во пользователей = " + countUsers);
            ResultSet resultSet2 = statement.executeQuery(countRoles);
            if (resultSet2.next()) {
                System.out.println(", кол-во возможных ролей = " + resultSet2.getInt(1));
            }
        } catch (SQLException e){
            throw e;
        }
    }
}
