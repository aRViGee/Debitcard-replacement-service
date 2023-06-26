package com.sogyo.rvgelder.ipdebitcardreplacementflow.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Array;
import java.util.ArrayList;

@Data
@Entity
public class Customer {
    @Id
    @GeneratedValue
    private final int customerID;
    private ArrayList<Enum> allowedActions;
    private Enum authorizationLevel;

    public Customer(int customerID, ArrayList<Enum> allowedActions, Enum authorizationLevel) {
        this.customerID = customerID;
        this.allowedActions = allowedActions;
        this.authorizationLevel = authorizationLevel;
    }
}
