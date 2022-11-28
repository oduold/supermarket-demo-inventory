/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (6.2.1).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.brandlogs.inventory.api.interfaces;

import com.brandlogs.inventory.api.model.TransactionType;
import com.brandlogs.inventory.api.utils.ApiUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.NativeWebRequest;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Validated
public interface TransactiontypesApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /transactiontypes : Add a TransactionType
     * Add a TransactionType
     *
     * @param transactionType  (optional)
     * @return OK (status code 200)
     *         or  (status code 200)
     */
    @Operation(
        operationId = "addTransactionType",
        summary = "Add a TransactionType",
        tags = { "TransactionTypes" },
        responses = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "200", description = "")
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/transactiontypes",
        consumes = { "application/json" }
    )
    default ResponseEntity<Void> addTransactionType(
        @Parameter(name = "TransactionType", description = "") @Valid @RequestBody(required = false) TransactionType transactionType
    ) {
        return new ResponseEntity<>(HttpStatus.OK);

    }


    /**
     * GET /transactiontypes/{id} : Retrieve transactionType data by id
     * TransactionType data by id
     *
     * @return A TransactionType&#39;s data (status code 200)
     *         or  (status code 200)
     */
    @Operation(
        operationId = "transactionType",
        summary = "Retrieve transactionType data by id",
        tags = { "TransactionType" },
        responses = {
            @ApiResponse(responseCode = "200", description = "A TransactionType's data", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = TransactionType.class))
            }),
            @ApiResponse(responseCode = "200", description = "")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/transactiontypes/{id}",
        produces = { "application/json" }
    )
    default ResponseEntity<TransactionType> transactionType(
            @Parameter(name = "id", description = "resource id", required = true) @PathVariable("id") Long id
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"code\" : \"code\", \"name\" : \"name\", \"id\" : 6 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.OK);

    }


    /**
     * PUT /transactiontypes/{id} : Update transactionType data by id
     * Update TransactionType data by id
     *
     * @param transactionType Update transactionType properties to be changed (optional)
     * @return A TransactionType&#39;s data (status code 200)
     *         or  (status code 200)
     */
    @Operation(
        operationId = "transactionTypeEdit",
        summary = "Update transactionType data by id",
        tags = { "TransactionType" },
        responses = {
            @ApiResponse(responseCode = "200", description = "A TransactionType's data", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = TransactionType.class))
            }),
            @ApiResponse(responseCode = "200", description = "")
        }
    )
    @RequestMapping(
        method = RequestMethod.PUT,
        value = "/transactiontypes/{id}",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    default ResponseEntity<TransactionType> transactionTypeEdit(
        @Parameter(name = "id", description = "resource id", required = true) @PathVariable("id") Long id,
        @Parameter(name = "TransactionType", description = "Update transactionType properties to be changed") @Valid @RequestBody(required = false) TransactionType transactionType
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"code\" : \"code\", \"name\" : \"name\", \"id\" : 6 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.OK);

    }


    /**
     * GET /transactiontypes : Retrieve all TransactionTypes
     * List of TransactionTypes
     *
     * @return A paged array of TransactionTypes (status code 200)
     *         or  (status code 200)
     */
    @Operation(
        operationId = "transactionTypes",
        summary = "Retrieve all TransactionTypes",
        tags = { "TransactionTypes" },
        responses = {
            @ApiResponse(responseCode = "200", description = "A paged array of TransactionTypes", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = TransactionType.class))
            }),
            @ApiResponse(responseCode = "200", description = "")
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/transactiontypes",
        produces = { "application/json" }
    )
    default ResponseEntity<List<TransactionType>> transactionTypes(
        
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"code\" : \"code\", \"name\" : \"name\", \"id\" : 6 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.OK);

    }

}