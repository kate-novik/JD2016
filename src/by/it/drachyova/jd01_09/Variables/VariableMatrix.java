package by.it.drachyova.jd01_09.Variables;

import by.it.drachyova.jd01_09.interfaces.IOperation;
import by.it.drachyova.jd01_09.interfaces.IVariable;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class VariableMatrix extends AbstractVariable implements IOperation, IVariable {

    private double[][] matrix;

    public VariableMatrix(String str)//конструктор инициализирует массив полученной строкой
    {
        setValue(str);
    }

    VariableMatrix(double[][] matrix) {//конструктор иницилизирует массив полученным массивом
        this.matrix = new double[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++)
            System.arraycopy(matrix, 0, this.matrix, 0, matrix.length);
    }

    VariableMatrix(VariableMatrix init) {//конструктор-копия
        this.matrix = new double[init.matrix.length][init.matrix.length];
        for (int i = 0; i < init.matrix.length; i++)
            System.arraycopy(init.matrix, 0, this.matrix, 0, this.matrix.length);
    }

    @Override //сложение
    public AbstractVariable addition(AbstractVariable var) {

        if (var instanceof VariableDouble) {
            VariableMatrix result = new VariableMatrix(this);
            double d = ((VariableDouble) var).getValue();
            for (int i = 0; i < result.matrix.length; i++) {
                for (int j = 0; j < result.matrix[i].length; j++) {
                    result.matrix[i][j] = this.matrix[i][j] + d;
                }
            }
            return result;
        }
        if (var instanceof VariableMatrix) {
            VariableMatrix result = new VariableMatrix(this);
            VariableMatrix m = ((VariableMatrix) var);
            for (int i = 0; i < result.matrix.length; i++) {
                for (int j = 0; j < result.matrix[i].length; j++) {
                    result.matrix[i][j] = this.matrix[i][j] + m.matrix[i][j];
                }
            }
            return result;
        }

        return super.addition(var);
    }


    @Override//вычитание
    public AbstractVariable subtraction(AbstractVariable var) {

        if (var instanceof VariableDouble) {
            VariableMatrix result = new VariableMatrix(this);
            double d = ((VariableDouble) var).getValue();
            for (int i = 0; i < result.matrix.length; i++) {
                for (int j = 0; j < result.matrix[i].length; j++) {
                    result.matrix[i][j] = this.matrix[i][j] - d;
                }
                return result;
            }
        }
        if (var instanceof VariableMatrix) {
            VariableMatrix result = new VariableMatrix(this);
            VariableMatrix m = ((VariableMatrix) var);
            for (int i = 0; i < result.matrix.length; i++) {
                for (int j = 0; j < result.matrix[i].length; j++) {
                    result.matrix[i][j] = this.matrix[i][j] - m.matrix[i][j];
                }
            }
            return result;
        }

        return super.subtraction(var);
    }


    @Override//умножение
    public AbstractVariable multiplication(AbstractVariable var) {

        if (var instanceof VariableDouble) {
            VariableMatrix result = new VariableMatrix(this);
            double d = ((VariableDouble) var).getValue();
            for (int i = 0; i < result.matrix.length; i++) {
                for (int j = 0; j < result.matrix[i].length; j++) {
                    result.matrix[i][j] = this.matrix[i][j] * d;
                }
                return result;
            }
        }

        return super.multiplication(var);
    }

    @Override//деление
    public AbstractVariable division(AbstractVariable var) {
        if (var instanceof VariableDouble) {
            VariableMatrix result = new VariableMatrix(this);
            double d = ((VariableDouble) var).getValue();
            for (int i = 0; i < result.matrix.length; i++) {
                for (int j = 0; j < result.matrix[i].length; j++) {
                    result.matrix[i][j] = this.matrix[i][j] / d;
                }
                return result;
            }
        }
        return super.division(var);
    }

    @Override//преобразование в строку
    public String toString() {
        StringBuilder s = new StringBuilder("{{");
        int k = 0;
        for (double[] v : matrix) {
            for (Double m : v) {
                k++;
                s = s.append(m.toString());
                if (k % matrix.length != 0) {
                    s.append(",");
                } else if (k != matrix.length * matrix.length) {
                    s.append("},{");
                } else {
                    s.append("}}");
                }
            }
        }
        return s.toString();
    }


    @Override//заполнение из строки
    public void setValue(String str) {
        String[] elem = str.split("[\\}\\]],[\\{\\[]");
        this.matrix = new double[elem.length][elem.length];
        for (int i = 0; i < elem.length; i++) {
            Matcher mat = Pattern.compile("-?[0-9]+(\\.[0-9]+)?").matcher(elem[i]);
            int j = 0;
            while (mat.find()) {
                this.matrix[i][j] = Double.parseDouble(mat.group());
                j++;
            }
        }
    }
}

