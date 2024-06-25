package com.Bloomberg.Warehouse.validator;

import com.Bloomberg.Warehouse.exception.DealAlreadyExistException;
import com.Bloomberg.Warehouse.repository.DealRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DealIdValidator {
    public void validate(Long dealId, DealRepository dealRepository) {
        log.info("Validating Deal Id");
        if (dealId == null) {
            throw new DealAlreadyExistException("Deal with dealId: " + dealId + " already exists");
        }
        if (dealId <= 0) {
            throw new DealAlreadyExistException("Deal with dealId: " + dealId + " already exists");
        }
        if(dealRepository.existsByDealId(dealId)){
            throw new DealAlreadyExistException("Deal with dealId: " + dealId + " already exists");
        }
        log.info("Deal Id is valid");
    }
}
