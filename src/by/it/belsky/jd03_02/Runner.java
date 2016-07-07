package by.it.belsky.jd03_02;

import java.sql.SQLException;

/**
 * Created by misha on 06.07.2016.
 */
public class Runner {
    public static void main(String[] args) {
        User user = new User(0, " tank", "email@.ru", "pass111", 1);
        UserCRUD userCRUD = new UserCRUD();
        try {
            userCRUD.create(user);
            System.out.print("Добавлена строка в базу данных(create): " + user);
            System.out.print("Чтение строки из базы данных(read): "+ userCRUD.read(user.getID()));
           // user.setID(7);
            user.setLogin("TANKVENERA");
            user.setEmail("vasia@mail.ru");
            user.setPassword("379123victory");
            System.out.print("Чтение обновленой строки из базы (update): " + userCRUD.read(userCRUD.update(user).getID()));
        if (userCRUD.delete(user))
            System.out.println("Удалена сторка из базы данных N: "+ user.getID());

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
