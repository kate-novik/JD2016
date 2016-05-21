package by.it.sinkevich.jd01_09.manipulators;

import by.it.sinkevich.jd01_09.operations.IAriphmeticOperation;
import by.it.sinkevich.jd01_09.variables.MathLabFloat;
import by.it.sinkevich.jd01_09.variables.MathLabMatrix;
import by.it.sinkevich.jd01_09.variables.MathLabVariable;
import by.it.sinkevich.jd01_09.variables.MathLabVector;

/**
 * Created by Computer on 17.05.2016.
 *
 * @author Sinkevich Denis
 */
public class Manipulator implements IAriphmeticOperation {

    @Override
    public MathLabVariable addition(MathLabVariable first, MathLabVariable second) {
        return castArgumentsAndChooseTypeOfOperation(first, second, "add");
    }

    @Override
    public MathLabVariable substraction(MathLabVariable first, MathLabVariable second) {
        return castArgumentsAndChooseTypeOfOperation(first, second, "sub");
    }

    @Override
    public MathLabVariable multiplication(MathLabVariable first, MathLabVariable second) {
        return castArgumentsAndChooseTypeOfOperation(first, second, "mul");
    }

    @Override
    public MathLabVariable division(MathLabVariable first, MathLabVariable second) {
        return castArgumentsAndChooseTypeOfOperation(first, second, "div");
    }

    private MathLabVariable castArgumentsAndChooseTypeOfOperation(MathLabVariable first, MathLabVariable second, String typeOfOperation) {
        if (first instanceof MathLabFloat) {
            return castArgumentsAndChooseTypeOfOperation((MathLabFloat) first, second, typeOfOperation);
        } else if (first instanceof MathLabVector) {
            return castArgumentsAndChooseTypeOfOperation((MathLabVector) first, second, typeOfOperation);
        } else {
            return castArgumentsAndChooseTypeOfOperation((MathLabMatrix) first, second, typeOfOperation);
        }
    }

    private MathLabVariable castArgumentsAndChooseTypeOfOperation(MathLabFloat first, MathLabVariable second, String typeOfOperation) {
        if (second instanceof MathLabFloat) {
            return chooseOperation(first, (MathLabFloat) second, typeOfOperation);
        } else if (second instanceof MathLabVector) {
            return chooseOperation(first, (MathLabVector) second, typeOfOperation);
        } else {
            return chooseOperation(first, (MathLabMatrix) second, typeOfOperation);
        }
    }

    private MathLabVariable castArgumentsAndChooseTypeOfOperation(MathLabVector first, MathLabVariable second, String typeOfOperation) {
        if (second instanceof MathLabFloat) {
            return chooseOperation(first, (MathLabFloat) second, typeOfOperation);
        } else if (second instanceof MathLabVector) {
            return chooseOperation(first, (MathLabVector) second, typeOfOperation);
        } else {
            return chooseOperation(first, (MathLabMatrix) second, typeOfOperation);
        }
    }

    private MathLabVariable castArgumentsAndChooseTypeOfOperation(MathLabMatrix first, MathLabVariable second, String typeOfOperation) {
        if (second instanceof MathLabFloat) {
            return chooseOperation(first, (MathLabFloat) second, typeOfOperation);
        } else if (second instanceof MathLabVector) {
            return chooseOperation(first, (MathLabVector) second, typeOfOperation);
        } else {
            return chooseOperation(first, (MathLabMatrix) second, typeOfOperation);
        }
    }

    private MathLabVariable chooseOperation(MathLabFloat first, MathLabFloat second, String typeOfOperation) {
        switch (typeOfOperation) {
            case "add":
                return AdditionMethodContainer.addition(first, second);
            case "sub":
                return SubstractionMethodContainer.substraction(first, second);
            case "mul":
                return MultiplicationMethodContainer.multiplication(first, second);
            default:
                return DivisionMethodContainer.division(first, second);
        }
    }

    private MathLabVariable chooseOperation(MathLabFloat first, MathLabVector second, String typeOfOperation) {
        switch (typeOfOperation) {
            case "add":
                return AdditionMethodContainer.addition(first, second);
            case "sub":
                return SubstractionMethodContainer.substraction(first, second);
            case "mul":
                return MultiplicationMethodContainer.multiplication(first, second);
            default:
                return DivisionMethodContainer.division(first, second);
        }
    }

    private MathLabVariable chooseOperation(MathLabFloat first, MathLabMatrix second, String typeOfOperation) {
        switch (typeOfOperation) {
            case "add":
                return AdditionMethodContainer.addition(first, second);
            case "sub":
                return SubstractionMethodContainer.substraction(first, second);
            case "mul":
                return MultiplicationMethodContainer.multiplication(first, second);
            default:
                return DivisionMethodContainer.division(first, second);
        }
    }

    private MathLabVariable chooseOperation(MathLabVector first, MathLabFloat second, String typeOfOperation) {
        switch (typeOfOperation) {
            case "add":
                return AdditionMethodContainer.addition(first, second);
            case "sub":
                return SubstractionMethodContainer.substraction(first, second);
            case "mul":
                return MultiplicationMethodContainer.multiplication(first, second);
            default:
                return DivisionMethodContainer.division(first, second);
        }
    }

    private MathLabVariable chooseOperation(MathLabVector first, MathLabVector second, String typeOfOperation) {
        switch (typeOfOperation) {
            case "add":
                return AdditionMethodContainer.addition(first, second);
            case "sub":
                return SubstractionMethodContainer.substraction(first, second);
            case "mul":
                return MultiplicationMethodContainer.multiplication(first, second);
            default:
                return DivisionMethodContainer.division(first, second);
        }
    }

    private MathLabVariable chooseOperation(MathLabVector first, MathLabMatrix second, String typeOfOperation) {
        switch (typeOfOperation) {
            case "add":
                return AdditionMethodContainer.addition(first, second);
            case "sub":
                return SubstractionMethodContainer.substraction(first, second);
            case "mul":
                return MultiplicationMethodContainer.multiplication(first, second);
            default:
                return DivisionMethodContainer.division(first, second);
        }
    }

    private MathLabVariable chooseOperation(MathLabMatrix first, MathLabFloat second, String typeOfOperation) {
        switch (typeOfOperation) {
            case "add":
                return AdditionMethodContainer.addition(first, second);
            case "sub":
                return SubstractionMethodContainer.substraction(first, second);
            case "mul":
                return MultiplicationMethodContainer.multiplication(first, second);
            default:
                return DivisionMethodContainer.division(first, second);
        }
    }

    private MathLabVariable chooseOperation(MathLabMatrix first, MathLabVector second, String typeOfOperation) {
        switch (typeOfOperation) {
            case "add":
                return AdditionMethodContainer.addition(first, second);
            case "sub":
                return SubstractionMethodContainer.substraction(first, second);
            case "mul":
                return MultiplicationMethodContainer.multiplication(first, second);
            default:
                return DivisionMethodContainer.division(first, second);
        }
    }

    private MathLabVariable chooseOperation(MathLabMatrix first, MathLabMatrix second, String typeOfOperation) {
        switch (typeOfOperation) {
            case "add":
                return AdditionMethodContainer.addition(first, second);
            case "sub":
                return SubstractionMethodContainer.substraction(first, second);
            case "mul":
                return MultiplicationMethodContainer.multiplication(first, second);
            default:
                return DivisionMethodContainer.division(first, second);
        }
    }
}
