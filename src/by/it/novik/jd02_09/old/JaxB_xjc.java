package by.it.novik.jd02_09.old;
//тут нужно указать путь к сгенерированным классам

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class JaxB_xjc {
        public static void main(String[ ] args) {
            String sourceXML = "src/by/it/novik/jd02_09/payments-xsd.xml";
            try {

                JAXBContext jc = JAXBContext.newInstance(Rolls.class);
                Unmarshaller u = jc.createUnmarshaller();
                FileReader reader = new FileReader(sourceXML);
                System.out.println("XML-файл прочитан:");
                Rolls rolls = (Rolls) u.unmarshal(reader);
                System.out.println(rolls);

            } catch (JAXBException e) {
                System.out.println("Error JAXB" + e);
            } catch (FileNotFoundException e) {
                System.out.println("File not found" + sourceXML + e);
            }
        }
    }