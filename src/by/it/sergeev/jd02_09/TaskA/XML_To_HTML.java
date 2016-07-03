package by.it.sergeev.jd02_09.TaskA;

import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;


public class XML_To_HTML {
    public static void main(String[] args) {
        try{
            TransformerFactory factory = TransformerFactory.newInstance();
            javax.xml.transform.Transformer transformer = factory.newTransformer(new StreamSource("src/by/it/sergeev/jd02_09/TaskA/Catalog.xsl"));
            transformer.transform(new StreamSource("src/by/it/sergeev/jd02_07/Catalog.xml"), new StreamResult("src/by/it/sergeev/jd02_09/TaskA/XML_To_HTML.html"));
            System.out.println("Complete");
        } catch (TransformerException e) {
            System.out.println(e.toString());
        }
    }
}