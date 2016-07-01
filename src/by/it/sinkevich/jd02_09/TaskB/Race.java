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
@XmlType(name = "Race", propOrder = {
        "time",
        "horses",
        "winner"
})
public class Race {

    @XmlElement(required = true)
    @XmlSchemaType(name = "time")
    @XmlID
    protected XMLGregorianCalendar time;
    @XmlElement(name = "Horse", required = true)
    protected List<Horse> horses;
    @XmlElement(required = true)
    protected String winner;

    public XMLGregorianCalendar getTime() {
        return time;
    }

    public void setTime(XMLGregorianCalendar time) {
        this.time = time;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public void setHorses(List<Horse> horses) {
        this.horses = horses;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }
}
