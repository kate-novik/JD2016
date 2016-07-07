package by.it.kushel.jd03_02.Crud;

public class User {
    private int ID;
    private String Login;
    private String Password;
    private String Email;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String login) {
        Login = login;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (ID != user.ID) return false;
        if (!Email.equals(user.Email)) return false;
        if (!Login.equals(user.Login)) return false;
        if (!Password.equals(user.Password)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = ID;
        result = 31 * result + Login.hashCode();
        result = 31 * result + Password.hashCode();
        result = 31 * result + Email.hashCode();

        return result;
    }

    public User() {
    }

    public User(int ID, String login, String password, String email) {
        this.ID = ID;
        this.Login = login;
        this.Password = password;
        this.Email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "ID=" + ID +
                ", Login='" + Login + '\'' +
                ", Password='" + Password + '\'' +
                ", Email='" + Email + '\'' +
                "}\n";
    }
}
