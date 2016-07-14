package by.it.kust.jd03_02.crud;

import by.it.kust.jd03_02.ConnectionCreator;
import by.it.kust.jd03_02.beans.Tour;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Tanya Kust.
 */
public class TourCrud {
    public Tour create(Tour tour) throws SQLException {
        String createTourSQL = String.format("INSERT INTO tours (ID, Country, City, Hotel, URL, " +
                        "Date, Days, Price, Type, Option1, Option2, FK_Users) " +
                "VALUES('%d','%s','%s','%s','%s','%t','%d','%d','%s','%s','%s','%d')",
                tour.getId(),tour.getCountry(),tour.getCity(),tour.getHotel(),tour.getUrl(),
                tour.getDate(),tour.getDays(),tour.getPrice(),tour.getType(),tour.getOption1(),
                tour.getOption2(),tour.getFk_Users());
        try (Connection connection = ConnectionCreator.getConnection(); // соединение с базой
             Statement statement = connection.createStatement()  // объект для обращения к базе
        ){
            int res = statement.executeUpdate(createTourSQL);
            if (res==1){   // если добавлено, узнаем последний ID
                ResultSet resultSet = statement.executeQuery("SELECT LAST_INSERT_ID();");
                // извлечем ID и установим его для текущего объекта tour
                if (resultSet.next()){
                    tour.setId(resultSet.getInt(1));
                }
            }
        } catch (SQLException e) {
            throw e;
        }
        return tour;
    }

    public Tour read(int id) throws SQLException {
        Tour tourResult = null;
        String readTourSQL = "SELECT * FROM tours WHERE ID=" + id;
        try (Connection connection = ConnectionCreator.getConnection(); // соединение с базой
             Statement statement = connection.createStatement()  // объект для обращения к базе
        ){
            final ResultSet resultSet = statement.executeQuery(readTourSQL);
            if (resultSet.next()){
                tourResult = new Tour(
                        resultSet.getInt("ID"),
                        resultSet.getString("Country"),
                        resultSet.getString("City"),
                        resultSet.getString("Hotel"),
                        resultSet.getString("URL"),
                        resultSet.getDate("Date"),
                        resultSet.getInt("Days"),
                        resultSet.getInt("Price"),
                        resultSet.getString("Type"),
                        resultSet.getString("Option1"),
                        resultSet.getString("Option2"),
                        resultSet.getInt("FK_Users")
                );
            }
        } catch (SQLException e) {
            throw e;
        }
        return tourResult;
    }

    public Tour update(Tour tour) throws SQLException {
        Tour tourResult = null;
        String updateTourSQL = String.format("UPDATE tours SET Country='%s', City='%s', Hotel='%s', URL='%s'," +
                        "Date='%t', Days='%d', Price='%d', Type='%s', Option1='%s', Option2='%s'," +
                "FK_Users='%d' WHERE tours.ID='%d'",
                tour.getCountry(),tour.getCity(),tour.getHotel(),tour.getUrl(),tour.getDate(),
                tour.getDays(),tour.getPrice(),tour.getType(),tour.getOption1(),tour.getOption2(),
                tour.getFk_Users());
        try (Connection connection = ConnectionCreator.getConnection(); // соединение с базой
             Statement statement = connection.createStatement()  // объект для обращения к базе
        ){
            int res = statement.executeUpdate(updateTourSQL);
            if (res==1){   // если добавлено
                tourResult = tour;
            }
        } catch (SQLException e) {
            throw e;
        }
        return tourResult;
    }

    public boolean delete(Tour tour) throws SQLException {
        String deleteTourSQL = String.format("DELETE FROM tours WHERE tours.ID='%d'", tour.getId());
        boolean result = false;
        try (Connection connection = ConnectionCreator.getConnection(); // соединение с базой
             Statement statement = connection.createStatement()  // объект для обращения к базе
        ){
            int res = statement.executeUpdate(deleteTourSQL);
            if (res==1){   // если удалено
                result = true;
            }
        } catch (SQLException e) {
            throw e;
        }
        return result;
    }
}
