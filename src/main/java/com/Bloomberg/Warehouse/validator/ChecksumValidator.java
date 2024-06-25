package com.Bloomberg.Warehouse.validator;

import com.Bloomberg.Warehouse.exception.DealAlreadyExistException;
import com.Bloomberg.Warehouse.repository.DealRepository;
import com.Bloomberg.Warehouse.util.ChecksumUtil;
import com.bloomberg.model.DealRequestDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ChecksumValidator {
    public void isValidChecksum(DealRequestDto dealRequestDto, DealRepository dealRepository) {
        log.info("Validating Checksum");

        String checksum = ChecksumUtil.generateChecksum(dealRequestDto.toString());
        if (dealRepository.existsByChecksum(checksum))
            throw new DealAlreadyExistException("System should not import same request twice.");

        log.info("Checksum is valid");
    }
}
