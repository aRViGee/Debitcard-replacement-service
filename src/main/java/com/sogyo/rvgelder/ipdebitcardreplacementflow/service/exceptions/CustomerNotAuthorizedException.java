package com.sogyo.rvgelder.ipdebitcardreplacementflow.service.exceptions;

public class CustomerNotAuthorizedException extends Exception{
    public CustomerNotAuthorizedException(String errorMessage) {
        super(errorMessage);
    }
}
