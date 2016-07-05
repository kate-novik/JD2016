package by.it.luksha.jd03_01;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

/**
 * Created by MMauz on 04.07.2016.
 */
public class Runner {
    public static void main(String[] args) {
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            System.err.printf("Ошибка создания драйвера БД %s\n", e);
        }

        try (Connection connection = DriverManager.getConnection(CN.URL_DB, CN.USER_DB, CN.PASSWORD_DB);
             Statement statement = connection.createStatement()) {
            //создание БД
            //statement.execute("CREATE DATABASE luksha CHARACTER SET utf8 COLLATE utf8_general_ci;");

            //создание таблиц
            //таблица cars
            statement.execute("CREATE TABLE `luksha`.`cars`(" +
                    "`ID` INT(11) NOT NULL AUTO_INCREMENT," +
                    "`Brand` VARCHAR(50) NOT NULL," +
                    "`Model` VARCHAR(50) NOT NULL," +
                    "`Category` VARCHAR(50) NOT NULL," +
                    "`Cost` INT(11) NOT NULL," +
                    "`Consumption` FLOAT(11) NOT NULL," +
                    "PRIMARY KEY (`ID`)" +
                    ") ENGINE = InnoDB CHARACTER SET utf8 COLLATE utf8_general_ci;");

            //таблица roles
            statement.execute("CREATE TABLE `luksha`.`roles` (" +
                    "`ID` INT(11) NOT NULL AUTO_INCREMENT," +
                    "`Name` VARCHAR(100) NOT NULL," +
                    "PRIMARY KEY (`ID`)" +
                    ") ENGINE=InnoDB CHARACTER SET utf8 COLLATE utf8_general_ci;");
            //таблица users
            statement.execute("CREATE TABLE `luksha`.`users` (" +
                    "`ID` INT(11) NOT NULL AUTO_INCREMENT," +
                    "`Login` VARCHAR(100) NOT NULL," +
                    "`Password` VARCHAR(100) NOT NULL," +
                    "`Email` VARCHAR(100) NOT NULL," +
                    "`FK_Role` INT(11) NOT NULL," +
                    "PRIMARY KEY (`ID`)," +
                    "FOREIGN KEY (FK_Role) REFERENCES roles(ID)" +
                    ") ENGINE=InnoDB CHARACTER SET utf8 COLLATE utf8_general_ci;");
            //таблица orders
            statement.execute("CREATE TABLE `luksha`.`orders` (" +
                    "`ID` INT(11) NOT NULL AUTO_INCREMENT," +
                    "`FK_User` INT(11) NOT NULL," +
                    "`FK_Car` INT(11) NOT NULL," +
                    "`StartRent` TIMESTAMP(6) NOT NULL," +
                    "`EndRent` TIMESTAMP(6) NOT NULL," +
                    "`TotalCost` INT(11) NOT NULL," +
                    "PRIMARY KEY (`ID`)," +
                    "FOREIGN KEY (FK_User) REFERENCES users(ID)," +
                    "FOREIGN KEY (FK_Car) REFERENCES cars(ID)" +
                    ") ENGINE=InnoDB CHARACTER SET utf8 COLLATE utf8_general_ci;");

            //добавление ролей
            statement.execute("INSERT INTO roles (Name) VALUES ('Administrator');");
            statement.execute("INSERT INTO roles (Name) VALUES ('User');");
            statement.execute("INSERT INTO roles (Name) VALUES ('Guest');");
            //добавление пользователей
            statement.execute("INSERT INTO users (Login, Password, Email, FK_Role) " +
                    "VALUES ('Administrator', 'admin123', 'admin@carrent.com', 1);");
            statement.execute("INSERT INTO users (Login, Password, Email, FK_Role) " +
                    "VALUES ('User', 'qwerty123', 'admin@google.com', 2);");
            statement.execute("INSERT INTO users (Login, Password, Email, FK_Role) " +
                    "VALUES ('CoolBoy', '12345678', 'hanson@facebook.com', 2);");
            statement.execute("INSERT INTO users (Login, Password, Email, FK_Role) " +
                    "VALUES ('CoolGirl', '87654321', 'pretty@vk.com', 2);");
            //добавление машин
            statement.execute("INSERT INTO cars (Brand, Model, Category, Cost, Consumption) " +
                    "VALUES ('BMW', '7er', 'business', 70, 12.5);");
            statement.execute("INSERT INTO cars (Brand, Model, Category, Cost, Consumption) " +
                    "VALUES ('Toyota', 'LC 200', 'off-road', 120, 15.7);");
            statement.execute("INSERT INTO cars (Brand, Model, Category, Cost, Consumption) " +
                    "VALUES ('Opel', 'Astra', 'econom', 25, 9.5);");
            //добавление заказов
            statement.execute("INSERT INTO orders (FK_User, FK_Car, StartRent, EndRent, TotalCost) " +
                    "VALUES (1, 1, '2016-07-01 00:00:01', '2016-07-03 00:00:01', 500);");

            //запросы и вывод в консоль из БД
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users;");
            while (resultSet.next()) {
                System.out.printf("Имя пользователя: %s; e-mail: %s\n", resultSet.getString("Login"), resultSet.getString("Email"));
            }

        } catch (SQLException e) {
            System.err.printf("Ошибка создания подключения БД %s\n", e);
        }
    }
}
