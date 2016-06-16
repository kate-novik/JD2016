package by.it.novik.jd02_03.entities;

import by.it.novik.jd02_03.interfaces.IManager;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * Created by Kate Novik.
 */
public class Manager implements IManager {
    //Поле id мэнеджера
    private int idMan;
    //Поле Executor для запуска касс
    private ExecutorService executor;
    //Поле объекта супермаркет
    private Supermarket sm;


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
        //Запускаем пул потоков касс
        executor = Executors.newFixedThreadPool(count);
        for (int i=1; i<=count; i++) {
            Cashier cashier = new Cashier(i,sm);
            //Запускаем поток кассира
            executor.execute(cashier);
            sm.getListCashiers().add(cashier);
        }
    }

    /**
     * Открытие кассы в магазине при появлении покупателей
     */
    @Override
    public void openCashier() {
        //При появлении одного покупателя открываем кассу или через каждые 5 появившихся покупателей в очереди открываем новую кассу
        if(sm.getQueueInCashRegister().size() == 1 || sm.getQueueInCashRegister().size() % 5 == 0) {
            for (Cashier cashier : sm.getListCashiers()) {
                if (cashier.getThCash().getState() == Thread.State.WAITING) {
                    synchronized (cashier) {
                        cashier.cashWait = false;
                        cashier.notify();
                    }
                    break;
                }
            }
        }
    }

    /**
     * Закрытие касс в конце дня
     */
    public boolean closeCashiers() {
        if (sm.getCountBuyers() == 0) {
            for (Cashier cashier : sm.getListCashiers()) {

                synchronized (cashier) {
                    cashier.cashWait = false;
                    cashier.notify();
                }
            }
           executor.shutdown(); //Остановка потоков после завершения работы касс
            return true;
        }
return false;
    }


}
