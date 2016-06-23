package by.it.novik.jd02_06.matlab.buider;

import by.it.novik.jd02_06.log.DateTime;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


/**
 * Created by Kate Novik.
 */
public class ReportOperations {

    private static PrintWriter instance;

    private ReportOperations() {}
    public static PrintWriter getInstance (){
        if (instance == null){
            String src = System.getProperty("user.dir") + "/src/by/it/novik/";
            String path = src + "jd02_06/matlab/builder/builder.txt";
            try {
                instance = new PrintWriter(new FileWriter(new File(path)));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return instance;
    }


}
