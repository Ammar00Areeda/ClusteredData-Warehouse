package com.Bloomberg.Warehouse;

import com.Bloomberg.Warehouse.exception.DealAlreadyExistException;
import com.Bloomberg.Warehouse.repository.DealRepository;
import com.Bloomberg.Warehouse.validator.DealIdValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

public class DealIdValidatorTest {

    private DealIdValidator dealIdValidator;
    private DealRepository dealRepository;

    @BeforeEach
    public void setUp() {
        dealIdValidator = new DealIdValidator();
        dealRepository = Mockito.mock(DealRepository.class);
    }

    @Test
    public void testValidDealId() {
        when(dealRepository.existsByDealId(1L)).thenReturn(false);
        // This should not throw any exception
        assertDoesNotThrow(() -> dealIdValidator.validate(1L, dealRepository));
    }

    @Test
    public void testNullDealId() {
        // This should throw a DealAlreadyExistException
        assertThrows(DealAlreadyExistException.class, () -> dealIdValidator.validate(null, dealRepository));
    }

    @Test
    public void testInvalidDealIdZero() {
        // This should throw a DealAlreadyExistException
        assertThrows(DealAlreadyExistException.class, () -> dealIdValidator.validate(0L, dealRepository));
    }

    @Test
    public void testInvalidDealIdNegative() {
        // This should throw a DealAlreadyExistException
        assertThrows(DealAlreadyExistException.class, () -> dealIdValidator.validate(-1L, dealRepository));
    }

    @Test
    public void testDealIdAlreadyExists() {
        when(dealRepository.existsByDealId(1L)).thenReturn(true);
        // This should throw a DealAlreadyExistException
        assertThrows(DealAlreadyExistException.class, () -> dealIdValidator.validate(1L, dealRepository));
    }
}
