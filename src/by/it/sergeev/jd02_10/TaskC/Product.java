package by.it.sergeev.jd02_10.TaskC;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Product", propOrder = {
        "manufacturer",
        "name",
        "model",
        "price",
})
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

    public Product() {
    }

    public Product(String manufacturer, String name, String model, Double price, String description) {
        setManufacturer(manufacturer);
        setName(name);
        setModel(model);
        setPrice(price);
        setDescription(description);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "Product{" +
                " manufacturer='" + manufacturer + '\'' +
                ", name='" + name + '\'' +
                ", model=" + model +
                ", price='" + price + '\'' +
                ", description='" + description + '\'' + '}';
    }


}