package by.it.vasilevich.jd01_05.math;

import static java.lang.Math.abs;
import static java.lang.Math.pow;
import static java.lang.Math.asin;

/**
 * Created by user_2 on 08.06.2016.
 */
public class Task2 {
    public static double optionA (double a, double b){
        double y = pow(a+1.5,3)+pow((a-b),8)-b/asin(pow(abs (a), 2));
        return y;
    }
}
