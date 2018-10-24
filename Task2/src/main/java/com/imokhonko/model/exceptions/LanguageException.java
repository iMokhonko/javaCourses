package com.imokhonko.model.exceptions;

public abstract class LanguageException extends Exception {

    public LanguageException() {
        super();
    }

    public LanguageException(String message) {
        super(message);
    }

    public LanguageException(String message, Throwable cause) {
        super(message, cause);
    }
}
