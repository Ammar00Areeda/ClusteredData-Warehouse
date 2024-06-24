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
 * Deal model for Request.
 */
@lombok.experimental.SuperBuilder

@Schema(name = "DealRequest", description = "Deal model for Request.")
@JsonTypeName("DealRequest")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-06-24T22:15:32.083626+03:00[Asia/Amman]")
public class DealRequestDto implements Serializable {

  private static final long serialVersionUID = 1L;

  private String fromCurrencyISOCode;

  private String toCurrencyISOCode;

  private java.math.BigDecimal dealAmount;

  public DealRequestDto() {
    super();
  }

  /**
   * Constructor with only required parameters
   */
  public DealRequestDto(String fromCurrencyISOCode, String toCurrencyISOCode, java.math.BigDecimal dealAmount) {
    this.fromCurrencyISOCode = fromCurrencyISOCode;
    this.toCurrencyISOCode = toCurrencyISOCode;
    this.dealAmount = dealAmount;
  }

  public DealRequestDto fromCurrencyISOCode(String fromCurrencyISOCode) {
    this.fromCurrencyISOCode = fromCurrencyISOCode;
    return this;
  }

  /**
   * Get fromCurrencyISOCode
   * @return fromCurrencyISOCode
  */
  @NotNull 
  @Schema(name = "fromCurrencyISOCode", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("fromCurrencyISOCode")
  public String getFromCurrencyISOCode() {
    return fromCurrencyISOCode;
  }

  public void setFromCurrencyISOCode(String fromCurrencyISOCode) {
    this.fromCurrencyISOCode = fromCurrencyISOCode;
  }

  public DealRequestDto toCurrencyISOCode(String toCurrencyISOCode) {
    this.toCurrencyISOCode = toCurrencyISOCode;
    return this;
  }

  /**
   * Get toCurrencyISOCode
   * @return toCurrencyISOCode
  */
  @NotNull 
  @Schema(name = "toCurrencyISOCode", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("toCurrencyISOCode")
  public String getToCurrencyISOCode() {
    return toCurrencyISOCode;
  }

  public void setToCurrencyISOCode(String toCurrencyISOCode) {
    this.toCurrencyISOCode = toCurrencyISOCode;
  }

  public DealRequestDto dealAmount(java.math.BigDecimal dealAmount) {
    this.dealAmount = dealAmount;
    return this;
  }

  /**
   * Get dealAmount
   * minimum: 0
   * @return dealAmount
  */
  @NotNull @DecimalMin("0") 
  @Schema(name = "dealAmount", requiredMode = Schema.RequiredMode.REQUIRED)
  @JsonProperty("dealAmount")
  public java.math.BigDecimal getDealAmount() {
    return dealAmount;
  }

  public void setDealAmount(java.math.BigDecimal dealAmount) {
    this.dealAmount = dealAmount;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DealRequestDto dealRequest = (DealRequestDto) o;
    return Objects.equals(this.fromCurrencyISOCode, dealRequest.fromCurrencyISOCode) &&
        Objects.equals(this.toCurrencyISOCode, dealRequest.toCurrencyISOCode) &&
        Objects.equals(this.dealAmount, dealRequest.dealAmount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(fromCurrencyISOCode, toCurrencyISOCode, dealAmount);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class DealRequestDto {\n");
    sb.append("    fromCurrencyISOCode: ").append(toIndentedString(fromCurrencyISOCode)).append("\n");
    sb.append("    toCurrencyISOCode: ").append(toIndentedString(toCurrencyISOCode)).append("\n");
    sb.append("    dealAmount: ").append(toIndentedString(dealAmount)).append("\n");
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

