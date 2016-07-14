package by.it.kust.jd03_02.beans;

/**
 * Created by Tanya Kust.
 */
public class User {
    private int ID;
    private String Name;
    private String Login;
    private String Password;
    private String Email;
    private String Address;
    private int Discount;
    private int FK_Role;

    public User() {
    }

    public User(int ID, String name, String login, String password, String email, String address, int discount, int FK_Role) {
        this.ID = ID;
        Name = name;
        Login = login;
        Password = password;
        Email = email;
        Address = address;
        Discount = discount;
        this.FK_Role = FK_Role;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
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

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public int getDiscount() {
        return Discount;
    }

    public void setDiscount(int discount) {
        Discount = discount;
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
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (ID != user.ID) return false;
        if (Discount != user.Discount) return false;
        if (FK_Role != user.FK_Role) return false;
        if (!Name.equals(user.Name)) return false;
        if (!Login.equals(user.Login)) return false;
        if (!Password.equals(user.Password)) return false;
        if (!Email.equals(user.Email)) return false;
        return Address.equals(user.Address);

    }

    @Override
    public int hashCode() {
        int result = ID;
        result = 31 * result + Name.hashCode();
        result = 31 * result + Login.hashCode();
        result = 31 * result + Password.hashCode();
        result = 31 * result + Email.hashCode();
        result = 31 * result + Address.hashCode();
        result = 31 * result + Discount;
        result = 31 * result + FK_Role;
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "ID=" + ID +
                ", Name='" + Name + '\'' +
                ", Login='" + Login + '\'' +
                ", Password='" + Password + '\'' +
                ", Email='" + Email + '\'' +
                ", Address='" + Address + '\'' +
                ", Discount=" + Discount +
                ", FK_Role=" + FK_Role +
                '}';
    }
}
