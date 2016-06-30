package by.it.drachyova.jd02_09.TaskB;

import javax.xml.bind.annotation.*;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "room", propOrder = {
        "type",
        "area",
        "price"
})

public class Room {

    @XmlElement(required = true)
    private String type;
    @XmlElement(required = true)
    private int area;
    @XmlElement(name = "Price", required = true)
    private int price;

    //конструктор без параметров
    public Room() {
    }

    public Room(String type, int area, int price) {
        this.type = type;
        this.area = area;
        this.price = price;
    }

    //геттеры
    public String getType() {
        return type;
    }

    public int getArea() {
        return area;
    }

    public int getPrice() {
        return price;
    }

    //сеттеры
    public void setType(String type) {
        this.type = type;
    }

    public void setArea(int area) {
        this.area = area;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    //преобразование в строку
    @Override
    public String toString() {
        return "\n" + "Room type " + type + " area " + area + " m\u00B2" + " price " + price + "$";
    }
}
