package com.Bloomberg.Warehouse.mapper;

import com.Bloomberg.Warehouse.entity.DealEntity;
import com.Bloomberg.Warehouse.util.ChecksumUtil;
import com.bloomberg.model.DealRequestDto;
import com.bloomberg.model.DealResponseDto;
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
    @Mapping(target = "checksum",ignore = true)
    DealEntity DtoToEntity(DealRequestDto fxDealRequestDto);

    @AfterMapping
    default void setChecksum(@MappingTarget DealEntity fxDealEntity, DealRequestDto fxDealRequestDto) {
        String checksum = ChecksumUtil.generateChecksum(fxDealRequestDto.toString());
        fxDealEntity.setChecksum(checksum);
    }

    DealResponseDto EntityToDto(DealEntity fxDealEntity);
}
