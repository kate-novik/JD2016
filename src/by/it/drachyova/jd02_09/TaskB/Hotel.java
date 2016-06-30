package by.it.drachyova.jd02_09.TaskB;


import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Hotel", propOrder = {
        "name",
        "stars",
        "address",
        "rooms"
})

public class Hotel {

    @XmlElement(required = true)
    private String name;
    @XmlElement(required = true)
    private int stars;
    @XmlElement(required = true)
    private String address;
    @XmlElement(required = true)
    private Rooms rooms = new Rooms();

    //конструктор без параметров
    public Hotel() {
    }

    public Hotel(String name, int stars, String address, Rooms rooms) {
        this.name = name;
        this.stars = stars;
        this.address = address;
        this.rooms = rooms;
    }

    //геттеры
    public String getName() {
        return name;
    }

    public int getStars() {
        return stars;
    }

    public String getAddress() {
        return address;
    }

    public Rooms getRooms() {
        return rooms;
    }

    //сеттеры
    public void setName(String name) {
        this.name = name;
    }

    public void setStars(int stars) {
        this.stars = stars;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setRooms(Rooms rooms) {
        this.rooms = rooms;
    }

    //преобразование в строку
    @Override
    public String toString() {
        return "Hotel \"" + name + "\"" + " " + stars + " stars " + "address: " + address + rooms;
    }

    //сравнение
    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    //хэшкод
    @Override
    public int hashCode() {
        return super.hashCode();
    }
}






