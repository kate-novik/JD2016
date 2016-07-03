package by.it.kust.jd02_09.TaskB;

import javax.xml.bind.annotation.*;

/**
 * Created by Tanya Kust.
 */

@XmlRootElement(name = "DreamTravel")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dreamTravel", propOrder = {
        "customer",
        "tours"
})
public class DreamTravel {
    @XmlElement(required = true)
    private Customer customer = new Customer();

    @XmlElement(required = true)
    private Tours tours = new Tours();

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setTours(Tours tours) {
        this.tours = tours;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Tours getTours() {
        return tours;
    }

    @Override
    public String toString() {
        return "\nDreamTravel{" +
                "\ncustomer=" + customer +
                ", \ntours=" + tours +
                '}';
    }

    public DreamTravel(Customer customer, Tours tours) {
        this.customer = customer;
        this.tours = tours;
    }

    public DreamTravel() {
    }
}
