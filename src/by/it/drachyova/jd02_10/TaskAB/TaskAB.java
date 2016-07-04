package by.it.drachyova.jd02_10.TaskAB;

import by.it.drachyova.jd02_09.TaskB.Hotel;
import by.it.drachyova.jd02_09.TaskB.Room;
import by.it.drachyova.jd02_09.TaskB.Rooms;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;


//Выполните экспорт (маршаллизацию) произвольного тестового POJO-класса в формат JSON с применением библиотеки GSON.
//Выполните импорт (демаршаллизацию) произвольного тестового класса из формата JSON в POJO с применением библиотеки GSON.

public class TaskAB {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
        Room roomClassic = new Room("Classic", 20, 400);
        Room roomDeluxe = new Room("Deluxe", 25, 489);
        Room roomSuit = new Room("Suit", 30, 733);
        Room roomRoyalSuit = new Room("Royal Suit", 40, 900);
        ArrayList<Room> room = new ArrayList<>();
        room.add(roomClassic);
        room.add(roomDeluxe);
        room.add(roomSuit);
        room.add(roomRoyalSuit);
        //creating Rooms object
        Rooms rooms = new Rooms();
        rooms.setList(room);
        //creating Hotel object
        Hotel hotel = new Hotel();
        hotel.setName("Villas Resort");
        hotel.setStars(4);
        hotel.setAddress("Localita Santa Giusta, 09040 , Castiadas, Sardegna, Italy");
        hotel.setRooms(rooms);
        String json = gson.toJson(hotel);
        System.out.print(json);
        Hotel hotel2 = gson.fromJson(json, Hotel.class);
        System.out.print("\n\nhotel2=" + hotel2.toString());

    }
}
