package com.Bloomberg.Warehouse.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeName;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.annotation.Generated;
import jakarta.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@lombok.experimental.SuperBuilder

@Schema(name = "ApiErrorResponse", description = "Model for some API errors")
@JsonTypeName("ApiErrorResponse")
@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-06-25T19:51:59.213926+03:00[Asia/Amman]")
public class ApiErrorResponseDto {

    private static final long serialVersionUID = 1L;

    @Valid
    private List<String> errors;

    private String message;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private OffsetDateTime timestamp;

    public ApiErrorResponseDto errors(List<String> errors) {
        this.errors = errors;
        return this;
    }

    public ApiErrorResponseDto addErrorsItem(String errorsItem) {
        if (this.errors == null) {
            this.errors = new ArrayList<>();
        }
        this.errors.add(errorsItem);
        return this;
    }

    /**
     * Get errors
     * @return errors
     */

    @Schema(name = "errors", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("errors")
    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public ApiErrorResponseDto message(String message) {
        this.message = message;
        return this;
    }

    /**
     * Get message
     * @return message
     */

    @Schema(name = "message", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ApiErrorResponseDto timestamp(OffsetDateTime timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    /**
     * Get timestamp
     * @return timestamp
     */
    @Valid
    @Schema(name = "timestamp", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    @JsonProperty("timestamp")
    public OffsetDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(OffsetDateTime timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public int hashCode() {
        return Objects.hash(errors, message, timestamp);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class ApiErrorResponseDto {\n");
        sb.append("    errors: ").append(toIndentedString(errors)).append("\n");
        sb.append("    message: ").append(toIndentedString(message)).append("\n");
        sb.append("    timestamp: ").append(toIndentedString(timestamp)).append("\n");
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
