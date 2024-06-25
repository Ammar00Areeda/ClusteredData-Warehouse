package com.Bloomberg.Warehouse;

import com.Bloomberg.Warehouse.exception.InvalidISOCodeException;
import com.Bloomberg.Warehouse.validator.ISOCodeValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ISOCodeValidatorTest {

    private ISOCodeValidator isoCodeValidator;

    @BeforeEach
    public void setUp() {
        isoCodeValidator = new ISOCodeValidator();
    }

    @Test
    public void testValidISOCodes() {
        // This should not throw any exception
        assertDoesNotThrow(() -> isoCodeValidator.validate("USD", "EUR"));
    }

    @Test
    public void testSameCurrency() {
        // This should throw an InvalidISOCodeException
        assertThrows(InvalidISOCodeException.class, () -> isoCodeValidator.validate("USD", "USD"));
    }

    @Test
    public void testNullFromCurrency() {
        // This should throw an InvalidISOCodeException
        assertThrows(InvalidISOCodeException.class, () -> isoCodeValidator.validate(null, "EUR"));
    }

    @Test
    public void testEmptyFromCurrency() {
        // This should throw an InvalidISOCodeException
        assertThrows(InvalidISOCodeException.class, () -> isoCodeValidator.validate("", "EUR"));
    }

    @Test
    public void testNullToCurrency() {
        // This should throw an InvalidISOCodeException
        assertThrows(InvalidISOCodeException.class, () -> isoCodeValidator.validate("USD", null));
    }

    @Test
    public void testEmptyToCurrency() {
        // This should throw an InvalidISOCodeException
        assertThrows(InvalidISOCodeException.class, () -> isoCodeValidator.validate("USD", ""));
    }

    @Test
    public void testInvalidFromCurrency() {
        // This should throw an InvalidISOCodeException
        assertThrows(InvalidISOCodeException.class, () -> isoCodeValidator.validate("INVALID", "USD"));
    }

    @Test
    public void testInvalidToCurrency() {
        // This should throw an InvalidISOCodeException
        assertThrows(InvalidISOCodeException.class, () -> isoCodeValidator.validate("USD", "INVALID"));
    }
}
