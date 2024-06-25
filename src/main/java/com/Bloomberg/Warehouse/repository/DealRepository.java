package com.Bloomberg.Warehouse.repository;

import com.Bloomberg.Warehouse.entity.DealEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DealRepository extends JpaRepository<DealEntity, Long> {

    Boolean existsByChecksum(String checksum);
}
