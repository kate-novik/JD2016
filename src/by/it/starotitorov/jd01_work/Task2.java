package by.it.starotitorov.jd01_work;

/**
 * Created by Vasiliy Starotitorov on 27.04.2016.
 * On example: "There is time interval in seconds. Do the output it on CommandPage in hours, minutes and seconds."
 * Continue task with calculation and  displaying days and weeks.
 */
public class Task2 {
    public static void main (String[] args) {
        int s = 3700000;    //we change 3700 seconds to 3700000 because 3700 seconds have low value for days and weeks
        int sec,m,min,h;    //from example variables
        int hr, d, day, w;  //add new variables
        sec =s % 60;
        m = (s - sec) / 60;
        min = m % 60;
        h = (m - min) / 60;
        hr = h % 24;
        d = (h - hr) /24;
        day = d % 7;
        w = (d - day)/7;
        System.out.println(w+ " week " + day + " day " + hr +" hours " + min + " minutes " + sec + " seconds ");
    }
}

