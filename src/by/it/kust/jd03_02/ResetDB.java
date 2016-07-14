package by.it.kust.jd03_02;

import java.sql.*;

/**
 * Created by Tanya Kust.
 */
public class ResetDB {
    public static void deleteAllTables() throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection(); // соединение с базой
             Statement statement = connection.createStatement();  // объект для обращения к базе
        ) {
            System.out.println("Удаляем все таблицы...");
            statement.executeUpdate("DROP TABLE IF EXISTS tours");
            statement.executeUpdate("DROP TABLE IF EXISTS users");
            statement.executeUpdate("DROP TABLE IF EXISTS roles");
        } catch (SQLException e){
            throw e;
        }
    }

    public static void createTables() throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection(); // соединение с базой
             Statement statement = connection.createStatement();  // объект для обращения к базе
        ) {
            System.out.println("Создаем таблицы roles, users, tours в БД kust...");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS kust.roles (\n" +
                    "  `ID` int(11) NOT NULL COMMENT 'ID роли пользователя',\n" +
                    "  `Role` varchar(100) COMMENT 'тип пользователя',\n" +
                    "PRIMARY KEY(`ID`)\n" +
                    ") ENGINE=InnoDB DEFAULT CHARSET=utf8;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS kust.users (\n" +
                    "  `ID` int(11) NOT NULL AUTO_INCREMENT,\n" +
                    "  `Name` varchar(100) NOT NULL COMMENT 'ФИО пользователя',\n" +
                    "  `Login` varchar(100) NOT NULL COMMENT 'логин',\n" +
                    "  `Password` varchar(100) NOT NULL COMMENT 'пароль',\n" +
                    "  `Email` varchar(100) NOT NULL COMMENT 'электронный адрес',\n" +
                    "  `Address` varchar(150) NOT NULL COMMENT 'почтовый адрес',\n" +
                    "  `Discount` int(3) NOT NULL COMMENT 'размер скидки',\n" +
                    "  `FK_Role` int(11)  NOT NULL COMMENT 'ID роли',\n" +
                    "PRIMARY KEY(`ID`),\n" +
                    "FOREIGN KEY (FK_Role) REFERENCES roles(ID)\n" +
                    ") ENGINE=InnoDB DEFAULT CHARSET=utf8;");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS kust.tours (\n" +
                    "  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID тура',\n" +
                    "  `Country` varchar(100) NOT NULL COMMENT 'страна',\n" +
                    "  `City` varchar(100) NOT NULL COMMENT 'город',\n" +
                    "  `Hotel` varchar(100) NOT NULL COMMENT 'гостиница',\n" +
                    "  `URL` varchar(200) NOT NULL COMMENT 'сайт гостиницы',\n" +
                    "  `Date` date NOT NULL COMMENT 'дата вылета',\n" +
                    "  `Days` int(10) NOT NULL COMMENT 'продолжительность тура',\n" +
                    "  `Price` int(10) NOT NULL COMMENT 'цена',\n" +
                    "  `Type` varchar(50) NOT NULL COMMENT 'тип тура',\n" +
                    "  `Option1` varchar(200) NOT NULL COMMENT 'дополнительная опция1',\n" +
                    "  `Option2` varchar(200) NOT NULL COMMENT 'дополнительная опция2',\n" +
                    "  `FK_Users` int(11) NULL DEFAULT NULL COMMENT 'ID заказавшего пользователя',\n" +
                    "PRIMARY KEY(`ID`),\n" +
                    "FOREIGN KEY (FK_Users) REFERENCES users(ID)\n" +
                    ") ENGINE=InnoDB DEFAULT CHARSET=utf8;\n");
        } catch (SQLException e){
            throw e;
        }
    }

    public static void insertData() throws SQLException {
        try (Connection connection = ConnectionCreator.getConnection(); // соединение с базой
             Statement statement = connection.createStatement();  // объект для обращения к базе
        ) {
            // добавим роли
            String roles = "INSERT INTO roles (ID, Role) VALUES\n" +
                    "(1, 'admin'),\n" +
                    "(2, 'user');";
            int res1 = statement.executeUpdate(roles);
            if (res1>0) System.out.println("Роли добавлены.");

            // добавим пользователей
            String users = "INSERT INTO users (Name, Login, Password, Email, Address, Discount, FK_Role) VALUES\n" +
                    "('Admin Adminov', 'a.adminov', 'hgkgdfxy', 'a.adminov@mail.ru', 'Belarus, Minsk, Pushkin str.,37/11', 0, 1),\n" +
                    "('Petrov Petr', 'p.petrov', 'jghjgrfgf', 'petrov@mail.ru', 'Belarus, Gomel, Gorkogo str.,5/68', 0,2),\n" +
                    "('Sidorova Olga', 's.olga', 'fgh5fghf', 'olga@mail.ru', 'Belarus, Brest, Masherov str.,28/157', 5,2),\n" +
                    "('Иванова Людмила', 'l.ivanova', 'hgkgdfxy', 'ivanov@mail.ru', 'Belarus, Minsk, Pushkin str.,37/11', 3,2);";
            int res2 = statement.executeUpdate(users);
            if (res2>0) System.out.println(res2 + " пользователя(ей) добавлено в таблицу users");

            // добавим туры
            String tours = "INSERT INTO tours (Country, City, Hotel, URL, Date, Days, Price, Type, Option1, Option2, FK_Users) VALUES\n" +
                    "('Spain', 'Barcelona', 'El Palace Hotel', 'https://www.hotelpalacebarcelona.com/en/', '2016-07-30', 10, 1500, 'Hot Tour', 'Flight', 'Medical insurance', null),\n" +
                    "('Georgia', 'Batumi', 'Sheraton Batumi Hotel', 'http://www.sheratonbatumi.com/', '2016-08-15', 14, 1800, 'Classic', 'Flight', 'Medical insurance', null),\n" +
                    "('Russia', 'Sochi', 'Hotel Russia', 'https://hotel.com', '2014-06-02', 7, 800, 'Classic', 'No Flight', 'Medical insurance', null),\n" +
                    "('Italy', 'Rome', 'Villa Resort Hotel', 'http://www.hotels.com/', '2015-09-23', 10, 1400, 'Hot Tour', 'Flight', 'Medical insurance', null);";
            int res3 = statement.executeUpdate(tours);
            if (res3>0) System.out.println("Туры добавлены.");
        } catch (SQLException e){
            throw e;
        }
    }
}
