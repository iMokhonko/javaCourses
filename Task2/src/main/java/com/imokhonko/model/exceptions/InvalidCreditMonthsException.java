package com.imokhonko.model.exceptions;

public class InvalidCreditMonthsException extends Exception {

    public InvalidCreditMonthsException() {
        super();
    }

    public InvalidCreditMonthsException(String message) {
        super(message);
    }

    public InvalidCreditMonthsException(String message, Throwable cause) {
        super(message, cause);
    }
}
