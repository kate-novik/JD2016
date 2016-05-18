package by.it.smirnova.jd01_08;


public class LaserPrinter extends AbstractPrinter{

    public void print(String text)
    {
        System.out.println("LaserPrinter печатает текст: " + text );
    }

    public void print(double number)
    {
        System.out.println("LaserPrinter печатает вещественное число: " + number);
    }

    public void print(long number)
    {
        System.out.println("LaserPrinter печатает целое число: " + number);
    }

    public void startPage()
    {
        state = PrinterState.PRINTING;
        System.out.println(this.getClass().getSimpleName() + " начинает печатать новую страницу");
    }

    public void endPage()
    {
        state = PrinterState.WAITING;
        System.out.println("LaserPrinter заканчивает печатать страницу");
    }

    public void printNewLine()
    {
        System.out.println();
    }

    public void printTestPage()
    {
        this.print("Добавление к тестовой странице для LaserPrinter");
        super.printTestPage();

    }
}
