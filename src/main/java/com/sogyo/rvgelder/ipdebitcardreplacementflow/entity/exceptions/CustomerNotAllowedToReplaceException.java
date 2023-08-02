package com.sogyo.rvgelder.ipdebitcardreplacementflow.entity.exceptions;

public class CustomerNotAllowedToReplaceException extends Exception {
    public CustomerNotAllowedToReplaceException(String errorMessage) {
        super(errorMessage);
    }
}
