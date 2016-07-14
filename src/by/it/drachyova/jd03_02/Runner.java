package by.it.drachyova.jd03_02;

import by.it.drachyova.jd03_02.beans.User;
import by.it.drachyova.jd03_02.crud.UserCRUD;

import java.sql.*;

public class Runner {
    public static void main(String[] args) {
        User user = new User(0, "login", "pass", "email", 2);
        int usersCounter = 0;
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            System.out.println("Task A");
            //проверка CRUD для пользователей
            UserCRUD userCRUD = new UserCRUD();
            //создание
            user = userCRUD.create(user);
            //чтение
            System.out.println(userCRUD.read(user.getId()));
            //обновление
            user.setLogin("loginUpdate");
            user = userCRUD.update(user);
            System.out.println(userCRUD.read(user.getId()));
            //удаление
            if (userCRUD.delete(user)) ;
            System.out.println("Удален №" + user.getId());
            System.out.println("Task B");
            ResultSet resultSet = statement.executeQuery("SELECT login, password, email, role FROM users INNER JOIN roles ON users.FK_Role=roles.ID");
            while (resultSet.next()) {
                ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
                int columnCount = resultSetMetaData.getColumnCount();
                for (int i = 1; i < columnCount + 1; i++) {
                    System.out.print(
                            resultSetMetaData.getColumnLabel(i) + "=" +
                                    resultSet.getString(i) + "\t"
                    );
                }
                usersCounter++;
                System.out.println();
            }
            System.out.println("Общее число пользователей " + usersCounter);
            System.out.println("Task C");
            ResetDataBase.deleteAllTables();
            ResetDataBase.createAllTables();
            ResetDataBase.fillAllTables();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}