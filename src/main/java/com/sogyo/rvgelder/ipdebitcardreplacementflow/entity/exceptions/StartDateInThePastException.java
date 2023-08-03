package com.sogyo.rvgelder.ipdebitcardreplacementflow.entity.exceptions;

public class StartDateInThePastException extends Exception {
    public StartDateInThePastException(String message) {
        super(message);
    }
}
