package com.sogyo.rvgelder.ipdebitcardreplacementflow.entity;


import com.sogyo.rvgelder.ipdebitcardreplacementflow.service.CardServiceImpl;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.service.CustomerService;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.service.CustomerServiceImpl;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="Customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "customer_number", unique = true, nullable = false)
    private String customerNumber;
    @Convert(converter = AuthorizationLevelConverter.class)
    @Column(name = "authorization_level", nullable = false, length = 1)
    private AuthorizationLevel authorizationLevel;
    @OneToMany(cascade = CascadeType.ALL, /*orphanRemoval = true,*/ fetch = FetchType.LAZY/*, targetEntity = CardArrangement.class*/)
    @JoinColumn(name = "customer_id")
    private List<CardArrangement> cardArrangements/* = new ArrayList<>()*/;

    public Customer() {
    }

    public Customer(String customerNumber, AuthorizationLevel authorizationLevel, List<CardArrangement> cardArrangements) {
        this.customerNumber = customerNumber;
        this.authorizationLevel = authorizationLevel;
        this.cardArrangements = cardArrangements;
    }

    public List<CardArrangement> getCardArrangements() {
        return cardArrangements;
    }

    public String getCustomerNumber() {
        return customerNumber;
    }

    public AuthorizationLevel getAuthorizationLevel() {
        return authorizationLevel;
    }

    public void replaceCard(Card card) {
        if (this.cardReplacementIsValid(card)) {
            if (CustomerServiceImpl.isAuthorized(this.getCustomerNumber(), 3)) { //TODO - External authorization implementation
//                TODO - Fulfillment:
//                  TODO - Fulfillment - Create new card
//                      TODO - Fulfillment - if new card created: set end_date current card
                this.fulfillReplaceCard(card);
            }

        }
    }

    private void fulfillReplaceCard(Card card) {

        this.createNewDebitCard();
//        this.setNewEndDateOldCard(card);
    }

    private boolean createNewDebitCard() {
        this.createNewDebitCard(this);
        return true;
    }

    private boolean cardReplacementIsValid(Card card) {
        return (this.isOwnerOfCard(card)) && (this.isAllowedToReplace());
    }

    private boolean isOwnerOfCard(Card card) { //TODO - refactor using (flat)Map of forEach?
        for (int indexCardArrangements = 0; indexCardArrangements < this.getCardArrangements().size(); indexCardArrangements++) {
            for (int indexCards = 0; indexCards < this.getCardArrangements().get(indexCardArrangements).getCards().size(); indexCards++) {
                if (this.getCardArrangements().get(indexCardArrangements).getCards().get(indexCards).equals(card)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isAllowedToReplace() {
        return AuthorizationLevel.checkAllowedActions(this.getAuthorizationLevel());
    }

    private boolean createNewDebitCard(Customer customer) {
        Card card = new Card("5E6F7G8H", Status.INACTIVE);
        customer.getCardArrangements().get(0).getCards().add(card);
        return true;
    }
}
