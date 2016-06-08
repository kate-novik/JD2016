package by.it.sereda.jd01_15.Tasks;

import java.io.BufferedReader;
import java.io.FileReader;

public class TaskB {
    public static final String OUT_CR = "OUT" + "CR";

    public static void main(String[] arg) {
        String src = System.getProperty("user.dir") + "/src/";
        String cl = TaskB.class.getName();
        System.out.println(cl);
        String path = src.concat(cl.replaceAll("[.]", "/")).concat(".java");
        String filename = src + "jd01_15/matrix.txt";
        try {
            FileReader fileReader = new FileReader((path));
            BufferedReader in = new BufferedReader(fileReader);
            String line;
            StringBuilder code = new StringBuilder("");
            while ((line = in.readLine()) != null) {
                //комментарий 1
                /* комментарий */
                code.append(line.replaceAll("(//.*)|(//*.+)", "").concat(OUT_CR));
            }
            System.out.println(code.toString().replaceAll(OUT_CR, "\n"));
        } catch (java.io.IOException e) {
            System.out.println("Ошибка работы с " + path);
        }
    }
}
