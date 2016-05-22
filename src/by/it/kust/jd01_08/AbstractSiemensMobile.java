package by.it.kust.jd01_08;

/**
 * Created by Tanya Kust on 18.05.2016.
 */
public abstract class AbstractSiemensMobile implements IMobile  {
    private String manufacturer = "Siemens";
    private String model;
    private int price;

    public AbstractSiemensMobile(String model, int price) {
        this.model = manufacturer + " " + model;
        this.price = price;
    }
    public String getModel(){return model;}
    public int getPrice(){return price;}

    public abstract void showModel();  //абстрактный метод

    @Override
    public void showPrice() {System.out.println("Цена телефона: " + getPrice());}

    @Override
    public void switchOn() {System.out.println("Телефон включен!");}

    @Override
    public void helloMessage() {System.out.println("---SIEMENS MOBILE--- ");}

    @Override
    public void checkBalance() {System.out.println("Проверка баланса...");}

    @Override
    public void flightModeOn() {System.out.println("Режим полета включен!");}

    @Override
    public void flightModeOff() {System.out.println("Режим полета выключен!");}

    @Override
    public void switchOff() {System.out.println("Телефон выключен!");}
}
