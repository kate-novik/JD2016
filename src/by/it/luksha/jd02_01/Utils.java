package by.it.luksha.jd02_01;

import java.util.Random;

/**
 * Created by MMauz on 14.06.2016.
 */
public class Utils {
    /**
     * Генерирует псевдослучайное число (int) в промежутке min - max
     * @param min минимум
     * @param max максимум
     * @return случайное int число
     */
    public static int randInt(int min, int max) {
        if (max < min) {
            int swap = min;
            min = max;
            max = swap;
        }

        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }
}
