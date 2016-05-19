package by.it.drachyova.jd01_08;


public abstract class PublicBuilding implements IBuilding{
    private String name;//название здания
    private boolean stateRepaired;//был ли произведен ремонт
    private boolean stateCleaned;//была ли произведена уборка
    private boolean stateOpened;//открыты ли двери
    private boolean stateLightOn;//включен ли свет
    public PublicBuilding(){
        stateRepaired=false;
        stateCleaned=false;
        stateOpened=true;
        stateLightOn=true;
    }
    public void setName(String name){//метод устанавливает название здания
        this.name=name;
    }
    public String getName(){//метод возращает название здания
        return this.name;
    }
    public void destroy() { // метод разрушает здание
        System.out.println("Здание разрушено!");
    }
    public boolean repair(){// метод производит ремонт здания
        stateRepaired=true;
        return stateRepaired;
    }
    public boolean clean() {// метод производит уборку здания
        stateCleaned = true;
        return stateCleaned;
    }
    public boolean openDoors(){// метод открывает двери здания
     stateOpened=true;
        return stateOpened;
    }
    public boolean closeDoors(){// метод закрывает двери здания
        stateOpened=false;
        return stateOpened;
    }
    public boolean turnOnLight(){// метод включает свет в здании
        stateLightOn=true;
        return stateLightOn;
    }
    public boolean turnOffLight() {// метод выключает свет в здании
        stateLightOn=false;
        return stateLightOn;
    }
    public void showState(){}//метод показывает текущее состояние здания
}
