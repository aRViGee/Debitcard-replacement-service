package com.sogyo.rvgelder.ipdebitcardreplacementflow.entity.exceptions;

public class CustomerNotOwnerOfCardException extends Exception {
    public CustomerNotOwnerOfCardException(String errorMessage, Throwable cause) {
        super(errorMessage, cause);
    }

    public CustomerNotOwnerOfCardException(String errorMessage) {
        super(errorMessage);
    }

    public CustomerNotOwnerOfCardException(Throwable cause) {
        super(cause);
    }
}
