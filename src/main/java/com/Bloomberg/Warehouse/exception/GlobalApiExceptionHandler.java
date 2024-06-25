package com.Bloomberg.Warehouse.exception;


import com.Bloomberg.Warehouse.util.DateUtils;
import com.bloomberg.model.ApiErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Collections;

@ControllerAdvice
public class GlobalApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ApiException.class)
    public ResponseEntity<Object> handleApiException(ApiException ex) {
        ApiErrorResponseDto response = ApiErrorResponseDto.builder()
                .message(ex.getMessage())
                .timestamp(DateUtils.offsetDateTimeNowUtc())
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
    @ExceptionHandler(InvalidAmountException.class)
    public ResponseEntity<Object> handleInvalidAmountException(InvalidAmountException ex) {
        ApiErrorResponseDto response = ApiErrorResponseDto.builder()
                .message(ex.getMessage())
                .timestamp(DateUtils.offsetDateTimeNowUtc())
                .errors(Collections.singletonList("Invalid amount"))
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(InvalidISOCodeException.class)
    public ResponseEntity<Object> handleInvalidISOCodeException(InvalidISOCodeException ex) {
        ApiErrorResponseDto response = ApiErrorResponseDto.builder()
                .message(ex.getMessage())
                .timestamp(DateUtils.offsetDateTimeNowUtc())
                .errors(Collections.singletonList("Invalid ISO code"))
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler(DealAlreadyExistException.class)
    public ResponseEntity<Object> handleDealAlreadyExistException(DealAlreadyExistException ex) {
        ApiErrorResponseDto response = ApiErrorResponseDto.builder()
                .message(ex.getMessage())
                .timestamp(DateUtils.offsetDateTimeNowUtc())
                .errors(Collections.singletonList("Deal already exists"))
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }
}