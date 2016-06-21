package by.it.sinkevich.jd01_09;

import by.it.sinkevich.jd01_09.manipulators.ExpressionSolver;
import by.it.sinkevich.jd01_09.parser.Parser;
import by.it.sinkevich.jd01_09.variables.VariablesStorage;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Основной класс, из которого стартует прорамма, используется для тестирования
 *
 * @author Sinkevich Denis
 */
public class ConsoleRunner {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();
        while (!(line.equals("-exit") || line.equals(""))) {
            if (line.equals("printvar")) {
                VariablesStorage.printVariables();
                line = reader.readLine();
                continue;
            }
            if (line.equals("sortvar")) {
                VariablesStorage.printSortedvariables();
                line = reader.readLine();
                continue;
            }
            new ExpressionSolver().solveExpression(Parser.parseLine(line));
            line = reader.readLine();
        }
    }
}
