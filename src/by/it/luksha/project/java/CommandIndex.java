package by.it.luksha.project.java;

import by.it.luksha.project.java.beans.Car;
import by.it.luksha.project.java.dao.CarDAO;
import by.it.luksha.project.java.dao.DAO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by MMauz on 17.07.2016.
 */
public class CommandIndex implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        String resultPage = Action.INDEX.inPage;

        CarDAO carDAO = DAO.getDAO().getCarDAO();
        List<Car> cars = carDAO.getAll("");
        request.setAttribute("ListCars", cars.toString());

        return resultPage;
    }
}
