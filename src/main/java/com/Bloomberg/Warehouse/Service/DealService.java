package com.Bloomberg.Warehouse.Service;


import com.bloomberg.model.DealRequestDto;
import com.bloomberg.model.DealResponseDto;

public interface DealService {
     DealResponseDto createDeal(DealRequestDto fxDealRequestDto);
}
