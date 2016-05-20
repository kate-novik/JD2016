package by.it.sinkevich.jd01_09.manipulators;

import by.it.sinkevich.jd01_09.operations.IAriphmeticOperation;
import by.it.sinkevich.jd01_09.variables.MathLabVariable;

/**
 * Created by Computer on 17.05.2016.
 *
 * @author Sinkevich Denis
 */
public class Manipulator implements IAriphmeticOperation {

    @Override
    public MathLabVariable addition(MathLabVariable first, MathLabVariable second) {
        return AdditionMethodContainer.addition(first, second);
    }

    @Override
    public MathLabVariable substraction(MathLabVariable first, MathLabVariable second) {
        return SubstractionMethodContainer.substraction(first, second);
    }

    @Override
    public MathLabVariable multiplication(MathLabVariable first, MathLabVariable second) {
        return MultiplicationMethodContainer.multiplication(first, second);
    }

    @Override
    public MathLabVariable division(MathLabVariable first, MathLabVariable second) {
        return DivisionMethodContainer.division(first, second);
    }
}
