package by.it.novik.jd02_06.matlab.buider;

/**
 * Created by Kate Novik.
 */
public abstract class ReportBuilder {
    ReportOperations reportOperations = new ReportOperations();
    abstract void buildHeader(String header);
    abstract void buildStartTime ();
    abstract void BuildEndTime();
    abstract void buildOperation(String operation);

}
