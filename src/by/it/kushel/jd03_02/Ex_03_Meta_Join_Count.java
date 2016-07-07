package by.it.kushel.jd03_02;



import by.it.akhmelev.jd03_02.*;
import by.it.akhmelev.jd03_02.ConnectionCreator;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class Ex_03_Meta_Join_Count {
    public static void main(String[] args) {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement();) {

            ResultSet resultSet = statement.executeQuery("SELECT * FROM kushel.users INNER JOIN kushel.books ON kushel.books.Userid=kushel.users.id");
            while (resultSet.next()) {
                ResultSetMetaData resultSetMetaData=resultSet.getMetaData();
                int columnCount=resultSetMetaData.getColumnCount();
                for (int i = 1; i < columnCount+1; i++) {
                System.out.print(
                        resultSetMetaData.getColumnLabel(i) + "=" +
                                resultSet.getString(i) + "\t"
                );
                }
                System.out.println();
            }
            resultSet=statement.executeQuery("SELECT COUNT(*) FROM kushel.users INNER JOIN kushel.books ON kushel.books.Userid=kushel.users.id");
            if (resultSet.next())
                System.out.println("Всего записей: "+resultSet.getInt(1));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
