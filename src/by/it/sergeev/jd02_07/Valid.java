package by.it.sergeev.jd02_07;

import org.xml.sax.SAXException;
import javax.xml.XMLConstants;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class Valid {

    public static void main(String[] args) {

        String catalogSchema = "src/by/it/sergeev/jd02_07/Catalog.xsd";
        String catalogXML = "src/by/it/sergeev/jd02_07/Catalog.xml";

        validate(catalogXML, catalogSchema);
    }

    private static void validate(String xmlFilePath, String schemaFilePath){
        String xmlLang = XMLConstants.W3C_XML_SCHEMA_NS_URI;
        SchemaFactory schemaFactory = SchemaFactory.newInstance(xmlLang);
        File schemaFile = new File(schemaFilePath);

        try {
            Schema schema = schemaFactory.newSchema(schemaFile);
            Validator validator = schema.newValidator();
            Source source = new StreamSource(xmlFilePath);
            validator.validate(source);
            System.out.println("XML " + xmlFilePath + " is valid");
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}