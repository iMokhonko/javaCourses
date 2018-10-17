package com.imokhonko.exceptions;

public class VehicleException extends Exception {

    public VehicleException() {
        super();
    }

    public VehicleException(String message) {
        super(message);
    }

    public VehicleException(String message, Throwable cause) {
        super(message, cause);
    }
}
