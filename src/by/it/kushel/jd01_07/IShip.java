package by.it.kushel.jd01_07;

/**
 * Created by Diomn on 15.05.2016.
 */
public interface IShip {
   public void sail();
    public String resupply(double restVolumeOFfuel, double addedVolumeOFfuel);
    public double calculationtTotalMass();
    public void stop();

}
