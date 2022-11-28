package com.brandlogs.inventory.api.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.Valid;
import java.time.LocalDate;

@Entity
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("creationDate")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @Column(insertable = false,updatable = false)
    private LocalDate creationDate;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "vendor_id", nullable = false)
    @JsonProperty("vendor")
    private Vendor vendor;

    public Item id() {
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

    public Item name(String name) {
        this.name = name;
        return this;
    }

    /**
     * Get name
     * @return name
     */

    @Schema(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Item vendor(Vendor vendor) {
        this.vendor = vendor;
        return this;
    }

    /**
     * Get vendor
     * @return vendor
     */
    @Valid
    @Schema(name = "vendor")
    public Vendor getVendor() {
        return vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    /**
     * Get creationDate
     * @return creationDate
     */
    @Valid
    @Schema(name = "creationDate")
    public LocalDate getCreationDate() {
        return creationDate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Item {\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    vendor: ").append(toIndentedString(vendor)).append("\n");
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
