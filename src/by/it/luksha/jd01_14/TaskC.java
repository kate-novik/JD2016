package by.it.luksha.jd01_14;


import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class TaskC {
    private static String src = System.getProperty("user.dir");

    /**
     * Выводит список каталогов и файлов каталога проекта
     */
    protected static void printDir() {
        File root = new File(src); //корневой каталог для поиска
        File[] array = root.listFiles();
        ArrayList<File> listAll = new ArrayList<File>(Arrays.asList(array));
        ArrayList<String> listFiles = new ArrayList<>();
        ArrayList<String> listDirs = new ArrayList<>();

        while (listAll.size() > 0) {
            File tmp = listAll.get(0);
            if (tmp.isFile()) {
                listFiles.add(tmp.getName());
                listAll.remove(0);
            } else {
                Collections.addAll(listAll, tmp.listFiles());
                listDirs.add(tmp.getName());
                listAll.remove(0);
            }
        }

        System.out.println("List dirs:");
        for (String element : listDirs) {
            System.out.println(element);
        }
        System.out.println("List files:");
        for (String element : listFiles) {
            System.out.println(element);
        }
    }
}
