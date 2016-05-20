package by.it.kushel.jd01_07;

/**
 * Created by Diomn on 15.05.2016.
 */
public class Main {
    public static void main(String[] args) {
        Aerocarrier aer = new Aerocarrier(100, 19, 40);
        System.out.println("Общая масса военного корабля "+aer.calculationtTotalMass());
        System.out.println(aer.resupply(15,18));
        aer.sail();
        aer.sail(2);
        aer.stop();

        Warcraft war = new Warcraft(100, 19);
        System.out.println("Общая масса авианосца "+war.calculationtTotalMass());
        System.out.println(war.resupply(5,8));
        war.sail();
        war.stop();

    }
}
