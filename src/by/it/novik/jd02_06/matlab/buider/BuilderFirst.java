package by.it.novik.jd02_06.matlab.buider;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Kate Novik.
 */
public class BuilderFirst extends ReportBuilder {

    @Override
    public void buildStartTime() {
        DateFormat start = DateFormat.getTimeInstance(DateFormat.FULL,new Locale("be","BY"));
        String startTime = start.format(new Date());
        printWriter.println(startTime);
    }


}
