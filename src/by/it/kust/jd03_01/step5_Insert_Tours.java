package by.it.kust.jd03_01;

import com.mysql.fabric.jdbc.FabricMySQLDriver;

import java.sql.*;

/**
 * Created by Tanya Kust.
 */
public class step5_Insert_Tours {
    public static void main(String[] args) {
        // загружаем драйвер
        try {
            Driver driver = new FabricMySQLDriver();
            DriverManager.registerDriver(driver);
            System.out.println("драйвер зарегистрирован");
        } catch (SQLException e) {
            System.out.println("Ошибка регистрации драйера");
        }
        // установка соединения
        try(Connection connection= DriverManager.getConnection(CN.URL_DB,CN.USER_DB,CN.PASSWORD_DB)) {
            if (!connection.isClosed()){System.out.println("соединение установлено");}
            // создание объекта запроса
            Statement statement = connection.createStatement();
            String tours = "INSERT INTO tours (Country, City, Hotel, URL, Date, Days, Price, Type, Option1, Option2, FK_Users) VALUES\n" +
                    "('Spain', 'Barcelona', 'El Palace Hotel', 'https://www.hotelpalacebarcelona.com/en/', '2016-07-30', 10, 1500, 'Hot Tour', 'Flight', 'Medical insurance', null),\n" +
                    "('Georgia', 'Batumi', 'Sheraton Batumi Hotel', 'http://www.sheratonbatumi.com/', '2016-08-15', 14, 1800, 'Classic', 'Flight', 'Medical insurance', null),\n" +
                    "('Russia', 'Sochi', 'Hotel Russia', 'https://hotel.com', '2014-06-02', 7, 800, 'Classic', 'No Flight', 'Medical insurance', null),\n" +
                    "('Italy', 'Rome', 'Villa Resort Hotel', 'http://www.hotels.com/', '2015-09-23', 10, 1400, 'Hot Tour', 'Flight', 'Medical insurance', null);";
            int res = statement.executeUpdate(tours);
            if (res>0) System.out.println("Туры добавлены.");
            statement.close();
            connection.close();
            if (connection.isClosed()){
                System.out.println("соединение прервано");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
