package by.it.kust.jd03_02;

import by.it.kust.jd03_02.beans.User;
import by.it.kust.jd03_02.crud.UserCRUD;

import java.sql.SQLException;

/**
 * Created by Tanya Kust.
 */
public class Runner {
    public static void main(String[] args) throws SQLException {
        // Task A
        User user = new User(0, "Иван Пупкин", "mylogin123", "password753", "pupkin@mail.ru",
                "Belarus, Minsk, Lenina str., 75/24", 0, 2);
        try {
            UserCRUD userCRUD = new UserCRUD();
            user = userCRUD.create(user);   // создание
            System.out.println(userCRUD.read(user.getID()));  // чтение
            user.setAddress("new address: moved to Brest...");
            user = userCRUD.update(user);  // обновление
            System.out.println(userCRUD.read(user.getID()));  // чтение
            if (userCRUD.delete(user)){   // удаление
                System.out.println("Удален пользователь №" + user.getID());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Task B
        SelectUsersWithRoles.doSelection();

        // Task C
        ResetDB.deleteAllTables();
        ResetDB.createTables();
        ResetDB.insertData();
    }
}
