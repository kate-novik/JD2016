package by.it.akhmelev.jd02_10.Converter;

import by.it.akhmelev.jd02_09.generate.Students;

import java.io.File;

/**
 * Created by user_2 on 01.07.2016.
 */
public class Runner {
    public static void main(String[] args) {
        File file;
        String src=System.getProperty("user.dir")+"/src/by/it/akhmelev/";
        ConverterFactory converterFactory = new ConverterFactory();

        //из XML-файла в JSON-текст
        AbstractConverter<Students> converter =
                converterFactory.createConverterBuilder("xml_to_json",Students.class);
        file=new File(src+"jd02_09/generate/xml_data.xml");
        converter.buildConverter(file);
        String json=converter.getConverterResult();
        System.out.println("\nиз XML-файла в JSON-текст\n");
        System.out.println(json);

        //из JSON-файла в XML-текст
        converter = converterFactory.createConverterBuilder("json_to_xml",Students.class);
        file=new File(src+"jd02_09/generate/json_data.json");
        converter.buildConverter(file);
        String xml=converter.getConverterResult();
        System.out.println("\nиз JSON-файла в XML-текст\n");
        System.out.println(xml);

        //из JSON-текста в XML-текст
        converter = converterFactory.createConverterBuilder("json_to_xml",Students.class);
        converter.buildConverter(json); //берем из предыдущего вызова конвертера
        xml=converter.getConverterResult();
        System.out.println("\nиз JSON-текста в XML-текст\n");
        System.out.println(xml);

    }
}
