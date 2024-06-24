package com.Bloomberg.Warehouse.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "deal")
@Data
public class DealEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "from_currency_ISO_code")
    private String fromCurrencyISOCode;

    @Column(name = "to_currency_ISO_code")
    private String toCurrencyISOCode;

    @Column(name = "deal_timestamp",
            nullable = false,
            updatable = false)
    private LocalDateTime dealTimestamp;

    @Column(name = "deal_amount")
    private BigDecimal dealAmount;


    @PrePersist
    protected void onCreate() {
        dealTimestamp = LocalDateTime.now();
    }

}
