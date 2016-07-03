package by.it.sergeev.jd02_09.TaskBC;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "description"
})
@XmlRootElement(name = "product")
public class Product {

    @XmlElement(required = true)
    protected String description;
    @XmlAttribute(name = "manufacturer", required = true)
    protected String manufacturer;
    @XmlAttribute(name = "name", required = true)
    protected String name;
    @XmlAttribute(name = "model", required = true)
    protected String model;
    @XmlAttribute(name = "price", required = true)
    protected double price;

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    /**
     * Gets the value of the description property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getDescription() {
        return description;
    }

    /**
     * Sets the value of the description property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setDescription(String value) {
        this.description = value;
    }

    /**
     * Gets the value of the name property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the price property.
     *
     */
    public double getPrice() {
        return price;
    }

    /**
     * Sets the value of the price property.
     *
     */
    public void setPrice(double value) {
        this.price = value;
    }

    @Override
    public String toString() {
        return "Product{" +
                " manufacturer='" + manufacturer + '\'' +
                ", name='" + name + '\'' +
                ", model='" + model + '\'' +
                ", price=" + price + '\'' +
                ",description='" + description +
                '}';
    }
}