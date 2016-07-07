package by.it.luksha.jd03_02.crud;

import by.it.luksha.jd03_02.ConnectionCreator;
import by.it.luksha.jd03_02.beans.Car;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by MMauz on 07.07.2016.
 */
public class CarCRUD {

    /**
     * Создает на основе bean запись в таблицу cars
     *
     * @param car bean
     * @return bean с id из таблицы
     * @throws SQLException
     */
    public Car create(Car car) throws SQLException {
        boolean okCreate = false; //флаг успешного создания записи в таблице БД
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();
        ) {
            String createCarSQL = String.format("insert into cars (Brand, Model, Category, Cost, Consumption) values ('%s', '%s', '%s', %d, %.1f);",
                    car.getBrand(), car.getModel(), car.getCategory(), car.getCost(), car.getConsumption());
            if (statement.executeUpdate(createCarSQL) == 1) {
                ResultSet resultSet = statement.executeQuery("SELECT LAST_INSERT_ID();");
                if (resultSet.next()) {
                    car.setId(resultSet.getInt(1));
                    okCreate = true;
                }
            }
        } catch (SQLException e) {
            throw e;
        }

        if (okCreate) {
            return car;
        } else {
            return null;
        }
    }

    /**
     * Чтение записи из таблицы cars по id записи
     *
     * @param id
     * @return bean с данными из записи
     * @throws SQLException
     */
    public Car read(int id) throws SQLException {
        Car carResult = null;
        String readCarSQL = "SELECT * FROM cars where ID=" + id;
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();
        ) {
            ResultSet resultSet = statement.executeQuery(readCarSQL);
            if (resultSet.next()) {
                carResult = new Car(
                        resultSet.getInt("ID"),
                        resultSet.getString("Brand"),
                        resultSet.getString("Model"),
                        resultSet.getString("Category"),
                        resultSet.getInt("Cost"),
                        resultSet.getDouble("Consumption"));
            }
        } catch (SQLException e) {
            throw e;
        }
        return carResult;
    }

    /**
     * Редактирует запись на основе данных в bean car в таблице cars с указанным id
     *
     * @param car bean
     * @return bean car соответствующий отредактированной записи
     * @throws SQLException
     */
    public Car update(Car car) throws SQLException {
        Car carResult = null;
        String updateCarSQL = String.format(
                "UPDATE cars SET Brand = '%s', Model = '%s', Category = '%s', Cost = %d, Consumption = %.1f WHERE cars.ID = %d",
                car.getBrand(), car.getModel(), car.getCategory(), car.getCost(), car.getConsumption(), car.getId()
        );
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();
        ) {
            if (statement.executeUpdate(updateCarSQL) == 1) {
                carResult = car;
            }
        } catch (SQLException e) {
            throw e;
        }
        return carResult;
    }

    /**
     * Удаляет запись из таблицы cars по id из bean
     *
     * @param car bean
     * @return результат true/false
     * @throws SQLException
     */
    public boolean delete(Car car) throws SQLException {
        String deleteCarSQL = String.format("DELETE FROM cars WHERE cars.ID = %d", car.getId());
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();
        ) {
            return (statement.executeUpdate(deleteCarSQL) == 1);
        } catch (SQLException e) {
            throw e;
        }
    }
}
