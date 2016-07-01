package by.it.kust.jd02_09;

import by.it.akhmelev.jd02_09.generate.Students;

/**
 * Created by user_2 on 01.07.2016.
 */
public abstract class AbstractConverter {
    protected Students bean;
    public AbstractConverter(){
        bean = null;
    }
    public AbstractConverter(Students bean){
        this.bean = bean;
    }
    public Students getBean(){
        return bean;
    }

    abstract public void buildConverter(String filename);
    abstract public String getConverterResult();
}
