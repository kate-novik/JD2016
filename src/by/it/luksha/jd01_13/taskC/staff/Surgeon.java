package by.it.luksha.jd01_13.taskC.staff;

import by.it.luksha.jd01_13.taskC.exeption.SurgeonException;
import by.it.luksha.jd01_13.taskC.patient.Patient;

import java.util.Random;

public abstract class Surgeon implements IDoctor {
    //имя
    private String name;
    //навык
    private final int skill;
    //бонус к навыку
    private int skillAdd;
    //готовность
    private boolean isReady = false;
    //кол-во удачных операци
    private int countGoodOperations;
    //кол-во неудачных операций
    private int countFailedOperations;
    //кол-во отработанных часов
    private int countWorkHour;

    /**
     * Конструктор класса хирург
     * @param name имя хирурга
     * @param skill навык хирурга
     */
    public Surgeon(String name, int skill) throws SurgeonException {
        if (name.matches("[0-9]]")) {throw new SurgeonException("Неведомое имя");}
        this.name = name;
        this.skill = skill;
    }

    /**
     * Метод одевает халат
     */
    @Override
    public void putOnSmock() {
        this.isReady = true;
    }

    /**
     * Метод снимает халат
     */
    @Override
    public void takeOffSmock() {
        this.isReady = false;
    }

    /**
     * Метод диагностирует заболевание пациента
     * @param patient
     * @return true/false
     */
    @Override
    public boolean diagnose(Patient patient) {
        this.countWorkHour++;
        System.out.println("Проводится диагностика пациента " + patient + "...");
        boolean isSick = new Random().nextBoolean();
        if (isSick) {
            patient.setSick(isSick);
            System.out.println("Пациент " + patient + " болен =(");
        }
        else {
            patient.setSick(isSick);
            System.out.println("Пациент " + patient + " здоров =)");
        }
        return isSick;
    }

    /**
     * Метод лечит пациента
     * @param patient пациент
     */
    @Override
    public void treat(Patient patient) {
        if (patient.isSick()) {
            if (isReady) {
                System.out.println("Проводится операция пациента " + patient + "...");
                this.countWorkHour++;
                if (carryOutOperation(patient)) {
                    System.out.println("Пациент " + patient + " успешно прооперирован!");
                    patient.setSick(false);
                    this.countGoodOperations++;
                } else {
                    System.out.println("Что-то пошло не так и пациенту " + patient + " операция не помогла!");
                    patient.setSick(true);
                    this.countFailedOperations++;
                }
            }
            else
            {
                System.out.println("Перед операцией следует надевать халат!");
            }
        }
        else
            System.out.println("Вы собираетесь лечить здорового пациента!");
    }

    /**
     * Метод создает и выводит в консоль отчет по хирургу
     */
    @Override
    public void makeReport() {
        System.out.println("Врач-хирург: " + this.name +
                ". Провел: " + (this.countFailedOperations+countGoodOperations) + " операций. " +
                "Из них " + countGoodOperations + " успешно. " +
                "Наработано: " + countWorkHour + " часов.");
    }

    /**
     * Метод изменяет навык хирурга на случайную величину
     */
    @Override
    public void pray() {
        int plus = (int) ((new Random().nextDouble())*10);
        System.out.println("Врач " + this.name + " помолился и получил " + plus + " очков навыка.");
        this.skillAdd += plus;
    }

    /**
     * Метод сбрасывает счетчик наработаных часов
     */
    @Override
    public void rest() {
        if (!this.isReady) {
            System.out.println("Врач " + this.name + " отдыхает.");
            this.countWorkHour = 0;
            this.skillAdd = 0;
        }
        else
            System.out.println("Врач " + this.name + " не может отдыхать. Может снимем хотя бы халат?");
    }

    /**
     * Метод проводит операцию на пациенте
     * @param patient пациент
     * @return исход операции true - успех
     */
    public abstract boolean carryOutOperation(Patient patient);

    /**
     * Метод рассчитывает шанс на успешную операцию
     * @return значение шанса от 0 до 0.7
     */
    public double chanceGoodOperation() {
        int allSkills = this.skill + this.skillAdd;
        double chance = ((200.0*(allSkills - 1))/(allSkills*this.countWorkHour))*0.01;
        if (chance > 1)
            System.out.println("Шанс на успешную операцию составляет 100%.");
        else
            System.out.printf("Шанс на успешную операцию составляет %2.2f %s", (chance*100), "%.\n");
        return chance;
    }

    @Override
    public String toString() {
        return "Меня зовут " + this.name + ". Я врач-хирург с навыком в " + skill + " балл(ов).";
    }

}
