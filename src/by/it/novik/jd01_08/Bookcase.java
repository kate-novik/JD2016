package by.it.novik.jd01_08;

/**
 * Created by Kate Novik.
 */
public class Bookcase extends Cupboards {
    // Укажем состояние для книжных шкафов по вешанью
    private boolean stateHang;

    public Bookcase () {
        super();
        stateHang = false;
    }

    public Bookcase (double stateX, double stateY) {
        super();
        stateHang = false;
        setStateX(stateX);
        setStateY(stateY);
    }

    public boolean hangBookcase () {
        stateHang = true;
    return stateHang;
    }

    @Override
    public boolean disassemble () { // Динамическое связывание
        super.disassemble();
        stateHang = false;
        return getStateAssemble();
    }

    public void showState (){
        System.out.print("Состояние книжного шкафа:");
       if (getStateAssemble()) {
           System.out.print("собран");
           if (stateHang) {
               System.out.print(", повешен"); }
           else { System.out.print(", не повешен"); }
           if (getStateOpen()) {
               System.out.print(", открыт"); }
           else { System.out.print(", закрыт"); }
       }
        else {
           System.out.print("разобран, не повешен, открыт");
       }
    }

    // Метод будет редактироваться
    public boolean sortThings (Things thing){
    return true;
    }
}
