package by.it.kust.jd03_02.beans;

import java.sql.Date;

/**
 * Created by Tanya Kust.
 */
public class Tour {
    private int id;
    private String country;
    private String city;
    private String hotel;
    private String url;
    private Date date;
    private int days;
    private int price;
    private String type;
    private String option1;
    private String option2;
    private int fk_Users;

    public Tour() {
    }

    public Tour(int id, String country, String city, String hotel, String url, Date date, int days, int price, String type, String option1, String option2, int fk_Users) {
        this.id = id;
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
        this.fk_Users = fk_Users;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getHotel() {
        return hotel;
    }

    public void setHotel(String hotel) {
        this.hotel = hotel;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getDays() {
        return days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOption1() {
        return option1;
    }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public int getFk_Users() {
        return fk_Users;
    }

    public void setFk_Users(int fk_Users) {
        this.fk_Users = fk_Users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tour tour = (Tour) o;

        if (id != tour.id) return false;
        if (days != tour.days) return false;
        if (price != tour.price) return false;
        if (fk_Users != tour.fk_Users) return false;
        if (country != null ? !country.equals(tour.country) : tour.country != null) return false;
        if (city != null ? !city.equals(tour.city) : tour.city != null) return false;
        if (hotel != null ? !hotel.equals(tour.hotel) : tour.hotel != null) return false;
        if (url != null ? !url.equals(tour.url) : tour.url != null) return false;
        if (date != null ? !date.equals(tour.date) : tour.date != null) return false;
        if (type != null ? !type.equals(tour.type) : tour.type != null) return false;
        if (option1 != null ? !option1.equals(tour.option1) : tour.option1 != null) return false;
        return option2 != null ? option2.equals(tour.option2) : tour.option2 == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (country != null ? country.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (hotel != null ? hotel.hashCode() : 0);
        result = 31 * result + (url != null ? url.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + days;
        result = 31 * result + price;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (option1 != null ? option1.hashCode() : 0);
        result = 31 * result + (option2 != null ? option2.hashCode() : 0);
        result = 31 * result + fk_Users;
        return result;
    }

    @Override
    public String toString() {
        return "Tour{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", hotel='" + hotel + '\'' +
                ", url='" + url + '\'' +
                ", date=" + date +
                ", days=" + days +
                ", price=" + price +
                ", type='" + type + '\'' +
                ", option1='" + option1 + '\'' +
                ", option2='" + option2 + '\'' +
                ", fk_Users=" + fk_Users +
                '}';
    }
}
