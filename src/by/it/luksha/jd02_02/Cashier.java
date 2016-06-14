package by.it.luksha.jd02_02;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by MMauz on 14.06.2016.
 */
public class Cashier extends Thread {
    private Market market;
    private String name;

    public Cashier(Market market, String name) {
        this.market = market;
        this.name = name;
        start();
    }

    @Override
    public void run() {
        do {
            if (market.getQueue().size() > 5) {
                System.out.println("Человек в очереди:" + market.getQueue().size());
                Buyer buyer = market.getQueue().remove();
                System.out.printf("%s осблужен на %s сумма чека: %.2f\n", buyer.toString(), this.name, printCheck(buyer));
                buyer.interrupt();
            } else if (market.getQueue().size() < 5 && market.getCountWorksCashier() == 0) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } while (true);
    }

    /**
     * Печатает чек покупателя
     * @param buyer покупатель
     */
    private double printCheck(Buyer buyer) {
        double sumCheck = 0;
        HashMap<Goods, Integer> basket = buyer.getBasket();
        for (Map.Entry<Goods, Integer> pair: basket.entrySet()) {
            Goods goods = pair.getKey();
            int count = pair.getValue();
            sumCheck += goods.getPrice() * count;
        }
        return sumCheck;
    }
}
