package com.sogyo.rvgelder.ipdebitcardreplacementflow.entity;



import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="CardArrangement")
public class CardArrangement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "cardArrangement_Type")
    private String cardArrangementType; //TODO - Make this of type Enum ('Debit_Card', 'Credit_Card')
    @OneToOne(/*mappedBy = "cardArrangement",*/ cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER, targetEntity = Card.class)
//    @OneToMany(mappedBy = "cardArrangement", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER, targetEntity = Card.class)
    private List<Card> cards;

    public CardArrangement() { }

    public CardArrangement(String cardArrangementType, List<Card> cards) {
        this.cardArrangementType = cardArrangementType;
        this.cards = cards;
    }

    public List<Card> getCards() {
        return cards;
    }

    public String getCardArrangementType() {
        return cardArrangementType;
    }
}