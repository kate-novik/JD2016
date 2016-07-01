package by.it.kust.jd02_09;

import by.it.akhmelev.jd02_09.generate.Students;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * Created by user_2 on 01.07.2016.
 */
public class ConveterXmlToJsonBuilder extends AbstractConverter {
    @Override
    public void buildConverter(String filename) {
        try {

            JAXBContext jc = JAXBContext.newInstance(Students.class);
            Unmarshaller u = jc.createUnmarshaller();
            FileReader reader = new FileReader(filename);
            System.out.println("XML-файл прочитан:");
            bean = (Students) u.unmarshal(reader);

        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getConverterResult() {
        Gson gson=new GsonBuilder().serializeNulls().setPrettyPrinting().create();
        return gson.toJson(bean);
    }
}
