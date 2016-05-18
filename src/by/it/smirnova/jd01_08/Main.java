package by.it.smirnova.jd01_08;


public class Main{

    public static JetPrinter createJetPrinter()
    {
        return new JetPrinter();
    }

    public static LaserPrinter createLaserPrinter()
    {
        return new HPLaserPrinter();
    }

    public static MatrixPrinter createMatrixPrinter()
    {
        return new MatrixPrinter();
    }


    public static void main(String[] args)
    {
        JetPrinter printer1 = createJetPrinter();

        LaserPrinter printer2 = createLaserPrinter();

        MatrixPrinter printer3 = createMatrixPrinter();

        System.out.println("Будем печатать страницу на всех принтерах");
        printPage(printer1);
        printPage(printer2);
        printPage(printer3);


        System.out.println("Распечатаем тестовую страницу для матричного принтера");
        printer3.printTestPage();
    }



    public static void printPage(LaserPrinter device)
    {
        device.startPage();

        System.out.println("Printer Status: " + device.getState());

        device.print(12345);

        device.print("Hello, world! on Laser Printer");

        device.print(678.0);

        device.endPage();

        device.printNewLine();
    }

    public static void printPage(MatrixPrinter device)
    {
        device.startPage();

        device.print(12345);

        device.print("Hello, world! on Matrix Printer");

        device.print(678.0);

        device.endPage();

        device.printNewLine();
    }


    public static void printPage(PrintingDevice device)
    {
        device.startPage();

        System.out.println("Printer Status: " + device.getState());

        device.print(12345);

        device.print("Hello, world! on any printer!");

        device.print(678.0);

        device.endPage();

        System.out.println("Printer Status: " + device.getState());

        device.printNewLine();


    }

}
