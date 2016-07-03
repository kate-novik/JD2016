package by.it.kust.jd02_09.TaskB;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by Tanya Kust on 03.07.2016.
 */
public class JAXB_from_XML {
    public static void main(String[] args) {
        try {
            JAXBContext jc = JAXBContext.newInstance(DreamTravel.class);
            Unmarshaller u = jc.createUnmarshaller();
            FileReader reader = new FileReader("src/by/it/kust/jd02_09/TaskB/DreamTravel2.xml");
            System.out.println("XML файл прочитан");
            DreamTravel dreamTravel = (DreamTravel)u.unmarshal(reader);
            System.out.println(dreamTravel);
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
