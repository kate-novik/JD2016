package by.it.drachyova.jd02_09.TaskB;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class JAXBToXML {
    public static void main(String[] args) {
        //creating Room objects
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

        try {
            // create JAXB context and initializing Marshaller
            JAXBContext context = JAXBContext.newInstance(Hotel.class);
            Marshaller marshaller = context.createMarshaller();
            //specify the location and name of xml file to be created
            File file = new File("src/by/it/drachyova/jd02_09/TaskB/hotel.xml");
            // writing to XML file
            marshaller.marshal(hotel, new FileOutputStream(file));
            System.out.println("XML-файл создан");
            // writing to console
            marshaller.marshal(hotel, System.out);
        } catch (FileNotFoundException e) {
            System.out.println("XML-файл не может быть создан: " + e);
        } catch (JAXBException e) {
            System.out.println("JAXB-контекст ошибочен " + e);
        }
    }
}
