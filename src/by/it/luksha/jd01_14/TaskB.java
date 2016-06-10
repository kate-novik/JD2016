package by.it.luksha.jd01_14;

import java.io.*;
import java.util.Scanner;


public class TaskB {
    private static String src = System.getProperty("user.dir") + "/src/by/it/luksha/jd01_14/data/";

    /**
     * Читает текст из файла и считает в нем кол-во слов и кол-во знаков препинания
     * @param fileName имя файла
     * @throws IOException
     */
    protected static void readTxtFile(String fileName) throws IOException {
        int countW = 0; //счетчик слов
        int countP = 0; //счетчик знаков препинания

        Scanner scanner = null;

        try {
            //поиск слов
            scanner = new Scanner(new File(src + fileName));
            scanner.useDelimiter("[^a-zA-Z]+");
            while (scanner.hasNext()) {
                scanner.next();
                countW++;
            }
            scanner.close();

            //поиск знаков препинания
            scanner = new Scanner(new File(src + fileName));
            scanner.useDelimiter("[^,\\.\\?!:;]+");
            while (scanner.hasNext()) {
                scanner.next();
                countP++;
            }

            //вывод счетчиков в консоль
            System.out.println("Слов в файле: " + countW);
            System.out.println("Знаков в файле: " + countP);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}
