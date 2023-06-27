package com.sogyo.rvgelder.ipdebitcardreplacementflow.entity;

import jakarta.persistence.*;

import java.util.ArrayList;

@Entity(name="Card_Arrangement")
public class CardArrangement {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "customer_id", nullable = false)
    private int customerID;
    @OneToMany(targetEntity = Card.class)
    @Column(name = "card_list", nullable = false)
    private ArrayList<Card> cardArrayList;

    public CardArrangement(){}

    public CardArrangement(int id, int customerID, ArrayList<Card> cardArrayList) {
        this.id = id;
        this.customerID = customerID;
        this.cardArrayList = cardArrayList;
    }
}

