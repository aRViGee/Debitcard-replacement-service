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
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = Customer.class)
    @JoinColumn(name = "customer_id", referencedColumnName = "id", nullable = false /*, length = 25*/)
    private final Customer customer;
    @OneToMany(mappedBy = "cardArrangement", fetch = FetchType.EAGER, targetEntity = Card.class)
    private List<Card> cards;

    public CardArrangement(Customer customer) {
        if (customer == null) {
            throw new RuntimeException("Customer must be specified");
        }
        this.customer = customer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }
}
//TODO Are the relationships working correctly?
