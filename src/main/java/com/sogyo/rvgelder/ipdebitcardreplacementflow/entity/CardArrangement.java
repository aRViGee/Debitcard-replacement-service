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
    private String cardArrangementType;
    @OneToOne(/*mappedBy = "cardArrangement",*/ cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER, targetEntity = Card.class)
//    @OneToMany(mappedBy = "cardArrangement", cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER, targetEntity = Card.class)
    private List<Card> cards = new ArrayList<>();

    public CardArrangement() { }

    public CardArrangement(String cardArrangementType, List<Card> cards) {
        this.cardArrangementType = cardArrangementType;
        this.cards = cards;
    }

    public List<Card> getCards() {
        return cards;
    }
}