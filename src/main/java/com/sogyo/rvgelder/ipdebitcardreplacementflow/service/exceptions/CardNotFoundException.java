package com.sogyo.rvgelder.ipdebitcardreplacementflow.service.exceptions;

public class CardNotFoundException extends Exception{
    public CardNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
