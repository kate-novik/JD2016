package by.it.novik.jd02_10.converter;

/**
 * Created by Kate Novik.
 */
public class RunConvertors {
    public static void main(String[] args) {
        ConverterFactory converterFactory = new ConverterFactory();
        AbstractConverter abstractConverter = converterFactory.createConverterBuilder("xml_to_json");
        abstractConverter.buildConverter("src/by/it/akhmelev/jd02_09/generate/xml_data.xml");
        String json = abstractConverter.getConverterResult();
        System.out.println(json);

        AbstractConverter abstractConverter2 = converterFactory.createConverterBuilder("json_to_xml");
        abstractConverter.buildConverter("src/by/it/akhmelev/jd02_09/generate/xml_data.xml");
        String json2 = abstractConverter.getConverterResult();
        System.out.println(json);
    }

}
