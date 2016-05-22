package by.it.luksha.jd01_09.io;

import by.it.luksha.jd01_09.operations.Operation;
import by.it.luksha.jd01_09.vars.Var;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Reader {

    /**
     * Запускает чтение из строки
     * @throws IOException
     */
    public static void startReadConsole() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        while(!line.isEmpty())
        {
            analysisLine(line);
            line = reader.readLine();
        }
    }

    /**
     * Определяет что делать с вводимой строкой
     * @param line строка
     */
    private static void analysisLine(String line) {
        String plus = "+";
        String minus = "-";
        String division = "/";
        String multiply = "*";
        String bind = "=";
        Var var1;
        Var var2;

        //проверка вводимых значений
        if (!line.equals("printvar") && !line.equals("sortvar")) {
            //нахождение переменных
            Var[] vars = Parser.toVars(line);
            var1 = vars[0];
            var2 = vars[1];
            //нахождение знака операции
            String operation = Parser.checkOperation(line);
            if (!operation.equals(bind)) {
                if (plus.equals(operation)) {
                    System.out.println("Результат: ");
                    System.out.println(Operation.add(var1, var2));
                } else if (minus.equals(operation)) {
                    System.out.println("Результат: ");
                    System.out.println(Operation.sub(var1, var2));
                } else if (division.equals(operation)) {
                    System.out.println("Результат: ");
                    System.out.println(Operation.div(var1, var2));
                } else if (multiply.equals(operation)) {
                    System.out.println("Результат: ");
                    System.out.println(Operation.mult(var1, var2));
                } else {
                    System.out.println("Такой операции не существует");
                }
            }
            else if (bind.equals(operation)) {
                System.out.println("присваивание");
            }
        }
        else if (line.equals("printvar")) {
            //TODO: вывод всех присвоенных значений
            System.out.println("вывод всех присвоенных значений");
        }
        else if (line.equals("sortvar")) {
            //TODO: сортировка и вывод всех значений
            System.out.println("сортировка и вывод всех значений");
        }
    }

}
