package by.it.sinkevich.jd02_09.TaskB;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Runner for jd02_09 taskB. Making beans to Test JAXB
 *
 * @author Sinkevich Denis
 */
public class Runner {

    private static HorseRaces horseRaces;

    static {
        Horse horse1 = new Horse("Favorit", 2.2);
        Horse horse2 = new Horse("Outsider", 11.5);
        List<Horse> horseList = new ArrayList<>();
        horseList.add(horse1);
        horseList.add(horse2);
        XMLGregorianCalendar time = null;
        try {
            time = DatatypeFactory.newInstance().newXMLGregorianCalendar(1986, 11, 8, 12, 30, 0, 0, 1);
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }
        Race race = new Race(time, horseList, horse1.getName());
        List<Race> races = new ArrayList<>();
        races.add(race);
        Bet bet = new Bet(time, race, horse1, 10., 22.);
        List<Bet> bets = new ArrayList<>();
        bets.add(bet);
        Bookmaker bookmaker = new Bookmaker("Sinkevich Denis", bets, 0.);
        Client client = new Client("Gambler", 21, bets);
        List<Client> clients = new ArrayList<>();
        clients.add(client);
        HorseRace horseRace = new HorseRace(time, bookmaker, horseList, races, clients);
        List<HorseRace> list = new ArrayList<>();
        list.add(horseRace);
        horseRaces = new HorseRaces(list);
    }

    public static void main(String[] args) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(HorseRaces.class);
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            marshaller.marshal(horseRaces, new FileOutputStream("D:\\ITAcademy\\JavaDeveloper\\JD2016_28_06\\" +
                    "src\\by\\it\\sinkevich\\jd02_09\\TaskB\\TestResult.xml"));
            marshaller.marshal(horseRaces, System.out);
        } catch (JAXBException e) {
            System.err.println("Ошибка в JAXB!");
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            System.err.println("Ошибка при работе с файлом!");
            e.printStackTrace();
        }
    }
}
