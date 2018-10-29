package com.imokhonko.model.exceptions;

public class InvalidCreditSumException extends Exception {

    public InvalidCreditSumException() {
        super();
    }

    public InvalidCreditSumException(String message) {
        super(message);
    }

    public InvalidCreditSumException(String message, Throwable cause) {
        super(message, cause);
    }
}
