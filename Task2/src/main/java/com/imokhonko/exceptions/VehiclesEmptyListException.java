package com.imokhonko.exceptions;

public class VehiclesEmptyListException extends RuntimeException {

    public VehiclesEmptyListException() {
        super();
    }

    public VehiclesEmptyListException(String message) {
        super(message);
    }

    public VehiclesEmptyListException(String message, Throwable cause) {
        super(message, cause);
    }
}
