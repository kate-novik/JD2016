package by.it.sinkevich.jd03_03.bean;

import java.sql.Timestamp;

/**
 * Class represents entity corresponding to table races in DB
 *
 * @author Sinkevich Denis
 */
public class Race {

    private int id;
    private Timestamp time;
    private String horse1;
    private String horse2;
    private String horse3;
    private String horse4;
    private String horse5;
    private String horse6;
    private String horse7;
    private String horse8;
    private String winner;

    public Race() {
    }

    public Race(int id, Timestamp time, String horse1, String horse2, String horse3, String horse4,
                String horse5, String horse6, String horse7, String horse8, String winner) {
        this.id = id;
        this.time = time;
        this.horse1 = horse1;
        this.horse2 = horse2;
        this.horse3 = horse3;
        this.horse4 = horse4;
        this.horse5 = horse5;
        this.horse6 = horse6;
        this.horse7 = horse7;
        this.horse8 = horse8;
        this.winner = winner;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getTime() {
        return time;
    }

    public void setTime(Timestamp time) {
        this.time = time;
    }

    public String getHorse1() {
        return horse1;
    }

    public void setHorse1(String horse1) {
        this.horse1 = horse1;
    }

    public String getHorse2() {
        return horse2;
    }

    public void setHorse2(String horse2) {
        this.horse2 = horse2;
    }

    public String getHorse3() {
        return horse3;
    }

    public void setHorse3(String horse3) {
        this.horse3 = horse3;
    }

    public String getHorse4() {
        return horse4;
    }

    public void setHorse4(String horse4) {
        this.horse4 = horse4;
    }

    public String getHorse5() {
        return horse5;
    }

    public void setHorse5(String horse5) {
        this.horse5 = horse5;
    }

    public String getHorse6() {
        return horse6;
    }

    public void setHorse6(String horse6) {
        this.horse6 = horse6;
    }

    public String getHorse7() {
        return horse7;
    }

    public void setHorse7(String horse7) {
        this.horse7 = horse7;
    }

    public String getHorse8() {
        return horse8;
    }

    public void setHorse8(String horse8) {
        this.horse8 = horse8;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Race race = (Race) o;

        if (getId() != race.getId()) return false;
        if (!getTime().equals(race.getTime())) return false;
        if (!getHorse1().equals(race.getHorse1())) return false;
        if (!getHorse2().equals(race.getHorse2())) return false;
        if (!getHorse3().equals(race.getHorse3())) return false;
        if (!getHorse4().equals(race.getHorse4())) return false;
        if (!getHorse5().equals(race.getHorse5())) return false;
        if (!getHorse6().equals(race.getHorse6())) return false;
        if (!getHorse7().equals(race.getHorse7())) return false;
        if (!getHorse8().equals(race.getHorse8())) return false;
        return getWinner().equals(race.getWinner());

    }

    @Override
    public int hashCode() {
        int result = getId();
        result = 31 * result + getTime().hashCode();
        result = 31 * result + getHorse1().hashCode();
        result = 31 * result + getHorse2().hashCode();
        result = 31 * result + getHorse3().hashCode();
        result = 31 * result + getHorse4().hashCode();
        result = 31 * result + getHorse5().hashCode();
        result = 31 * result + getHorse6().hashCode();
        result = 31 * result + getHorse7().hashCode();
        result = 31 * result + getHorse8().hashCode();
        result = 31 * result + getWinner().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Race{" +
                "id=" + id +
                ", time=" + time +
                ", horse1='" + horse1 + '\'' +
                ", horse2='" + horse2 + '\'' +
                ", horse3='" + horse3 + '\'' +
                ", horse4='" + horse4 + '\'' +
                ", horse5='" + horse5 + '\'' +
                ", horse6='" + horse6 + '\'' +
                ", horse7='" + horse7 + '\'' +
                ", horse8='" + horse8 + '\'' +
                ", winner='" + winner + '\'' +
                '}';
    }
}
