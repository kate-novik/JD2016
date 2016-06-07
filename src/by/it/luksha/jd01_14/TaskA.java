package by.it.luksha.jd01_14;


import java.io.*;

public class TaskA {
    private static String src = System.getProperty("user.dir") + "/src/by/it/luksha/jd01_14/data/";

    /**
     * Создает бинарный файл и записывает в него 20 случайных чисел
     * @param fileName имя файла
     * @return ссылка на файл
     * @throws IOException
     */
    protected static File createFileWith20Numbers(String fileName) throws IOException {
        //создание файла в рабочем каталоге
        File file = new File(src + fileName);

        //создание потока для записи данных в файл
        DataOutputStream dataOutputStream = null;

        try {
            dataOutputStream = new DataOutputStream(new FileOutputStream(file));
            for (int i = 0; i < 20; i++) {
                dataOutputStream.writeInt((int) (Math.random() * 10));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        }
        finally {
            if (dataOutputStream != null) {dataOutputStream.close();}
        }

        return file;
    }

    /**
     * Читает числа (int) в бинарном файле, выводит их в консоль, считает среднее арифметическое всех чисел
     * @param file ссылка на файл
     * @throws IOException
     */
    protected static void readFile(File file) throws IOException {
        int sum = 0;
        int count = 0;
        DataInputStream dataInputStream = null;
        try {
            dataInputStream = new DataInputStream(new BufferedInputStream(new FileInputStream(file)));
            while (dataInputStream.available() > 0) {
                int number = dataInputStream.readInt();
                System.out.println(number);
                sum += number;
                count++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден");
        }
        finally {
            if (dataInputStream != null) {dataInputStream.close();}
        }
        System.out.println("Среднее арифметическое: " + 1.0*sum/count);
    }
}
