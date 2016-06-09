package by.it.luksha.jd01_15;


import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class TaskC {
    private String currentDirectory = System.getProperty("user.dir");

    private void setCurrentDirectory(String currentDirectory) {
        this.currentDirectory += "/" + currentDirectory;
    }

    private String getCurrentDirectory() {
        return currentDirectory;
    }

    /**
     * Запуск программы
     *
     * @throws IOException
     */
    protected void run() throws IOException {
        commandDIR();
        readCommand();
    }

    /**
     * Читает команды из консоли
     *
     * @throws IOException
     */
    private void readCommand() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        try {
            while ((line = bufferedReader.readLine()) != null) {
                String[] command = line.split(" {1}");
                //команды
                if (command[0].equals("cd")) { //команда cd
                    commandCD(command[1]);
                } else if (command[0].equals("dir")) { //команда dir
                    commandDIR();
                } else if (line.isEmpty()) { //пустая строка
                    break;
                } else { //прочий ввод
                    throw new IOException();
                }
            }
        } catch (IOException e) {
            System.err.printf("Не поддерживаемая команда (введите команды dir или cd каталог)\n", e);
            readCommand();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.printf("Введите имя каталога\n");
            readCommand();
        } finally {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        }
    }

    /**
     * Проверяет существование каталога и выполняет команду cd (смена каталога), если существует
     *
     * @param path
     */
    private void commandCD(String path) {
        File file = new File(getCurrentDirectory() + "/" + path);
        if (file.exists() && file.isDirectory()) {
            setCurrentDirectory(path);
            commandDIR();
        } else {
            try {
                throw new FileNotFoundException();
            } catch (FileNotFoundException e) {
                System.err.printf("Такого каталога не существует\n");
            }
        }
    }

    /**
     * Выводит список файлов и каталогов текущего каталога
     */
    private void commandDIR() {
        File file = new File(getCurrentDirectory());
        File[] array = file.listFiles();
        ArrayList<File> listAll = new ArrayList<File>(Arrays.asList(array));
        for (File element : listAll) {
            String type = "";
            String size = "";
            String name = "";
            if (element.isFile()) {
                size = 1.0 * element.length() / 1000 + "Kb";
                name = element.getName();
            } else if (element.isDirectory()) {
                type = "<DIR>";
                name = element.getName();
            }
            System.out.printf("%5s %10s %s\n", type, size, name);
        }
    }
}
