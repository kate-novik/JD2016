package by.it.kushel.jd01_07;

/**
 * Created by Diomn on 15.05.2016.
 */
public class Warcraft implements Ship {
    double capacity;
    Warcraft(double capacity){
        this.capacity=capacity;

    }

    double totalMass=0;
    @Override
    public double load(double weightOfShip, double weightOfPassenger, double weightOfLoad) {
        totalMass=weightOfShip+weightOfPassenger+weightOfLoad;
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
    @Override
    public double resupply(double restVolumeOFfuel, double addedVolumeOFfuel) {
        volumeOfFuel=restVolumeOFfuel+addedVolumeOFfuel;
        return  volumeOfFuel;
    }
}
