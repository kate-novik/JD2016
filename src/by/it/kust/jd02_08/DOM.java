package by.it.kust.jd02_08;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/**
 * Created by Tanya Kust.
 */
public class DOM {   // создает древовидную структуру
    public static void main(String[] args) {
        String filename = "src/by/it/kust/jd02_08/04+XSD.xml";
        // создаем объект-фабрику
        DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
        try {
            // создаем объект builder
            DocumentBuilder builder = factory.newDocumentBuilder();
            File file = new File(filename);
            // разбор документа с помощью метода parse
            Document document = builder.parse(file);
            // получаем доступ к корневому элементу
            Element root = document.getDocumentElement();
            printElement(root);
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Выводит в консоль ноды xml файла
     * @param node - на вход - прочитанный из файла корневой элемент
     */
    static void printElement(Node node){
        short type = node.getNodeType();
        if (type == Node.ELEMENT_NODE) {   // если тип нода ELEMENT
            System.out.print("<" + node.getNodeName());
            NamedNodeMap attributesNodes = node.getAttributes();
            for (int a=0; a<attributesNodes.getLength(); a++){  // если есть атрибуты, повторим вызов вывода в консоль
                printElement(attributesNodes.item(a));
            }
            System.out.print(">");
            if (node.hasChildNodes()) {  // если есть потомки
                NodeList childNodes = node.getChildNodes();
                for (int i = 0; i < childNodes.getLength(); i++) {
                    printElement(childNodes.item(i));   // для каждого потомка повторим вызов вывода в консоль
                }
                System.out.print("</" + node.getNodeName() + ">");
            }
        }else if (type == Node.ATTRIBUTE_NODE){  // если тип нода ATTRIBUTE
            System.out.print(" " + node.getNodeName() + "=\"");
            System.out.print(((Attr)node).getValue() + "\"");
        }else if (type == Node.TEXT_NODE){    // если тип нода TEXT
            System.out.print(node.getNodeValue());
        }
    }

}
