package by.it.sinkevich.jd02_08;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * Class for jd02_08. Using DomParser
 *
 * @author Sinkevich Denis
 */
public class DOMRunner {

    public static void main(String[] args) {
        String src = System.getProperty("user.dir") + "/src/";
        String filePath = src + "by/it/sinkevich/jd02_08/HorseRaceForXSD.xml";
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(filePath);
            Element element = document.getDocumentElement();
            String xmlText = getDOMText(element);
            System.out.println(xmlText);
        } catch (ParserConfigurationException | SAXException | IOException e) {
            System.out.print("Ошибка! " + e.getMessage());
        }
    }

    private static StringBuilder stringBuilder = new StringBuilder();
    private static String tab = "";

    private static String getDOMText(Node node) {
        stringBuilder.append(tab).append("<").append(node.getNodeName());
        NamedNodeMap attributes = node.getAttributes();
        for (int i = 0; i < attributes.getLength(); i++) {
            Node attribute = attributes.item(i);
            stringBuilder.append(" ").append(attribute.getNodeName());
            stringBuilder.append("=\"").append(attribute.getNodeValue()).append("\"");
        }
        stringBuilder.append(">\n");
        tab = tab +"\t";
        NodeList children = node.getChildNodes();
        for (int i = 0; i < children.getLength(); i++) {
            if (children.item(i) instanceof Element) {
                getDOMText(children.item(i));
            } else {
                String text = children.item(i).getTextContent().trim();
                if (!text.isEmpty()) {
                    stringBuilder.append(tab).append(text).append("\n");
                }
            }
        }
        tab = tab.substring(1);
        stringBuilder.append(tab).append("</").append(node.getNodeName()).append(">\n");
        return stringBuilder.toString();
    }
}
