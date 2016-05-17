package by.it.kushel.jd01_08;

/**
 * Created by Diomn on 17.05.2016.
 */
public class Variable implements IVariable {
    private Double value;

    public Variable() {

    }
    public Variable(Double value) {
        this.value = value;
    }
    public Variable(String string) {
        this.value = Double.valueOf(string);
    }

    @Override
    public Variable add(Variable varAdd) {
        Variable out = new Variable();
        out.value=this.value+varAdd.value;
        return out;
    }

    @Override
    public Variable sub(Variable varSub) {
        Variable out = new Variable();
        out.value=Math.rint(100*(this.value-varSub.value))/100;
        return out;
    }

    @Override
    public Variable mul(Variable varMul) {
        Variable out = new Variable();
        out.value=this.value*varMul.value;
        return out;
    }

    @Override
    public Variable div(Variable varDiv) {
        Variable out = new Variable();
        out.value=Math.rint(100*this.value/varDiv.value)/100;
        return out;
    }
    public  String  toString(){
        return value.toString();
    }
}
