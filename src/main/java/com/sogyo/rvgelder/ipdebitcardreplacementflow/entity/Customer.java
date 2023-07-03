package com.sogyo.rvgelder.ipdebitcardreplacementflow.entity;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name="Customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Convert(converter = AuthorizationLevelConverter.class)
    @Column(name = "authorization_level", nullable = false, length = 1)
    private AuthorizationLevel authorizationLevel;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<CardArrangement> cardArrangements; //TODO Deze lijst verschijnt niet als column in de Customer table. Klopt dit en hoe roep ik deze nu aan?

    public Customer() {}

    public Customer(AuthorizationLevel authorizationLevel) {

        this.authorizationLevel = authorizationLevel;
    }

    public int getId() {
        return id;
    }

    public AuthorizationLevel getAuthorizationLevel() {
        return authorizationLevel;
    }

//    public void setAuthorizationLevel(AuthorizationLevel authorizationLevel) {
//        this.authorizationLevel = authorizationLevel;
//    }

    public List<CardArrangement> getCardArrangements() {
        return cardArrangements;
    }

//    public void setCardArrangements(List<CardArrangement> cardArrangements) {
//        this.cardArrangements = cardArrangements;
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return id == customer.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
