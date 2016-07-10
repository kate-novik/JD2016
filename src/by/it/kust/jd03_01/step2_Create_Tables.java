package by.it.kust.jd03_01;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

/**
 * Created by Tanya Kust.
 */
public class step2_Create_Tables {
    public static void main(String[] args) {
        // загружаем драйвер
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            System.out.println("драйвер зарегистрирован");
        } catch (SQLException e) {
            System.out.println("Ошибка регистрации драйвера");
        }
        // установка соединения
        try(Connection connection= DriverManager.getConnection(CN.URL_DB,CN.USER_DB,CN.PASSWORD_DB)) {
            if (!connection.isClosed()){System.out.println("соединение установлено");}
            System.out.println("Создаем таблицы roles, users, tours в БД kust...");
            // создание объекта запроса
            Statement statement = connection.createStatement();
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
