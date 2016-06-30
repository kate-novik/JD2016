package by.it.drachyova.jd02_09.TaskB;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "rooms", propOrder = {
        "room"
})

public class Rooms {

    @XmlElement(required = true)
    private ArrayList<Room> room = new ArrayList<Room>();

    //конструктор без параметров
    public Rooms() {
    }

    public Rooms(ArrayList<Room> room) {
        this.room = room;
    }

    //сеттер
    public void setList(ArrayList<Room> room) {
        this.room = room;
    }

    //геттер
    public ArrayList<Room> getList() {
        return room;
    }

    public boolean add(Room value) {
        return room.add(value);
    }

    @Override
    public String toString() {
        return String.valueOf(room);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }
}
