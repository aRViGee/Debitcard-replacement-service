package com.sogyo.rvgelder.ipdebitcardreplacementflow.entity;

import com.mifmif.common.regex.Generex;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.entity.exceptions.*;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.service.CustomerServiceImpl;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.service.exceptions.CustomerNotAuthorizedException;
import jakarta.persistence.*;

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


    public Card replaceCard(Card card)
            throws CustomerNotOwnerOfCardException,
            CustomerNotAllowedToReplaceException,
            CustomerNotAuthorizedException,
            CardNotCreatedException,
            NewEndDateOldCardNotSetException,
            CardIsInactiveException,
            StartDateInThePastException {
            if (startDateIsInPast(card) &&
                    statusIsNotInactive(card) &&
                    (this.cardReplacementIsValid(card))) {
                if (CustomerServiceImpl.isAuthorized(this.getCustomerNumber(), 3)) {
                    return this.fulfillReplaceCard(card);
                }

            }
            return null;
    }

    private static boolean statusIsNotInactive(Card card) throws CardIsInactiveException {
        if (!card.getStatus().equals(Status.INACTIVE)) {
            return true;
        }
        throw new CardIsInactiveException("This card is inactive and can't be replaced yet");
    }

    private static boolean startDateIsInPast(Card card) throws StartDateInThePastException {
        if (card.getStartDate().isBefore(LocalDate.now())) {
            return true;
        }
        throw new StartDateInThePastException("This card's start date is in the future and can't be replaced yet.");
    }

    private boolean cardReplacementIsValid(Card card) throws CustomerNotOwnerOfCardException, CustomerNotAllowedToReplaceException {
        return (this.isOwnerOfCard(card)) && (this.isAllowedToReplace());
    }

    private boolean isOwnerOfCard(Card card) throws CustomerNotOwnerOfCardException {
        for (CardArrangement cardArrangementResult: this.getCardArrangements()) {
            for (Card cardResult: cardArrangementResult.getCards()) {
                if (cardResult.equals(card)){
                    return true;
                }
            }
        }
        throw new CustomerNotOwnerOfCardException("You do not own a card with card number " + card.getCardNumber());
    }

    private boolean isAllowedToReplace() throws CustomerNotAllowedToReplaceException {
        if(AuthorizationLevel.checkAllowedActions(this.getAuthorizationLevel(),AllowedActions.REPLACE)) {
            return true;
        }
        throw new CustomerNotAllowedToReplaceException("You are not allowed to replace a card.");
    }

    private Card fulfillReplaceCard(Card card)
            throws CardNotCreatedException,
            NewEndDateOldCardNotSetException {
        Card newCard = this.createNewDebitCard();
        this.setNewEndDateOldCardOnFourteenDaysLater(card);
        return newCard;
    }

    private Card createNewDebitCard() throws CardNotCreatedException {
        try {
            Card card = new Card(cardNumberGenerator(), dateGeneratorForDays(7), dateGeneratorForYears(5), Status.INACTIVE);
            this.getCardArrangements().get(0).getCards().add(card);
            return card;
        } catch (Exception e) {
            throw new CardNotCreatedException("Replacement card could not be created or added to customer");
        }
    }

    private LocalDate dateGeneratorForDays(Integer days) {
        return LocalDate.now().plusDays(days);
    }

    private LocalDate dateGeneratorForYears(Integer years) {
        var newStartDate = dateGeneratorForDays(7);
        return newStartDate.plusYears(years);
    }

    private void setNewEndDateOldCardOnFourteenDaysLater(Card card) throws NewEndDateOldCardNotSetException {
        try {
            card.setEndDate(dateGeneratorForDays(14));
        } catch (Exception e) {
            throw new NewEndDateOldCardNotSetException("A new end date for current card " + card.getCardNumber() + " could not be set");
        }
    }


    private String cardNumberGenerator() {
        Generex generex = new Generex("\\d{3}[A-HJ-NP-Z]\\d{3}");
        return generex.random();
    }

}
