package by.it.drachyova.jd01_08;

//Вариант 4 interface Здание <-- abstract class Общественное Здание <-- class Театр
public class Runner {
    public static void main(String[] args) {
        PublicBuilding opera = new Theatre();
        opera.setName("Опера");
        System.out.println(opera.getName());
        TheatreVisitor visitor = new TheatreVisitor("Иван", 30);
        opera.openDoors();
        opera.turnOnLight();
        if(opera.openDoors()&&opera.turnOnLight()) {
            visitor.visitTheatre();
        }
        if (visitor.getIsVisited()){
            opera.clean();
            opera.turnOffLight();
            opera.closeDoors();
        }
        opera.showState();
        opera.repair();
        opera.destroy();
    }
}
