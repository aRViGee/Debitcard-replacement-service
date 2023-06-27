package com.sogyo.rvgelder.ipdebitcardreplacementflow.entity;

import jakarta.persistence.*;

import java.util.ArrayList;

@Entity(name="Card_Arrangement")
public class CardArrangement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(targetEntity = Customer.class)
    @JoinColumn(name = "customer_id", nullable = false)
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
//TODO Are the relationships working correctly?
