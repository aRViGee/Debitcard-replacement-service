package com.sogyo.rvgelder.ipdebitcardreplacementflow.entity.exceptions;

public class CardIsInactiveException extends Exception {
    public CardIsInactiveException(String message) {
        super(message);
    }
}
