package by.it.smirnova.jd01_08;


public class MatrixPrinter extends AbstractPrinter {

    public void print(String text)
    {
        System.out.println("MatrixPrinter печатает текст: " + text );
    }

    public void print(double number)
    {
        System.out.println("MatrixPrinter печатает вещественное число: " + number);
    }

    public void print(long number)
    {
        System.out.println("MatrixPrinter печатает целое число: " + number);
    }

    public void startPage()
    {
        state = PrinterState.PRINTING;
        System.out.println("MatrixPrinter начинает печатать новую страницу");
    }

    public void endPage()
    {
        state = PrinterState.WAITING;
        System.out.println("MatrixPrinter заканчивает печатать страницу");
    }

    public void printNewLine()
    {
        System.out.println();
    }
}
