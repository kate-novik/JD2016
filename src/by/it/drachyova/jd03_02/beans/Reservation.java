package by.it.drachyova.jd03_02.beans;

import java.sql.Timestamp;

public class Reservation {
    private int id;
    private Timestamp checkIn;
    private Timestamp checkOut;
    private int fk_type;
    private int fk_user;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(Timestamp checkIn) {
        this.checkIn = checkIn;
    }

    public Timestamp getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(Timestamp checkOut) {
        this.checkOut = checkOut;
    }

    public int getFk_type() {
        return fk_type;
    }

    public void setFk_type(int fk_type) {
        this.fk_type = fk_type;
    }

    public int getFk_user() {
        return fk_user;
    }

    public void setFk_user(int fk_user) {
        this.fk_user = fk_user;
    }

    public Reservation() {
    }

    public Reservation(int id, Timestamp checkIn, Timestamp checkOut, int fk_type, int fk_user) {
        this.id = id;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.fk_type = fk_type;
        this.fk_user = fk_user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Reservation)) return false;

        Reservation that = (Reservation) o;

        if (getId() != that.getId()) return false;
        if (getFk_type() != that.getFk_type()) return false;
        if (getFk_user() != that.getFk_user()) return false;
        if (!getCheckIn().equals(that.getCheckIn())) return false;
        if (!getCheckOut().equals(that.getCheckOut())) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getCheckIn().hashCode();
        result = 31 * result + getCheckOut().hashCode();
        result = 31 * result + getFk_type();
        result = 31 * result + getFk_user();
        return result;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                "checkIn=" + checkIn +
                ", checkOut=" + checkOut +
                ", fk_type='" + fk_type + '\'' +
                ", fk_user='" + fk_user + '\'' +
                '}';
    }
}
