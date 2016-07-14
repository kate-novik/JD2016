package by.it.belsky.project.java;

import by.it.belsky.project.java.Beans.Form;
import by.it.belsky.project.java.custom_dao.DAO;

import javax.servlet.http.HttpServletRequest;

public class CommandCreateform implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String page = Action.CREATEFORM.inPage;
        //проверим отправлены ли данные из формы, если нет, то покажем форму
        if (request.getParameter("CarModel") == null) {
            return page;
        }

        Form form = new Form();
        form.setID(0);
        form.setFK_Users(Integer.parseInt(request.getParameter("FK_Users")));
        form.setCarModel(request.getParameter("CarModel"));
        form.setYearOfIssue(Integer.parseInt(request.getParameter("YearOfIssue")));
        form.setMileage(Integer.parseInt(request.getParameter("Mileage")));
        form.setDescriptionOfBreakage(request.getParameter("DescriptionOfBreakage"));
        form.setFK_Users(Integer.parseInt(request.getParameter("FK_Users")));


            DAO dao = new DAO();
            if (dao.form.create(form)) {
                request.setAttribute(
                        Action.msgMessage, "Форма зарегистрирована");
                page = Action.CREATEFORM.okPage;
            } else {
                request.setAttribute(
                        Action.msgMessage, "Форма не зарегистрирована. Введите данные заново. " + dao.user.lastSQL);
                page = Action.CREATEFORM.inPage;
            }

    return page;
    }


}