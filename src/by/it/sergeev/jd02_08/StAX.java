package by.it.sergeev.jd02_08;


import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import java.io.FileInputStream;

import static javax.xml.stream.XMLStreamConstants.*;

public class StAX {

    public static void main(String[] args) {
        String tab = "";
        String content = "";
        String name = "";
        String filename = "src/by/it/sergeev/jd02_07/Catalog.xml";
        try (FileInputStream inputStream = new FileInputStream(filename)) {
            XMLInputFactory inputFactory = XMLInputFactory.newInstance();
            XMLStreamReader reader = inputFactory.createXMLStreamReader(inputStream);
            while (reader.hasNext()) {
                int type = reader.next();
                switch (type) {
                    case START_ELEMENT: {
                        name = reader.getLocalName();
                        System.out.print(tab + "<" + name);
                        int attrCount = reader.getAttributeCount();
                        for (int i = 0; i < attrCount; i++) {
                            System.out.print(" " + reader.getAttributeLocalName(i) + "=\"");
                            System.out.print(reader.getAttributeValue(i) + "\"");
                        }
                        System.out.println(">");
                        tab = tab.concat("\t");
                        content = "";
                        break;
                    }
                    case END_ELEMENT: {
                        if (!content.isEmpty())
                            System.out.println(tab + content);
                        content = "";
                        tab = tab.substring(1);
                        System.out.println(tab + "</" + name + ">");
                        break;
                    }
                    case CHARACTERS: {
                        content = content.concat(reader.getText().trim());
                        break;
                    }

                    case END_DOCUMENT: {
                        System.out.println("End Document");
                    }
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
