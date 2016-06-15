package by.it.novik.jd02_02.entities;

import by.it.novik.jd02_02.interfaces.ICashier;
import by.it.novik.jd02_02.utils.RandomCounter;

import java.util.Map;


/**
 * Created by Kate Novik.
 */
public class Cashier implements ICashier, Runnable {
    //Поле id кассы
    private int idCashier;
    //Поле объекта супермаркет
    private Supermarket sm;
    //Поле потока кассиров
    Thread thCash;
    //Поле для синхронизации кассиров
    private final static Integer lockCashier = 0;


    public Cashier(int idCashier, Supermarket sm) {
        this.idCashier = idCashier;
        this.sm = sm;
        thCash = new Thread(this);
        thCash.setName("Касса № " + idCashier);
        thCash.start();
    }

    public int getIdCashier() {
        return idCashier;
    }

    public void setIdCashier(int idCashier) {
        this.idCashier = idCashier;
    }

    @Override
    public String toString() {
        return this.thCash.getName();
    }

    /**
     * Обслуживание покупателя
     */
    @Override
    public void serveBuyers() {
        do {
            try {
                while (sm.getQueueInCashRegister().size() != 0) {
                    //Вызываем метод с генератором случайных чисел для генерации числа в промежутке от 200 до 500 мс
                    int pause = RandomCounter.countRandom(200, 500);
                    final Buyer buyer = sm.removeBuyerFromQueueCashRegister();
                    synchronized (buyer) {
                        buyer.notify();
                    }
                    System.out.println(this + " обслуживает покупателя");
                    Thread.sleep(pause);
                    int sum = 0;
                    System.out.println(buyer.getBasket().getGoodsInBasket().size());
                    while (buyer.getBasket().getGoodsInBasket().size() != 0) {
                        Map.Entry<Good, Integer> set = buyer.getBasket().takeGoodFromBasket();
                        sum += set.getValue();
                        System.out.println(set.getKey() + " = " + set.getValue());
                    }
                    System.out.println("Общая сумма чека " + sum);
                    sm.setRevenueMarket(sm.getRevenueMarket() + sum); //Добавим сумму в выручку магазина
                    System.out.println(this + " обслужила покупателя");
                    synchronized (buyer) {
                        buyer.notify();
                    }
                }
            } catch (InterruptedException e) {
                System.out.println(this + " : некорректное завершение ожидания!");
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (sm.getManager().closeCashiers()) {
                break;
            }

//                synchronized (lockCashier) {
//                    try {
//                        lockCashier.wait();
//                    } catch (InterruptedException e) {
//                        break;
//                    }
//
//            }

        }
        while (true);
System.out.println(this + " закрылась");
        }


    @Override
    public void run() {
        serveBuyers();
    }
}
