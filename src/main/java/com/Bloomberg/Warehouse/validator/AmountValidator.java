package com.Bloomberg.Warehouse.validator;

import com.Bloomberg.Warehouse.exception.InvalidAmountException;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class AmountValidator {

    public void validateAmount(BigDecimal amount) {
        if (amount == null || amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new InvalidAmountException("Amount cannot be null or empty");
        }
    }


}
