package by.it.sereda.jd02_01;

public class Buyer implements IBuyer, Runnable {

    @Override
    public void enteToMarket() {
        System.out.println("Buyer in shop");
    }

    @Override
    public void choosegoods() {
        try {
            int timeout = Utils.getTimeOut(500, 2000);
            Thread.sleep(timeout);
            System.out.println("Buyer choose goods");
        } catch (InterruptedException e) {
            System.out.println("Buyer crash");
        }
    }

    @Override
    public void goToOut() {
        System.out.println("Buyer out from shop");
    }

    @Override
    public void run() {
        enteToMarket();
        choosegoods();
        goToOut();
    }
}
