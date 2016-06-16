package by.it.luksha.jd02_03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import static by.it.luksha.jd02_03.Utils.print;
import static by.it.luksha.jd02_03.Utils.randInt;
import static by.it.luksha.jd02_03.Utils.sleepIn;

/**
 * Created by MMauz on 14.06.2016.
 */
public class Cashier implements Runnable {
    private Market market;
    private String name;
    private int number;
    private double bill = 0;

    public Cashier(Market market, int number) {
        this.market = market;
        this.number = number;
        this.name = "Касса " + number;
    }

    public String getName() {
        return name;
    }

    @Override
    public void run() {
        this.market.incCountWorksCashier();
        System.out.printf("%s открыта\n", this.getName());
        do {
            if (market.getQueue().size() > 5 || this.market.getCountWorksCashier().get() < 1) {
                //System.out.println("Человек в очереди:" + market.getQueue().size());
                print("Человек в очереди:" + market.getQueue().size());
                Buyer buyer = market.getQueue().remove();
                sleepIn(randInt(2000, 5000));
                String check = printCheck(buyer);
                //System.out.printf("[%s]: %s\n%s", this.name, buyer.toString(), check);
                print(String.format("[%s]: %s\n%s", this.name, buyer.toString(), check));
                double checkBuyer = check(buyer); //сумма чека покупателя
                this.bill += checkBuyer; //увеличиваем сумму кассы
                this.market.setBill(checkBuyer); //увеличиваем выручку маркета на сумму чека
                System.out.println(printAllCashier()); //выводим сводную таблицу по всем кассам
                synchronized (buyer) {
                    buyer.setiWait(false);
                    buyer.notify();
                }

            } else if (market.getQueue().size() < 5) {
                //System.out.printf("%s закрыта на перерыв\n", this.getName());
                print(String.format("%s закрыта на перерыв", this.getName()));
                this.market.decCountWorksCashier();
                sleepIn(5000);
                //System.out.printf("%s открыта после перерыва\n", this.getName());
                print(String.format("%s открыта после перерыва", this.getName()));
                this.market.incCountWorksCashier();
            }
        } while (this.market.getBill() < 500);
        this.market.closeMarket();

    }

    /**
     * Печатает чек покупателя
     * @param buyer покупатель
     */
    private String printCheck(Buyer buyer) {
        double sumCheck = 0;
        StringBuilder check = new StringBuilder();
        check.append("===========================\n");
        HashMap<Goods, Integer> basket = buyer.getBasket();
        for (Map.Entry<Goods, Integer> pair: basket.entrySet()) {
            Goods goods = pair.getKey();
            int count = pair.getValue();
            sumCheck += goods.getPrice() * count;
            String toCheck = String.format("%s x %d шт. = %.2fр\n", goods.toString(), count, goods.getPrice() * count);
            check.append(toCheck);
        }
        check.append(String.format("Сумма чека: %.2fр\n", sumCheck));
        check.append("===========================");
        return check.toString();
    }

    /**
     * Считает сумму чека покупателя
     * @param buyer покупатель
     * @return сумма чека
     */
    private double check(Buyer buyer) {
        double sumCheck = 0;
        HashMap<Goods, Integer> basket = buyer.getBasket();
        for (Map.Entry<Goods, Integer> pair: basket.entrySet()) {
            Goods goods = pair.getKey();
            int count = pair.getValue();
            sumCheck += goods.getPrice() * count;
        }
        return sumCheck;
    }

    /**
     * Печатает сводную информацию по кассам и маркету
     * @return строка с информацией
     */
    private String printAllCashier() {
        ArrayList<Cashier> list = market.getCashierArrayList();
        StringBuilder string = new StringBuilder();
        //вывод заглавной строки
        for (int i = 0; i < list.size(); i++) {
            string.append(String.format("%s |", list.get(i).getName()));
        }
        int size = 9; // ширина столбца
        string.append("Очередь | Выручка\n"); // добавление столбцов
        int firstPosition = string.length(); // размер строки с заголовками столбцов и первая позиция для вставки значений
        //добавление пробелов в строку для вставки значений - костыль
        for (int i = 0; i < firstPosition*2; i++) {
            string.insert(firstPosition, " ");
        }

        //вставка значений
        string.insert(firstPosition + (number-1)*size, String.format("%.2f", this.bill)); //добавление баланса текущей кассы
        string.insert(firstPosition + list.size()*size, String.valueOf(market.getQueue().size())); //добавление размера очереди
        string.insert(firstPosition + list.size()*size + size, String.format("%.2f", market.getBill())); //добавление выручки маркета

        //System.out.println(string); //вывод строки в консоль
        return String.valueOf(string);
    }
}
