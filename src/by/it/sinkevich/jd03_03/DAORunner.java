package by.it.sinkevich.jd03_03;

import by.it.sinkevich.jd03_03.bean.Bet;
import by.it.sinkevich.jd03_03.bean.Race;
import by.it.sinkevich.jd03_03.bean.Role;
import by.it.sinkevich.jd03_03.bean.User;
import by.it.sinkevich.jd03_03.dao.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.List;

/**
 * Checks all CRUD operations of DAO
 *
 * @author Sinkevich Denis
 */
public class DAORunner {

    public static void main(String[] args) {
        DAO dao = DAO.getDao();

        RaceDAO raceDAO= dao.getRaceDAO();
        Race race = new Race(11, Timestamp.valueOf("1986-11-08 00:00:00"), "1", "2", "3", "4", "5", "6", "7", "8", "Победа!");
        System.out.println("Создание: " + raceDAO.create(race));
        List<Race> races = raceDAO.readAll("");
        race = races.get(races.size() - 1);
        System.out.println("Чтение: " + raceDAO.read(race.getId()));
        race.setHorse1("Первый");
        System.out.println("Изменение: " + raceDAO.update(race));
        System.out.println("Чтение: " + raceDAO.read(race.getId()));
        System.out.println("Удаление: " + raceDAO.delete(race));

        RoleDAO roleDAO = dao.getRoleDAO();
        Role role = new Role(1, "Модератор");
        System.out.println("Создание: " + roleDAO.create(role));
        List<Role> roles = roleDAO.readAll("");
        role = roles.get(roles.size() - 1);
        System.out.println("Чтение: " + roleDAO.read(role.getId()));
        role.setName("Читер");
        System.out.println("Изменение: " + roleDAO.update(role));
        System.out.println("Чтение: " + roleDAO.read(role.getId()));
        System.out.println("Удаление: " + roleDAO.delete(role));

        UserDAO userDAO = dao.getUserDAO();
        User user = new User(100, "vova", Date.valueOf("1555-01-22"), "fdsf@mail", 2, "hehe", "haha");
        System.out.println("Создание: " + userDAO.create(user));
        List<User> users = userDAO.readAll("");
        user = users.get(users.size() - 1);
        System.out.println("Чтение: " + userDAO.read(user.getId()));
        user.setName("Владимир");
        System.out.println("Изменение: " + userDAO.update(user));
        System.out.println("Чтение: " + userDAO.read(user.getId()));
        System.out.println("Удаление: " + userDAO.delete(user));

        BetDAO betDAO = dao.getBetDAO();
        Bet bet = new Bet(2, Timestamp.valueOf("1986-11-08 00:00:00"), 1, "8", 66.6, 2);
        System.out.println("Создание: " + betDAO.create(bet));
        List<Bet> bets = betDAO.readAll("");
        bet = bets.get(bets.size() - 1);
        System.out.println("Чтение: " + betDAO.read(bet.getId()));
        bet.setBetSum(1000.);
        System.out.println("Изменение: " + betDAO.update(bet));
        System.out.println("Чтение: " + betDAO.read(bet.getId()));
        System.out.println("Удаление: " + betDAO.delete(bet));
    }
}
