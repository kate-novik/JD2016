package by.it.vasilevich.jd03_03.beans;


public class User {

    private int ID;
    private String Login;
    private String Password;
    private String Email;
    private int FK_Role;

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

    public int getFK_Role() {
        return FK_Role;
    }

    public void setFK_Role(int FK_Role) {
        this.FK_Role = FK_Role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        return FK_Role == user.FK_Role && ID == user.ID && Email.equals(user.Email) && Login.equals(user.Login) && Password.equals(user.Password);

    }

    @Override
    public int hashCode() {
        int result = ID;
        result = 31 * result + Login.hashCode();
        result = 31 * result + Password.hashCode();
        result = 31 * result + Email.hashCode();
        result = 31 * result + FK_Role;
        return result;
    }

    public User() {
    }

    public User(int ID, String login, String password, String email, int FK_Role) {
        this.ID = ID;
        Login = login;
        Password = password;
        Email = email;
        this.FK_Role = FK_Role;
    }

    @Override
    public String toString() {
        return "User{" +
                "ID=" + ID +
                ", Login='" + Login + '\'' +
                ", Password='" + Password + '\'' +
                ", Email='" + Email + '\'' +
                ", FK_Role=" + FK_Role +
                "}\n";
    }
}

