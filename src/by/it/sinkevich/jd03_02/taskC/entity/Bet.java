package by.it.sinkevich.jd03_02.taskC.entity;

import java.sql.Timestamp;

/**
 * Class represents entity corresponding to table bets in DB
 *
 * @author Sinkevich Denis
 */
public class Bet {

    private int id;
    private Timestamp time;
    private int fk_race;
    private String horse;
    private double betSum;
    private int fk_user;

    public Bet() {
    }

    public Bet(int id, Timestamp time, int fk_race, String horse, double betSum, int fk_user) {
        this.id = id;
        this.time = time;
        this.fk_race = fk_race;
        this.horse = horse;
        this.betSum = betSum;
        this.fk_user = fk_user;
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

    public int getFk_race() {
        return fk_race;
    }

    public void setFk_race(int fk_race) {
        this.fk_race = fk_race;
    }

    public String getHorse() {
        return horse;
    }

    public void setHorse(String horse) {
        this.horse = horse;
    }

    public double getBetSum() {
        return betSum;
    }

    public void setBetSum(double betSum) {
        this.betSum = betSum;
    }

    public int getFk_user() {
        return fk_user;
    }

    public void setFk_user(int fk_user) {
        this.fk_user = fk_user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Bet bet = (Bet) o;

        if (getId() != bet.getId()) return false;
        if (getFk_race() != bet.getFk_race()) return false;
        if (Double.compare(bet.getBetSum(), getBetSum()) != 0) return false;
        if (getFk_user() != bet.getFk_user()) return false;
        if (!getTime().equals(bet.getTime())) return false;
        return getHorse().equals(bet.getHorse());

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = getId();
        result = 31 * result + getTime().hashCode();
        result = 31 * result + getFk_race();
        result = 31 * result + getHorse().hashCode();
        temp = Double.doubleToLongBits(getBetSum());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + getFk_user();
        return result;
    }

    @Override
    public String toString() {
        return "Bets{" +
                "id=" + id +
                ", time=" + time +
                ", fk_race=" + fk_race +
                ", horse='" + horse + '\'' +
                ", betSum=" + betSum +
                ", fk_user=" + fk_user +
                '}';
    }
}
