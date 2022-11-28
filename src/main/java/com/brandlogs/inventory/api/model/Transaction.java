package com.brandlogs.inventory.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.Valid;
import java.time.LocalDate;

@Entity
@Table(name = "stock_transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "transaction_type_id")
    @JsonProperty("transactionType")
    private TransactionType transactionType;

    @ManyToOne
    @JoinColumn(name = "store_id")
    @JsonProperty("store")
    private Location store;

    @ManyToOne
    @JoinColumn(name = "vendor_id")
    @JsonProperty("Vendor")
    private Vendor vendor;

    @JsonProperty("transactionDate")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate transactionDate;

    public Transaction id(Long id) {
        this.id = id;
        return this;
    }

    /**
     * Get id
     * @return id
     */

    @Schema(name = "id")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Transaction transactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
        return this;
    }

    /**
     * Get transactionType
     * @return transactionType
     */
    @Valid
    @Schema(name = "transactionType")
    public TransactionType getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    public Transaction store(Location store) {
        this.store = store;
        return this;
    }

    /**
     * Get store
     * @return store
     */
    @Valid
    @Schema(name = "store")
    public Location getStore() {
        return store;
    }

    public void setStore(Location store) {
        this.store = store;
    }

    public Transaction vendor(Vendor vendor) {
        this.vendor = vendor;
        return this;
    }

    /**
     * Get vendor
     * @return vendor
     */
    @Valid
    @Schema(name = "Vendor")
    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public Transaction transactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
        return this;
    }

    /**
     * Get transactionDate
     * @return transactionDate
     */
    @Valid
    @Schema(name = "transactionDate")
    public LocalDate getTransactionDate() {
        return transactionDate;
    }

    public void setTransactionDate(LocalDate transactionDate) {
        this.transactionDate = transactionDate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Transaction {\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    transactionType: ").append(toIndentedString(transactionType)).append("\n");
        sb.append("    store: ").append(toIndentedString(store)).append("\n");
        sb.append("    vendor: ").append(toIndentedString(vendor)).append("\n");
        sb.append("    transactionDate: ").append(toIndentedString(transactionDate)).append("\n");
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
