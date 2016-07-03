package by.it.kust.jd02_09.TaskC;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by Tanya Kust.
 */
public class JAXB_try_Generated_Classes {
    // для автомат.генерации в коммандной строке была использована комманда
    // "C:\Program Files\Java\jdk1.8.0_91\bin\xjc.exe" C:\Users\User\Desktop\Java\JD2016\src\by\it\kust\jd02_09\TaskC\DreamTravel.xsd -d C:\Users\User\Desktop\Java\JD2016\src
    public static void main(String[] args) {
        try {
            JAXBContext jc = JAXBContext.newInstance(DreamTravel.class);
            Unmarshaller u = jc.createUnmarshaller();
            FileReader reader = new FileReader("src/by/it/kust/jd02_09/taskc/DreamTravelXSD.xml");
            System.out.println("XML файл прочитан: ");
            DreamTravel dreamTravel = (DreamTravel)u.unmarshal(reader);
            System.out.println(dreamTravel);
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}
