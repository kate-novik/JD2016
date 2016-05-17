package by.it.novik.jd01_09.operations;

import by.it.novik.jd01_09.entity.DoubleValue;
import by.it.novik.jd01_09.entity.MatrixValue;
import by.it.novik.jd01_09.entity.Variable;
import by.it.novik.jd01_09.entity.VectorValue;

/**
 * Created by Kate Novik.
 */
public class VariablesOperations implements IOperations {

    @Override
    public Variable addition(Variable valueOne, Variable valueTwo) {
        Variable result = null;

        if (valueOne instanceof DoubleValue) {
            if (valueTwo instanceof DoubleValue) {
                result = AddOperations.addDoubleAndDouble((DoubleValue)valueOne, (DoubleValue)valueTwo);
            } else if (valueTwo instanceof MatrixValue) {

            } else if (valueTwo instanceof VectorValue) {

            }
        } else if (valueOne instanceof MatrixValue) {
            if (valueTwo instanceof DoubleValue) {

            } else if (valueTwo instanceof MatrixValue) {

            } else if (valueTwo instanceof VectorValue) {

            }
        } else if (valueOne instanceof VectorValue) {
            if (valueTwo instanceof DoubleValue) {

            } else if (valueTwo instanceof MatrixValue) {

            } else if (valueTwo instanceof VectorValue) {

            }
        }
        return result;
    }

    @Override
    public Variable subtraction(Variable valueOne, Variable valueTwo) {
        Variable sub = null;
        if (valueOne instanceof DoubleValue) {
            if (valueTwo instanceof DoubleValue) {
                sub = SubOperations.subDoubleAndDouble((DoubleValue)valueOne, (DoubleValue)valueTwo);
            } else if (valueTwo instanceof MatrixValue) {

            } else if (valueTwo instanceof VectorValue) {

            }
        } else if (valueOne instanceof MatrixValue) {
            if (valueTwo instanceof DoubleValue) {

            } else if (valueTwo instanceof MatrixValue) {

            } else if (valueTwo instanceof VectorValue) {

            }
        } else if (valueOne instanceof VectorValue) {
            if (valueTwo instanceof DoubleValue) {

            } else if (valueTwo instanceof MatrixValue) {

            } else if (valueTwo instanceof VectorValue) {

            }
        }
        return sub;
    }

    @Override
    public Variable multiplication(Variable valueOne, Variable valueTwo) {
        Variable mul = null;
        if (valueOne instanceof DoubleValue) {
            if (valueTwo instanceof DoubleValue) {
                mul = MultiOperations.multipleDoubleAndDouble((DoubleValue)valueOne, (DoubleValue)valueTwo);
            } else if (valueTwo instanceof MatrixValue) {

            } else if (valueTwo instanceof VectorValue) {

            }
        } else if (valueOne instanceof MatrixValue) {
            if (valueTwo instanceof DoubleValue) {

            } else if (valueTwo instanceof MatrixValue) {

            } else if (valueTwo instanceof VectorValue) {

            }
        } else if (valueOne instanceof VectorValue) {
            if (valueTwo instanceof DoubleValue) {

            } else if (valueTwo instanceof MatrixValue) {

            } else if (valueTwo instanceof VectorValue) {

            }
        }
        return mul;
    }

    @Override
    public Variable division(Variable valueOne, Variable valueTwo) {
        Variable result = null;
        if (valueOne instanceof DoubleValue) {
            if (valueTwo instanceof DoubleValue) {
                result = DivOperations.divDoubleAndDouble((DoubleValue)valueOne, (DoubleValue)valueTwo);
            } else if (valueTwo instanceof MatrixValue) {

            } else if (valueTwo instanceof VectorValue) {

            }
        } else if (valueOne instanceof MatrixValue) {
            if (valueTwo instanceof DoubleValue) {

            } else if (valueTwo instanceof MatrixValue) {

            } else if (valueTwo instanceof VectorValue) {

            }
        } else if (valueOne instanceof VectorValue) {
            if (valueTwo instanceof DoubleValue) {

            } else if (valueTwo instanceof MatrixValue) {

            } else if (valueTwo instanceof VectorValue) {

            }
        }
        return result;
    }
}
