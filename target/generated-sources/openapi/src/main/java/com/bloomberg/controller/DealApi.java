/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (7.0.1).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.bloomberg.controller;

import com.bloomberg.model.ApiErrorResponseDto;
import com.bloomberg.model.DealRequestDto;
import com.bloomberg.model.DealResponseDto;
import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import jakarta.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2024-06-24T22:15:32.083626+03:00[Asia/Amman]")
@Validated
@Controller
@Tag(name = "Deal", description = "the Deal API")
public interface DealApi {

    /**
     * POST /api/deal : Insert new deal
     *
     * @param dealRequestDto  (required)
     * @return FXDeal successfully created (status code 201)
     *         or Wrong request (not all responses will have specified content model) (status code 400)
     */
    @Operation(
        operationId = "createNewDeal",
        summary = "Insert new deal",
        tags = { "Deal" },
        responses = {
            @ApiResponse(responseCode = "201", description = "FXDeal successfully created", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = DealResponseDto.class))
            }),
            @ApiResponse(responseCode = "400", description = "Wrong request (not all responses will have specified content model)", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = ApiErrorResponseDto.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/api/deal",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    ResponseEntity<DealResponseDto> createNewDeal(
        @Parameter(name = "DealRequestDto", description = "", required = true) @Valid @RequestBody DealRequestDto dealRequestDto
    );

}
