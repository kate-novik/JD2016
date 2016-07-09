package by.it.sinkevich.jd03_02.taskC;

import by.it.sinkevich.jd03_02.taskC.entity.*;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


class DeleteScenario {

    private static List<Bet> bets = new ArrayList<>();
    private static List<User> users = new ArrayList<>();
    private static List<Race> races = new ArrayList<>();
    private static List<Role> roles = new ArrayList<>();

    private static final List<String> QUERIES;

    static {
        QUERIES = new ArrayList<>();

        QUERIES.add("DROP TABLE `sinkevich`.`bets`;");
        QUERIES.add("DROP TABLE `sinkevich`.`users`;");
        QUERIES.add("DROP TABLE `sinkevich`.`races`;");
        QUERIES.add("DROP TABLE `sinkevich`.`roles`;");
    }

    static void deleteAllTables() {
        try {
            saveBets();
            saveUsers();
            saveRaces();
            saveRoles();
            System.out.println("Данные таблиц сохранены!");
        } catch (SQLException e) {
            System.err.println("Ошибка работы с БД при сохранении данных!");
            e.printStackTrace();
        }
        try (Connection connection = Connector.getConnection();
             Statement statement = connection.createStatement()) {
            for (String QUERY : QUERIES) {
                statement.addBatch(QUERY);
            }
            statement.executeBatch();
            System.out.println("Таблицы удалены!");
        } catch (SQLException e) {
            System.err.println("Ошибка работы с БД при удалении данных!");
            e.printStackTrace();
        }
    }

    private static void saveBets() throws SQLException {
        BetCRUD betCRUD = new BetCRUD();
        bets = betCRUD.readAll();
    }

    private static void saveUsers() throws SQLException {
        UserCRUD userCRUD = new UserCRUD();
        users = userCRUD.readAll();
    }

    private static void saveRaces() throws SQLException {
        RaceCRUD raceCRUD = new RaceCRUD();
        races = raceCRUD.readAll();
    }

    private static void saveRoles() throws SQLException {
        RoleCRUD roleCRUD = new RoleCRUD();
        roles = roleCRUD.readAll();
    }

    public static List<Bet> getBets() {
        return bets;
    }

    public static List<User> getUsers() {
        return users;
    }

    public static List<Race> getRaces() {
        return races;
    }

    public static List<Role> getRoles() {
        return roles;
    }
}
