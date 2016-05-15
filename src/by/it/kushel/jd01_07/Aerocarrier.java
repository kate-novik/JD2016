package by.it.kushel.jd01_07;

/**
 * Created by Diomn on 15.05.2016.
 */
public class Aerocarrier extends Warcraft {
    double weightOfPlane=0;
    Aerocarrier(double capacity, double weightOfPlane){
        super(capacity);
        this.weightOfPlane=weightOfPlane;
    }
    public double calculationMaxNumberOfPlane(){
        double maxNumberOfPlane=capacity/weightOfPlane;
        return maxNumberOfPlane;
    }
}
