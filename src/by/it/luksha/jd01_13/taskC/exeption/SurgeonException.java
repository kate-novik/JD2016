package by.it.luksha.jd01_13.taskC.exeption;

/**
 * Created by MMauz on 09.06.2016.
 */
public class SurgeonException extends Exception {
    public SurgeonException() {
        super();
    }

    public SurgeonException(String message) {
        super(message);
    }

    public SurgeonException(String message, Throwable cause) {
        super(message, cause);
    }

    public SurgeonException(Throwable cause) {
        super(cause);
    }
}
