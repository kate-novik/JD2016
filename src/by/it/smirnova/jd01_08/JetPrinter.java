package by.it.smirnova.jd01_08;


public class JetPrinter extends AbstractPrinter{

    public void print(String text){
        System.out.println("JetPrinter печатает текст: " + text);
    }

    public void print(double number){
        System.out.println("JetPrinter печатает вещественное число: " + number);
    }

    public void print(long number){
        System.out.println("JetPrinter печатает целое число: " + number);
    }

    public void startPage(){
        state = PrinterState.PRINTING;
        System.out.println("JetPrinter начинает печатать новую страницу");
    }

    public void endPage(){
        state = PrinterState.WAITING;
        System.out.println("JetPrinter заканчивает печатать страницу");
    }

    public void printNewLine()
    {
        System.out.println();
    }
}
