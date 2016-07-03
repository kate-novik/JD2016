package by.it.luksha.jd02_09.taskB;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by MMauz on 03.07.2016.
 */
public class JaxB_use {
    public void create(String filepathXML) {
        try {
            JAXBContext jc = JAXBContext.newInstance(CarRent.class);
            Unmarshaller u = jc.createUnmarshaller();
            FileReader reader = new FileReader(filepathXML);
            System.out.println("XML-файл прочитан:");
            CarRent carRent = (CarRent) u.unmarshal(reader);
            System.out.println(carRent);

        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
