package by.it.novik.jd02_06.matlab.builder;

/**
 * Created by Kate Novik.
 */
public class Director {

    private ReportBuilder reportBuilder;

    public void setReportBuilder (ReportBuilder reportBuilder) {
        this.reportBuilder = reportBuilder;
    }

    public void build (String header, String operation) {
        reportBuilder.buildHeader(header);
        reportBuilder.buildStartTime();
        reportBuilder.buildOperation(operation);
        reportBuilder.BuildEndTime();
    }
}
