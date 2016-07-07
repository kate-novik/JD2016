package by.it.luksha.jd03_02.crud;

import by.it.luksha.jd03_02.ConnectionCreator;
import by.it.luksha.jd03_02.beans.Order;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by MMauz on 07.07.2016.
 */
public class OrderCRUD {
    /**
     * Добавление записи в таблицу orders
     *
     * @param order
     * @return
     * @throws SQLException
     */
    public Order create(Order order) throws SQLException {
        boolean okCreate = false;
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();
        ) {
            String createOrderSQL = String.format(
                    "insert into orders (FK_User, FK_Car, StartRent, EndRent, TotalCost) values " +
                            "(%d, %d, '%s', '%s', %d);",
                    order.getFk_user(), order.getFk_car(), order.getStartRent(), order.getEndRent(), order.getTotalCost()
            );
            if (statement.executeUpdate(createOrderSQL) == 1) {
                ResultSet resultSet = statement.executeQuery("SELECT LAST_INSERT_ID();");
                if (resultSet.next()) {
                    order.setId(resultSet.getInt(1));
                    okCreate = true;
                }
            }
        } catch (SQLException e) {
            throw e;
        }

        if (okCreate) {
            return order;
        } else {
            return null;
        }
    }

    /**
     * Чтение записи из таблицы orders по id
     *
     * @param id
     * @return
     * @throws SQLException
     */
    public Order read(int id) throws SQLException {
        Order orderResult = null;
        String readOrderSQL = "SELECT * FROM orders where ID=" + id;
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();
        ) {
            ResultSet resultSet = statement.executeQuery(readOrderSQL);
            if (resultSet.next()) {
                orderResult = new Order(
                        resultSet.getInt("ID"),
                        resultSet.getInt("FK_User"),
                        resultSet.getInt("FK_Car"),
                        resultSet.getTimestamp("StartRent"),
                        resultSet.getTimestamp("EndRent"),
                        resultSet.getInt("TotalCost"));
            }
        } catch (SQLException e) {
            throw e;
        }
        return orderResult;
    }

    /**
     * Обновление записи в таблице orders
     *
     * @param order
     * @return
     * @throws SQLException
     */
    public Order update(Order order) throws SQLException {
        Order orderResult = null;
        String updateOrderSQL = String.format(
                "UPDATE orders SET FK_User = %d, FK_Car = %d, StartRent = '%s', EndRent = '%s', TotalCost = %d WHERE orders.ID = %d",
                order.getFk_user(), order.getFk_car(), order.getStartRent(), order.getEndRent(), order.getTotalCost(), order.getId()
        );
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();
        ) {
            if (statement.executeUpdate(updateOrderSQL) == 1)
                orderResult = order;
        } catch (SQLException e) {
            throw e;
        }
        return orderResult;
    }

    /**
     * Удаление записи из таблицы orders
     *
     * @param order
     * @return
     * @throws SQLException
     */
    public boolean delete(Order order) throws SQLException {
        String deleteOrderSQL = String.format("DELETE FROM orders WHERE orders.ID = %d", order.getId());
        try (
                Connection connection = ConnectionCreator.getConnection();
                Statement statement = connection.createStatement();
        ) {
            return (statement.executeUpdate(deleteOrderSQL) == 1);
        } catch (SQLException e) {
            throw e;
        }
    }
}
