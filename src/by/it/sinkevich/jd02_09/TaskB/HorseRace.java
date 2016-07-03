package by.it.sinkevich.jd02_09.TaskB;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.List;

/**
 * Class for jd02_09 taskB. Making beans to Test JAXB
 *
 * @author Sinkevich Denis
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "HorseRace", propOrder = {
        "dateTime",
        "bookmaker",
        "horses",
        "races",
        "clients"
})
public class HorseRace {

    public HorseRace() {
    }

    public HorseRace(XMLGregorianCalendar dateTime, Bookmaker bookmaker, List<Horse> horses, List<Race> races, List<Client> clients) {
        this.dateTime = dateTime;
        this.bookmaker = bookmaker;
        this.horses = horses;
        this.races = races;
        this.clients = clients;
    }

    @XmlElement(name = "DateTime", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dateTime;
    @XmlElement(name = "Bookmaker", required = true)
    protected Bookmaker bookmaker;
    @XmlElementWrapper(name = "Horses")
    @XmlElement(name = "Horse", required = true)
    protected List<Horse> horses;
    @XmlElementWrapper(name = "Races")
    @XmlElement(name = "Race", required = true)
    protected List<Race> races;
    @XmlElementWrapper(name = "Clients")
    @XmlElement(name = "Client", required = true)
    protected List<Client> clients;

    public XMLGregorianCalendar getDateTime() {
        return dateTime;
    }

    public void setDateTime(XMLGregorianCalendar dateTime) {
        this.dateTime = dateTime;
    }

    public Bookmaker getBookmaker() {
        return bookmaker;
    }

    public void setBookmaker(Bookmaker bookmaker) {
        this.bookmaker = bookmaker;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public void setHorses(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Race> getRaces() {
        return races;
    }

    public void setRaces(List<Race> races) {
        this.races = races;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }
}
