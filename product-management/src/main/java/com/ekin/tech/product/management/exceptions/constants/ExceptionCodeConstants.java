package com.ekin.tech.product.management.exceptions.constants;

public class ExceptionCodeConstants {

    public static final String SAVE_EXCEPTION_CODE = "SAVE-100";
    public static final String UPDATE_EXCEPTION_CODE = "UPDATE-100";
    public static final String DELETE_EXCEPTION_CODE = "DELETE-100";
    public static final String GET_EXCEPTION_CODE = "GET-100";
    public static final String UNIQUE_VIOLATION_EXCEPTION_CODE = "UNIQUE-VIOLATION-100";
    public static final String SAVE_ERROR_MESSAGE = "An error occurred while saving.";
    public static final String UPDATE_ERROR_MESSAGE = "An error occurred while updating.";
    public static final String DELETE_ERROR_MESSAGE = "An error occurred while deleting.";
    public static final String GET_ERROR_MESSAGE = "An error occurred while getting.";
    public static final String UNIQUE_VIOLATION_ERROR_MESSAGE = "An error occurred while an attempt to insert or update data results in violation of an integrity constraint.";

    private ExceptionCodeConstants() {
        /* Singleton class cannot be instantiated! */
    }

}
