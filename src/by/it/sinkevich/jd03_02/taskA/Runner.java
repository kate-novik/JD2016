package by.it.sinkevich.jd03_02.taskA;

import java.sql.Date;
import java.sql.SQLException;
import java.util.GregorianCalendar;

/**
 * Class for testing CRUD operations
 *
 * @author Sinkevich Denis
 */
class Runner {

    public static void main(String[] args) {
        User user = new User(4, "Везунчик Андрей Петрович", new Date(new GregorianCalendar(1966, 0, 8).getTimeInMillis()),
                "Luckyman@tut.by", 2, "lucky", "bestPasswordEU");
        UserCRUD userCRUD = new UserCRUD();

        try {
            user = userCRUD.create(user);
            user = userCRUD.read(user.getId());
            System.out.println(user);

            user = userCRUD.update(user);
            user = userCRUD.read(user.getId());
            System.out.println(user);

            System.out.println(userCRUD.delete(user));
        } catch (SQLException e) {
            System.err.println("Ошибка работы с БД!");
            System.err.println(e.getMessage());
        }

        System.out.println(RoleIndex.findIndexByRole("Bookmaker"));
        System.out.println(RoleIndex.findIndexByRole("Client"));
    }
}
