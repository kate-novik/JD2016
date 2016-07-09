package by.it.sinkevich.jd03_02.taskC.entity;

import by.it.sinkevich.jd03_02.taskC.Connector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Class contains all CRUD operations for Class Bet
 *
 * @author Sinkevich Denis
 */
public class BetCRUD {

    public Bet create(Bet bet) throws SQLException {
        boolean okCreate = false;
        try (Connection connection = Connector.getConnection();
             Statement statement = connection.createStatement()) {
            String query = String.format("INSERT INTO bets (time, fk_race, horse, betSum, fk_user) " +
                    "values('%s', %d, '%s', '%s', %d);", bet.getTime(), bet.getFk_race(), bet.getHorse(), bet.getBetSum(), bet.getFk_user());
            if (statement.executeUpdate(query) == 1) {
                ResultSet resultSet = statement.executeQuery("SELECT LAST_INSERT_ID();");
                if (resultSet.next()) {
                    bet.setId(resultSet.getInt(1));
                    okCreate = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        if (okCreate) {
            return bet;
        } else {
            return null;
        }
    }

    public Bet update(Bet bet) throws SQLException {
        try (Connection connection = Connector.getConnection();
             Statement statement = connection.createStatement()) {
            String query = String.format("UPDATE bets SET time = '%s', fk_race = %d, horse = '%s', betSum = '%s', fk_user = %d WHERE id = %d;",
                    bet.getTime(), bet.getFk_race(), bet.getHorse(), bet.getBetSum(), bet.getFk_user(), bet.getId());
            if (statement.executeUpdate(query) == 1) {
                return bet;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return null;
    }

    public Bet read(int id) throws SQLException {
        Bet result = null;
        try (Connection connection = Connector.getConnection();
             Statement statement = connection.createStatement()) {
            String query = String.format("SELECT * FROM bets WHERE id = %d", id);
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                result = new Bet(id,
                        resultSet.getTimestamp("time"),
                        resultSet.getInt("fk_race"),
                        resultSet.getString("horse"),
                        resultSet.getDouble("betSum"),
                        resultSet.getInt("fk_user"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return result;
    }

    public boolean delete(Bet bet) throws SQLException {
        String query = String.format("DELETE FROM bets WHERE bets.ID = %d", bet.getId());
        try (Connection connection = Connector.getConnection();
             Statement statement = connection.createStatement()) {
            return (statement.executeUpdate(query) == 1);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public List<Bet> readAll() throws SQLException {
        List<Bet> result = new ArrayList<>();
        try (Connection connection = Connector.getConnection();
             Statement statement = connection.createStatement()) {
            String query = "SELECT * FROM bets";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                result.add(new Bet(resultSet.getInt("id"),
                        resultSet.getTimestamp("time"),
                        resultSet.getInt("fk_race"),
                        resultSet.getString("horse"),
                        resultSet.getDouble("betSum"),
                        resultSet.getInt("fk_user")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return result;
    }
}
