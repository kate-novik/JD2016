package by.it.novik.jd02_06.matlab.buider;

/**
 * Created by Катя.
 */
public class BuilderFirst extends ReportBuilder {
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
    void BuildEndTime() {   }
}
