package com.Bloomberg.Warehouse.exception;


import com.Bloomberg.Warehouse.util.DateUtils;
import com.bloomberg.model.ApiErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

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
}