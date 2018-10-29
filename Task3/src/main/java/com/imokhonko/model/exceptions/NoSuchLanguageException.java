package com.imokhonko.model.exceptions;

public class NoSuchLanguageException extends LanguageException {

    public NoSuchLanguageException() {
        super();
    }

    public NoSuchLanguageException(String message) {
        super(message);
    }

    public NoSuchLanguageException(String message, Throwable cause) {
        super(message, cause);
    }

}
