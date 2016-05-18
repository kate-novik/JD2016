package by.it.luksha.jd01_09.operations;

import by.it.luksha.jd01_09.vars.Var;

public abstract class Operation implements IOperation{
    public Var add(Var var1, Var var2) {
        System.out.println("Операция невозможна!");
        return null;
    }
    public Var sub(Var var1, Var var2) {
        System.out.println("Операция невозможна!");
        return null;
    }
    public Var mult(Var var1, Var var2) {
        System.out.println("Операция невозможна!");
        return null;
    }
    public Var div(Var var1, Var var2) {
        System.out.println("Операция невозможна!");
        return null;
    }
}
