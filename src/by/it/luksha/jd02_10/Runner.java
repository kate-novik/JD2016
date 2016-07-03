package by.it.luksha.jd02_10;

import by.it.luksha.jd02_09.taskB.CarRent;

import java.io.File;

public class Runner {
    public static void main(String[] args) {
        File file;
        String src=System.getProperty("user.dir")+"/src/by/it/luksha/";
        ConverterFactory converterFactory = new ConverterFactory();

        //из XML-файла в JSON-текст
        AbstractConverter<CarRent> converter =
                converterFactory.createConverterBuilder("xml_2_json",CarRent.class);
        file=new File(src+"jd02_10/CarRent-xsd.xml");
        converter.buildConverter(file);
        String json=converter.getConverterResult();
        System.out.println("\nиз XML-файла в JSON-текст\n");
        System.out.println(json);

        //из JSON-файла в XML-текст
        converter = converterFactory.createConverterBuilder("json_2_xml",CarRent.class);
        file=new File(src+"jd02_10/json_data.json");
        converter.buildConverter(file);
        String xml=converter.getConverterResult();
        System.out.println("\nиз JSON-файла в XML-текст\n");
        System.out.println(xml);

        //из JSON-текста в XML-текст
        converter = converterFactory.createConverterBuilder("json_2_xml",CarRent.class);
        converter.buildConverter(json); //берем из предыдущего вызова конвертера
        xml=converter.getConverterResult();
        System.out.println("\nиз JSON-текста в XML-текст\n");
        System.out.println(xml);
    }
}
