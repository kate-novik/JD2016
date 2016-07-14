package by.it.sinkevich.project.java;

import by.it.sinkevich.project.java.bean.User;
import by.it.sinkevich.project.java.dao.DAO;
import by.it.sinkevich.project.java.dao.UserDAO;
import by.it.sinkevich.project.java.util.Pattern;
import by.it.sinkevich.project.java.util.Utility;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;

public class CommandRegister implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = Action.REGISTER.startPage;
        if (request.getParameter("name") == null) {
            return page;
        }
        if (Utility.isValid(request.getParameter("name"), Pattern.userNameRegex) &&
                Utility.isValid(request.getParameter("dateOfBirth"), Pattern.dateRegex) &&
                Utility.isValid(request.getParameter("email"), Pattern.emailRegex) &&
                Utility.isValid(request.getParameter("login"), Pattern.loginRegex) &&
                Utility.isValid(request.getParameter("password"), Pattern.passwordRegex)) {
            User user = new User();
            user.setId(0);
            user.setName(request.getParameter("name"));
            user.setDateOfBirth(Date.valueOf(request.getParameter("dateOfBirth")));
            user.setEmail(request.getParameter("email"));
            user.setFk_role(2);
            user.setLogin(request.getParameter("login"));
            user.setPassword(request.getParameter("password"));

            UserDAO userDAO = DAO.getDao().getUserDAO();
            if (userDAO.create(user)) {
                request.setAttribute(Action.message, request.getAttribute(Action.message).toString()
                        .concat("Пользователь создан! Можете авторизироваться на сайте!"));
                page = Action.REGISTER.okPage;
            } else {
                request.setAttribute(Action.message, request.getAttribute(Action.message).toString()
                        .concat("Пользователь не создан! Пожалуйста введите данные заново!"));
            }
        } else {
            request.setAttribute(Action.message, request.getAttribute(Action.message).toString()
                    .concat("Переданы невалидные данные! Пожалуйста введите данные заново!"));
        }
        return page;
    }
}
