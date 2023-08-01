package com.sogyo.rvgelder.ipdebitcardreplacementflow.entity.exceptions;

public class CustomerNotOwnerOfCardException extends RuntimeException {
    public CustomerNotOwnerOfCardException(String errorMessage, Throwable err) {
        super(errorMessage, err);
    }
}
