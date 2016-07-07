package by.it.sinkevich.jd03_01.taskC;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.List;

/**
 * Main class for jd03_01 taskC
 *
 * @author Sinkevich Denis
 */
class Runner {

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
            System.out.println("Сколько секунд вам хватит на проверку того, что БД действительно создалась? ");
            long time = 10;
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
                time = Long.parseLong(reader.readLine());
            } catch (Exception e) {
                System.err.println("Ошибка ввода!");
                System.err.println(e.getMessage());
            }
            createTables(statement);
            System.out.println("База данных создана!");

            try {
                Thread.sleep(time * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            deleteTables(statement);
            System.out.println("База данных удалена!");
        } catch (SQLException e) {
            System.err.println("Ошибка работы с БД");
            System.err.println(e.getMessage());
        }
    }

    private static void createTables(Statement statement) throws SQLException {
        List<String> queries = CreateScenario.QUERIES;
        for (String query : queries) {
            statement.addBatch(query);
        }
        statement.executeBatch();
    }

    private static void deleteTables(Statement statement) throws SQLException {
        List<String> queries = DeleteScenario.QUERIES;
        for (String query : queries) {
            statement.addBatch(query);
        }
        statement.executeBatch();
    }
}
