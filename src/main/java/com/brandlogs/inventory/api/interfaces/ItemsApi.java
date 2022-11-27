package com.brandlogs.inventory.api.interfaces;

import com.brandlogs.inventory.api.utils.ApiUtil;
import com.brandlogs.inventory.api.model.Item;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
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
public interface ItemsApi {

    default Optional<NativeWebRequest> getRequest() {
        return Optional.empty();
    }

    /**
     * POST /items : Add a StockItem
     * Add a StockItems
     *
     * @param item  (optional)
     * @return OK (status code 200)
     *         or  (status code 200)
     */
    @Operation(
            operationId = "addStockItem",
            summary = "Add a StockItem",
            tags = { "StockItems" },
            responses = {
                    @ApiResponse(responseCode = "200", description = "OK"),
                    @ApiResponse(responseCode = "200", description = "")
            }
    )
    @RequestMapping(
            method = RequestMethod.POST,
            value = "/items",
            consumes = { "application/json" }
    )
    default ResponseEntity<Item> addStockItem(
            @Parameter(name = "Item", description = "") @Valid @RequestBody(required = true) Item item
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);
    }



    /**
     * GET /items/{id} : Retrieve stock item data by id
     * Stock Item data by id
     *
     * @param id resource id (required)
     * @return A Stock Item&#39;s data (status code 200)
     *         or  (status code 200)
     */
    @Operation(
            operationId = "item",
            summary = "Retrieve stock item data by id",
            tags = { "StockItem" },
            responses = {
                    @ApiResponse(responseCode = "200", description = "A Stock Item's data", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = Item.class))
                    }),
                    @ApiResponse(responseCode = "200", description = "")
            }
    )
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/items/{id}",
            produces = { "application/json" }
    )
    default ResponseEntity<Item> item(
            @Parameter(name = "id", description = "resource id", required = true) @PathVariable("id") Long id
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"vendor\" : { \"code\" : \"code\", \"name\" : \"name\", \"id\" : 6 }, \"name\" : \"name\", \"id\" : 0 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }


    /**
     * DELETE /items/{id} : Delete stock item data by id
     * Stock Item data by id
     *
     * @param id resource id (required)
     * @return A Stock Item&#39;s deleted (status code 200)
     *         or  (status code 200)
     */
    @Operation(
            operationId = "itemDelete",
            summary = "Delete stock item data by id",
            tags = { "StockItem" },
            responses = {
                    @ApiResponse(responseCode = "200", description = "A Stock Item's deleted"),
                    @ApiResponse(responseCode = "200", description = "")
            }
    )
    @RequestMapping(
            method = RequestMethod.DELETE,
            value = "/items/{id}"
    )
    default ResponseEntity<Void> itemDelete(
            @Parameter(name = "id", description = "resource id", required = true) @PathVariable("id") Long id
    ) {
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * PUT /items/{id} : Update stock item data by id
     * Update Stock Item data by id
     *
     * @param id resource id (required)
     * @param item Update stock item properties to be changed (optional)
     * @return A Stock Item&#39;s data (status code 200)
     *         or  (status code 200)
     */
    @Operation(
            operationId = "itemEdit",
            summary = "Update stock item data by id",
            tags = { "StockItem" },
            responses = {
                    @ApiResponse(responseCode = "200", description = "A Stock Item's data", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = Item.class))
                    }),
                    @ApiResponse(responseCode = "200", description = "")
            }
    )
    @RequestMapping(
            method = RequestMethod.PUT,
            value = "/items/{id}",
            produces = { "application/json" },
            consumes = { "application/json" }
    )
    default ResponseEntity<Item> itemEdit(
            @Parameter(name = "id", description = "resource id", required = true) @PathVariable("id") Long id,
            @Parameter(name = "Item", description = "Update stock item properties to be changed") @Valid @RequestBody(required = false) Item item
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType: MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"vendor\" : { \"code\" : \"code\", \"name\" : \"name\", \"id\" : 6 }, \"name\" : \"name\", \"id\" : 0 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.NOT_IMPLEMENTED);

    }


    /**
     * GET /items : Retrieve all StockItems
     * List of StockItems
     *
     * @param created Date of creation of resource (optional)
     * @return A paged array of StockItems (status code 200)
     *         or http unexpected errors (status code 200)
     */
    @Operation(
            operationId = "stockItems",
            summary = "Retrieve all StockItems",
            tags = { "StockItems" },
            responses = {
                    @ApiResponse(responseCode = "200", description = "A paged array of StockItems", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = Item.class))
                    }),
                    @ApiResponse(responseCode = "200", description = "http unexpected errors", content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = Error.class))
                    })
            }
    )
    @RequestMapping(
            method = RequestMethod.GET,
            value = "/items",
            produces = { "application/json" }
    )
    default ResponseEntity<List<Item>> stockItems(
            @Parameter(name = "created",
            description = "Date of creation of resource") @Valid @RequestParam(value = "created",
            required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate created
    ) {
        getRequest().ifPresent(request -> {
            for (MediaType mediaType : MediaType.parseMediaTypes(request.getHeader("Accept"))) {
                if (mediaType.isCompatibleWith(MediaType.valueOf("application/json"))) {
                    String exampleString = "{ \"vendor\" : { \"code\" : \"code\", \"name\" : \"name\", \"id\" : 6 }, \"name\" : \"name\", \"id\" : 0 }";
                    ApiUtil.setExampleResponse(request, "application/json", exampleString);
                    break;
                }
            }
        });
        return new ResponseEntity<>(HttpStatus.MULTI_STATUS);
    }
}
