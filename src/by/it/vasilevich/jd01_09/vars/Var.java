package by.it.vasilevich.jd01_09.vars;

import by.it.vasilevich.jd01_09.interfaces.*;
import by.it.vasilevich.jd01_09.Error;


public abstract class Var implements IAdd, ISub, IMul, IDiv {

    private Double value;

    public Var(){

    }
    //конструктор по строке
    public Var (String string){
        this.value=Double.valueOf(string);
    }
    //конструктор по значению
    public Var (Double value){
        this.value=value;
    }


    @Override
    public Var add (Var var){
        new Error ("Сложение невозможно");
        return null;
    }

    @Override
    public Var sub (Var var){
        new Error ("Вычитание невозможно");
        return null;
    }

    @Override
    public Var mul (Var var){
        new Error ("Умножение невозможно");
        return null;
    }

    @Override
    public Var div (Var var){
        new Error ("Деление невозможно");
        return null;
    }
}
