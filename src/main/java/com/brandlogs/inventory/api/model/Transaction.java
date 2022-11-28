package com.brandlogs.inventory.api.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
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

    /**
     * Gets or Sets transactionType
     */
    public enum TransactionTypeEnum {
        receipts("receipts"),

        releases("releases"),

        returns("returns");

        private final String value;

        TransactionTypeEnum(String value) {
            this.value = value;
        }

        @JsonValue
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        @JsonCreator
        public static TransactionTypeEnum fromValue(String value) {
            for (TransactionTypeEnum b : TransactionTypeEnum.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            throw new IllegalArgumentException("Unexpected value '" + value + "'");
        }
    }

    @JsonProperty("transactionType")
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TransactionTypeEnum transactionType;

    @JsonProperty("storeTransfer")
    private Boolean storeTransfer;

    @JsonProperty("vendorTransfer")
    private Boolean vendorTransfer;

    @JsonProperty("source")
    private Long source;

    @JsonProperty("target")
    private Long target;
    @JsonProperty("transactionDate")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(insertable = false,updatable = false)
    private LocalDate transactionDate;


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

    public Transaction transactionType(TransactionTypeEnum transactionType) {
        this.transactionType = transactionType;
        return this;
    }

    /**
     * Get transactionType
     * @return transactionType
     */

    @Schema(name = "transactionType")
    public TransactionTypeEnum getTransactionType() {
        return transactionType;
    }

    public void setTransactionType(TransactionTypeEnum transactionType) {
        this.transactionType = transactionType;
    }

    public Transaction storeTransfer(Boolean storeTransfer) {
        this.storeTransfer = storeTransfer;
        return this;
    }

    /**
     * Get storeTransfer
     * @return storeTransfer
     */

    @Schema(name = "storeTransfer")
    public Boolean getStoreTransfer() {
        return storeTransfer;
    }

    public void setStoreTransfer(Boolean storeTransfer) {
        this.storeTransfer = storeTransfer;
    }

    public Transaction vendorTransfer(Boolean vendorTransfer) {
        this.vendorTransfer = vendorTransfer;
        return this;
    }

    /**
     * Get vendorTransfer
     * @return vendorTransfer
     */

    @Schema(name = "vendorTransfer")
    public Boolean getVendorTransfer() {
        return vendorTransfer;
    }

    public void setVendorTransfer(Boolean vendorTransfer) {
        this.vendorTransfer = vendorTransfer;
    }

    public Transaction source(Long source) {
        this.source = source;
        return this;
    }

    /**
     * Get source
     * @return source
     */

    @Schema(name = "source")
    public Long getSource() {
        return source;
    }

    public void setSource(Long source) {
        this.source = source;
    }

    public Transaction target(Long target) {
        this.target = target;
        return this;
    }

    /**
     * Get target
     * @return target
     */

    @Schema(name = "target")
    public Long getTarget() {
        return target;
    }

    public void setTarget(Long target) {
        this.target = target;
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
        sb.append("    storeTransfer: ").append(toIndentedString(storeTransfer)).append("\n");
        sb.append("    vendorTransfer: ").append(toIndentedString(vendorTransfer)).append("\n");
        sb.append("    source: ").append(toIndentedString(source)).append("\n");
        sb.append("    target: ").append(toIndentedString(target)).append("\n");
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
