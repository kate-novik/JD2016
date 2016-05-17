package by.it.novik.jd01_08;


/**
 * Created by Kate Novik.
 */
public interface IFurniture {
    /**
     * Опишем возможные действия с мебелью
     * interface Мебель <-- abstract class Шкаф <-- class Книжный Шкаф.
     */
    boolean open ();
    boolean close ();
    boolean putThing (Things thing);
    Things takeThing (String nameThing);
    double[] move (double[] xyNext);
    boolean assemble ();
    boolean disassemble ();
    boolean clean ();
}
