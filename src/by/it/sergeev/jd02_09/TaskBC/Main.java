package by.it.sergeev.jd02_09.TaskBC;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;

public class Main {

    private static String outputFile = "src/by/it/sergeev/jd02_09/TaskBC/product.xml";

    public static void main(String[] args) {
        System.out.println("------------------------------------------------------------------------Marshalling----------------------------------------------------------------------");
        System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------");
        marshalling();
        System.out.println("-----------------------------------------------------------------------Unmarshalling-----------------------------------------------------------------------");
        System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------");
        unmarshalling();
    }




    private static void marshalling(){
        try {
            JAXBContext context = JAXBContext.newInstance(Product.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true); // pretty prints
            Product product = new Product();

            product.setManufacturer("Apple");
            product.setName("iPhone");
            product.setModel("6s");
            product.setPrice(2200.00);
            product.setDescription("Apple iOS, экран 5.5, IPS (1080x1920), ОЗУ 2 ГБ, флэш-память 128 ГБ, камера 12 Мп, цвет розовый");

            marshaller.marshal(product, System.out);
            marshaller.marshal(product, new FileOutputStream(new File(outputFile)));


        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void unmarshalling(){
        try {
            JAXBContext context = JAXBContext.newInstance(Product.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            FileReader fileReader = new FileReader(outputFile);

            Product product = (Product) unmarshaller.unmarshal(fileReader);
            System.out.println(product);

        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}