package by.it.drachyova.jd01_08;


public class Theatre extends PublicBuilding implements IBuilding{
    public Theatre(){
        super();
        setName("Театр");
    }
    @Override
    public void destroy(){
        System.out.println("Театр разрушен");

    }
    @Override
    public void showState(){//метод показывает текушее состояние театра
        if(this.repair()){
            System.out.println("Театр отремонтирован");
        }
        if(this.clean()){
            System.out.println("Театр убран");
        }
        if(this.openDoors()){
            System.out.println("Двери театра открыты");
        }
        if(!this.closeDoors()){
            System.out.println("Двери театра закрыты");
        }
        if(this.turnOnLight()){
            System.out.println("Свет в театре включен");
        }
        if(!this.turnOffLight()){
            System.out.println("Свет в театре выключен");
        }
    }
}
