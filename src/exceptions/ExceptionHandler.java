package exceptions;

/**
 * Custom exception class for handling index out of bounds exceptions in MyList.
 */
public class ExceptionHandler extends RuntimeException {

    /**
     * Constructs a new ExceptionHandler with the specified detail message.
     *
     * @param message the detail message.
     */
    public ExceptionHandler(String message) {
        super(message);
    }

    /**
     * Constructs a new ExceptionHandler with the specified detail message
     * and cause.
     *
     * @param message the detail message.
     * @param cause   the cause (which is saved for later retrieval by the getCause() method).
     */
    public ExceptionHandler(String message, Throwable cause) {
        super(message, cause);
    }
}
