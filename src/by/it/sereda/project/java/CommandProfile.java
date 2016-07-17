package by.it.sereda.project.java;

import by.it.sereda.project.java.beans.Rent;
import by.it.sereda.project.java.beans.User;
import by.it.sereda.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class CommandProfile implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        HttpSession httpSession = request.getSession(true);
        FormHelper frm = new FormHelper((request));
        try {
            //если был POST и нажали кнопку выйти из аккаунта, то сессия сбрасывается.
            if (frm.isPost() && frm.getInt("LogoutButton") == 1) {
                httpSession.invalidate();
                return Action.PROFILE.okPage;
            }

            //получим пользователя, его данные и его объявления
            User sessionUser = (User) httpSession.getAttribute("user");
            List<Rent> rents = DAO.getDAO().rent.getAll("WHERE FK_Users='" + sessionUser.getId() + "'");
            request.setAttribute("ProfileLogin", sessionUser.getEmail());
            request.setAttribute("ProfileEmail", sessionUser.getLogin());
            request.setAttribute("ProfileAds", rents.toString());
            return Action.PROFILE.inPage;

        } catch (Exception e) {
            frm.setErrorMessage(e.toString());
        }
        return Action.LOGIN.inPage;
    }
}
