package by.it.luksha.jd03_02;

import by.it.luksha.jd03_02.beans.Car;
import by.it.luksha.jd03_02.beans.Order;
import by.it.luksha.jd03_02.beans.User;
import by.it.luksha.jd03_02.crud.CarCRUD;
import by.it.luksha.jd03_02.crud.OrderCRUD;
import by.it.luksha.jd03_02.crud.UserCRUD;
import by.it.luksha.jd03_02.reset_db.ResetDB;
import by.it.luksha.jd03_02.taskB.TaskB;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.util.Date;
import java.util.Locale;

public class Runner {
    public static void main (String[] args) {
        Locale.setDefault(new Locale("en_EN"));
        /*
        User user = new User(0, "logintest", "emailtest", "passtest", 1);
        UserCRUD userCRUD = new UserCRUD();
        try {
            user = userCRUD.create(user);
            user = userCRUD.read(user.getId());
            System.out.println(user);
            user.setLogin("Tommy");
            user.setEmail("email@email.com");
            user = userCRUD.update(user);
            System.out.println(user);
            //удаление пользователя
            //userCRUD.delete(user);
            //System.out.println(userCRUD.delete(user));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        */

        /*
        Car car = new Car(0, "Honda", "Civic 5D", "economy", 35, 5.5);
        CarCRUD carCRUD = new CarCRUD();
        try {
            System.out.println(carCRUD.read(2));
            car = carCRUD.create(car);
            car.setBrand("ZAZ");
            car = carCRUD.update(car);
            System.out.println(car);
            carCRUD.delete(car);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        */

        /*
        OrderCRUD orderCRUD = new OrderCRUD();
        Date today = new Date();
        Timestamp timestampStart = new Timestamp(today.getTime());
        Timestamp timestampEnd = Timestamp.valueOf("2016-07-08 09:01:10");
        Order order = new Order(0, 1, 1, timestampStart, timestampEnd, 240);
        try {
            orderCRUD.create(order);
            System.out.println(order);
            System.out.println(orderCRUD.read(1));
            order.setTotalCost(777);
            orderCRUD.update(order);
            System.out.println(order);
            orderCRUD.delete(order);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        */

        //TaskB.joinRolesUsers();
        try {
            ResetDB.dropAllDB();
            ResetDB.createAllDB();
            ResetDB.insertAllDB();
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

}
