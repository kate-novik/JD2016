package by.it.akhmelev.jd03_04.java;

import javax.servlet.http.HttpServletRequest;

public class CommandSignUp implements ActionCommand {
    @Override
    public String execute(HttpServletRequest request) {
        return Action.SIGNUP.inPage;
    }
}