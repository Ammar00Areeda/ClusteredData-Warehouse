package com.Bloomberg.Warehouse.validator;

import com.Bloomberg.Warehouse.exception.InvalidAmountException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;


@Component
@Slf4j
public class AmountValidator {

    public void validateAmount(BigDecimal amount) {
        log.info("Validating Amount");
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new InvalidAmountException("Amount cannot be null or empty");
        }
        log.info("Amount is valid");
    }


}
