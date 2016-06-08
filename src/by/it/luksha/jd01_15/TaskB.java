package by.it.luksha.jd01_15;

import java.io.*;

public class TaskB {
    private static String src = System.getProperty("user.dir") + "/src/by/it/luksha/jd01_15/";

    /**
     * Выводит файл с кодом без комментариев в консоль и файл
     */
    protected static void doSomething() {
        File file = new File(src + "TaskB.java");
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = null;
        int countLine = 1;

        try {
            bufferedReader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                //комментарий 1
                String redLine = line.replaceAll("//.*\\n", "");
                stringBuilder.append(String.format("%2d", countLine++) + ": " + redLine + "\n");
            }
        } catch (FileNotFoundException e) {
            System.err.printf("Ошибка cоздания файла %s", e);
        } catch (IOException e) {
            System.err.printf("Ошибка %s", e);
        }

        //вывод в консоль
        System.out.println(stringBuilder.toString());
        //вывод в файл
        File fileOut = new File(src + "data/TaskB.txt");
        PrintWriter printWriter = null;
        try {
            printWriter = new PrintWriter(new FileWriter(fileOut));
            printWriter.print(stringBuilder.toString());
        } catch (IOException e) {
            System.err.printf("Ошибка cоздания файла %s", e);
        } finally {
            if (printWriter != null) {
                printWriter.close();
            }
        }
    }
}