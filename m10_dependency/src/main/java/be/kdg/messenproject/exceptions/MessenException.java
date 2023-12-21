package be.kdg.messenproject.exceptions;

import be.kdg.messenproject.model.Mes;

/**
 * Vincent Verboven
 * 21/12/2023
 */
public class MessenException extends RuntimeException {

    public MessenException(){
        super();
    }

    public MessenException(Throwable cause){
        super(cause);
    }

    public MessenException(String message) {
        super(message);
    }

    public MessenException(String message, Throwable cause) {
        super(message, cause);
    }

    public MessenException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
