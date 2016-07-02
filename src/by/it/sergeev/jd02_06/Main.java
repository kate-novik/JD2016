package by.it.sergeev.jd02_06;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Logger logger = Logger.getLogger();

        logger.log("Starting program!", Logger.LOG_LEVEL.DEBUG);
        logger.log("Log message");
        logger.log("Could not open file", Logger.LOG_LEVEL.ERROR);
        logger.log("Exiting..", Logger.LOG_LEVEL.DEBUG);
    }
}