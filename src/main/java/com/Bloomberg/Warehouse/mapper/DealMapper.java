package com.Bloomberg.Warehouse.mapper;

import com.Bloomberg.Warehouse.dto.DealRequestDto;
import com.Bloomberg.Warehouse.dto.DealResponseDto;
import com.Bloomberg.Warehouse.entity.DealEntity;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.factory.Mappers;

@Mapper
public interface DealMapper {

    DealMapper INSTANCEMapper = Mappers.getMapper( DealMapper.class );

    @Mapping(target = "id",ignore = true)
    @Mapping(target = "dealTimestamp",ignore = true)
    DealEntity DtoToEntity(DealRequestDto fxDealRequestDto);

    DealResponseDto EntityToDto(DealEntity fxDealEntity);
}
