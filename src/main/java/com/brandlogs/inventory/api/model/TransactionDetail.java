package com.brandlogs.inventory.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

import javax.persistence.*;
import javax.validation.Valid;

@Entity
public class TransactionDetail {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "transaction_id")
    @JsonProperty("Transaction")
    private Transaction transaction;

    @ManyToOne
    @JoinColumn(name = "item_id")
    @JsonProperty("Item")
    private Item item;

    @JsonProperty("quantity")
    private Integer quantity;

    public TransactionDetail transaction(Transaction transaction) {
        this.transaction = transaction;
        return this;
    }

    public void setTransaction(Transaction transaction) {
        this.transaction = transaction;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Schema(name = "Transaction")
    public Transaction getTransaction() {
        return transaction;
    }

    public TransactionDetail item(Item item) {
        this.item = item;
        return this;
    }

    /**
     * Get item
     * @return item
     */
    @Valid
    @Schema(name = "Item")
    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public TransactionDetail quantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    /**
     * Get quantity
     * @return quantity
     */

    @Schema(name = "quantity")
    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class TransactionDetail {\n");
        sb.append("    transaction: ").append(toIndentedString(transaction)).append("\n");
        sb.append("    item: ").append(toIndentedString(item)).append("\n");
        sb.append("    quantity: ").append(toIndentedString(quantity)).append("\n");
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
