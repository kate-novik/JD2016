package by.it.luksha.jd02_03;

import java.util.HashMap;
import java.util.Set;

import static by.it.luksha.jd02_03.Utils.print;
import static by.it.luksha.jd02_03.Utils.randInt;
import static by.it.luksha.jd02_03.Utils.sleepIn;

/**
 * Created by MMauz on 14.06.2016.
 */
public class Buyer implements Runnable, IBuyer, IUseBasket {
    private String name;
    private HashMap<Goods, Integer> basket; //basket<товар, кол-во>
    private boolean pensioner = false;
    private Market market;
    private boolean iWait = false;

    public Buyer(String name, boolean pensioner, Market market) {
        this.name = "Покупатель " + name;
        this.pensioner = pensioner;
        this.market = market;
    }

    public HashMap<Goods, Integer> getBasket() {
        return basket;
    }

    public void setiWait(boolean iWait) {
        this.iWait = iWait;
    }

    /**
     * Вход покупателя в магазин
     */
    @Override
    public void enterToMarket() {
        print(this + " вошел в магазин");
    }

    /**
     * Выбирает товар
     */
    @Override
    public void chooseGoods() {
        int pause = randInt(500, 2000);
        if (this.pensioner) {pause = (int) (1.5 * pause);}
        sleepIn(pause);

        int countGoods = randInt(1, 4);
        for (int i = 0; i < countGoods; i++) {
            putGoodsToBasket();
        }
        //System.out.println(this + " выбрал товар");
        print(this + " выбрал товар");
    }

    /**
     * Завершает процесс покупателя
     */
    @Override
    public void goToOut() {
        print(this + " вышел из магазина");
    }

    /**
     * Назначает покупателю корзину для товаров
     */
    @Override
    public void takeBasket() {
        int pause = randInt(100, 200);
        if (this.pensioner) {pause = (int) (1.5 * pause);}
        sleepIn(pause);
        this.basket = new HashMap<>();
    }

    /**
     * Кладет случайный товар в корзину покупателя
     */
    @Override
    public void putGoodsToBasket() {
        int pause = randInt(100, 200);
        if (this.pensioner) {pause = (int) (1.5 * pause);}
        sleepIn(pause);

        Set setGoods = market.getSetGoods();
        Object[] goods = setGoods.toArray(new Goods[setGoods.size()]);
        basket.put((Goods) goods[randInt(0, goods.length-1)], randInt(1, 4));
    }

    /**
     * Ставит покупателя в очередь на кассе
     */
    public void goToCashier() {
        this.market.getQueue().add(this);
        synchronized (this) {
            print(this + " встал в очередь на кассе");
            iWait = true;
            while (iWait) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    System.err.println(this + " некорректное завершение ожидания");
                }
            }
        }
        print(this + " вышел из очереди на кассе");
    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        chooseGoods();
        goToCashier();
        goToOut();
    }

    @Override
    public String toString() {
        if (this.pensioner) {
            return this.name + " (пенсионер):";
        } else {
            return this.name+":";
        }
    }
}
