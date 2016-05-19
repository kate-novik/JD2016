package by.it.drachyova.jd01_08;

/**
 * Здесь описываются возможные действия со зданием
 * Задание 4 interface Здание <-- abstract class Общественное Здание <-- class Театр
 */

public interface IBuilding {
    void destroy(); //1. метод разрушает здание
    boolean repair();//2. метод производит ремонт здания
    boolean clean();//3. метод производит уборку здания
    boolean openDoors();//4. метод открывает двери здания
    boolean closeDoors();//5. метод закрывает двери здания
    boolean turnOnLight();//6. метод включает свет в здании
    boolean turnOffLight();//7. метод выключает свет в здании

}
