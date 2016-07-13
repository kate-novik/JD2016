package by.it.sinkevich.jd03_03.bean;

import java.sql.Date;

/**
 * Class represents entity corresponding to table users in DB
 *
 * @author Sinkevich Denis
 */
public class User {

    private int id;
    private String name;
    private Date dateOfBirth;
    private String email;
    private int fk_role;
    private String login;
    private String password;

    public User() {
    }

    public User(int id, String name, Date dateOfBirth, String email, int fk_role, String login, String password) {
        this.id = id;
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.fk_role = fk_role;
        this.login = login;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getFk_role() {
        return fk_role;
    }

    public void setFk_role(int fk_role) {
        this.fk_role = fk_role;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (getId() != user.getId()) return false;
        if (getFk_role() != user.getFk_role()) return false;
        if (!getName().equals(user.getName())) return false;
        if (!getDateOfBirth().equals(user.getDateOfBirth())) return false;
        if (!getEmail().equals(user.getEmail())) return false;
        if (!getLogin().equals(user.getLogin())) return false;
        return getPassword().equals(user.getPassword());

    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getName().hashCode();
        result = 31 * result + getDateOfBirth().hashCode();
        result = 31 * result + getEmail().hashCode();
        result = 31 * result + getFk_role();
        result = 31 * result + getLogin().hashCode();
        result = 31 * result + getPassword().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", email='" + email + '\'' +
                ", fk_role=" + fk_role +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
