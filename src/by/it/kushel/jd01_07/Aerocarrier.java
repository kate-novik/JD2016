package by.it.kushel.jd01_07;

/**
 * Created by Diomn on 15.05.2016.
 */
public class Aerocarrier extends Warcraft {

    double weightOfPlane;
   public  Aerocarrier(double weightOfShip, double weightOfLoad, double weightOfPlane){
        super(weightOfShip, weightOfLoad);
        this.weightOfPlane=weightOfPlane;
    }
    public double calculationtTotalMass(){
        totalMass=weightOfShip+weightOfLoad+ weightOfPlane;
        return totalMass;
    }
    public void stop() {
        System.out.println("Aerocarrier stops");
    }
    public void sail(int numberOfPlanes) {
        System.out.println("Aerocarrier sails with "+ numberOfPlanes+ " planes");

    }
}
