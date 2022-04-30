package com.ekin.tech.product.management.exceptions.base;

import java.io.Serializable;

public interface BaseException extends Serializable {

    BaseErrorInformation getErrorInformation();

    void setErrorInformation(BaseErrorInformation baseErrorInformation);

}
