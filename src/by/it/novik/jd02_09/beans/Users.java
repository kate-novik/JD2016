package by.it.novik.jd02_09.beans;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;

/**
 * Created by Kate Novik.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Users", propOrder = {
        "User"
})
public class Users {
    @XmlElement(name="User")
    private ArrayList<User> listUser = new ArrayList<>();

    public Users() {
        super();
    }

    public ArrayList<User> getListUser() {
        return listUser;
    }

    public void setListUser(ArrayList<User> listUser) {
        this.listUser = listUser;
    }

    /**
     * Добавить User в список listUser
     * @param user Объект User
     */
    public void addUser (User user) {listUser.add(user);}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Users users = (Users) o;

        return listUser != null ? listUser.equals(users.listUser) : users.listUser == null;

    }

    @Override
    public int hashCode() {
        return listUser != null ? listUser.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Users{" +
                "listUser=" + listUser +
                '}';
    }
}
