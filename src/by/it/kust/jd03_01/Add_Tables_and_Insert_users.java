package by.it.kust.jd03_01;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

/**
 * Created by Tanya Kust.
 */
public class Add_Tables_and_Insert_users {
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
            statement.executeUpdate("CREATE TABLE kust.users (\n" +
                    "  `ID` int(11) NOT NULL,\n" +
                    "  `Name` varchar(100) NOT NULL COMMENT 'ФИО пользлвателя',\n" +
                    "  `Login` varchar(100) NOT NULL COMMENT 'логин',\n" +
                    "  `Password` varchar(100) NOT NULL COMMENT 'пароль',\n" +
                    "  `Email` varchar(100) NOT NULL COMMENT 'электронный адрес',\n" +
                    "  `Address` varchar(150) NOT NULL COMMENT 'почтовый адрес',\n" +
                    "  `Discount` int(3) NOT NULL COMMENT 'размер скидки',\n" +
                    "  `FK_Role` int(11) NOT NULL COMMENT 'ID роли'\n" +
                    ") ENGINE=InnoDB DEFAULT CHARSET=utf8;");
            statement.executeUpdate("CREATE TABLE kust.tours (\n" +
                    "  `ID` int(11) NOT NULL COMMENT 'ID тура',\n" +
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
                    "  `FK_Users` int(11) NOT NULL COMMENT 'ID заказавшего пользователя'\n" +
                    ") ENGINE=InnoDB DEFAULT CHARSET=utf8;\n");
            statement.executeUpdate("CREATE TABLE kust.roles (\n" +
                    "  `ID` int(11) NOT NULL DEFAULT '0' COMMENT 'ID роли пользователя',\n" +
                    "  `Role` varchar(100) NOT NULL COMMENT 'тип пользователя'\n" +
                    ") ENGINE=InnoDB DEFAULT CHARSET=utf8;");
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
