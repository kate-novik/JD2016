package by.it.luksha.jd02_02;

import java.util.*;

/**
 * Created by MMauz on 14.06.2016.
 */
public class Market {
    private String name;
    private volatile int counterBuyers = 0;
    private long deltaTime;
    private volatile Queue<Buyer> queue; //будет изменяться разными потоками, поэтому volatile
    private ArrayList<Cashier> cashierArrayList; //множество касс
    private volatile int countWorksCashier = 0; //сколько касс работает в данный момент
    private Set<Goods> setGoods; //множество товаров
    private volatile double bill = 0; //общая выручка магазина

    public Queue<Buyer> getQueue() {
        return queue;
    }

    public int getCountWorksCashier() {
        return countWorksCashier;
    }

    public Set<Goods> getSetGoods() {
        return setGoods;
    }

    public Market(String name) {
        this.name = name;
    }

    public ArrayList<Cashier> getCashierArrayList() {
        return cashierArrayList;
    }

    public void setBill(double bill) {
        this.bill += bill;
    }

    public double getBill() {
        return bill;
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
                    counterBuyers++;
                    Thread thread = new Thread(new Buyer(String.valueOf(counterBuyers), (Utils.randInt(1, 4) != 4) ? false : true, this));
                    thread.start();
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

        //создание 5 касс, запуск и добавление в список касс маркета
        cashierArrayList = new ArrayList<>();
        for (int i = 1; i <= 5; i++) {
            Cashier cashier = new Cashier(this, i);
            Thread thread = new Thread(cashier);
            thread.start();
            cashierArrayList.add(cashier);
        }

        //добавление товаров
        setGoods = new HashSet<>();
        setGoods.add(new Goods("Бакалея", 2.0));
        setGoods.add(new Goods("Канцтовары", 1.2));
        setGoods.add(new Goods("Виноводка", 3.4));
        setGoods.add(new Goods("Галантерея", 5.6));
        setGoods.add(new Goods("Хозтовары", 2.3));
        setGoods.add(new Goods("Мясо", 3.2));
    }
}
