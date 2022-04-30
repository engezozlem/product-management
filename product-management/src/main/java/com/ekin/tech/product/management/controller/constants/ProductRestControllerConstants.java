package com.ekin.tech.product.management.controller.constants;

public final class ProductRestControllerConstants {

    public static final String PRODUCT = "Product";
    public static final String PRODUCT_ID_PATH_VARIABLE = "id";
    public static final String PRODUCT_NAME_PATH_VARIABLE = "productName";
    public static final String GET_ALL_PRODUCTS_PATH = "/getAllProducts";
    public static final String GET_PRODUCT_BY_ID_PATH = "/get" + PRODUCT + "/byId/{" + PRODUCT_ID_PATH_VARIABLE + "}";
    public static final String GET_PRODUCT_BY_NAME_PATH = "/get" + PRODUCT + "/byId/{" + PRODUCT_NAME_PATH_VARIABLE + "}";
    public static final String SAVE_PRODUCT_PATH = "/save" + PRODUCT;
    public static final String UPDATE_PRODUCT_PATH = "/update" + PRODUCT;
    public static final String DELETE_PRODUCT_BY_ID_PATH = "/deleteById/{" + PRODUCT_ID_PATH_VARIABLE + "}";
    public static final String DELETE_PRODUCT_BY_NAME_PATH = "/deleteByName/{" + PRODUCT_NAME_PATH_VARIABLE + "}";
    public static final String DELETE_ALL_PRODUCTS = "/deleteAllProducts";

    private ProductRestControllerConstants() {
        /* Singleton class cannot be instantiated! */
    }

}
