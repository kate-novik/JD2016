package by.it.akhmelev.jd02_10.Converter;

import java.io.*;

public abstract class AbstractConverter<T> {
    //тут данные, т.е. сам bean
    protected T bean;
    //поле класса нужен на случай, когда bean = null;
    private Class beanClass;
    //можно обойти этот недостаток, но довльно сложно:
    //https://habrahabr.ru/post/66593/

    public AbstractConverter(Class beanClass) {
        bean = null;
        this.beanClass=beanClass;
    }

    public AbstractConverter(T bean) {
        this.bean = bean;
        this.beanClass=bean.getClass();
    }

    public T getBean() {
        return bean;
    }

    public Class getBeanClass() {
        return beanClass;
    }

    //построение по данным из строки
    abstract public void buildConverter(String txtData);

    //запись результата в строку
    abstract public String getConverterResult();

    //построение по данным из файла
    //метод не абстрактный, т.к. одинаков для всех)
    public void buildConverter(File file){
        String txtData = "";
        try (BufferedReader reader =
                     new BufferedReader(
                             new FileReader(file))) {
            String line = "";
            while ((line = reader.readLine()) != null) {
                txtData = txtData.concat(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        //специализированный builder (тот что здесь абстрактный)
        buildConverter(txtData);
    };

    //запись результата в файл
    //метод не абстрактный, т.к. одинаков для всех)
    public void saveConverterResultToFile(File endFile) {
        try (BufferedWriter bufferedWriter =
                     new BufferedWriter(
                             new FileWriter(endFile))) {
            bufferedWriter.write(
                    //специализированный конвертер (тот что здесь абстрактный)
                    getConverterResult()
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
