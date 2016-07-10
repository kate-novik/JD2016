package by.it.kust.jd03_01;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

/**
 * Created by Tanya Kust.
 */
public class step4_Insert_Users_and_Select_users_and_Roles {
    public static void main(String[] args) {
        // загружаем драйвер
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            System.out.println("драйвер зарегистрирован");
        } catch (SQLException e) {
            System.out.println("Ошибка регистрации драйера");
        }

        // установка соединения
        try(Connection connection= DriverManager.getConnection(CN.URL_DB,CN.USER_DB,CN.PASSWORD_DB)) {
            if (!connection.isClosed()){System.out.println("соединение установлено");}
            // создание объекта запроса
            Statement statement = connection.createStatement();
            String users = "INSERT INTO users (Name, Login, Password, Email, Address, Discount, FK_Role) VALUES\n" +
                    "('Admin Adminov', 'a.adminov', 'hgkgdfxy', 'a.adminov@mail.ru', 'Belarus, Minsk, Pushkin str.,37/11', 0, 1),\n" +
                    "('Petrov Petr', 'p.petrov', 'jghjgrfgf', 'petrov@mail.ru', 'Belarus, Gomel, Gorkogo str.,5/68', 0,2),\n" +
                    "('Sidorova Olga', 's.olga', 'fgh5fghf', 'olga@mail.ru', 'Belarus, Brest, Masherov str.,28/157', 5,2),\n" +
                    "('Иванова Людмила', 'l.ivanova', 'hgkgdfxy', 'ivanov@mail.ru', 'Belarus, Minsk, Pushkin str.,37/11', 3,2);";
            int res = statement.executeUpdate(users);
            if (res>0) System.out.println(res + " пользователя(ей) добавлено в таблицу users");

            String query = "select name, fk_role from users";
            ResultSet result = statement.executeQuery(query);
            System.out.println("Список пользователей с их ролями:");
            while (result.next()){
                System.out.println(
                        result.getString(1) + " " + result.getString(2));
            }
            statement.close();
            connection.close();
            if (connection.isClosed()){
                System.out.println("соединение прервано");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
