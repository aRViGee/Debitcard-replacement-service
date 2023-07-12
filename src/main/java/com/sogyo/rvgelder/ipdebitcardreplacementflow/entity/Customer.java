package com.sogyo.rvgelder.ipdebitcardreplacementflow.entity;


import com.sogyo.rvgelder.ipdebitcardreplacementflow.service.CustomerServiceImpl;
import jakarta.persistence.*;
import org.apache.commons.lang3.RandomStringUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


@Entity
@Table(name="Customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @SequenceGenerator(name = "Customer_id_gen")
    private Long id;
    @Column(name = "customer_number", unique = true, nullable = false)
    private String customerNumber;
    @Convert(converter = AuthorizationLevelConverter.class)
    @Column(name = "authorization_level", nullable = false, length = 1)
    private AuthorizationLevel authorizationLevel;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY/*, targetEntity = CardArrangement.class*/)
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


    public Card replaceCard(Card card) {
        if (this.cardReplacementIsValid(card)) {
            if (CustomerServiceImpl.isAuthorized(this.getCustomerNumber(), 3)) { //TODO - External authorization implementation
//                TODO - Fulfillment:
//                  TODO - Fulfillment - Create new card
//                      TODO - Fulfillment - if new card created: set end_date current card
                Card newCard = this.fulfillReplaceCard(card);
                return newCard;
            }
        }
       return null;
    }

    private Card fulfillReplaceCard(Card card) {
        Card newCard = this.createNewDebitCard();
        this.setNewEndDateOldCard(card);
        return newCard;
    }

    private void setNewEndDateOldCard(Card card) {
        card.setEndDate(DateFormatter(14));
    }

    private String DateFormatter(Integer days) {
        LocalDateTime myDateObj = LocalDateTime.now().plusDays(days);
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        return myDateObj.format(myFormatObj);
    }

    private Card createNewDebitCard() {
        Card card = new Card(cardNumberGenerator(), DateFormatter(7), DateFormatter((365*5)), Status.INACTIVE);
        this.getCardArrangements().get(0).getCards().add(card);
        return card;
    }

    private String cardNumberGenerator() {
        int length = 8;
        boolean useLetters = true;
        boolean useNumbers = true;

        return RandomStringUtils.random(length, useLetters, useNumbers);
    }

    private boolean cardReplacementIsValid(Card card) {
        System.out.println("Card replacement is valid");
        return (this.isOwnerOfCard(card)) && (this.isAllowedToReplace());
    }

    private boolean isOwnerOfCard(Card card) { //TODO - refactor using (flat)Map of forEach?
        for (int indexCardArrangements = 0; indexCardArrangements < this.getCardArrangements().size(); indexCardArrangements++) {
            for (int indexCards = 0; indexCards < this.getCardArrangements().get(indexCardArrangements).getCards().size(); indexCards++) {
                if (this.getCardArrangements().get(indexCardArrangements).getCards().get(indexCards).equals(card)) {
                    System.out.println("Customer is owner of card");
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isAllowedToReplace() {
        System.out.println("Customer is allowed to replace");
        return AuthorizationLevel.checkAllowedActions(this.getAuthorizationLevel());
    }

}
