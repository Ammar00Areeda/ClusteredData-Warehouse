package com.Bloomberg.Warehouse.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMin;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Objects;


@lombok.experimental.SuperBuilder

@Schema(name = "DealResponse", description = "Deal model for Response.")
@JsonTypeName("DealResponse")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-06-25T19:51:59.213926+03:00[Asia/Amman]")
public class DealResponseDto {

    private static final long serialVersionUID = 1L;

    private Long id;

    private Long dealId;

    private String fromCurrencyISOCode;

    private String toCurrencyISOCode;

    private BigDecimal dealAmount;

    private java.time.LocalDateTime dealTimestamp;

    public DealResponseDto id(Long id) {
        this.id = id;
        return this;
    }

    /**
     * Get id
     * @return id
     */

    @Schema(name = "id", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DealResponseDto dealId(Long dealId) {
        this.dealId = dealId;
        return this;
    }

    /**
     * Get dealId
     * @return dealId
     */

    @Schema(name = "dealId", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("dealId")
    public Long getDealId() {
        return dealId;
    }

    public void setDealId(Long dealId) {
        this.dealId = dealId;
    }

    public DealResponseDto fromCurrencyISOCode(String fromCurrencyISOCode) {
        this.fromCurrencyISOCode = fromCurrencyISOCode;
        return this;
    }

    /**
     * Get fromCurrencyISOCode
     * @return fromCurrencyISOCode
     */

    @Schema(name = "fromCurrencyISOCode", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("fromCurrencyISOCode")
    public String getFromCurrencyISOCode() {
        return fromCurrencyISOCode;
    }

    public void setFromCurrencyISOCode(String fromCurrencyISOCode) {
        this.fromCurrencyISOCode = fromCurrencyISOCode;
    }

    public DealResponseDto toCurrencyISOCode(String toCurrencyISOCode) {
        this.toCurrencyISOCode = toCurrencyISOCode;
        return this;
    }

    /**
     * Get toCurrencyISOCode
     * @return toCurrencyISOCode
     */

    @Schema(name = "toCurrencyISOCode", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("toCurrencyISOCode")
    public String getToCurrencyISOCode() {
        return toCurrencyISOCode;
    }

    public void setToCurrencyISOCode(String toCurrencyISOCode) {
        this.toCurrencyISOCode = toCurrencyISOCode;
    }

    public DealResponseDto dealAmount(BigDecimal dealAmount) {
        this.dealAmount = dealAmount;
        return this;
    }

    /**
     * Get dealAmount
     * minimum: 0
     * @return dealAmount
     */
    @DecimalMin("0")
    @Schema(name = "dealAmount", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("dealAmount")
    public BigDecimal getDealAmount() {
        return dealAmount;
    }

    public void setDealAmount(BigDecimal dealAmount) {
        this.dealAmount = dealAmount;
    }

    public DealResponseDto dealTimestamp(LocalDateTime dealTimestamp) {
        this.dealTimestamp = dealTimestamp;
        return this;
    }

    /**
     * Get dealTimestamp
     * @return dealTimestamp
     */
    @Valid
    @Schema(name = "dealTimestamp", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("dealTimestamp")
    public java.time.LocalDateTime getDealTimestamp() {
        return dealTimestamp;
    }

    public void setDealTimestamp(java.time.LocalDateTime dealTimestamp) {
        this.dealTimestamp = dealTimestamp;
    }


    @Override
    public int hashCode() {
        return Objects.hash(id, dealId, fromCurrencyISOCode, toCurrencyISOCode, dealAmount, dealTimestamp);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class DealResponseDto {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    dealId: ").append(toIndentedString(dealId)).append("\n");
        sb.append("    fromCurrencyISOCode: ").append(toIndentedString(fromCurrencyISOCode)).append("\n");
        sb.append("    toCurrencyISOCode: ").append(toIndentedString(toCurrencyISOCode)).append("\n");
        sb.append("    dealAmount: ").append(toIndentedString(dealAmount)).append("\n");
        sb.append("    dealTimestamp: ").append(toIndentedString(dealTimestamp)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}
