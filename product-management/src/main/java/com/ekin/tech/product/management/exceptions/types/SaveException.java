package com.ekin.tech.product.management.exceptions.types;

import com.ekin.tech.product.management.exceptions.base.BaseCheckedException;
import com.ekin.tech.product.management.exceptions.base.BaseErrorInformation;
import com.ekin.tech.product.management.exceptions.constants.ExceptionCodeConstants;
import com.ekin.tech.product.management.exceptions.constants.ExceptionType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

public class SaveException extends BaseCheckedException {

    private static final Logger LOGGER = LoggerFactory.getLogger(SaveException.class);
    private static final String EXCEPTION_LOG =
            "\n Time : {} " +
                    "\n Exception Code : {} " +
                    "\n Exception Message : {} " +
                    "\n Error Detail : {} ";

    public SaveException(Exception exception) {
        super();
        this.setErrorInformation(
                new BaseErrorInformation(
                        ExceptionType.SAVE_EXCEPTION, ExceptionCodeConstants.SAVE_ERROR_MESSAGE, new Date()
                )
        );
        LOGGER.error(EXCEPTION_LOG,
                this.getErrorInformation().getTime(),
                ExceptionCodeConstants.SAVE_EXCEPTION_CODE,
                exception.getMessage(),
                this.getErrorInformation().getErrorDetail());
    }
}
