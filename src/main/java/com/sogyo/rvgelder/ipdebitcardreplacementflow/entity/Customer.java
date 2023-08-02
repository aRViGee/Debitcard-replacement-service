package com.sogyo.rvgelder.ipdebitcardreplacementflow.entity;

import com.mifmif.common.regex.Generex;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.entity.exceptions.CustomerNotAllowedToReplaceException;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.entity.exceptions.CustomerNotOwnerOfCardException;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.service.CustomerServiceImpl;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.logging.Logger;


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


    public Card replaceCard(Card card) throws CustomerNotOwnerOfCardException, CustomerNotAllowedToReplaceException {
            if (startDateIsInPast(card) &&
                    statusIsNotInactive(card) &&
                    (this.cardReplacementIsValid(card))) {
                if (CustomerServiceImpl.isAuthorized(this.getCustomerNumber(), 3)) {
                    return this.fulfillReplaceCard(card);
                }

            }
            return null;
    }

    private static boolean statusIsNotInactive(Card card) {
        return !card.getStatus().equals(Status.INACTIVE);
    }

    private static boolean startDateIsInPast(Card card) {
        return card.getStartDate().isBefore(LocalDate.now());
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
        throw new CustomerNotOwnerOfCardException("You are not the owner of card " + card.getCardNumber());
    }

    private boolean isAllowedToReplace() throws CustomerNotAllowedToReplaceException {
        if(AuthorizationLevel.checkAllowedActions(this.getAuthorizationLevel(),AllowedActions.REPLACE)) {
            return true;
        }
        throw new CustomerNotAllowedToReplaceException("You are not allowed to replace a card.");
    }

    private Card fulfillReplaceCard(Card card) {
        Card newCard = this.createNewDebitCard();
        this.setNewEndDateOldCardOnFourteenDaysLater(card);
        return newCard;
    }

    private Card createNewDebitCard() {
        Card card = new Card(cardNumberGenerator(), dateGeneratorForDays(7), dateGeneratorForYears(5), Status.INACTIVE);
        this.getCardArrangements().get(0).getCards().add(card);
        return card;
    }

    private LocalDate dateGeneratorForDays(Integer days) {
        return LocalDate.now().plusDays(days);
    }

    private LocalDate dateGeneratorForYears(Integer years) {
        var newStartDate = dateGeneratorForDays(7);
        return newStartDate.plusYears(years);
    }

    private void setNewEndDateOldCardOnFourteenDaysLater(Card card) {
        card.setEndDate(dateGeneratorForDays(14));
    }


    private String cardNumberGenerator() {
        Generex generex = new Generex("\\d{3}[A-HJ-NP-Z]\\d{3}");
        return generex.random();
    }

}
