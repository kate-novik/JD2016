package by.it.luksha.jd01_13.taskC.staff;

import by.it.luksha.jd01_13.taskC.patient.Patient;

public interface IDoctor {
    /**
     * Здесь описываются возможные действия докторов
     * Задание 7 interface Врач <-- abstract class Хирург <-- class Нейрохирург.
     */
    /**
     * Метод подготавливает врача к работе с пациентами
     */
    void putOnSmock();

    /**
     * Метод подготавливает врача к отдыху
     */
    void takeOffSmock();

    /**
     * Метод диагностирует пациента
     * @param patient пациент
     * @return false - здоров, true - болен
     */
    boolean diagnose(Patient patient);

    /**
     * Метод лечит пациента
     * @param patient пациент
     */
    void treat(Patient patient);

    /**
     * Метод составляет отчет по деятельности врача
     */
    void makeReport();

    /**
     * Метод изменяет навыка врача на случайную величину
     * @return
     */
    void pray();

    /**
     * Метод сбрасывает счетчик наработанных врачом часов
     */
    void rest();
}
