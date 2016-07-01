package by.it.sinkevich.jd02_09.TaskB;

import javax.xml.bind.annotation.*;

/**
 * Class for jd02_09 taskB. Making beans to Test JAXB
 *
 * @author Sinkevich Denis
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Horse", propOrder = {
        "name",
        "odds"
})
public class Horse {

    @XmlElement(required = true)
    @XmlID
    protected String name;
    @XmlElement(required = true)
    protected Double odds;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getOdds() {
        return odds;
    }

    public void setOdds(double odds) {
        this.odds = odds;
    }
}
