package by.it.kushel.jd03_02;

import by.it.akhmelev.jd03_02.crud.User;
import by.it.akhmelev.jd03_02.crud.UserCRUD;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Ex_04_CRUD {
    public static void main(String[] args) {
        User user = new User(0, "kate", "fgh678", "hg@tut.by");
        try {

            UserCRUD userCRUD = new UserCRUD();

            user=userCRUD.create(user);

            System.out.print(userCRUD.read(user.getID()));

            user.setLogin("loginUpdate");
            user=userCRUD.update(user);
            System.out.print(userCRUD.read(user.getID()));

            if (userCRUD.delete(user));
            System.out.print("Удален №"+user.getID());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
