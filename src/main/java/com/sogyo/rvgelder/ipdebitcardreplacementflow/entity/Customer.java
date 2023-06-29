package com.sogyo.rvgelder.ipdebitcardreplacementflow.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

//TODO check if the relations with arrayList table are correct when there are Customer rows.

@Entity
@Table(name="Customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Convert(converter = AuthorizationLevelConverter.class)
    @Column(name = "authorization_level", nullable = false, length = 1)
    private AuthorizationLevel authorizationLevel;
    @OneToMany(targetEntity = CardArrangement.class)
    @Column(name = "card_arrangement_list", nullable = true /*, length = 25*/)
    private List<CardArrangement> cardArrangements;

    public Customer() {}

    public Customer(AuthorizationLevel authorizationLevel) {
        this.authorizationLevel = authorizationLevel;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public AuthorizationLevel getAuthorizationLevel() {
        return authorizationLevel;
    }

    public void setAuthorizationLevel(AuthorizationLevel authorizationLevel) {
        this.authorizationLevel = authorizationLevel;
    }

    public List<CardArrangement> getCardArrangements() {
        return cardArrangements;
    }

    public void setCardArrangements(List<CardArrangement> cardArrangements) {
        this.cardArrangements = cardArrangements;
    }
    //    public record CustomerTest(
//            @Id Integer id,
//            @Convert(converter = AuthorizationLevelConverter.class) AuthorizationLevel authorizationLevel,
//            ArrayList<CardArrangement> cardArrangementArrayList
//            ){}
}
