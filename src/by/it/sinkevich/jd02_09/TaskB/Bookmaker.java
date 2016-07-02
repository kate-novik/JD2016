package by.it.sinkevich.jd02_09.TaskB;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Class for jd02_09 taskB. Making beans to Test JAXB
 *
 * @author Sinkevich Denis
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Bookmaker", propOrder = {
        "name",
        "bets",
        "profit"
})
public class Bookmaker {

    public Bookmaker() {
    }

    public Bookmaker(String name, List<Bet> bets, Double profit) {
        this.name = name;
        this.bets = bets;
        this.profit = profit;
    }

    @XmlElement(name = "Name", required = true)
    protected String name;
    @XmlElementWrapper(name = "Bets")
    @XmlElement(name = "Bet", required = true)
    protected List<Bet> bets;
    @XmlElement(name = "Profit", required = true)
    protected Double profit;


}
