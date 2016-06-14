package by.it.luksha.jd02_02;

/**
 * Created by MMauz on 14.06.2016.
 */
public class Runner {
    public static void main(String[] args) throws InterruptedException {
        Market gippo = new Market("Гиппо");
        gippo.setup();
        gippo.openMarket();
    }
}
