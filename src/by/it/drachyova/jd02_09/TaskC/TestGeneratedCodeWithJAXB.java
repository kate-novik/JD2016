package by.it.drachyova.jd02_09.TaskC;

/*
Повторите задание B используя автоматическую генерацию кода по XSD-схеме.
 */

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class TestGeneratedCodeWithJAXB {
    public static void main(String[] args) {
        try {

            JAXBContext jc = JAXBContext.newInstance(Hotel.class);
            Unmarshaller u = jc.createUnmarshaller();
            FileReader reader = new FileReader("src/by/it/drachyova/jd02_09/TaskC/Hotel_XSD.xml");
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
