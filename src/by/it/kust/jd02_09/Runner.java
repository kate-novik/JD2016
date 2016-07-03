package by.it.kust.jd02_09;

/**
 * Created by user_2 on 01.07.2016.
 */
public class Runner {
    public static void main(String[] args) {
        ConverterFactory converterFactory = new ConverterFactory();
        AbstractConverter converter = converterFactory.createConverterBuilder("xml_to_json");
        converter.buildConverter("src/by/it/akhmelev/jd02_09/generate/xml_data.xml");
        String json=converter.getConverterResult();
        System.out.println(json);
    }
}
