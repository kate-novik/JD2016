package by.it.luksha.jd02_02;

/**
 * Created by MMauz on 14.06.2016.
 */
public interface IBuyer {
    void enterToMarket(); //вошел в магазин (мгновенно)
    void chooseGoods(); //выбрал товар (от 0,5 до 2 секунд)
    void goToOut(); //отправился на выход(мгновенно)
}
