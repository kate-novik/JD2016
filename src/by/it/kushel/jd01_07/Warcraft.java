package by.it.kushel.jd01_07;

/**
 * Created by Diomn on 15.05.2016.
 */
public class Warcraft implements IShip {
    double weightOfShip;
    double weightOfLoad;
    public Warcraft(double weightOfShip, double weightOfLoad){
        this.weightOfShip=weightOfShip;
        this.weightOfLoad=weightOfLoad;

    }

    double totalMass=0;
    @Override
    public double calculationtTotalMass() {
        totalMass=weightOfShip+weightOfLoad;
        return totalMass;
    }

    @Override
    public void sail() {
        System.out.println("Warcraft sails");

    }

    @Override
    public void stop() {
        System.out.println("Warcraft stops");
    }

    double volumeOfFuel;
    String volume;
    @Override
    public String resupply(double restVolumeOFfuel, double addedVolumeOFfuel) {
        volumeOfFuel=restVolumeOFfuel+addedVolumeOFfuel;
        volume = "Объем топлива после заправки ="+ volumeOfFuel + " л.";
        return  volume;
    }
}
