package by.it.kust.jd03_01;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

/**
 * Created by Tanya Kust.
 */
public class Insert_users {
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
            String user1 = "INSERT INTO users(ID, Name, Login, Password, Email, Address, Discount, FK_Role" +
                    ") VALUES (" +
                    "1,'Ivanov Ivan','i.ivanov','hgkgdfxy','ivanov@mail.ru'," +
                    "'Belarus, Minsk, Pushkin str.,37/11',0,'admin');";
            String user2 = "INSERT INTO users(" +
                    "ID, Name, Login, Password, Email, Address, Discount, FK_Role" +
                    ") VALUES (" +
                    "2,'Petrov Petr','p.petrov','jghjgrfgf','petrov@mail.ru'," +
                    "'Belarus, Gomel, Gorkogo str.,5/68',0,'user');";
            String user3 = "INSERT INTO users(" +
                    "ID, Name, Login, Password, Email, Address, Discount, FK_Role" +
                    ") VALUES (" +
                    "3,'Sidorova Olga','s.olga','fgh5fghf','olga@mail.ru'," +
                    "'Belarus, Brest, Masherov str.,28/157',5,'user');";
            statement.executeUpdate(user1);
            statement.executeUpdate(user2);
            statement.executeUpdate(user3);
            connection.close();
            if (connection.isClosed()){
                System.out.println("соединение прервано");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
