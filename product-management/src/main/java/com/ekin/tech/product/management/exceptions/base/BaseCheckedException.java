package com.ekin.tech.product.management.exceptions.base;


public class BaseCheckedException extends Exception implements BaseException {

    private BaseErrorInformation errorInformation;

    public BaseCheckedException() {
    }

    public BaseCheckedException(BaseErrorInformation errorInformation) {
        super(errorInformation.getErrorDetail());
        this.errorInformation = errorInformation;
    }

    public BaseCheckedException(String message, BaseErrorInformation errorInformation) {
        super(message);
        this.errorInformation = errorInformation;
    }


    public BaseCheckedException(String message, Throwable cause, BaseErrorInformation errorInformation) {
        super(message, cause);
        this.errorInformation = errorInformation;
    }

    public BaseCheckedException(Throwable cause, BaseErrorInformation errorInformation) {
        super(cause);
        this.errorInformation = errorInformation;
    }

    public BaseCheckedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, BaseErrorInformation errorInformation) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.errorInformation = errorInformation;
    }

    @Override
    public BaseErrorInformation getErrorInformation() {
        return errorInformation;
    }

    @Override
    public void setErrorInformation(BaseErrorInformation baseErrorInformation) {
        this.errorInformation = baseErrorInformation;
    }

}
