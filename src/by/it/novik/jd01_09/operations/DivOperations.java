package by.it.novik.jd01_09.operations;


import by.it.novik.jd01_04.SLAU;
import by.it.novik.jd01_09.entity.DoubleValue;
import by.it.novik.jd01_09.entity.MatrixValue;
import by.it.novik.jd01_09.entity.Variable;
import by.it.novik.jd01_09.entity.VectorValue;
import by.it.novik.jd01_09.utils.InverseMatrix;

/**
 * Created by Kate Novik.
 */
public class DivOperations implements IDivision{

    /**
     * Перегружаем метод division
     */
    public DoubleValue division(DoubleValue valueOne, DoubleValue valueTwo) {
        DoubleValue div = new DoubleValue();
        try {
            div.setValue(valueOne.getValue() / valueTwo.getValue());
        } catch (Exception ex) {
            System.out.println("Division on null");
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

    public Variable division(Variable value1, Variable value2) {
        System.out.print("Деление невозможно!");
        return null;
    }


}
