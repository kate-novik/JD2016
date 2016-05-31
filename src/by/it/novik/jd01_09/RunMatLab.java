package by.it.novik.jd01_09;

import by.it.akhmelev.jd01_07.matrixOk.Matrix;
import by.it.novik.jd01_09.entity.DoubleValue;
import by.it.novik.jd01_09.entity.MatrixValue;
import by.it.novik.jd01_09.entity.Variable;
import by.it.novik.jd01_09.entity.VectorValue;
import by.it.novik.jd01_09.io.InOutImpl;
import by.it.novik.jd01_09.operations.*;
import by.it.novik.jd01_09.utils.Calculate;
import by.it.novik.jd01_09.utils.ParsingInput;

import java.io.IOException;
import java.util.List;

/**
 * Created by Kate Novik.
 */
public class RunMatLab {
    public static void main(String[] args) throws IOException {
        AddOperations operAdd = new AddOperations();
        SubOperations operSub = new SubOperations();
        MultiOperations operMulti = new MultiOperations();
        DivOperations operDiv = new DivOperations();
        InOutImpl inout = new InOutImpl();

        String vec = "{1,2,3}";
        String m = "{{1,2,3},{4,5,6},{7,8,9}}";

        // Операции со скалярными величинами
//        System.out.println("Операции со скаларной величиной");
//        System.out.println(operAdd.addition(new DoubleValue(26.2),new DoubleValue(26.2)));
//        System.out.println(operAdd.addition(new DoubleValue(26.2),new VectorValue(vec)));
//        System.out.println(operAdd.addition(new DoubleValue(26.2),new MatrixValue(m)));
//
//        System.out.println(operSub.subtraction(new DoubleValue(26.2),new DoubleValue(23.1)));
//        System.out.println(operSub.subtraction(new DoubleValue(26.2),new VectorValue(vec)));
//        System.out.println(operSub.subtraction(new DoubleValue(26.2),new MatrixValue(m)));
//
//        System.out.println(operMulti.multiplication(new DoubleValue(26.2),new DoubleValue("5.9")));
//        System.out.println(operMulti.multiplication(new DoubleValue(26.2),new VectorValue(vec)));
//        System.out.println(operMulti.multiplication(new DoubleValue(26.2),new MatrixValue(m)));
//
//        System.out.println(operDiv.division(new DoubleValue(26.2),new DoubleValue("8.5")));
//        System.out.println(operDiv.division(new DoubleValue(26.2),new VectorValue(vec)));
//        System.out.println(operDiv.division(new DoubleValue(26.2),new MatrixValue(m)));
//
//        System.out.println("/n Операции с матрицой");
//        System.out.println(operAdd.addition(new MatrixValue(m),new DoubleValue(26.2)));
//        System.out.println(operAdd.addition(new MatrixValue(m),new VectorValue(vec)));
//        System.out.println(operAdd.addition(new MatrixValue(m),new MatrixValue(m)));
//
//        System.out.println(operSub.subtraction(new MatrixValue(m),new DoubleValue(23.1)));
//        System.out.println(operSub.subtraction(new MatrixValue(m),new VectorValue(vec)));
//        System.out.println(operSub.subtraction(new MatrixValue(m),new MatrixValue(m)));
//
//        System.out.println(operMulti.multiplication(new MatrixValue(m),new DoubleValue("5.9")));
//        System.out.println(operMulti.multiplication(new MatrixValue(m),new VectorValue(vec)));
//        System.out.println(operMulti.multiplication(new MatrixValue(m),new MatrixValue(m)));
//
//        System.out.println(operDiv.division(new MatrixValue(m),new DoubleValue("8.5")));
//        System.out.println(operDiv.division(new MatrixValue(m),new VectorValue(vec)));
//        System.out.println(operDiv.division(new MatrixValue(m),new MatrixValue(m)));
//
//        System.out.println("/nОперации с вектором");
//        System.out.println(operAdd.addition(new VectorValue(vec),new DoubleValue(26.2)));
//        System.out.println(operAdd.addition(new VectorValue(vec),new VectorValue(vec)));
//        System.out.println(operAdd.addition(new VectorValue(vec),new MatrixValue(m)));
//
//        System.out.println(operSub.subtraction(new VectorValue(vec),new DoubleValue(26.2)));
//        System.out.println(operSub.subtraction(new VectorValue(vec),new VectorValue(vec)));
//        System.out.println(operSub.subtraction(new VectorValue(vec),new MatrixValue(m)));
//
//        System.out.println(operMulti.multiplication(new VectorValue(vec),new DoubleValue(26.2)));
//        System.out.println(operMulti.multiplication(new VectorValue(vec),new VectorValue(vec)));
//        System.out.println(operMulti.multiplication(new VectorValue(vec),new MatrixValue(m)));
//
//        System.out.println(operDiv.division(new VectorValue(vec),new DoubleValue(26.2)));
//        System.out.println(operDiv.division(new VectorValue(vec),new VectorValue(vec)));
//        System.out.println(operDiv.division(new VectorValue(vec),new MatrixValue(m)));

        //Ввод с консоли
        String line=inout.input();
        Calculate calculate = new Calculate();
        inout.output(calculate.calculateExp(line));

    }


}
