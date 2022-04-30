package com.ekin.tech.product.management.model;

/* TODO 2 : add javadoc on getter and setters methods */
/* TODO 3 : add sequence implementation */

import com.ekin.tech.product.management.model.contants.ProductEntityConstants;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

@Entity
@Table(schema = ProductEntityConstants.PRODUCT_SCHEMA_NAME, name = ProductEntityConstants.PRODUCT_TABLE_NAME,
        uniqueConstraints = {
                @UniqueConstraint(name = "ID_PRODUCT_NAME_CONSTRAINT", columnNames = {"ID", "PRODUCT_NAME"}),
                @UniqueConstraint(name = "PRODUCT_NAME_CODE_CONSTRAINT", columnNames = {"PRODUCT_NAME", "PRODUCT_CODE"})}
)
public class ProductEntity extends BaseEntity {

    @NotNull
    @Column(name = "PRODUCT_NAME")
    private String productName;

    @NotNull
    @Column(name = "PRODUCT_DESCRIPTION")
    private String productDescription;

    @NotNull
    @Column(name = "PRODUCT_CODE")
    private String productCode;

    public ProductEntity() {
    }

    public ProductEntity(String productName, String productDescription, String productCode) {
        this.productName = productName;
        this.productDescription = productDescription;
        this.productCode = productCode;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }
}
