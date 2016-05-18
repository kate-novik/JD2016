package by.it.smirnova.jd01_08;


public abstract class AbstractPrinter implements PrintingDevice {

    protected PrinterState state;

    @Override
    public PrinterState getState() {
        return state;
    }

    @Override
    public void printTestPage()
    {
        this.startPage();

        this.print("Тестовая страница");

        this.endPage();

        this.printNewLine();
    }
}
