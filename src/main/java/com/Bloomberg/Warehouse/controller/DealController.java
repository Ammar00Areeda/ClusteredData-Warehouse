package com.Bloomberg.Warehouse.controller;


import com.Bloomberg.Warehouse.Service.DealService;
import com.bloomberg.controller.DealApi;
import com.bloomberg.model.DealRequestDto;
import com.bloomberg.model.DealResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
@Slf4j
public class DealController implements DealApi {
    private final DealService dealService;

    @Override
    public ResponseEntity<DealResponseDto> createNewDeal(DealRequestDto dealRequestDto) {
        return new ResponseEntity<>(dealService.createDeal(dealRequestDto), HttpStatus.CREATED);
    }
}

