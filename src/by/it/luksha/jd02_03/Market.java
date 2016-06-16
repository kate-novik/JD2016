package by.it.luksha.jd02_03;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

import static by.it.luksha.jd02_03.Utils.randInt;

/**
 * Created by MMauz on 14.06.2016.
 */
public class Market {
    private String name;
    private AtomicInteger counterBuyers;
    private ConcurrentLinkedQueue<Buyer> queue;
    private ArrayList<Cashier> cashierArrayList; //множество касс
    private AtomicInteger countWorksCashier; //сколько касс работает в данный момент
    private Set<Goods> setGoods; //множество товаров
    private volatile double bill = 0; //общая выручка магазина
    private ExecutorService executor;

    public ConcurrentLinkedQueue<Buyer> getQueue() {
        return queue;
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

    public void incCountWorksCashier() {
        this.countWorksCashier.incrementAndGet();
    }

    public void decCountWorksCashier() {
        this.countWorksCashier.decrementAndGet();
    }

    public AtomicInteger getCountWorksCashier() {
        return countWorksCashier;
    }

    /**
     * Открывает маркет
     */
    public void openMarket() throws InterruptedException {
        //запускаем покупателей каждую секунду, пока их кол-во < 1000
        while (counterBuyers.get() < 1000) {
            Thread.sleep(1000);
            //размер очереди 30, когда достигнут, ждем уменьшения очереди и запускаем новых покупателей
            if (queue.size() < 30) {
                int buyers = randInt(0, 2);
                for (int i = 0; i < buyers; i++) {
                    //counterBuyers++;
                    counterBuyers.incrementAndGet();
                    Thread thread = new Thread(new Buyer(String.valueOf(counterBuyers), (randInt(1, 4) == 4) ? true : false, this));
                    thread.start();
                }
            } else {
                Thread.sleep(1000); //когда достигнут предел очереди, ждем 1 секунду
            }
        }
    }

    public void closeMarket() {
        this.executor.shutdown();
    }

    public void setup() {
        counterBuyers = new AtomicInteger(0);
        countWorksCashier = new AtomicInteger(0);
        //создание общей очереди для покупателей маркета
        this.queue = new ConcurrentLinkedQueue<>();

        //создание 5 касс, запуск и добавление в список касс маркета
        this.cashierArrayList = new ArrayList<>();
        this.executor = Executors.newFixedThreadPool(5);
        for (int i = 1; i <= 5; i++) {
            Cashier cashier = new Cashier(this, i);
            executor.execute(cashier);
            this.cashierArrayList.add(cashier);
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
