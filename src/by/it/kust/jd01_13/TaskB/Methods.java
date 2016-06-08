package by.it.kust.jd01_13.TaskB;

/**
 * Created by Tanya Kust.
 */
public class Methods {
    void firstMethod() throws Exception{
        System.out.println("Первый метод. Начало.");
            secondMethod();
        System.out.println("Первый метод. Конец.");
    }

    void secondMethod() throws Exception{
        System.out.println("Второй метод. Начало.");
            thirdMethod();
        System.out.println("Второй метод. Конец.");
    }

    void thirdMethod() throws Exception{
        System.out.println("Третий метод. Начало.");
            int a = 0;
            double div = 1/a;
        System.out.println("Третий метод. Конец.");
    }
}
