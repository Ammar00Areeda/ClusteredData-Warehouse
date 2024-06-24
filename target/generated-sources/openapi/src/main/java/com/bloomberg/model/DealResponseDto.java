package com.bloomberg.model;

import java.net.URI;
import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonTypeName;
import java.io.Serializable;
import java.time.OffsetDateTime;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import io.swagger.v3.oas.annotations.media.Schema;


import java.util.*;
import jakarta.annotation.Generated;

/**
 * Deal model for Response.
 */
@lombok.experimental.SuperBuilder

@Schema(name = "DealResponse", description = "Deal model for Response.")
@JsonTypeName("DealResponse")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-06-24T22:15:32.083626+03:00[Asia/Amman]")
public class DealResponseDto implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long id;

  private String fromCurrencyISOCode;

  private String toCurrencyISOCode;

  private java.math.BigDecimal dealAmount;

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

  public DealResponseDto dealAmount(java.math.BigDecimal dealAmount) {
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
  public java.math.BigDecimal getDealAmount() {
    return dealAmount;
  }

  public void setDealAmount(java.math.BigDecimal dealAmount) {
    this.dealAmount = dealAmount;
  }

  public DealResponseDto dealTimestamp(java.time.LocalDateTime dealTimestamp) {
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
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DealResponseDto dealResponse = (DealResponseDto) o;
    return Objects.equals(this.id, dealResponse.id) &&
        Objects.equals(this.fromCurrencyISOCode, dealResponse.fromCurrencyISOCode) &&
        Objects.equals(this.toCurrencyISOCode, dealResponse.toCurrencyISOCode) &&
        Objects.equals(this.dealAmount, dealResponse.dealAmount) &&
        Objects.equals(this.dealTimestamp, dealResponse.dealTimestamp);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, fromCurrencyISOCode, toCurrencyISOCode, dealAmount, dealTimestamp);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DealResponseDto {\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
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

