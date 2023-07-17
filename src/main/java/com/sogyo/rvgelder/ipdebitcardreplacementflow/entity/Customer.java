package com.sogyo.rvgelder.ipdebitcardreplacementflow.entity;

import com.sogyo.rvgelder.ipdebitcardreplacementflow.service.CustomerServiceImpl;
import jakarta.persistence.*;
import org.apache.commons.lang3.RandomStringUtils;

import java.time.LocalDate;
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
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "customer_id")
    private List<CardArrangement> cardArrangements;

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


    public Card replaceCard(Card card) {
        if (card.getStartDate().isBefore(LocalDate.now()) && !(card.getStatus().equals(Status.INACTIVE)) && (this.cardReplacementIsValid(card) && (CustomerServiceImpl.isAuthorized(this.getCustomerNumber(), 3)))) {
                return this.fulfillReplaceCard(card);

        }
       return null;
    }

    private boolean cardReplacementIsValid(Card card) {
        return (this.isOwnerOfCard(card)) && (this.isAllowedToReplace());
    }

    private boolean isOwnerOfCard(Card card) {
        for (CardArrangement cardArrangementResult: this.getCardArrangements()) {
            for (Card cardResult: cardArrangementResult.getCards()) {
                if (cardResult.equals(card)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isAllowedToReplace() {
        return AuthorizationLevel.checkAllowedActions(this.getAuthorizationLevel());
    }

    private Card fulfillReplaceCard(Card card) {
        Card newCard = this.createNewDebitCard();
        this.setNewEndDateOldCard(card);
        return newCard;
    }

    private Card createNewDebitCard() {
        Card card = new Card(cardNumberGenerator(), dateGenerator(7), dateGenerator(((365*5)+7)), Status.INACTIVE);
        this.getCardArrangements().get(0).getCards().add(card);
        return card;
    }

    private void setNewEndDateOldCard(Card card) {
        card.setEndDate(dateGenerator(14));
    }

    private LocalDate dateGenerator(Integer days) {
        return LocalDate.now().plusDays(days);
    }

    private String cardNumberGenerator() {
        int length = 8;
        boolean useLetters = true;
        boolean useNumbers = true;

        return RandomStringUtils.random(length, useLetters, useNumbers);
    }

}
