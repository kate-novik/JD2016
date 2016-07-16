package by.it.sergeev.project.java;

import by.it.sergeev.project.java.beans.User;
import by.it.sergeev.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;

public class CommandSignUp implements ActionCommand {


    @Override
    public String execute(HttpServletRequest request) {
        String page = Action.SIGNUP.inPage;

        //проверим отправлены ли данные из формы, если нет, то покажем форму
        if (request.getParameter("Email") == null) {
            return page;
        }

        User user = new User();
        user.setId(0);
        //добавляем пользователей и администраторов, но это демо!!!
        int fkUser = Integer.parseInt(request.getParameter("FK_role"));
        user.setFk_Role(fkUser);

        user.setEmail(request.getParameter("Email"));   //почта
        user.setLogin(request.getParameter("Login"));   //логин
        user.setPassword(request.getParameter("Password"));
        user.setName(request.getParameter("Name"));
        user.setLastname(request.getParameter("LastName"));
        user.setAddress(request.getParameter("LastName"));
        user.setPassword(request.getParameter("Password"));
        //пароль. тут проблема безопасности.
        // нужно "солить" и хешировать.

        //проверим поля (добавьте паттерны самостоятельно)
        if (FormHelper.valid(user.getEmail()) &&
                FormHelper.valid(user.getLogin()) &&
                FormHelper.valid(user.getPassword())
                ) {
            DAO dao = DAO.getDAO();
            if (dao.user.create(user)) {
                request.setAttribute(
                        Action.msgMessage,
                        "Пользователь создан. Введите данные для авторизации.");
                page = Action.SIGNUP.okPage;
            } else {
                request.setAttribute(
                        Action.msgMessage,
                        "Пользователь НЕ создан. Введите данные заново. " + dao.user.lastSQL);
                page = Action.SIGNUP.inPage;
            }
        }
        return page;
    }
}