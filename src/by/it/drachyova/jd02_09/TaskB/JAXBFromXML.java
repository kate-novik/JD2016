package by.it.drachyova.jd02_09.TaskB;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class JAXBFromXML {
    public static void main(String[] args) {
        try {

            JAXBContext jc = JAXBContext.newInstance(Hotel.class);
            Unmarshaller u = jc.createUnmarshaller();
            FileReader reader = new FileReader("src/by/it/drachyova/JD02_09/TaskB/hotel.xml");
            System.out.println("XML-файл прочитан:");
            Hotel hotel = (Hotel) u.unmarshal(reader);
            System.out.println(hotel);

        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
