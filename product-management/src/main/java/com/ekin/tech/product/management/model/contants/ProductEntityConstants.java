package com.ekin.tech.product.management.model.contants;

public final class ProductEntityConstants {

    public static final String PRODUCT_SCHEMA_NAME = "product";
    public static final String PRODUCT_TABLE_NAME = "product_information";
    public static final String PRODUCT_SEQUENCE_NAME = PRODUCT_TABLE_NAME + "_seq";

    private ProductEntityConstants() {
        /* Singleton class cannot be instantiated! */
    }
}
