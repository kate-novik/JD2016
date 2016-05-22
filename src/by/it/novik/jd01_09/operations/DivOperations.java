package by.it.novik.jd01_09.operations;

import by.it.novik.jd01_09.entity.DoubleValue;
import by.it.novik.jd01_09.entity.MatrixValue;
import by.it.novik.jd01_09.entity.Variable;
import by.it.novik.jd01_09.entity.VectorValue;
import by.it.novik.jd01_09.errors.ErrorOperations;
import by.it.novik.jd01_09.utils.InverseMatrix;

/**
 * Created by Kate Novik.
 */
public class DivOperations implements IDivision{

    /**
     * Override метода Деление переменных
     * @param value1 Переменная 1
     * @param value2 Переменная 1
     * @return Результат вычисления
     */
    public Variable division(Variable value1, Variable value2) {
        new ErrorOperations().error("Деление невозможно");
        return null;
    }

    //Перегрузки метода division при различных входных переменных

    public DoubleValue division(DoubleValue valueOne, DoubleValue valueTwo) {
        DoubleValue div = new DoubleValue();
        try {
            div.setValue(valueOne.getValue() / valueTwo.getValue());
        } catch (Exception ex) {
            new ErrorOperations().error("Division on null!");
        }
        return div;
    }

    public MatrixValue division(MatrixValue valueOne, DoubleValue valueTwo) {
        return new MultiOperations().multiplication(division(new DoubleValue(1), valueTwo), valueOne);
    }

    public MatrixValue division(MatrixValue valueOne, MatrixValue valueTwo) {
        return new MultiOperations().multiplication(valueOne, new MatrixValue(InverseMatrix.inverseMatrix(valueTwo.getValue())));
    }

    public VectorValue division(VectorValue value1, DoubleValue value2) {
        VectorValue div = new VectorValue(value1.getValue().length);
        for (int i = 0; i < value1.getValue().length; i++) {
            div.getValue() [i] = value1.getValue()[i] / value2.getValue();
        }
        return div;
    }
}
