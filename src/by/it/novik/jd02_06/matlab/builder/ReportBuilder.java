package by.it.novik.jd02_06.matlab.builder;

import java.io.PrintWriter;

/**
 * Created by Kate Novik.
 */
public abstract class ReportBuilder {

    protected PrintWriter printWriter = ReportOperations.getInstance();

    public void buildHeader(String header){
            printWriter.println(header);

    }

    void buildStartTime (){  }
    void BuildEndTime(){ }
    void buildOperation(String operation){  }

}
