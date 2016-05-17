package by.it.novik.jd01_09;

import by.it.novik.jd01_09.entity.DoubleValue;
import by.it.novik.jd01_09.operations.VariablesOperations;

/**
 * Created by Kate Novik.
 */
public class RunMatLab {
    public static void main(String[] args) {
        VariablesOperations operations = new VariablesOperations();
        // Создадим переменные типа double
        DoubleValue doubleValue1 = new DoubleValue(3.8);
        DoubleValue doubleValue2 = new DoubleValue(26.2);
        System.out.println("Сложение скалярных величин");
        System.out.print(doubleValue1.getValue() + "+" + doubleValue2.getValue() + "=");
        System.out.println(operations.addition(doubleValue1,doubleValue2).toString());

        System.out.println("Вычитание скалярных величин");
        doubleValue1.setValue(87.4);
        doubleValue2.setValue(23.1);
        System.out.print(doubleValue1.getValue() + "-" + doubleValue2.getValue() + "=");
        System.out.println(operations.subtraction(doubleValue1,doubleValue2).toString());

        System.out.println("Умножение скалярных величин");
        doubleValue1.setValue(-1.04);
        doubleValue2.setValue(5.9);
        System.out.print(doubleValue1.getValue() + "*" + doubleValue2.getValue() + "=");
        System.out.println(operations.multiplication(doubleValue1,doubleValue2).toString());

        System.out.println("Деление скалярных величин");
        doubleValue1.setValue(4.5);
        doubleValue2.setValue(8.5);
        System.out.print(doubleValue1.getValue() + "/" + doubleValue2.getValue() + "=");
        System.out.println(operations.division(doubleValue1,doubleValue2).toString());


    }



}
