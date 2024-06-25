package com.Bloomberg.Warehouse;

import com.Bloomberg.Warehouse.exception.InvalidAmountException;
import com.Bloomberg.Warehouse.validator.AmountValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AmountValidatorTest {

    private AmountValidator amountValidator;

    @BeforeEach
    public void setUp() {
        amountValidator = new AmountValidator();
    }

    @Test
    public void testValidAmount() {
        // This should not throw any exception
        assertDoesNotThrow(() -> amountValidator.validateAmount(new BigDecimal("100")));
    }

    @Test
    public void testInvalidAmountZero() {
        // This should throw an InvalidAmountException
        assertThrows(InvalidAmountException.class, () -> amountValidator.validateAmount(BigDecimal.ZERO));
    }

    @Test
    public void testInvalidAmountNegative() {
        // This should throw an InvalidAmountException
        assertThrows(InvalidAmountException.class, () -> amountValidator.validateAmount(new BigDecimal("-100")));
    }

    @Test
    public void testNullAmount() {
        // This should throw an InvalidAmountException
        assertThrows(InvalidAmountException.class, () -> amountValidator.validateAmount(null));
    }
}
