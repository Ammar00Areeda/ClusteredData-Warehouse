package com.Bloomberg.Warehouse.Service;

import com.Bloomberg.Warehouse.repository.DealRepository;

import com.bloomberg.model.DealRequestDto;
import com.bloomberg.model.DealResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import static com.Bloomberg.Warehouse.mapper.DealMapper.INSTANCEMapper;

@Service
@RequiredArgsConstructor
@Slf4j
public class DealServiceImpl implements DealService {


    private final DealRepository dealRepository;


    @Override
    public DealResponseDto createDeal(DealRequestDto dealRequestDto) {
        log.info("Creating FX Deal");
        return INSTANCEMapper.EntityToDto(dealRepository.save(INSTANCEMapper.DtoToEntity(dealRequestDto)));
    }
}
