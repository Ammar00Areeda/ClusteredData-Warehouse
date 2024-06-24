package com.Bloomberg.Warehouse.exception;

public class InvalidISOCodeException extends RuntimeException{
    public InvalidISOCodeException(String message) {
        super(message);
    }
}
