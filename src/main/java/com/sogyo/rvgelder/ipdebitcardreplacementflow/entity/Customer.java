package com.sogyo.rvgelder.ipdebitcardreplacementflow.entity;


import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="Customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "customer_number")
    private String customerNumber;
    @Convert(converter = AuthorizationLevelConverter.class)
    @Column(name = "authorization_level", nullable = false, length = 1)
    private AuthorizationLevel authorizationLevel;
//    @OneToOne/*(*//*mappedBy = "customer",*//* cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)*/
    @OneToMany(/*mappedBy = "customer", */cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @Column(name = "cardArrangements")
    private List<CardArrangement> cardArrangements = new ArrayList<>();

    public Customer() {}

    public Customer(String customerNumber, AuthorizationLevel authorizationLevel, List<CardArrangement> cardArrangements) {
        this.customerNumber = customerNumber;
        this.authorizationLevel = authorizationLevel;
        this.cardArrangements = cardArrangements;
    }

    public List<CardArrangement> getCardArrangements() {
        return cardArrangements;
    }
}
