package by.it.kushel.jd01_07;

/**
 * Created by Diomn on 15.05.2016.
 */
public interface Ship {
   public void sail();
    public double resupply(double restVolumeOFfuel, double addedVolumeOFfuel);
    public double load(double weightOfShip, double weightOfPassenger, double weightOfLoad);
    public void stop();

}
