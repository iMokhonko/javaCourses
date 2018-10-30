package com.imokhonko.exceptions;

public class UnableOpenCreditException extends Exception {

    public UnableOpenCreditException() {
    }

    public UnableOpenCreditException(String message) {
        super(message);
    }

    public UnableOpenCreditException(String message, Throwable cause) {
        super(message, cause);
    }
}
