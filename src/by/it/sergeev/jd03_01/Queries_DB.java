package by.it.sergeev.jd03_01;

import java.sql.SQLException;
import java.sql.Statement;

public class Queries_DB {


    public static void createTable(Statement statement) throws Exception {

        statement.executeUpdate("CREATE TABLE `searchhost_java`.`role` (\n" +
                "  `id_role` INT(11) NOT NULL AUTO_INCREMENT,\n" +
                "  `role` VARCHAR(50) NOT NULL,\n" +
                "  PRIMARY KEY (`id_role`))\n" +
                "ENGINE = InnoDB\n" +
                "DEFAULT CHARACTER SET = utf8;\n");

        statement.executeUpdate("CREATE TABLE `searchhost_java`.`user` (\n" +
                "  `id` INT(11) NOT NULL AUTO_INCREMENT,\n" +
                "  `login` VARCHAR(50) NOT NULL,\n" +
                "  `password` VARCHAR(50) NOT NULL,\n" +
                "  `name` VARCHAR(50) NULL,\n" +
                "  `email` VARCHAR(50) NULL,\n" +
                "  `id_role` INT(11) NOT NULL,\n" +
                "  PRIMARY KEY (`id`),\n" +
                "  INDEX `id_role_idx` (`id_role` ASC),\n" +
                "  CONSTRAINT `id_role`\n" +
                "    FOREIGN KEY (`id_role`)\n" +
                "    REFERENCES `searchhost_java`.`role` (`id_role`)\n" +
                "    ON DELETE CASCADE\n" +
                "    ON UPDATE CASCADE)\n" +
                "ENGINE = InnoDB\n" +
                "DEFAULT CHARACTER SET = utf8;\n");

        statement.executeUpdate("CREATE TABLE `searchhost_java`.`ad` (\n" +
                "  `id` INT(11) NOT NULL,\n" +
                "  `electronics` VARCHAR(50) NULL,\n" +
                "  `manufacturer` VARCHAR(50) NULL,\n" +
                "  `name` VARCHAR(50) NULL,\n" +
                "  `model` VARCHAR(50) NULL,\n" +
                "  `price` INT (11) NOT NULL,\n" +
                "  `description` TEXT(200) NOT NULL,\n" +
                "  PRIMARY KEY (`id_user`),\n" +
                "  INDEX `id_city_idx` (`id_city` ASC),\n" +
                "  CONSTRAINT `id_user`\n" +
                "    FOREIGN KEY (`id_user`)\n" +
                "    REFERENCES `searchhost_java`.`users` (`id`)\n" +
                "    ON DELETE CASCADE\n" +
                "    ON UPDATE CASCADE)\n" +
                "ENGINE = InnoDB\n" +
                "DEFAULT CHARACTER SET = utf8;");

    }

    public static void insertData (Statement statement) throws SQLException {

        statement.executeUpdate("insert into role (role_type) values ('administrator');");
        statement.executeUpdate("insert into role (role_type) values ('user');");
        statement.executeUpdate("insert into role (role_type) values ('guest');");

        statement.executeUpdate("insert into user (Login, Password, Name, Email, FK_Role) " +
                "values ('specmedia', 'c123456', 'Dmitry','specmedia@yandex.ru', 1);");
        statement.executeUpdate("insert into user (Login, Password, Name, Email, FK_Role) " +
                "values ('garsia', 'qwerty', 'Anna','garsia-gonza@mail.ru', 2);");
        statement.executeUpdate("insert into user (Login, Password, Name, Email, FK_Role) " +
                "values ('pacukevich', '23432', 'Ludmila','pacuk@gmail.com', 2);");

        statement.executeUpdate("into ad (electronics, manufacturer, name, model, price, description, FK_User) " +
                "values ('notebooks', 'Apple', 'Macbook Pro 15','MJLT2', 4799, '15.4\" 2880 x 1800 глянцевый, Intel Core i7 2500 МГц, 16 ГБ, 512 Гб (SSD), AMD Radeon R9 M370X, OS X, цвет корпуса серебристый', 1);");
        statement.executeUpdate("into ad ('phones', 'Samsung', 'Galaxy Note 5','128GB', 2000, 'Android, экран 5.7\" AMOLED (1440x2560), ОЗУ 4 ГБ, флэш-память 128 ГБ, камера 16 Мп, аккумулятор 3000 мАч, цвет розовый', 2)" +
                "values ('garsia', 'qwerty', 'Anna','garsia-gonza@mail.ru', 2);");
        statement.executeUpdate("into ad (electronics, manufacturer, name, model, price, description, FK_User)" +
                "values ('tablets', 'Lenovo', 'ThinkPad 10 128GB LTE','128GB', 1921, '10.1\" IPS (1920x1200), Windows 10, ОЗУ 4 ГБ, флэш-память 128 ГБ, LTE, цвет черный', 3);");




    }
}