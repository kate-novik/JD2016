package by.it.sinkevich.project.java;

import by.it.sinkevich.project.java.bean.User;
import by.it.sinkevich.project.java.dao.DAO;
import by.it.sinkevich.project.java.dao.UserDAO;

import javax.servlet.http.HttpServletRequest;
import java.sql.Date;

public class CommandRegister implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = Action.REGISTER.startPage;

        if (request.getParameter("login") == null) {
            return page;
        }

        User user = new User();
        user.setId(0);
        user.setName(request.getParameter("name"));
        user.setDateOfBirth(Date.valueOf(request.getParameter("dateOfBirth")));
        user.setEmail(request.getParameter("email"));
        user.setFk_role(2);
        user.setLogin(request.getParameter("login"));
        user.setPassword(request.getParameter("password"));

        UserDAO userDAO = DAO.getDao().getUserDAO();
        userDAO.create(user);
        return Action.REGISTER.okPage;
    }
}
