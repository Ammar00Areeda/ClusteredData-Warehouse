package com.Bloomberg.Warehouse.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;


@Schema(
        name = "DealRequest",
        description = "Deal model for Request."
)
@JsonTypeName("DealRequest")
public class DealRequestDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private @NotNull Long dealId;
    private @NotNull String fromCurrencyISOCode;
    private @NotNull String toCurrencyISOCode;
    private @NotNull BigDecimal dealAmount;

    public DealRequestDto() {
    }

    public DealRequestDto(Long dealId, String fromCurrencyISOCode, String toCurrencyISOCode, BigDecimal dealAmount) {
        this.dealId = dealId;
        this.fromCurrencyISOCode = fromCurrencyISOCode;
        this.toCurrencyISOCode = toCurrencyISOCode;
        this.dealAmount = dealAmount;
    }



    @Schema(
            name = "dealId",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @JsonProperty("dealId")
    public @NotNull Long getDealId() {
        return this.dealId;
    }

    public void setDealId(Long dealId) {
        this.dealId = dealId;
    }



    @Schema(
            name = "fromCurrencyISOCode",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @JsonProperty("fromCurrencyISOCode")
    public @NotNull String getFromCurrencyISOCode() {
        return this.fromCurrencyISOCode;
    }

    public void setFromCurrencyISOCode(String fromCurrencyISOCode) {
        this.fromCurrencyISOCode = fromCurrencyISOCode;
    }



    @Schema(
            name = "toCurrencyISOCode",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @JsonProperty("toCurrencyISOCode")
    public @NotNull String getToCurrencyISOCode() {
        return this.toCurrencyISOCode;
    }

    public void setToCurrencyISOCode(String toCurrencyISOCode) {
        this.toCurrencyISOCode = toCurrencyISOCode;
    }



    @Schema(
            name = "dealAmount",
            requiredMode = Schema.RequiredMode.REQUIRED
    )
    @JsonProperty("dealAmount")
    public @NotNull @DecimalMin("0") BigDecimal getDealAmount() {
        return this.dealAmount;
    }

    public void setDealAmount(BigDecimal dealAmount) {
        this.dealAmount = dealAmount;
    }



    public int hashCode() {
        return Objects.hash(new Object[]{this.dealId, this.fromCurrencyISOCode, this.toCurrencyISOCode, this.dealAmount});
    }



    private String toIndentedString(Object o) {
        return o == null ? "null" : o.toString().replace("\n", "\n    ");
    }


        public String toString() {
            Long var10000 = this.dealId;
            return "DealRequestDto.DealRequestDtoBuilder(dealId=" + var10000 + ", fromCurrencyISOCode=" + this.fromCurrencyISOCode + ", toCurrencyISOCode=" + this.toCurrencyISOCode + ", dealAmount=" + String.valueOf(this.dealAmount) + ")";
        }
    }





