package by.it.novik.jd02_10.converter;

/**
 * Created by Kate Novik.
 */
public class ConverterFactory {
    private enum DirectType{
        XML_TO_JSON, JSON_TO_XML
    }

    public AbstractConverter createConverterBuilder (String type) {
        DirectType directType = DirectType.valueOf(type.toUpperCase());
        switch (directType){
            case XML_TO_JSON :
            {
                return new ConverterXMLToJSON();
            }
            case JSON_TO_XML :
            {
                return new ConverterJSONToXML();
            }
            default: throw new EnumConstantNotPresentException(directType.getDeclaringClass(),directType.name());
        }
    }
}
