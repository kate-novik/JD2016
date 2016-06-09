package by.it.luksha.jd01_13.taskC.exeption;

/**
 * Created by MMauz on 09.06.2016.
 */
public class PatientException extends Exception {
    //нужно 4 конструктора для своего исключения
    public PatientException() {
    }
    public PatientException(String message, Throwable exception) {
        super(message, exception);
    }
    public PatientException(String message) {
        super(message);
    }
    public PatientException(Throwable exception) {
        super(exception);
    }
}
