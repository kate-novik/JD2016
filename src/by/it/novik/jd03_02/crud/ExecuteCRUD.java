package by.it.novik.jd03_02.crud;

import by.it.novik.jd03_02.beans.User;

import java.sql.SQLException;

/**
 * Created by Kate Novik.
 */
public class ExecuteCRUD {

    public static void main(String[] args) {
        //Create object ActionsWithUsers for working with table users
        ActionsCRUD <User,Integer> actionsCRUD = new ActionsWithUsers();
        //Create object User
        User user = new User ( "Анна","Петровна","Соболь","MC267895, 19.05.2013", "г. Минск, ул. Гикало 1-2",
                "+375297785643", "anna", "234", "sobol_anna@gmail.com", '2');
        User resultUser;
        //Operation Create User
        try {
            //Insert user in table users
            resultUser = actionsCRUD.create(user);
            //Read user from table users
            actionsCRUD.read(resultUser.getIdUser()).toString();

            //Update user in table users
            //resultUser = actionsCRUD.update()

        } catch (SQLException e) {
            System.out.println("Error sql operation" + e);
        }

    }
}
