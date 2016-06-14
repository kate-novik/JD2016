package by.it.luksha.jd02_01;

/**
 * Created by MMauz on 14.06.2016.
 */
public class Market {
    private String name;
    private static int counterBuyer = 0;
    private long deltaTime;

    public Market(String name) {
        this.name = name;
    }

    /**
     * Открывает маркет
     */
    public void openMarket() {
        long start = System.currentTimeMillis();
        while (counterBuyer < 100) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("Ошибка ожидания в магазине");
            }
            int buyers = Utils.randInt(0, 2);
            for (int i = 0; i < buyers; i++) {
                counterBuyer++;
                Buyer buyer = new Buyer(String.valueOf(counterBuyer), (Utils.randInt(1, 4) != 4) ? false : true);
            }
        }
        long end = System.currentTimeMillis();
        this.deltaTime = (end - start)/1000;
        closeMarket();
    }

    /**
     * Закрывает маркет
     */
    public void closeMarket() {
        System.out.printf("Супермаркет %s работал %d секунд, обслужил %d клиента(ов)", this.name, this.deltaTime, counterBuyer);
    }
}
