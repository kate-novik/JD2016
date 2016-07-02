package by.it.sinkevich.jd02_09.TaskB;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Class for jd02_09 taskB. Making beans to Test JAXB
 *
 * @author Sinkevich Denis
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Races", propOrder = "races")
public class Races {

    public Races() {
    }

    public Races(List<Race> races) {

        this.races = races;
    }
    @XmlElementWrapper(name = "Races")
    @XmlElement(name = "Race", required = true)
    protected List<Race> races;

    public List<Race> getRaces() {
        return races;
    }

    public void setRaces(List<Race> races) {
        this.races = races;
    }
}
