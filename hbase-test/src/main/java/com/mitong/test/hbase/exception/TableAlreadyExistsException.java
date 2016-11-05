package com.mitong.test.hbase.exception;

/**
 * @author tong.mi
 * @email tong.mi@qunar.com
 * @date 16-1-21
 * @description
 */
public class TableAlreadyExistsException extends Exception {
    public TableAlreadyExistsException() {
    }

    public TableAlreadyExistsException(String message) {
        super(message);
    }

    public TableAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public TableAlreadyExistsException(Throwable cause) {
        super(cause);
    }

    public TableAlreadyExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
