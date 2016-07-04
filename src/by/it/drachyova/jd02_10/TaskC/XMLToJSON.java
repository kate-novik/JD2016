package by.it.drachyova.jd02_10.TaskC;


import by.it.drachyova.jd02_09.TaskB.Hotel;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;


public class XMLToJSON {
    public static void main(String[] args) {
        Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
        try {

            JAXBContext jc = JAXBContext.newInstance(Hotel.class);
            Unmarshaller u = jc.createUnmarshaller();
            FileReader reader = new FileReader("src/by/it/drachyova/JD02_09/TaskB/hotel.xml");
            System.out.println("XML-файл прочитан:");
            Hotel hotel = (Hotel) u.unmarshal(reader);
            String json = gson.toJson(hotel);
            System.out.println(json);

        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
