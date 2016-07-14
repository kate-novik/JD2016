package by.it.drachyova.jd03_02;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class ResetDataBase {
    public static void deleteAllTables() {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            System.out.println("Удаление всех таблиц в базе данных");
            statement.executeUpdate("DROP TABLE IF EXISTS roles ");
            statement.executeUpdate("DROP TABLE IF EXISTS users ");
            statement.executeUpdate("DROP TABLE IF EXISTS reservations ");
            statement.executeUpdate("DROP TABLE IF EXISTS rooms ");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void createAllTables() {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            System.out.println("Создания всех таблиц");
            statement.executeUpdate("CREATE TABLE drachyova.roles ( id INT(10) NOT NULL AUTO_INCREMENT , " +
                    "role VARCHAR(30) NOT NULL , PRIMARY KEY (`id`)) ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE drachyova.users ( id INT(10) NOT NULL AUTO_INCREMENT ," +
                    " login VARCHAR(30) NOT NULL , password VARCHAR(30) NOT NULL , email VARCHAR(30) NOT NULL , " +
                    "fk_role INT(10) NOT NULL , PRIMARY KEY (id)) ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE drachyova.reservations ( id INT(10) NOT NULL AUTO_INCREMENT , " +
                    "checkIn TIMESTAMP NOT NULL , chekOut TIMESTAMP NOT NULL , fk_type INT(10) NOT NULL , " +
                    "fk_user INT(10) NOT NULL , PRIMARY KEY (id)) ENGINE = InnoDB;");
            statement.executeUpdate("CREATE TABLE drachyova.rooms ( id INT(10) NOT NULL AUTO_INCREMENT , " +
                    "type VARCHAR(30) NOT NULL , price INT NOT NULL , isAvaliable VARCHAR(10) NOT NULL , " +
                    "PRIMARY KEY (id)) ENGINE = InnoDB;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void fillAllTables() {
        try (Connection connection = ConnectionCreator.getConnection();
             Statement statement = connection.createStatement()) {
            System.out.println("Заполнение всех таблиц");
            statement.executeUpdate("INSERT INTO roles (role) VALUES ('administrator'), ('user');");
            statement.executeUpdate("INSERT INTO users (login, password, email, fk_role)" +
                    " VALUES ('admin', '123456', 'admin@hotel.by', 1), ('petrov1985', '111111', " +
                    "'petrov1985@tut.by', 2);");
            statement.executeUpdate("INSERT INTO reservations(checkIn, chekOut, fk_type, fk_user) " +
                    "VALUES ('2016-07-24 00:00:00', '2016-07-26 00:00:00', '2', '2');");
            statement.executeUpdate("INSERT INTO rooms (type, price, isAvaliable) VALUES ('single', 50, 'yes'), " +
                    "('double', 70, 'yes'), ('twin', 75, 'yes');");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
