package by.it.smirnova.jd01_08;

/**

 * Задание 13 interface Устройство печати <-- abstract class Принтер <-- class Лазерный принтер .
 */
public interface PrintingDevice {

    void print(String text);

    void print(double number);

    void print(long number);

    void startPage();

    void endPage();

    void printNewLine();

    void printTestPage();

    PrinterState getState();
}
