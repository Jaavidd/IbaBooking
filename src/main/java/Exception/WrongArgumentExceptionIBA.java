package Exception;

public class WrongArgumentExceptionIBA extends ExceptionIBA {

    public WrongArgumentExceptionIBA(String message) {
        super(message);
    }
    public WrongArgumentExceptionIBA() {
        super("Wrong Argument entered application exited with exception !");
    }

}
