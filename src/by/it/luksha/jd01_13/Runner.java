package by.it.luksha.jd01_13;

import by.it.luksha.jd01_13.taskC.exeption.SurgeonException;


/**
 * Created by MMauz on 09.06.2016.
 */
public class Runner {
    public static void main(String[] args) throws SurgeonException {

        //TaskA
        TaskA.run();

        //TaskB
        try {
            TaskB.run();
        } catch (Exception e) {
            System.out.printf("Ошибка >>>%s<<< обработана в main\n", e.getMessage());
        }

        //TaskC
        TaskC.run();
    }
}
