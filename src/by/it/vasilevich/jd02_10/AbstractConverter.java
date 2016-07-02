package by.it.vasilevich.jd02_10;


public abstract class AbstractConverter<T> {
    protected T bean;

    public AbstractConverter() {
        bean = null;
    }

    public AbstractConverter(T bean) {
        this.bean = bean;
    }

    public T getBean() {
        return bean;
    }

    abstract public void buildConverter(String filename);

    abstract public String getConverterResult();


}
