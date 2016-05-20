package by.it.sinkevich.jd01_09.variables;

/**
 * Created by Computer on 16.05.2016.
 *
 * @author Sinkevich Denis
 */
public class MathLabMatrix extends MathLabVariable {

    private Double[][] value;

    public MathLabMatrix() {
        value = new Double[5][5];
    }

    public MathLabMatrix(int columns, int rows) {
        if (columns > 0 && rows > 0) {
            value = new Double[rows][columns];
        } else {
            System.out.println("Размерность матрицы меньше нуля!");
        }
    }

    public MathLabMatrix(Double[][] matrix) {
        value = new Double[matrix.length][matrix[0].length];
        for (int rows = 0; rows < matrix.length; rows++) {
            System.arraycopy(matrix[rows], 0, value[rows], 0, matrix[rows].length);
        }
    }

    public int getRows() {
        return value.length;
    }

    public int getColumns() {
        return value[0].length;
    }

    public Double[][] getValue() {
        return value.clone();
    }

    public void setValue(Double[][] value) {
        this.value = new Double[value.length][value[0].length];
        for (int rows = 0; rows < value.length; rows++) {
            System.arraycopy(value[rows], 0, this.value[rows], 0, value[rows].length);
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("{{");
        for (int rows = 0; rows < value.length; rows++) {
            for (int cols = 0; cols < value[rows].length; cols++) {
                if (cols != value[rows].length - 1) {
                    String formatStr = String.format("% 5.2f,", value[rows][cols]);
                    stringBuilder.append(formatStr);
                } else {
                    String formatStr = String.format("% 5.2f}", value[rows][cols]);
                    stringBuilder.append(formatStr);
                }
            }
            if (rows != value.length - 1) {
                stringBuilder.append(",\n {");
            } else {
                stringBuilder.append("}");
            }
        }
        return stringBuilder.toString();
    }
}
