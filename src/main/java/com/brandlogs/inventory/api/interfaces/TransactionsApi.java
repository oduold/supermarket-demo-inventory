/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (6.2.1).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package com.brandlogs.inventory.api.interfaces;

import com.brandlogs.inventory.api.model.Item;
import com.brandlogs.inventory.api.model.Transaction;
import com.brandlogs.inventory.api.model.TransactionDetail;
import com.brandlogs.inventory.api.utils.ApiUtil;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Validated
public interface TransactionsApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /transactions/{type} : Add a StockTransaction
     * Add a StockTransaction
     *
     * @param transactionDetail  (optional)
     * @return OK (status code 200)
     *         or  (status code 200)
     */
    @Operation(
            operationId = "addStockTransaction",
            summary = "Add a StockTransaction",
            tags = { "StockTransactions" },
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK"),
                    @ApiResponse(responseCode = "200", description = "")
            }
    )
    @RequestMapping(
            method = RequestMethod.POST,
            value = "/transactions/{type}",
            consumes = { "application/json" }
    )
    default ResponseEntity<Void> addStockTransaction(
            @Parameter(name = "type", description = "transaction type code with enum value", required = true) @PathVariable("type") Transaction.TransactionTypeEnum type,
            @Parameter(name = "TransactionDetail", description = "") @Valid @RequestBody(required = false) List<TransactionDetail> transactionDetail
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /transactions/{id} : Retrieve stock transaction data by id
     * StockTransaction data by id
     *
     * @param id resource id (required)
     * @return A StockTransaction&#39;s data (status code 200)
     *         or  (status code 200)
     */
    @Operation(
            operationId = "stockTransaction",
            summary = "Retrieve stock transaction data by id",
            tags = { "StockTransaction" },
            responses = {
                    @ApiResponse(responseCode = "200", description = "A StockTransaction's data", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = TransactionDetail.class))
                    }),
                    @ApiResponse(responseCode = "200", description = "")
            }
    )
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/transactions/{id}",
            produces = { "application/json" }
    )
    default ResponseEntity<List<TransactionDetail>> stockTransaction(
            @Parameter(name = "id", description = "resource id", required = true) @PathVariable("id") Long id
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"Item\" : { \"vendor\" : { \"code\" : \"code\", \"name\" : \"name\", \"id\" : 6 }, \"name\" : \"name\", \"id\" : 0, \"creationDate\" : \"2000-01-23\" }, \"quantity\" : 5, \"transaction\" : { \"transactionType\" : \"receive\", \"storeTransfer\" : true, \"vendorTransfer\" : true, \"id\" : 0, \"source\" : 6, \"transactionDate\" : \"2000-01-23\", \"target\" : 1 } }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /transactions/{type} : Retrieve all StockTransactions Detail
     * List of StockTransactions Details
     *
     * @param type transaction type code with enum value (required)
     * @param source store code | vendor code (optional)
     * @param target store code | vendor code (optional)
     * @param from Transaction Date from (optional)
     * @param to Transaction Date to (optional)
     * @return A paged array of StockTransaction Details (status code 200)
     *         or  (status code 200)
     */
    @Operation(
            operationId = "stockTransactionsItems",
            summary = "Retrieve StockItems in StockTransactions Resource",
            tags = { "StockItems" },
            responses = {
                    @ApiResponse(responseCode = "200", description = "A paged array of StockTransaction Details", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = TransactionDetail.class))
                    }),
                    @ApiResponse(responseCode = "200", description = "")
            }
    )
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/transactions/items",
            produces = { "application/json" }
    )
    default ResponseEntity<List<Item>> stockTransactionsItems(
            @Parameter(name = "type", description = "transaction type code with enum value") @Valid @RequestParam(value = "type", required = false)Transaction.TransactionTypeEnum type,
            @Parameter(name = "vendor", description = "is it a vendor based stock items transfer") @Valid @RequestParam(value = "vendor", required = false, defaultValue = "false") boolean vendor,
            @Parameter(name = "source", description = "store code | vendor code") @Valid @RequestParam(value = "source", required = false) String source,
            @Parameter(name = "target", description = "store code | vendor code") @Valid @RequestParam(value = "target", required = false) String target,
            @Parameter(name = "from", description = "Transaction Date from") @Valid @RequestParam(value = "from", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate from,
            @Parameter(name = "to", description = "Transaction Date to") @Valid @RequestParam(value = "to", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate to
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"Item\" : { \"vendor\" : { \"code\" : \"code\", \"name\" : \"name\", \"id\" : 6 }, \"name\" : \"name\", \"id\" : 0, \"creationDate\" : \"2000-01-23\" }, \"quantity\" : 5, \"transaction\" : { \"transactionType\" : \"receive\", \"storeTransfer\" : true, \"vendorTransfer\" : true, \"id\" : 0, \"source\" : 6, \"transactionDate\" : \"2000-01-23\", \"target\" : 1 } }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }

}
