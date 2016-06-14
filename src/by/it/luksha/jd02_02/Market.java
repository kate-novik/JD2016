package by.it.luksha.jd02_02;

import java.util.*;

/**
 * Created by MMauz on 14.06.2016.
 */
public class Market {
    private String name;
    private static int counterBuyers = 0;
    private long deltaTime;
    private static volatile Queue<Buyer> queue; //будет изменяться разными потоками, поэтому volatile
    private Set<Cashier> setCashiers; //множество касс
    private volatile int countWorksCashier = 0; //сколько касс работает в данный момент
    private static Set<Goods> setGoods; //множество товаров

    public static Queue<Buyer> getQueue() {
        return queue;
    }

    public int getCountWorksCashier() {
        return countWorksCashier;
    }

    public static Set<Goods> getSetGoods() {
        return setGoods;
    }

    public Market(String name) {
        this.name = name;
    }

    /**
     * Открывает маркет
     */
    public void openMarket() throws InterruptedException {
        //запускаем покупателей каждую секунду, пока их кол-во < 1000
        while (counterBuyers < 1000) {
            Thread.sleep(1000);
            //размер очереди 30, когда достигнут, ждем уменьшения очереди и запускаем новых покупателей
            if (queue.size() < 30) {
                int buyers = Utils.randInt(0, 2);
                for (int i = 0; i < buyers; i++) {
                    new Buyer(String.valueOf(counterBuyers), (Utils.randInt(1, 4) != 4) ? false : true, this);
                    counterBuyers++;
                }
            } else {
                Thread.sleep(1000); //когда достигнут предел очереди, ждем 1 секунду
            }
        }
    }

    /**
     * Закрывает маркет
     */
    public void closeMarket() {
        System.out.printf("Супермаркет %s работал %d секунд, обслужил %d клиента(ов)", this.name, this.deltaTime, counterBuyers);
    }

    public void setup() {
        //создание общей очереди для покупателей маркета
        this.queue = new ArrayDeque<>();

        //создание 5 касс и добавление в список касс маркета
        setCashiers = new HashSet<>();
        for (int i = 1; i <= 5; i++) {
            setCashiers.add(new Cashier(this, "Касса " + i));
        }

        //добавление товаров
        setGoods = new HashSet<>();
        setGoods.add(new Goods("Молоко", 10.0));
    }
}
