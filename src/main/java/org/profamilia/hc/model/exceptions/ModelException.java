package org.profamilia.hc.model.exceptions;

public class ModelException extends Exception {

    /**
     * Constructor with error message.
     * 
     * @param msg the error message associated with the exception
     */
    public ModelException(String msg) {
        super(msg);
    }

    /**
     * Constructor with error message and root cause.
     * 
     * @param msg the error message associated with the exception
     * @param cause the root cause of the exception
     */
    public ModelException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
