package by.it.sinkevich.jd03_01.taskC;

import java.util.ArrayList;
import java.util.List;

/**
 * Utility class for jd03_01 TaskC
 * Contains sequence of sql queries to delete my DB with Data
 *
 * @author Sinkevcih Denis
 */
class DeleteScenario {

    static final List<String> QUERIES;

    static {
        QUERIES = new ArrayList<>();

        QUERIES.add("DROP TABLE `sinkevich`.`bets`, `sinkevich`.`users`, `sinkevich`.`races`, `sinkevich`.`roles`;");
    }
}
