package com.ekin.tech.product.management.exceptions.base;

import com.ekin.tech.product.management.exceptions.constants.ExceptionType;

import java.io.Serializable;
import java.util.Date;

public class BaseErrorInformation implements Serializable {

    private ExceptionType exceptionType;

    private String errorDetail;

    private Date time;

    public BaseErrorInformation() {
    }

    public BaseErrorInformation(ExceptionType exceptionType, String errorDetail, Date time) {
        this.exceptionType = exceptionType;
        this.errorDetail = errorDetail;
        this.time = time;
    }

    public ExceptionType getExceptionType() {
        return exceptionType;
    }

    public void setExceptionType(ExceptionType exceptionType) {
        this.exceptionType = exceptionType;
    }

    public String getErrorDetail() {
        return errorDetail;
    }

    public void setErrorDetail(String errorDetail) {
        this.errorDetail = errorDetail;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}
