package com.Bloomberg.Warehouse.validator;

import com.Bloomberg.Warehouse.exception.InvalidISOCodeException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Currency;
import java.util.Objects;

@Component
@Slf4j
public class ISOCodeValidator {
    public void validate(String fromCurrency, String toCurrency) {

        log.info("Validating ISO Codes");

        if (Objects.equals(fromCurrency, toCurrency)){
            throw new InvalidISOCodeException("From and To currency cannot be the same");
        }

        if(Objects.isNull(fromCurrency) || fromCurrency.isEmpty()){
            throw new InvalidISOCodeException("From currency is required");
        }
        if(Objects.isNull(toCurrency) || toCurrency.isEmpty()){
            throw new InvalidISOCodeException("To currency is required");
        }

        try {
            Currency.getInstance(fromCurrency);
            Currency.getInstance(toCurrency);
        } catch (IllegalArgumentException ex) {
            throw new InvalidISOCodeException("ISO Code is not valid");
        }
        log.info("ISO Codes are valid");

    }
}
