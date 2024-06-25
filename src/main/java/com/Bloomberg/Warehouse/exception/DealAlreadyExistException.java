package com.Bloomberg.Warehouse.exception;

public class DealAlreadyExistException extends RuntimeException{
    public DealAlreadyExistException(String message) {
        super(message);
    }
}
