package by.it.novik.jd02_10.converter;

import by.it.akhmelev.jd02_09.generate.Students;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.*;

/**
 * Created by Kate Novik.
 */
public class ConverterJSONToXML extends AbstractConverter {
    @Override
    public String getConverterResult() {
        StringWriter stringWriter = null;
        try {
        JAXBContext jc = JAXBContext.newInstance(Students.class);

            Marshaller marshaller = jc.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);//Перенос строк
            stringWriter = new StringWriter();
            marshaller.marshal(bean,stringWriter);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        if (stringWriter!= null){
        return stringWriter.toString();}
        return null;
    }

    @Override
    public void buildConverter(String filename) {
        String json="";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line;

            while((line=reader.readLine())!=null){
                json=json.concat(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
        bean = gson.fromJson(json,Students.class);


    }
}
