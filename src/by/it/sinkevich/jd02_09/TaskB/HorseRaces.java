package by.it.sinkevich.jd02_09.TaskB;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Class for jd02_09 taskB. Making beans to Test JAXB
 *
 * @author Sinkevich Denis
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = "horseRaces")
@XmlRootElement(name = "HorseRaces")
public class HorseRaces {

    public HorseRaces() {
    }

    public HorseRaces(List<HorseRace> horseRaces) {
        this.horseRaces = horseRaces;
    }

    @XmlElement(name = "HorseRace", required = true)
    protected List<HorseRace> horseRaces;

    public List<HorseRace> getHorseRaces() {
        return horseRaces;
    }

    public void setHorseRaces(List<HorseRace> horseRaces) {
        this.horseRaces = horseRaces;
    }
}
