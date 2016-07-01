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

    @XmlElement(required = true)
    @XmlSchemaType(name = "time")
    @XmlID
    protected XMLGregorianCalendar time;
    @XmlElement(required = true)
    protected Race race;
    @XmlElement(required = true)
    protected Horse horse;
    @XmlElement(required = true)
    protected Double betSum;
    @XmlElement(required = true)
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
