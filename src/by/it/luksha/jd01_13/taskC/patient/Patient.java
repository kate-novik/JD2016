package by.it.luksha.jd01_13.taskC.patient;

public class Patient {
    //имя пациента
    private String name;
    //название болезни
    private String sickness;
    //состояние пациента здоров/болен - false/true
    private boolean isSick = false;

    public Patient(String name) {
        this.name = name;
    }

    public void setSickness(String sickness) {
        this.sickness = sickness;
    }

    public void setSick(boolean sick) {
        isSick = sick;
    }

    public String getSickness() {
        return sickness;
    }

    public boolean isSick() {
        return isSick;
    }

    @Override
    public String toString() {
        return this.name;
    }

}
