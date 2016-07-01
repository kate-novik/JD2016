package by.it.vasilevich.jd02_10;


public class Runner {
    public static void main(String[] args) {
        ConverterFactory converterFactory = new ConverterFactory();
        AbstractConverter converter = converterFactory.createConverterBuilder("xml_to_json");
        converter.buildConverter("src/by/it/akhmelev/jd02_09/generate/xml_data.xml");
        String json = converter.getConverterResult();
        System.out.println(json);

    }
}
