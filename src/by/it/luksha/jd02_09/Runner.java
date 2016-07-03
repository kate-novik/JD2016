package by.it.luksha.jd02_09;

import by.it.luksha.jd02_09.taskAxml2html.GeneratorXML2HTML;
import by.it.luksha.jd02_09.taskB.JaxB_use;

/**
 * Created by MMauz on 30.06.2016.
 */
public class Runner {
    public static void main(String[] args) {
        String filepathXML = "src/by/it/luksha/jd02_09/taskAxml2html/CarRent.xml";
        GeneratorXML2HTML generatorXML2HTML = new GeneratorXML2HTML();
        generatorXML2HTML.convertXML2HTML(filepathXML);


        filepathXML = "src/by/it/luksha/jd02_09/taskB/CarRent-xsd.xml";
        JaxB_use jaxB_use = new JaxB_use();
        jaxB_use.create(filepathXML);
    }
}
