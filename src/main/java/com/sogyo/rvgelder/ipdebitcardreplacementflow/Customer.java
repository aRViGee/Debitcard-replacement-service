package com.sogyo.rvgelder.ipdebitcardreplacementflow;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Customer {
    private final int customerID;
    private ArrayList<Enum> allowedActions;
    private Enum authorizationLevel;

    public Customer(int customerID, ArrayList<Enum> allowedActions, Enum authorizationLevel) {
        this.customerID = customerID;
        this.allowedActions = allowedActions;
        this.authorizationLevel = authorizationLevel;
    }
}
