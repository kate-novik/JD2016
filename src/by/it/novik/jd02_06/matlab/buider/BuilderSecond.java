package by.it.novik.jd02_06.matlab.buider;

/**
 * Created by Катя.
 */
public class BuilderSecond extends ReportBuilder {

    @Override
    void buildHeader(String header) {
        super.reportOperations.setHeader(header);
    }

    @Override
    void buildStartTime() {  }

    @Override
    void buildOperation(String operation) {
        super.reportOperations.setTypeOperation(operation);
    }

    @Override
    void BuildEndTime() {   }
}
