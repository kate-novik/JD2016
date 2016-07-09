package by.it.sinkevich.jd03_02.taskC.entity;

import by.it.sinkevich.jd03_02.taskC.Connector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Class contains all CRUD operations for Class Race
 *
 * @author Sinkevich Denis
 */
public class RaceCRUD {

    public Race create(Race race) throws SQLException {
        boolean okCreate = false;
        try (Connection connection = Connector.getConnection();
             Statement statement = connection.createStatement()) {
            String query = String.format("INSERT INTO races (time, horse1, horse2, horse3, horse4, horse5, horse6, horse7, horse8, winner) " +
                    "values('%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s', '%s');", race.getTime(),
                    race.getHorse1(), race.getHorse2(), race.getHorse3(), race.getHorse4(), race.getHorse5(),
                    race.getHorse6(), race.getHorse7(), race.getHorse8(), race.getWinner());
            if (statement.executeUpdate(query) == 1) {
                ResultSet resultSet = statement.executeQuery("SELECT LAST_INSERT_ID();");
                if (resultSet.next()) {
                    race.setId(resultSet.getInt(1));
                    okCreate = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        if (okCreate) {
            return race;
        } else {
            return null;
        }
    }

    public Race update(Race race) throws SQLException {
        try (Connection connection = Connector.getConnection();
             Statement statement = connection.createStatement()) {
            String query = String.format("UPDATE races SET time = '%s', horse1 = '%s', horse2 = '%s', horse3 = '%s', horse4 = '%s', " +
                    "horse5 = '%s', horse6 = '%s', horse7 = '%s', horse8 = '%s', winner = '%s' WHERE id = %d;", race.getTime(),
                    race.getHorse1(), race.getHorse2(), race.getHorse3(), race.getHorse4(), race.getHorse5(),
                    race.getHorse6(), race.getHorse7(), race.getHorse8(), race.getWinner(), race.getId());
            if (statement.executeUpdate(query) == 1) {
                return race;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return null;
    }

    public Race read(int id) throws SQLException {
        Race result = null;
        try (Connection connection = Connector.getConnection();
             Statement statement = connection.createStatement()) {
            String query = String.format("SELECT * FROM races WHERE id = %d", id);
            ResultSet resultSet = statement.executeQuery(query);
            if (resultSet.next()) {
                result = new Race(id, resultSet.getTimestamp("time"), resultSet.getString("horse1"),
                        resultSet.getString("horse2"), resultSet.getString("horse3"), resultSet.getString("horse4"),
                        resultSet.getString("horse5"), resultSet.getString("horse6"), resultSet.getString("horse7"),
                        resultSet.getString("horse8"), resultSet.getString("winner"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return result;
    }

    public boolean delete(Race race) throws SQLException {
        String query = String.format("DELETE FROM races WHERE races.ID = %d", race.getId());
        try (Connection connection = Connector.getConnection();
             Statement statement = connection.createStatement()) {
            return (statement.executeUpdate(query) == 1);
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

    public List<Race> readAll() throws SQLException {
        List<Race> result = new ArrayList<>();
        try (Connection connection = Connector.getConnection();
             Statement statement = connection.createStatement()) {
            String query = "SELECT * FROM races;";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                result.add(new Race(resultSet.getInt("id"), resultSet.getTimestamp("time"), resultSet.getString("horse1"),
                        resultSet.getString("horse2"), resultSet.getString("horse3"), resultSet.getString("horse4"),
                        resultSet.getString("horse5"), resultSet.getString("horse6"), resultSet.getString("horse7"),
                        resultSet.getString("horse8"), resultSet.getString("winner")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
        return result;
    }
}
