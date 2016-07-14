package by.it.novik.project.java;

import by.it.novik.project.java.beans.Account;
import by.it.novik.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Kate Novik.
 */
public class CommandGetAccounts implements ActionCommand{
    @Override
    public String execute(HttpServletRequest request) {
        String page = Action.ACCOUNTS.inPage;
        String reference = request.getParameter("reference");
        if (reference == null) {
            return page;
        }
        //Получаем объект DAO
        DAO dao = DAO.getDAO();
        Account account = new Account(0,0,"Working",2);
        if (dao.getAccountDAO().create(account)) {
            request.setAttribute(Action.msgMessage, "Account № " + account.getIdAccount() +" was created.");
            page = Action.ACCOUNTS.okPage;
        }
        else {
            request.setAttribute(Action.msgMessage, "Account wasn't created.");
            page = Action.ACCOUNTS.inPage;
        }

        return page;
    }
}
