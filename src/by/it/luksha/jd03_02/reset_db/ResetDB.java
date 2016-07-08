package by.it.luksha.jd03_02.reset_db;

import by.it.luksha.jd03_02.ConnectionCreator;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by MMauz on 08.07.2016.
 */
public class ResetDB {
    /**
     * Удаляет все таблицы в БД
     *
     * @throws SQLException
     */
    public static void dropAllDB() throws SQLException {
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();
        ) {
            String dropAllDBSQL = String.format("DROP TABLE IF EXISTS orders, cars, users, roles;");
            statement.execute(dropAllDBSQL);
        } catch (SQLException e) {
            throw e;
        }
    }

    /**
     * Создает таблицы в БД
     *
     * @throws SQLException
     */
    public static void createAllDB() throws SQLException {
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();
        ) {
            //таблица cars
            statement.execute("CREATE TABLE `luksha`.`cars`(" +
                    "`ID` INT(11) NOT NULL AUTO_INCREMENT," +
                    "`Brand` VARCHAR(50) NOT NULL," +
                    "`Model` VARCHAR(50) NOT NULL," +
                    "`Category` VARCHAR(50) NOT NULL," +
                    "`Cost` INT(11) NOT NULL," +
                    "`Consumption` DOUBLE NOT NULL," +
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
        } catch (SQLException e) {
            throw e;
        }
    }

    /**
     * Заполняет данными таблицы в БД
     *
     * @throws SQLException
     */
    public static void insertAllDB() throws SQLException {
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();
        ) {
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
                    "VALUES ('Opel', 'Astra', 'economy', 25, 9.5);");
            //добавление заказов
            statement.execute("INSERT INTO orders (FK_User, FK_Car, StartRent, EndRent, TotalCost) " +
                    "VALUES (1, 1, '2016-07-01 00:00:01', '2016-07-03 00:00:01', 500);");
        } catch (SQLException e) {
            throw e;
        }
    }
}
