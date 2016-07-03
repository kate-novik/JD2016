package by.it.kust.jd02_08;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.helpers.DefaultHandler;
import java.io.IOException;

/**
 * Created by Tanya Kust.
 */
public class SAX extends DefaultHandler{
    public static void main(String[] args) {
        String filename = "src/by/it/kust/jd02_08/04+XSD.xml";
        // создадим фабрику и парсер
        SAXParserFactory factory = SAXParserFactory.newInstance();
        try {
            SAXParser parser = factory.newSAXParser();
            // создадим собственный вариант SAX-класса
            SAX sax = new SAX();
            // запускаем парсер
           parser.parse(filename, sax);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // реализация методов DefaultHandler
    private String tab = "";
    private String value;
    @Override
    public void startDocument() throws SAXException {
        System.out.println("Start parsing");
    }

    @Override
    public void endDocument() throws SAXException {
        System.out.println("End parsing");
    }

    @Override  // начало тега и атрибуты в цикле
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        System.out.print(tab + "<" + qName);
        for (int i=0; i<attributes.getLength(); i++){
            String name = attributes.getLocalName(i);
            String value = attributes.getValue(i);
            System.out.print(" " + name + "=\"" + value + "\"");
        }
        System.out.println(">");
        tab = tab + "\t";   // добавим табулятор
        value = "";
    }

    @Override    // конец тега
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (!value.isEmpty()){
            System.out.println(tab + value);
        }
        value = "";
        tab = tab.substring(1);     // уберем один табулятор
        System.out.println(tab + "</" + qName + ">");
    }

    @Override   // собираем из кусочков value. Обрывы будут на символах ' " &
    public void characters(char[] ch, int start, int length) throws SAXException {
        value = value.concat(new String(ch,start,length).trim());
    }
}
