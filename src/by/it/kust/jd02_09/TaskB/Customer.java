package by.it.kust.jd02_09.TaskB;

import javax.xml.bind.annotation.*;
import java.math.BigInteger;

/**
 * Created by Tanya Kust.
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "customer", propOrder = {
        "name",
        "email",
        "address",
        "discount"
})
public class Customer {
    @XmlElement(required = true)
    private String name;
    @XmlElement(required = true)
    private String email;
    @XmlElement(required = true)
    private String address;
    @XmlElement(required = true)
    private BigInteger discount;

    public Customer() {
    }

    public Customer(String name, String email, String address, BigInteger discount) {
        this.name = name;
        this.email = email;
        this.address = address;
        this.discount = discount;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setDiscount(BigInteger discount) {
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public BigInteger getDiscount() {
        return discount;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "\nname='" + name + '\'' +
                ", \nemail='" + email + '\'' +
                ", \naddress='" + address + '\'' +
                ", \ndiscount=" + discount +
                '}';
    }

}
