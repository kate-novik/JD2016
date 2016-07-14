package by.it.sinkevich.project.java;


public enum Action {

    REGISTER {
        {
            command = new CommandRegister();
            startPage = "/register.jsp";
            okPage = "/index.jsp";
        }
    },
    INDEX {
        {
            command = new CommandIndex();
            okPage = "/index.jsp";
        }
    },
    LOGIN {
        {
            command = new CommandLogin();
            startPage = "/index.jsp";
            okPage = "/index.jsp";
        }
    },
    LOGOUT {
        {
            command = new CommandLogout();
            startPage = "/index.jsp";
            okPage = "/index.jsp";
        }
    },
    ERROR {
        {
            command = new CommandError();
            startPage = "/error.jsp";
            okPage = "/error.jsp";
        }
    },
    PLACE_BET {
        {
            command = new CommandPlaceBet();
            startPage = "/main.jsp";
            okPage = "/main.jsp";
        }
    },
    VIEW_RACES {
        {
            command = new CommandViewRaces();
            startPage = "/main.jsp";
            okPage = "/main.jsp";
        }
    };

    public String startPage;
    public String okPage;
    public ActionCommand command;
}
