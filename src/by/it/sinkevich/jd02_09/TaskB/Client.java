package by.it.sinkevich.jd02_09.TaskB;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Class for jd02_09 taskB. Making beans to Test JAXB
 *
 * @author Sinkevich Denis
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Client", propOrder = {
        "name",
        "age",
        "bets"
})
public class Client {

    public Client() {
    }

    public Client(String name, Integer age, List<Bet> bets) {
        this.name = name;
        this.age = age;
        this.bets = bets;
    }

    @XmlElement(name = "Name", required = true)
    protected String name;
    @XmlElement(name = "Age", required = true)
    protected Integer age;
    @XmlElementWrapper(name = "Bets")
    @XmlElement(name = "Bet", required = true)
    protected List<Bet> bets;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<Bet> getBets() {
        return bets;
    }

    public void setBets(List<Bet> bets) {
        this.bets = bets;
    }
}
