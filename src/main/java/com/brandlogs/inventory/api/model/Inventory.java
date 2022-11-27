package com.brandlogs.inventory.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.Valid;
import java.time.LocalDate;

public class Inventory {
    @JsonProperty("stockItem")
    private Item stockItem;

    @JsonProperty("Location")
    private Location location;

    @JsonProperty("quantity")
    private Long quantity;

    @JsonProperty("created")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate created;

    @JsonProperty("modified")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate modified;

    public Inventory stockItem(Item stockItem) {
        this.stockItem = stockItem;
        return this;
    }

    /**
     * Get stockItem
     * @return stockItem
     */
    @Valid
    @Schema(name = "stockItem")
    public Item getStockItem() {
        return stockItem;
    }

    public void setStockItem(Item stockItem) {
        this.stockItem = stockItem;
    }

    public Inventory location(Location location) {
        this.location = location;
        return this;
    }

    /**
     * Get location
     * @return location
     */
    @Valid
    @Schema(name = "Location")
    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Inventory quantity(Long quantity) {
        this.quantity = quantity;
        return this;
    }

    /**
     * Get quantity
     * @return quantity
     */

    @Schema(name = "quantity")
    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Inventory created(LocalDate created) {
        this.created = created;
        return this;
    }

    /**
     * Get created
     * @return created
     */
    @Valid
    @Schema(name = "created")
    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public Inventory modified(LocalDate modified) {
        this.modified = modified;
        return this;
    }

    /**
     * Get modified
     * @return modified
     */
    @Valid
    @Schema(name = "modified")
    public LocalDate getModified() {
        return modified;
    }

    public void setModified(LocalDate modified) {
        this.modified = modified;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Inventory {\n");
        sb.append("    stockItem: ").append(toIndentedString(stockItem)).append("\n");
        sb.append("    location: ").append(toIndentedString(location)).append("\n");
        sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
        sb.append("    created: ").append(toIndentedString(created)).append("\n");
        sb.append("    modified: ").append(toIndentedString(modified)).append("\n");
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
