package by.it.luksha.jd01_13.taskC;

import by.it.luksha.jd01_13.taskC.patient.Patient;
import by.it.luksha.jd01_13.taskC.staff.Neurosurgeon;
import by.it.luksha.jd01_13.taskC.staff.Surgeon;

import java.util.ArrayList;

public class Hospital {
    //список пациентов
    ArrayList<Patient> listPatient;

    /**
     * Конструктор для госпиталя
     */
    public Hospital() {
        this.listPatient = new ArrayList<>();
    }

    /**
     * Метод возвращает список пациентов
     * @return ArrayList пациентов
     */
    public ArrayList<Patient> getListPatient() {
        return listPatient;
    }

    /**
     * Метод добавляет пациента в список пациентов
     * @param patient добавляемый пациент
     */
    public void addPatient(Patient patient) {
        listPatient.add(patient);
    }

    public static void setup() {
        //создание больницы
        Hospital hospitalOfMinsk = new Hospital();
        //получение списка больных
        ArrayList<Patient> listPatient = hospitalOfMinsk.getListPatient();
        //создание пациентов
        Patient patient1 = new Patient("Ленин");
        Patient patient2 = new Patient("Сталин");
        Patient patient3 = new Patient("Хрущев");
        Patient patient4 = new Patient("Брежнев");
        Patient patient5 = new Patient("Андропов");
        Patient patient6 = new Patient("Черненко");
        Patient patient7 = new Patient("Горбачев");
        //добавление пациентов в список пациентов
        listPatient.add(patient1);
        listPatient.add(patient2);
        listPatient.add(patient3);
        listPatient.add(patient4);
        listPatient.add(patient5);
        listPatient.add(patient6);
        listPatient.add(patient7);

        //создание врачей
        Neurosurgeon goodDM = new Neurosurgeon("Никонор Иосифович", 10);
        Surgeon mediumDM = new Neurosurgeon("Поликарп Сигизмундович", 5);
        Surgeon badDM = new Neurosurgeon("Равшан Джамшутович", 2);

        for (Patient patient: listPatient) {
            badDM.diagnose(patient);
        }

        for (Patient patient: listPatient) {
            badDM.treat(patient);
        }

        badDM.makeReport();

        badDM.putOnSmock();

        for (Patient patient: listPatient) {
            badDM.treat(patient);
        }

        badDM.makeReport();
        badDM.rest();
        badDM.makeReport();
        badDM.takeOffSmock();
        badDM.rest();
        badDM.makeReport();

        //Помолимся!
        badDM.pray();
        badDM.pray();
        badDM.pray();
        badDM.pray();
        badDM.pray();

        //И возьмем в руки скальпель!
        badDM.putOnSmock();
        for (Patient patient: listPatient) {
            badDM.treat(patient);
        }

        badDM.makeReport();
    }

}
