package by.it.belsky.project.java;

import javax.servlet.http.HttpServletRequest;

public class CommandCreateform implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        //DO SOMETHING;
        //USE DAO
        //&ETC
        return Action.CREATEFORM.inPage;
    }
}