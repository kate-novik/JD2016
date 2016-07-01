package by.it.vasilevich.jd02_10;


public class ConverterFactory {
    private enum Direction {
        XML_TO_JSON, JSON_TO_XML
    }

    public AbstractConverter createConverterBuilder(String typeParser) {
        Direction direction = Direction.valueOf(typeParser.toUpperCase());
        switch (direction) {
            case XML_TO_JSON: {
                return new ConverterXmlToJson();
            }
            case JSON_TO_XML: {
                return new ConverterJsonToXml();
            }
            default:
                throw new EnumConstantNotPresentException(direction.getDeclaringClass(), direction.name());
        }
    }
}
