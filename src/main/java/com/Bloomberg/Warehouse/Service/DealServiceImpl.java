package com.Bloomberg.Warehouse.Service;

import com.Bloomberg.Warehouse.exception.DealAlreadyExistException;
import com.Bloomberg.Warehouse.repository.DealRepository;
import com.Bloomberg.Warehouse.validator.AmountValidator;
import com.Bloomberg.Warehouse.validator.DealIdValidator;
import com.Bloomberg.Warehouse.validator.ISOCodeValidator;
import com.bloomberg.model.DealRequestDto;
import com.bloomberg.model.DealResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.Bloomberg.Warehouse.mapper.DealMapper.INSTANCEMapper;

@Service
@RequiredArgsConstructor
@Slf4j
public class DealServiceImpl implements DealService {

    private final DealRepository dealRepository;
    private final AmountValidator amountValidator;
    private final ISOCodeValidator isoCodeValidator;
    private final DealIdValidator dealIdValidator;

    @Override
    @Transactional(noRollbackFor = {RuntimeException.class})
    public DealResponseDto createDeal(DealRequestDto dealRequestDto) {

        dealIdValidator.validate(dealRequestDto.getDealId(), dealRepository);
        amountValidator.validateAmount(dealRequestDto.getDealAmount());
        isoCodeValidator.validate(dealRequestDto.getFromCurrencyISOCode(), dealRequestDto.getToCurrencyISOCode());

        return INSTANCEMapper.EntityToDto(dealRepository.save(INSTANCEMapper.DtoToEntity(dealRequestDto)));
    }
}
