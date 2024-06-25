package com.Bloomberg.Warehouse.Service;


import com.Bloomberg.Warehouse.dto.DealRequestDto;
import com.Bloomberg.Warehouse.dto.DealResponseDto;

public interface DealService {
     DealResponseDto createDeal(DealRequestDto fxDealRequestDto);
}
