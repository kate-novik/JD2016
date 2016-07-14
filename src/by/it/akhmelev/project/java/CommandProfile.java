package by.it.akhmelev.project.java;

import by.it.akhmelev.project.java.beans.Ad;
import by.it.akhmelev.project.java.beans.User;
import by.it.akhmelev.project.java.dao.DAO;

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
            List<Ad> ads = DAO.getDAO().ad.getAll("WHERE FK_Users='" + sessionUser.getId() + "'");
            request.setAttribute("ProfileLogin", sessionUser.getEmail());
            request.setAttribute("ProfileEmail", sessionUser.getLogin());
            request.setAttribute("ProfileAds", ads.toString());
            return Action.PROFILE.inPage;

        } catch (Exception e) {
            frm.setErrorMessage(e.toString());
        }
        return Action.LOGIN.inPage;
    }
}
