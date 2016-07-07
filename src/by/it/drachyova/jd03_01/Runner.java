package by.it.drachyova.jd03_01;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

public class Runner {
    public static void main(String[] args) {
        try (java.sql.Connection connection = MyConnection.getConnection();
             Statement statement = connection.createStatement()) {
            statement.executeUpdate("DROP TABLE IF EXISTS roles ");
            statement.executeUpdate("DROP TABLE IF EXISTS users ");
            statement.executeUpdate("DROP TABLE IF EXISTS reservations ");
            statement.executeUpdate("DROP TABLE IF EXISTS rooms ");
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
            statement.executeUpdate("INSERT INTO roles (role) VALUES ('administrator'), ('user');");
            statement.executeUpdate("INSERT INTO users (login, password, email, fk_role)" +
                    " VALUES ('admin', '123456', 'admin@hotel.by', 1), ('petrov1985', '111111', " +
                    "'petrov1985@tut.by', 2);");
            statement.executeUpdate("INSERT INTO reservations(checkIn, chekOut, fk_type, fk_user) " +
                    "VALUES ('2016-07-24 00:00:00', '2016-07-26 00:00:00', '2', '2');");
            statement.executeUpdate("INSERT INTO rooms (type, price, isAvaliable) VALUES ('single', 50, 'yes'), " +
                    "('double', 70, 'yes'), ('twin', 75, 'yes');");
            ResultSet resultSet = statement.executeQuery("SELECT * FROM users INNER JOIN roles ON users.fk_role=roles.id");
            while (resultSet.next()) {
                ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
                int columnCount = resultSetMetaData.getColumnCount();
                for (int i = 1; i < columnCount + 1; i++) {
                    System.out.print(
                            resultSetMetaData.getColumnLabel(i) + " = " +
                                    resultSet.getString(i) + "\t");
                }
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
