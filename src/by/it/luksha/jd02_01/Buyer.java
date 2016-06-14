package by.it.luksha.jd02_01;

import java.util.HashMap;

/**
 * Created by MMauz on 14.06.2016.
 */
public class Buyer extends Thread implements IBuyer, IUseBasket {
    private String name;
    private HashMap<Goods, Integer> basket; //basket<товар, кол-во>
    private boolean pensioner = false;

    public Buyer(String name, boolean pensioner) {
        this.name = "Покупатель " + name;
        this.pensioner = pensioner;
        start();
    }

    /**
     * Вход покупателя в магазин
     */
    @Override
    public void enterToMarket() {
        System.out.println(this + " вошел в магазин");
    }

    /**
     * Выбирает товар
     */
    @Override
    public void chooseGoods() {
        int pause = Utils.randInt(500, 2000);
        if (this.pensioner) {pause = (int) (1.5 * pause);}
        try {
            Thread.sleep(pause);
        } catch (InterruptedException e) {
            System.out.println(this + " некорректное завершение ожидания");
        }
        putGoodsToBasket(new Goods("Хлеб", (double) 45), Utils.randInt(1, 4));
        System.out.println(this + " выбрал товар");
    }

    /**
     * Завершает процесс покупателя
     */
    @Override
    public void goToOut() {
        System.out.println(this + " вышел из магазина");
        this.interrupt();
    }

    /**
     * Назначает покупателю корзину для товаров
     */
    @Override
    public void takeBasket() {
        int pause = Utils.randInt(100, 200);
        if (this.pensioner) {pause = (int) (1.5 * pause);}
        try {
            Thread.sleep(pause);
        } catch (InterruptedException e) {
            System.out.println(this + " некорректное завершение ожидания");
        }
        this.basket = new HashMap<>();
    }

    /**
     * Кладет выбранный товар в корзину покупателя
     * @param goods товар
     * @param count кол-во
     */
    @Override
    public void putGoodsToBasket(Goods goods, int count) {
        int pause = Utils.randInt(100, 200);
        if (this.pensioner) {pause = (int) (1.5 * pause);}
        try {
            Thread.sleep(pause);
        } catch (InterruptedException e) {
            System.out.println(this + " некорректное завершение ожидания");
        }
        if (this.basket != null) {
            this.basket.put(goods, count);
        } else {
            System.out.println(this + " возьмите корзинку");
        }
    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        chooseGoods();
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
