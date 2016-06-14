package by.it.luksha.jd02_02;

/**
 * Created by MMauz on 14.06.2016.
 */
public class Goods {
    private String name;
    private Double price;

    public Goods(String name, Double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }
}
