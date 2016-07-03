package by.it.sinkevich.jd02_09.TaskB;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Class for jd02_09 taskB. Making beans to Test JAXB
 *
 * @author Sinkevich Denis
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Horses", propOrder = {
        "horse"
})
public class Horses {

    public Horses() {
    }

    public Horses(List<Horse> horses) {

        this.horse = horses;
    }
    @XmlElementWrapper(name = "Horses")
    @XmlElement(name = "Horse", required = true)
    protected List<Horse> horse;

    public List<Horse> getHorses() {
        return horse;
    }
}
