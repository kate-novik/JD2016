package by.it.sergeev.jd02_10.Converter;

import by.it.akhmelev.jd02_09.generate.Students;

public abstract class AbstractConverter {
    protected Students bean;
    public AbstractConverter(){
        bean=null;
    }
    public AbstractConverter (Students bean)
    {
        this.bean=bean;
    }
    public Students getBean(){
        return bean;
    }
    abstract public void buildConverter(String filename);
    abstract public String getConverterResult();


}
