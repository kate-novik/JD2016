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
        Horse horse1 = new Horse("Favorit", 2.2f);
        Horse horse2 = new Horse("Outsider", 11.5f);
        Horse horse3 = new Horse("Arrow", 5.5f);
        Horse horse4 = new Horse("Flash", 3.0f);
        List<Horse> horseList = new ArrayList<>();
        horseList.add(horse1);
        horseList.add(horse2);
        horseList.add(horse3);
        horseList.add(horse4);
        XMLGregorianCalendar time = null;
        try {
            time = DatatypeFactory.newInstance().newXMLGregorianCalendar(1986, 11, 8, 12, 30, 0, 0, 0);
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }
        List<Horse> raceList = new ArrayList<>(horseList);
        raceList.remove(1);
        Race race = new Race(time, raceList, horse1.getName());
        List<Race> races = new ArrayList<>();
        races.add(race);
        Bet bet1 = new Bet(time, race, horse1, 10., 22.);
        Bet bet2 = new Bet(time, race, horse3, 100., 550.);
        List<Bet> bets = new ArrayList<>();
        bets.add(bet1);
        bets.add(bet2);
        Bookmaker bookmaker = new Bookmaker("Sinkevich Denis", bets, 0.);
        List<Bet> client1Bets = new ArrayList<>(bets);
        Client client1 = new Client("Gambler", 21, client1Bets);
        List<Bet> client2Bets = new ArrayList<>();
        Client client2 = new Client("Observer", 91, client2Bets);
        List<Client> clients = new ArrayList<>();
        clients.add(client1);
        clients.add(client2);
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
