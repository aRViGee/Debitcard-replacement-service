package com.sogyo.rvgelder.ipdebitcardreplacementflow.entity;

import jakarta.persistence.*;

import java.util.ArrayList;


@Entity
@Table(name="Customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Convert(converter = AuthorizationLevelConverter.class)
    @Column(name = "authorization_level", nullable = false, length = 1)
    private AuthorizationLevel authorizationLevel;
    @OneToMany(targetEntity = CardArrangement.class)
    @Column(name = "card_arrangement_list", nullable = false/*, length = 25*/)
    private ArrayList<CardArrangement> cardArrangementArrayList;

    public Customer() {}

    public Customer(int id, AuthorizationLevel authorizationLevel, ArrayList<CardArrangement> cardArrangementArrayList) {
        this.id = id;
        this.authorizationLevel = authorizationLevel;
        this.cardArrangementArrayList = cardArrangementArrayList;
    }
}
