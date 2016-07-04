package by.it.drachyova.jd02_10.TaskC;

import by.it.drachyova.jd02_09.TaskB.Hotel;


import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.*;


public class JSONToXML {
    private Class type = Hotel.class;

    public static void main(String[] args) {
        File file;
        String src = System.getProperty("user.dir") + "/src/by/it/drachyova/";
        file = new File(src + "jd02_10/TaskC/Hotel.json");
        String txtData = "";
        try (BufferedReader reader =
                     new BufferedReader(
                             new FileReader(file))) {
            String line = "";
            while ((line = reader.readLine()) != null) {
                txtData = txtData.concat(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            // create JAXB context and initializing Marshaller
            JAXBContext context = JAXBContext.newInstance(src + "jd02_10/TaskC/Hotel.json");
            Marshaller marshaller = context.createMarshaller();
            //specify the location and name of xml file to be created
            File fileXML = new File("src/by/it/drachyova/jd02_10/TaskC/hotel.xml");
            // writing to XML file
            marshaller.marshal(context, new FileOutputStream(fileXML));
            System.out.println("XML-файл создан");
            // writing to console
            marshaller.marshal(fileXML, System.out);
        } catch (FileNotFoundException e) {
            System.out.println("XML-файл не может быть создан: " + e);
        } catch (JAXBException e) {
            System.out.println("JAXB-контекст ошибочен " + e);
        }
    }
}
