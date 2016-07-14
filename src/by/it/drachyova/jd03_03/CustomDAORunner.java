package by.it.drachyova.jd03_03;

import by.it.drachyova.jd03_03.beans.Reservation;
import by.it.drachyova.jd03_03.beans.Role;
import by.it.drachyova.jd03_03.beans.Room;
import by.it.drachyova.jd03_03.beans.User;
import by.it.drachyova.jd03_03.custom_dao.*;

import java.sql.SQLException;
import java.util.List;

public class CustomDAORunner {
    static void showRoles() {
        System.out.println("\nРоли пользователей:");
        List<Role> roles = new RoleDAO().getAll("");
        for (Role each : roles) System.out.println(each);
    }

    static void showUsers() {
        //покажем все, что есть в таблице пользователей
        System.out.println("\nТаблица пользователей:");
        List<User> users = new UserDAO().getAll("");
        for (User each : users) System.out.println(each);
    }

    static void showReservation() {
        System.out.println("\nТаблица заявок:");
        List<Reservation> reservations = new ReservationDAO().getAll("");
        for (Reservation each : reservations) System.out.println(each);
    }

    static void showRooms() {
        System.out.println("\nТаблица номеров:");
        List<Room> rooms = new RoomDAO().getAll("");
        for (Room each : rooms) System.out.println(each);
    }

    public static void main(String[] args) throws SQLException {
        //инициализация работы с базой
        DAO dao = DAO.getDAO();
        showRoles();
        showUsers();
        User user = new User(0, "Сергей Иванович", "siivanov", "siivanov@mail.ru", 2);
        //добавим пользователя
        if (dao.user.create(user)) System.out.println("\nДобавлен:" + user);
        showUsers();

        //извлечем и обновим пользователя с email siivanov@mail.ru
        user = dao.user.getAll("WHERE ID>2").get(0);
        user.setLogin("up_siivanov");
        if (dao.user.update(user)) System.out.println("\nИзменен:" + user);
        showUsers();

        //удалим пользователя
        if (dao.user.delete(user)) System.out.println("\nУдален:" + user);
        showUsers();
        showReservation();
        showRooms();
    }
}
