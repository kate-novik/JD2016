package by.it.luksha.project.java;

import by.it.luksha.project.java.beans.User;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class CommandSignOut implements by.it.luksha.project.java.ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String resultPage;
        HttpSession session = request.getSession(true);
        User user;

        /**
         * Если сессии нет (пользователь не залогинен), то переход на страницу авторизации
         */
        if (session == null && request.getParameter("LogoutButton") != null) {
            request.setAttribute(Action.msgMessage, "Сначало нужно войти");
            return Action.SIGNOUT.okPage;
        } else {
            user = (User) session.getAttribute("user");
        }

        try {
            /**
             * Если нажата кнопка Выйти, то сессия пользователя завершается,
             * иначе пользователь получает страницу со своими данными
             */
            if (request.getParameter("LogoutButton") != null) {
                request.setAttribute(Action.msgMessage, "Пользователь, " + user.getLogin() + ", возвращайся!");
                session.invalidate();
                resultPage = Action.SIGNOUT.okPage;
            } else {
                request.setAttribute("ProfileLogin", user.getLogin());
                request.setAttribute("ProfileEmail", user.getEmail());

                /**
                 * Заполнение данными из cookie
                 */
                String data = "";
                Cookie[] userCookies = request.getCookies();
                for (int i = 0; i < userCookies.length; i++) {
                    data += String.format("%s: %s\n", userCookies[i].getName(), userCookies[i].getValue());
                }
                request.setAttribute("DataCookies", data);

                resultPage = Action.SIGNOUT.inPage;
            }
        } catch (Exception e) {
            request.setAttribute(Action.msgMessage, "Ошибка выхода: " + e.toString());
            resultPage = Action.SIGNOUT.inPage;
        }

        return resultPage;
    }
}
