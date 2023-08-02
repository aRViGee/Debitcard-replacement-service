package com.sogyo.rvgelder.ipdebitcardreplacementflow.service.exceptions;

public class CustomerNotFoundException extends Exception{
    public CustomerNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
