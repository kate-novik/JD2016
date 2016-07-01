package by.it.akhmelev.jd02_10.Converter;

/**
 * Created by user_2 on 01.07.2016.
 */
public class ConverterFactory {
    private enum Direction{
        XML_TO_JSON, JSON_TO_XML
    }

    public AbstractConverter createConverterBuilder(String typeParser){
        Direction direction=Direction.valueOf(typeParser.toUpperCase());
        switch (direction) {
            case XML_TO_JSON:
            {
                return new ConverterXmlToJsonBuilder();
            }
            case JSON_TO_XML:
            {
                return new ConverterJsonToXmlBuilder();
            }
            default: throw new EnumConstantNotPresentException(
                    direction.getDeclaringClass(),direction.name()
            );
        }
    }
}
