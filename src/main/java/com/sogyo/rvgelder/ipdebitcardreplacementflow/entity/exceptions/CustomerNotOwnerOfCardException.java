package com.sogyo.rvgelder.ipdebitcardreplacementflow.entity.exceptions;

public class CustomerNotOwnerOfCardException extends Exception {
    public CustomerNotOwnerOfCardException(String errorMessage) {
        super(errorMessage);
    }
}
