package by.it.novik.jd02_10.converter;

import by.it.akhmelev.jd02_09.generate.Students;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by Kate Novik.
 */
public class ConverterXMLToJSON extends AbstractConverter {

    @Override
    public void buildConverter(String filename) {
        try {

            JAXBContext jc = JAXBContext.newInstance(Students.class);
            Unmarshaller u = jc.createUnmarshaller();
            FileReader reader = new FileReader(filename);
            System.out.println("XML-файл прочитан:");
            bean = (Students) u.unmarshal(reader);

        } catch (JAXBException e) {
            System.out.println("JAXB error" + e);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден" + e);
        }
    }

    @Override
    public String getConverterResult() {
        Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
        return gson.toJson(bean);
    }
}
