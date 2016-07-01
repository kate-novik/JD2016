package by.it.akhmelev.jd02_10.Converter;

import by.it.akhmelev.jd02_09.generate.Students;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.*;

/**
 * Created by user_2 on 01.07.2016.
 */
public class ConverterJsonToXmlBuilder extends AbstractConverter {
    @Override
    public void buildConverter(String filename) {
        String json = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            String line = "";
            while ((line = reader.readLine())!=null) {
                json = json.concat(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        Gson gson = new GsonBuilder().serializeNulls().setPrettyPrinting().create();
        bean = gson.fromJson(json, Students.class);
    }

    @Override
    public String getConverterResult() {
        JAXBContext jc = null;
        String res="";
        try {
            jc = JAXBContext.newInstance(Students.class);
            Marshaller marshaller=jc.createMarshaller();
            StringWriter stringWriter=new StringWriter();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,true);
            marshaller.marshal(bean,stringWriter);
            res=stringWriter.toString();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return res;
    }
}
