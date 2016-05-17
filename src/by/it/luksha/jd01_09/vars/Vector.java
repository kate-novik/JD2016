package by.it.luksha.jd01_09.vars;

import java.util.ArrayList;

public class Vector extends Var {
    /**
     * Массив значений вектора
     */
    private double[] value;

    /**
     * Конструктор преобразующий строку в объект типа Vector
     * @param vector строка
     */
    public Vector(String vector) {
        String[] strArray = vector.split("\\{|,|\\}");
        //костыль
        ArrayList<String> array = new ArrayList<>();
        for (int i = 0; i < strArray.length; i++) {
            if (!strArray[i].isEmpty())
                array.add(strArray[i]);
        }
        //

        this.value = new double[array.size()];
        for (int i = 0; i < this.value.length; i++) {
            this.value[i] = Double.parseDouble(array.get(i));
        }
    }

    @Override
    public String toString() {
        for (int i = 0; i < this.value.length; i++) {
            System.out.printf("[%1d]=%-3.2f ",i+1, this.value[i]);
        }
        return "";
    }
}
