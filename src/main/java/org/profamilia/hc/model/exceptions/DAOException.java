package org.profamilia.hc.model.exceptions;

/**
 * Exceptin thrown inside DAO implementations.
 * @author Abie
 */
public class DAOException extends RuntimeException {

    /**
     * The serial version identifier.
     */
    private static final long serialVersionUID = 2394637209611900805L;

    /**
     * Default constructor.
     */
    public DAOException() {
        super();
    }

    /**
     * Constructor with a message.
     * @param message the message to be shown
     */
    public DAOException(final String message) {
        super(message);
    }

    /**
     * Constructor with a cause.
     * @param cause the cause of the exception.
     */
    public DAOException(final Throwable cause) {
        super(cause);
    }

    /**
     * Constructor with a message and a cause.
     * @param message the message to be shown.
     * @param cause the cause of the exception.
     */
    public DAOException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
