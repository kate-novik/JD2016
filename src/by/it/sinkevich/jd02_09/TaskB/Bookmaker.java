package by.it.sinkevich.jd02_09.TaskB;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
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

    @XmlElement(required = true)
    protected String name;
    @XmlElement(name = "Bet", required = true)
    protected List<Bet> bets;
    @XmlElement
    protected Double profit;


}
