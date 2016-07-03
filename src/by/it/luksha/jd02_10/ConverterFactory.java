package by.it.luksha.jd02_10;

public class ConverterFactory {
    private enum Direction {
        XML_2_JSON, JSON_2_XML
    }

    public AbstractConverter createConverterBuilder(String typeParser, Class beanClass) {
        Direction direction = Direction.valueOf(typeParser.toUpperCase());
        switch (direction) {
            case XML_2_JSON:
            {
                return new ConverterXML2JSONBuilder(beanClass);
            }
            case JSON_2_XML:
            {
                return new ConverterJSON2XMLBuilder(beanClass);
            }
            default: throw new EnumConstantNotPresentException(
                    direction.getDeclaringClass(), direction.name()
            );
        }
    }
}
