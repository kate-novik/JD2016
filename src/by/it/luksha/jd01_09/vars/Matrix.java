package by.it.luksha.jd01_09.vars;

import java.util.ArrayList;

public class Matrix extends Var {
    /**
     * Двумерный массив значений матрицы
     */
    private double[][] value;
    private int row;
    private int col;

    public double[][] getValue() {
        return value;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public Matrix(double[][] value) {
        this.value = value;
        this.row = value.length;
        this.col = value[0].length;
    }

    /**
     * Конструктор преобразующий строку в объект типа Matrix
     * @param matrix
     */
    public Matrix(String matrix) {
        int row = 0;
        int col = 0;
        String[] rows = matrix.split("\\{\\{|\\},\\{|\\}\\}");
        //костыль
        ArrayList<String> array = new ArrayList<>();
        for (int i = 0; i < rows.length; i++) {
            if (!rows[i].isEmpty())
                array.add(rows[i]);
        }
        //
        row = array.size();
        for (int i = 0; i < array.size(); i++) {
            String[] arrCol = array.get(i).split(",");
            col = arrCol.length;
        }

        double[][] result = new double[row][col];
        for (int i = 0; i < row; i++) {
            String[] tmp = array.get(i).split(",");
            for (int j = 0; j < col; j++) {
                result[i][j] = Double.valueOf(tmp[j]);
            }
        }

        this.value = result;
    }

    @Override
    public String toString() {
        for (int i = 0; i < this.value.length; i++) {
            for (int j = 0; j < this.value[0].length; j++) {
                System.out.printf("[%1d,%1d]=%-6.2f",i+1, j+1, this.value[i][j]);
            }
            System.out.println();
        }

        return "";
    }
}
