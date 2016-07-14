package by.it.drachyova.jd03_02.beans;

import java.sql.Timestamp;

public class Reservation {
    private Timestamp checkIn;
    private Timestamp checkOut;
    private String fk_type;
    private String fk_user;

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

    public String getFk_type() {
        return fk_type;
    }

    public void setFk_type(String fk_type) {
        this.fk_type = fk_type;
    }

    public String getFk_user() {
        return fk_user;
    }

    public void setFk_user(String fk_user) {
        this.fk_user = fk_user;
    }

    public Reservation() {
    }

    public Reservation(Timestamp checkIn, Timestamp checkOut, String fk_type, String fk_user) {
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

        if (!getCheckIn().equals(that.getCheckIn())) return false;
        if (!getCheckOut().equals(that.getCheckOut())) return false;
        if (!getFk_type().equals(that.getFk_type())) return false;
        if (!getFk_user().equals(that.getFk_user())) return false;
        return true;

    }

    @Override
    public int hashCode() {
        int result = getCheckIn().hashCode();
        result = 31 * result + getCheckOut().hashCode();
        result = 31 * result + getFk_type().hashCode();
        result = 31 * result + getFk_user().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "checkIn=" + checkIn +
                ", checkOut=" + checkOut +
                ", fk_type='" + fk_type + '\'' +
                ", fk_user='" + fk_user + '\'' +
                '}';
    }
}
