package com.imokhonko.exceptions;

public class NoSuchClientException extends Exception {

    public NoSuchClientException() {
    }

    public NoSuchClientException(String message) {
        super(message);
    }

    public NoSuchClientException(String message, Throwable cause) {
        super(message, cause);
    }
}
