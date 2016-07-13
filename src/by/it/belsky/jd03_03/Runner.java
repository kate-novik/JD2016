package by.it.belsky.jd03_03;


import by.it.belsky.jd03_03.Beans.Form;
import by.it.belsky.jd03_03.Beans.Role;
import by.it.belsky.jd03_03.Beans.User;
import by.it.belsky.jd03_03.custom_dao.DAO;
import by.it.belsky.jd03_03.custom_dao.FormDAO;
import by.it.belsky.jd03_03.custom_dao.UserDAO;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by misha on 12.07.2016.
 */
public class Runner {

    static void showUsers(){
        //покажем все, что есть в таблице пользователей
        System.out.println("\nТаблица пользователей:");
        List<User> users=new UserDAO().getAll("");
        for (User each:users) System.out.println(each);
    }
    static void showForm() {
        System.out.println("\nТаблица формы:");
        List<Form> forms = new FormDAO().getAll("");
        for (Form x:forms) System.out.println(x);
    }


    public static void main(String[] args) throws SQLException {
        //инициализация работы с базой
        DAO dao = DAO.getDAO();
        System.out.println("Роли пользователей");
        for (Role role: dao.role.getAll("")) {
            System.out.println(role);
        }
        showUsers();


        User user = new User(0,"Vasia", "Popkin", "popkin@mail.ru",2);
        //добавим пользователя
        if (dao.user.create(user)) System.out.println("\nДобавлен:" + user);
        showUsers();

        Form form = new Form(0, "lada", 1988, 132000, "none", 1);
        if (dao.form.create(form))
            System.out.println("\nДобавлен: "+form);
        showForm();
        //извлечем и обновим пользователя с email siivanov@mail.ru
        user = dao.user.getAll("WHERE ID>2").get(4);
        user.setEmail("VIRGINIA@mail.com");
        if (dao.user.update(user)) System.out.println("\nИзменен:" + user);
        showUsers();

        //удалим пользователя
        if (dao.user.delete(user)) System.out.println("\nУдален:" + user);
        showUsers();
    }
}
