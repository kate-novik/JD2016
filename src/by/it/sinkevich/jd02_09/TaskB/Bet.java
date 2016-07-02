package by.it.sinkevich.jd02_09.TaskB;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * Class for jd02_09 taskB. Making beans to Test JAXB
 *
 * @author Sinkevich Denis
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Bet", propOrder = {
        "time",
        "race",
        "horse",
        "betSum",
        "payout"
})
public class Bet {

    public Bet() {
    }

    public Bet(XMLGregorianCalendar time, Race race, Horse horse, Double betSum, Double payout) {

        this.time = time;
        this.race = race;
        this.horse = horse;
        this.betSum = betSum;
        this.payout = payout;
    }

    @XmlElement(name = "Time", required = true)
    @XmlSchemaType(name = "time")
    protected XMLGregorianCalendar time;
    @XmlElement(name = "Race", required = true)
    protected Race race;
    @XmlElement(name = "Horse", required = true)
    protected Horse horse;
    @XmlElement(name = "BetSum", required = true)
    protected Double betSum;
    @XmlElement(name = "Payout", required = true)
    protected Double payout;

    public XMLGregorianCalendar getTime() {
        return time;
    }

    public void setTime(XMLGregorianCalendar time) {
        this.time = time;
    }

    public Race getRace() {
        return race;
    }

    public void setRace(Race race) {
        this.race = race;
    }

    public Horse getHorse() {
        return horse;
    }

    public void setHorse(Horse horse) {
        this.horse = horse;
    }

    public Double getBetSum() {
        return betSum;
    }

    public void setBetSum(Double betSum) {
        this.betSum = betSum;
    }

    public Double getPayout() {
        return payout;
    }

    public void setPayout(Double payout) {
        this.payout = payout;
    }
}
