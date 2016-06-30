package by.it.sinkevich.jd02_09.taskA;

import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 * Class for jd02_09 taskA. XSLTransformer
 *
 * @author Sinkevich Denis
 */
public class TransformerRunner {

    public static void main(String[] args) {
        String root = "src/by/it/sinkevich/jd02_09/taskA/";
        String xmlPath = root + "HorseRaceForXSD.xml";
        String xslPath = root + "HorseRaces.xsl";
        TransformerFactory factory = TransformerFactory.newInstance();
        Source source = new StreamSource(xslPath);
        try {
            Transformer transformer = factory.newTransformer(source);
            transformer.transform(new StreamSource(xmlPath), new StreamResult(root + "result.html"));
        } catch (TransformerException e) {
            System.out.println("Файл не трансформирован!");
            e.printStackTrace();
        }
    }
}
