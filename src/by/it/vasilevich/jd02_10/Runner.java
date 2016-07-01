package by.it.vasilevich.jd02_10;


public class Runner {
    public static void main(String[] args) {
        ConverterFactory converterFactory = new ConverterFactory();
        AbstractConverter<Students> converter = converterFactory.createConverterBuilder("xml_to_json");
        converter.buildConverter("src\\by\\it\\akhmelev\\jd02_09\\generate\\xml_data.xml");
        converter.getConverterResult();
        String json = converter.getConverterResult();
        System.out.println(json);


//        AbstractConverter converter = converterFactory.createConverterBuilder("json_to_xml");
//        converter.buildConverter("src\\by\\it\\akhmelev\\jd02_09\\generate\\xml_data.json");
//        converter.getConverterResult();
//
//        System.out.println(converter.getConverterResult());

    }
}
