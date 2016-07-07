package by.it.sinkevich.jd03_01.taskB;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

/**
 * Class for jd03_01 TaskB
 *
 * @author Sinkevich Denis
 */
public class Runner {

    private static final String DB_URL = "jdbc:mysql://localhost:2016/sinkevich" +
            "?useUnicode=true&characterEncoding=UTF-8";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "";

    public static void main(String[] args) {
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
        } catch (SQLException e) {
            System.err.println("Register driver error!");
        }

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
             Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("select * from users inner join roles on users.fk_role = roles.id;");
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1) + "\t" + resultSet.getString(2) + "\t" +
                        resultSet.getString(3) + "\t" + resultSet.getString(4) + "\t" + resultSet.getString(6) + "\t" +
                        resultSet.getString(7) + "\t" + resultSet.getString(9));
            }
        } catch (SQLException e) {
            System.err.println("Ошибка работы с БД");
        }
    }
}
