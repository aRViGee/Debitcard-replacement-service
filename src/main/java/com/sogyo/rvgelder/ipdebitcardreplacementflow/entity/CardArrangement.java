package com.sogyo.rvgelder.ipdebitcardreplacementflow.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

//TODO check if the relations with arrayList table are correct when there are CardArrangement rows.

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
    private List<Card> cards;

    public CardArrangement(){}

    public CardArrangement(int id, int customerID, ArrayList<Card> cards) {
        this.id = id;
        this.customerID = customerID;
        this.cards = cards;
    }
}
//TODO Are the relationships working correctly?
