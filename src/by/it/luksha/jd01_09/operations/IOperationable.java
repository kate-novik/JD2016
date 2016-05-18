package by.it.luksha.jd01_09.operations;

import by.it.luksha.jd01_09.vars.Var;

public interface IOperationable {
    public Var add(Var var1, Var var2);
    public Var sub(Var var1, Var var2);
    public Var mult(Var var1, Var var2);
    public Var div(Var var1, Var var2);
}
