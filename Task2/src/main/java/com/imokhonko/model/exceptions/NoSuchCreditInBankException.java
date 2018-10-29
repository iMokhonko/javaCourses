package com.imokhonko.model.exceptions;

public class NoSuchCreditInBankException extends Exception {

    public NoSuchCreditInBankException() {
    }

    public NoSuchCreditInBankException(String message) {
        super(message);
    }

    public NoSuchCreditInBankException(String message, Throwable cause) {
        super(message, cause);
    }
}
