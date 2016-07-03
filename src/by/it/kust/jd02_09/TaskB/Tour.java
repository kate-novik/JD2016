package by.it.kust.jd02_09.TaskB;

import javax.xml.bind.annotation.*;
import javax.xml.datatype.XMLGregorianCalendar;
import java.math.BigInteger;

/**
 * Created by Tanya Kust.
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "tour", propOrder = {
        "country",
        "city",
        "hotel",
        "url",
        "date",
        "days",
        "price",
        "type",
        "option1",
        "option2"
})
public class Tour {
    @XmlElement(required = true)
    private String country;
    @XmlElement(required = true)
    private String city;
    @XmlElement(required = true)
    private String hotel;
    @XmlElement(required = true)
    private String url;
    @XmlElement(required = true)
    private XMLGregorianCalendar date;
    @XmlElement(required = true)
    private BigInteger days;
    @XmlElement(required = true)
    private BigInteger price;
    @XmlElement(required = true)
    private String type;
    @XmlElement(required = true)
    private String option1;
    @XmlElement(required = true)
    private String option2;

    public Tour(String country, String city, String hotel, String url, XMLGregorianCalendar date, BigInteger days, BigInteger price, String type, String option1, String option2) {
        this.country = country;
        this.city = city;
        this.hotel = hotel;
        this.url = url;
        this.date = date;
        this.days = days;
        this.price = price;
        this.type = type;
        this.option1 = option1;
        this.option2 = option2;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setDate(XMLGregorianCalendar date) {
        this.date = date;
    }

    public void setDays(BigInteger days) {
        this.days = days;
    }

    public void setPrice(BigInteger price) {
        this.price = price;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public String getHotel() {
        return hotel;
    }

    public String getUrl() {
        return url;
    }

    public XMLGregorianCalendar getDate() {
        return date;
    }

    public BigInteger getDays() {
        return days;
    }

    public BigInteger getPrice() {
        return price;
    }

    public String getType() {
        return type;
    }

    public String getOption1() {
        return option1;
    }

    public String getOption2() {
        return option2;
    }

    @Override
    public String toString() {
        return "Tour{" +
                "\ncountry='" + country + '\'' +
                ", \ncity='" + city + '\'' +
                ", \nhotel='" + hotel + '\'' +
                ", \nurl='" + url + '\'' +
                ", \ndate=" + date +
                ", \ndays=" + days +
                ", \nprice=" + price +
                ", \ntype='" + type + '\'' +
                ", \noption1='" + option1 + '\'' +
                ", \noption2='" + option2 + '\'' +
                '}' + "\n";
    }

    public Tour() {
    }
}
