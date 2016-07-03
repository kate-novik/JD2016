package by.it.drachyova.jd02_06;

public class Runner {
    static int mistakeCounter = 1;

    public static void main(String[] args) {
        Logger logger = Logger.getLoggerInstance();
        int[] array = new int[10];
        for (int i = 0; i < 10; i++) {
            try {
                for (int j = 0; j < array.length; j++) {
                    array[j] = (int) (Math.random() * 4 - 2);
                    double d = j / array[j];
                    Thread.sleep(1000);
                }
            } catch (ArithmeticException e) {

                logger.WriteToLog("Произошло деление на 0");
                System.out.println("Ошибка " + mistakeCounter + " записана в log.txt");
                mistakeCounter++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
