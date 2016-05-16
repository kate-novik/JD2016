package by.it.novik.jd01_08;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kate Novik.
 */
public abstract class Cupboards implements IFurniture {
    // Укажем состояние для всех шкафов по закрытию
    private boolean stateOpen;
    // Укажем состояние для всех шкафов по собранности
    private boolean stateAssemble;
    // Укажем координаты положения шкафа
    private double stateX;
    private double stateY;
    // Укажем список вещей
    private List <Things> listOfThings;

    public Cupboards (){
        this.listOfThings = new ArrayList<>();
        this.stateX = 0;
        this.stateY = 0;
        this.stateOpen = false;
        this.stateAssemble = true;
    }

    @Override
    public boolean open (){
        stateOpen = true; // При открытии поле состояние открытия получает значение true
        return stateOpen;
    }

    @Override
    public boolean close (){
        stateOpen = false; // При закрытии поле состояние открытия получает значение false
        return stateOpen;
    }

    @Override
    public boolean putThing (Things thing){
        if (thing != null) { // Проверка на не пустой объект
          //  listOfThings.add(thing);
            return true;
        }
        return false;
    }

    @Override
    public Things takeThing (String nameThing){
        if (!nameThing.isEmpty()) { // Проверка на не пустое название вещи
     //       for (Things thing : listOfThings) {
      //          if (thing.getNameThing().equals(nameThing)) {
       //             listOfThings.remove(thing);
     //           }
     //           return thing;
     //       }
        }
        return null;
    }

    @Override
    public double[] move (double[] xyNext){
        double stateX = this.stateX + xyNext[0]; // Перемещение по X шкафа
        double stateY = this.stateY + xyNext[1]; // Перемещение по Y шкафа
        return new double[] {stateX,stateY};
    }

    public boolean assemble (){
        stateAssemble = true;
        return stateAssemble;
    }

    @Override
    public boolean disassemble (){
        if (clean()) {
            stateOpen = true;
            stateAssemble = false;
        }
        return stateAssemble;
    }

    @Override
    public boolean clean () {
        listOfThings.clear();
        return true;
    }

    public abstract void showState ();
    public abstract boolean sortThings ();

    public List <Things> getListOfThings (){ return listOfThings; }
    public boolean getStateOpen () { return stateOpen; }
    public boolean getStateAssemble () { return stateAssemble; }
    public double getStateX () { return stateX; }
    public double getStateY () { return stateY; }
    public void setStateX (double stateX) { this.stateX = stateX; }
    public void setStateY (double stateY) { this.stateY = stateY; }
}
