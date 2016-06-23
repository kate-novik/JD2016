package by.it.novik.jd02_06.matlab.buider;

import by.it.novik.jd02_06.log.DateTime;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Kate Novik.
 */
public class ReportOperations {

    public static PrintWriter getPrintWriter () {
        String src = System.getProperty("user.dir") + "/src/by/it/novik/";
        String path = src + "jd02_06/matlab/builder/builder.txt";
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(new FileWriter(new File(path)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pw;
    }
    public void setHeader (String header) {
        getPrintWriter().println(header);
    }

    public void setStartTime () {
        DateFormat start = DateFormat.getTimeInstance(DateFormat.FULL,new Locale("be","BY"));
        String startTime = start.format(new Date());
        getPrintWriter().println(startTime);
    }

    public void setEndTime () {
        DateFormat end = DateFormat.getTimeInstance(DateFormat.FULL,new Locale("be","BY"));
        String endTime = end.format(new Date());
        getPrintWriter().println(endTime);
    }

    public void setTypeOperation(String operation) {
        getPrintWriter().println(operation);
    }

}
