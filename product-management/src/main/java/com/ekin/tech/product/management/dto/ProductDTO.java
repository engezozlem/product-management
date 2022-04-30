package com.ekin.tech.product.management.dto;

import javax.validation.constraints.NotNull;

public class ProductDTO extends BaseDTO {

    @NotNull
    private String productName;

    @NotNull
    private String productDescription;

    @NotNull
    private String productCode;

    public ProductDTO() {
    }

    public ProductDTO(@NotNull Long id, String productName, String productDescription, String productCode) {
        super(id);
        this.productName = productName;
        this.productDescription = productDescription;
        this.productCode = productCode;
    }

    public ProductDTO(String productName, String productDescription, String productCode) {
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
