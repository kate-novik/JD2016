package by.it.akhmelev.project.java;

import by.it.akhmelev.project.java.beans.Role;
import by.it.akhmelev.project.java.beans.User;
import by.it.akhmelev.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

public class CommandAllUsers implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        HttpSession httpSession = request.getSession(true);
        FormHelper frm = new FormHelper(request);
        DAO dao = DAO.getDAO();


        //покажем всех пользователей, без проверки прав
        List<User> users = dao.user.getAll("");
        request.setAttribute("users", users);
        //передадим список их ролей
        List<Role> roles = dao.role.getAll("");
        request.setAttribute("roles", roles);

        if (1<2)
            return Action.ALLUSERS.inPage;

        if (frm.isPost()) {
            //получим пользователя
            User user = (User) request.getSession(true).getAttribute("user");
            //проверим является ли пользователь администратором
            //Role role = (Role) DAO.getDAO().role.getAll("WHERE ID=" + user.getFk_Role());
            Role role = null;
            for (Role r: roles) {
                if (r.getId()==user.getFk_Role())
                    role=r;
            }
            if (role == null || role.getRole().equals("user")) {
                frm.setErrorMessage(
                        String.format(
                                "Операция для пользователя %s невозможна. Недостаточно прав.",
                                user.getLogin())
                );
            }
            else //иначе операция возможна. Определим, это обновление или удаление.
            {
                frm.setMessage("Update "+user);
            }
        }
        return Action.ALLUSERS.inPage;
    }
}