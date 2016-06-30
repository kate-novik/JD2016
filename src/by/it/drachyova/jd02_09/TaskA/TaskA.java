package by.it.drachyova.jd02_09.TaskA;
/*
Выполните по аналогии с Заданием 12 из рабочей тетради – преобразование XML в HTML файл с таблицей, в которой
каждая отдельная строка это одна из повторяющихся сущностей XML. (используйте свой XML-файл без схемы и DTD из
предыдущих заданий).
 */

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

public class TaskA {

    final static String root = "src/by/it/drachyova/jd02_09/TaskA/";

    public static void main(String[] args) {
        String fileName = root + "Hotel.xml";
        String fileHTML = root + "Hotel.html";

        try {
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer transformer = tf.newTransformer(new StreamSource(root + "Hotel_Xpath.xsl"));
            // создаем объект Transformer с помощью фабрики TransformerFactory
            transformer.transform(new StreamSource(fileName),
                    new StreamResult(fileHTML));
            System.out.println("Transform " + fileName + " complete");
        } catch (TransformerException e) {
            System.err.println("Impossible transform file " + fileName + " : " + e.getMessage());
        }
    }
}


