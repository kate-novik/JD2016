package by.it.drachyova.jd03_03;

import by.it.drachyova.jd03_03.beans.User;
import by.it.drachyova.jd03_03.generics_dao.UniversalDAO;

import java.sql.SQLException;

public class GenericsDAORunner {
    public static void main(String[] args) {
        UniversalDAO<User> userUniversalDAO = new UniversalDAO<>(new User(), "users");
        User user = new User(0, "ТестовыйЛогин", "ТестовыйПароль", "Тестовый Email", 1);

        try {
            userUniversalDAO.create(user);
            System.out.println("Создан: " + user);
            userUniversalDAO.update(user);
            user.setEmail("Новый Email");
            System.out.println("Обновлен: " + user);

            if (userUniversalDAO.delete(user))
                System.out.println("Удален: " + user);

            System.out.println("\nСписок всех записей:");
            for (User current : userUniversalDAO.getAll("")) {
                System.out.println(current);
            }
        } catch (SQLException e) {
            e.getMessage();
        }
    }
}
