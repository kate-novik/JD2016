package by.it.sinkevich.jd01_09.variables;

import by.it.sinkevich.jd01_09.parser.Patterns;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public MathLabMatrix(String matrix) {
        setValue(matrix);
    }

    public MathLabMatrix(MathLabMatrix matrix) {
        value = new Double[matrix.value.length][matrix.value[0].length];
        for (int i = 0; i < matrix.value.length; i++) {
            System.arraycopy(matrix.value[i], 0, value[i], 0, matrix.value[0].length);
        }
    }

    public int getRows() {
        return value.length;
    }

    public int getColumns() {
        return value[0].length;
    }

    @Override
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
    public void setValue(String strFrom) {
        if (!strFrom.trim().matches(Patterns.regexMatrix)) {
            System.out.println("Запись матрицы невозможна!");
        }
        Pattern pattern = Pattern.compile(Patterns.regexVector);
        Matcher matcher = pattern.matcher(strFrom);
        List<Double[]> vectors = new ArrayList<>();
        while (matcher.find()) {
            String vector = matcher.group();
            String replaced = vector.replaceAll("[\\}\\{,]", " ");
            String[] valuesStr = replaced.trim().split(" +");
            Double[] tempVector = new Double[valuesStr.length];
            for (int i = 0; i < valuesStr.length; i++) {
                tempVector[i] = Double.parseDouble(valuesStr[i]);
            }
            vectors.add(tempVector);
        }
        value = new Double[vectors.size()][vectors.get(0).length];
        for (int i = 0; i < vectors.size(); i++) {
            value[i] = vectors.get(i);
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("{{");
        for (int rows = 0; rows < value.length; rows++) {
            for (int cols = 0; cols < value[rows].length; cols++) {
                String formatStr;
                if (cols != value[rows].length - 1) {
                    formatStr = String.format("% 7.2f,", value[rows][cols]);
                } else {
                    formatStr = String.format("% 7.2f}", value[rows][cols]);
                }
                stringBuilder.append(formatStr);
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
