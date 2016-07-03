package by.it.kust.jd02_09.TaskA;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 * Created by Tanya Kust.
 */
public class Run_XSL_Transformer {
    final static String root = "src/by/it/kust/jd02_09/TaskA/";
    public static void main(String[] args) {
        String fileName = root + "DreamTravel.xml";
        String fileHtml = root + "DreamTravel.html";
        String fileSource = root + "DreamTravel.xsl";
        TransformerFactory factory = TransformerFactory.newInstance();
        try {
            // установка используемого XSL-преобразования
            Transformer transformer = factory.newTransformer(new StreamSource(fileSource));
            // установка исходного XML-документа и конечного XML-файла
            transformer.transform(new StreamSource(fileName), new StreamResult(fileHtml));
            transformer.transform(new StreamSource(fileName), new StreamResult(System.out));
            System.out.println("Transform " + fileName + " completed.");
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }

    }
}
