package by.it.sinkevich.jd03_02.taskC;

/**
 * Main class for jd03_02 TaskC
 *
 * @author Sinkevich Denis
 */
class Runner {

    public static void main(String[] args) {
        //Перед тестом должна быть создана БД! Дамб базы из WorkBench прилагается.
        DeleteScenario.deleteAllTables();
        CreateScenario.reset();
    }
}
