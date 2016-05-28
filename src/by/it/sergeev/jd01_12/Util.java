package by.it.sergeev.jd01_12;

import java.util.Random;

/**
 * Created by Spec on 28.05.16.
 */
public class Util {
    //А1.
    private static Random random = new Random();

    static int generateRandom(int n) {
        return Math.abs(random.nextInt()) % n;
    }
}
