package by.it.akhmelev.jd02_10.Converter;

import by.it.akhmelev.jd02_09.generate.Students;

/**
 * Created by user_2 on 01.07.2016.
 */
public class Runner {
    public static void main(String[] args) {
        ConverterFactory converterFactory = new ConverterFactory();
//        AbstractConverter converter = converterFactory.createConverterBuilder("xml_to_json");
//        converter.buildConverter("src/by/it/akhmelev/jd02_09/generate/xml_data.xml");
//        String json=converter.getConverterResult();

        AbstractConverter<Students> converter = converterFactory.createConverterBuilder("json_to_xml");
        converter.buildConverter("D:\\Students\\agh\\JD2016_07_01\\src\\by\\it\\akhmelev\\jd02_09\\generate\\xml_data.json");
        converter.getConverterResult();

        System.out.println(converter.getConverterResult());
    }
}
