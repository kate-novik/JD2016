package by.it.kust.jd02_09.TaskB;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.math.BigInteger;

/**
 * Created by Tanya Kust.
 */
public class JAXB_to_XML {
    public final static DreamTravel dt = new DreamTravel();
    public static void main(String[] args) {
        try {
            JAXBContext context = JAXBContext.newInstance(DreamTravel.class);
            Marshaller m = context.createMarshaller();
            {
                {   // анонимный класс
                    Customer customer = new Customer("Ivanov Petr", "mail@mail.ru", "Belarus, Minsk...",
                            BigInteger.valueOf(5));
                    Tour tour1 = new Tour("Italy", "Rome", "Hotel*4", "www.hotels.com", null,
                            BigInteger.valueOf(10), BigInteger.valueOf(1200), "Hot Tour", "Flight", "Medical insurance");
                    Tour tour2 = new Tour("Spain", "Madrid", "Sun Resort Hotel*5", "www.hotels.com", null,
                            BigInteger.valueOf(7), BigInteger.valueOf(1550), "All Inclusive", "Flight", "Medical insurance");
                    Tours tours = new Tours();
                    tours.add(tour1);
                    tours.add(tour2);
                    dt.setCustomer(customer);
                    dt.setTours(tours);
                }
            };
            m.marshal(dt,new FileOutputStream("src/by/it/kust/jd02_09/TaskB/DreamTravel2.xml"));
            System.out.println("XML файл создан");
            m.marshal(dt,System.out);
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
