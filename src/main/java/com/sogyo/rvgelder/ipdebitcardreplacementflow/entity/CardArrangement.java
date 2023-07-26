package com.sogyo.rvgelder.ipdebitcardreplacementflow.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="Card_Arrangement")
public class CardArrangement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cardArrangement_Type", nullable = false)
    private String cardArrangementType;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true,fetch = FetchType.EAGER)
    @JoinColumn(name = "card_arrangement_id")
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