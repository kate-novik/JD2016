package by.it.novik.jd02_06.matlab.buider;

/**
 * Created by Катя.
 */
public class BuildThirt extends ReportBuilder {
    @Override
    void buildHeader(String header) {
        super.reportOperations.setHeader(header);
    }

    @Override
    void buildStartTime() {
        super.reportOperations.setStartTime();
    }

    @Override
    void buildOperation(String operation) {  }

    @Override
    void BuildEndTime() {
        super.reportOperations.setEndTime();
    }
}
