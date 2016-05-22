package by.it.kust.jd01_08;

/**
 * Created by Tanya Kust on 19.05.2016.
 */
public class Main {
    /**
     * задание 5. interface Mobile <-- abstract class Siemens Mobile <-- class Model.
     * @param args модель, цена
     */
    public static void main(String[] args) {
        Model model1 = new Model("CX75", 300);
        model1.showModel();
        model1.showPrice();
        model1.switchOn();
        model1.helloMessage();
        model1.checkBalance();
        model1.flightModeOn();
        model1.flightModeOff();
        model1.switchOff();
    }
}
