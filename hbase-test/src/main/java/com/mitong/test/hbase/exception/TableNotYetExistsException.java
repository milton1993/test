package com.mitong.test.hbase.exception;

/**
 * @author tong.mi
 * @email tong.mi@qunar.com
 * @date 16-1-21
 * @description
 */
public class TableNotYetExistsException extends Exception {
    public TableNotYetExistsException() {
    }

    public TableNotYetExistsException(String message) {
        super(message);
    }

    public TableNotYetExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public TableNotYetExistsException(Throwable cause) {
        super(cause);
    }

    public TableNotYetExistsException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
