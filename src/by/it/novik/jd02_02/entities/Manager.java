package by.it.novik.jd02_02.entities;

import by.it.novik.jd02_02.interfaces.IManager;

import java.util.List;


/**
 * Created by Kate Novik.
 */
public class Manager implements IManager {
    //Поле id мэнеджера
    private int idMan;
    //Поле объекта супермаркет
    private Supermarket sm;
    //Поле для синхронизации кассиров
    private final static Integer lockCashier = 0;

    public Manager(int idMan, Supermarket sm) {
        this.idMan = idMan;
        this.sm = sm;

    }

    /**
     * Создание касс
     * @param count Количество касс
     */
    @Override
    public void createCashiers(int count) {
        for (int i=1; i<=count; i++) {
            sm.getListCashiers().add(new Cashier(i,sm));
        }
    }

    /**
     * Открытие кассы в магазине при появлении покупателей
     */
    @Override
    public void openCashier() {
        //При появлении одного покупателя открываем кассу
        if(sm.getQueueInCashRegister().size() == 1) {
//            Cashier cashier = new Cashier(sm.getListCashiers().size()+1,sm);
//            sm.getListCashiers().add(cashier);
//            System.out.println("Менеджер открыл" + cashier.toString());
            synchronized (lockCashier) {
                    lockCashier.notify();
                }
        } //Через каждые 5 появившихся покупателей в очереди открываем новую кассу
            else if (sm.getQueueInCashRegister().size()>5 && (sm.getQueueInCashRegister().size() % 5 == 0)) {
//            Cashier cashier = new Cashier(sm.getListCashiers().size()+1,sm);
//            sm.getListCashiers().add(cashier);
//            System.out.println("Менеджер открыл" + cashier.toString());
            synchronized (lockCashier) {
                lockCashier.notify();
            }
        }

    }

    /**
     * Закрытие касс в конце дня
     */
    public boolean closeCashiers() {
        if (sm.getCountBuyers() == 0)
        {
            return true;
        }
return false;
    }


}
