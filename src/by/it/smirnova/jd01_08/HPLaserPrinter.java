package by.it.smirnova.jd01_08;


public class HPLaserPrinter extends LaserPrinter {

    public HPLaserPrinter()
    {
        System.out.println("Конструируем объект класса HPLaserPrinter");
    }


    public void print(String text)
    {
        System.out.println("HPLaserPrinter printing text: " + text);
    }


    @Override
    public String toString()
    {
        return "My HPLaserPrinter! do not touch!";
    }
}
