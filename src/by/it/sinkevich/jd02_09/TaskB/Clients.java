package by.it.sinkevich.jd02_09.TaskB;

import javax.xml.bind.annotation.*;
import java.util.List;

/**
 * Class for jd02_09 taskB. Making beans to Test JAXB
 *
 * @author Sinkevich Denis
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Clients", propOrder = "clients")
public class Clients {

    public Clients() {
    }

    public Clients(List<Client> clients) {
        this.clients = clients;
    }
    @XmlElementWrapper(name = "Clients")
    @XmlElement(name = "Client", required = true)
    protected List<Client> clients;

    public List<Client> getClients() {
        return clients;
    }

    public void setClients(List<Client> clients) {
        this.clients = clients;
    }
}
