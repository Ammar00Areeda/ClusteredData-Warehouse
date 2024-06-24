package com.Bloomberg.Warehouse.exception;

import lombok.experimental.StandardException;

import java.io.Serial;

/**
 * Universal class for business logic exceptions, which are handled in {@link GlobalApiExceptionHandler} and
 * exception message goes to frontend client within {@link }.
 */
@StandardException
public class ApiException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = 1L;
}