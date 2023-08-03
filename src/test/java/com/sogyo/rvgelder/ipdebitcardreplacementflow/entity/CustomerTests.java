package com.sogyo.rvgelder.ipdebitcardreplacementflow.entity;

import com.sogyo.rvgelder.ipdebitcardreplacementflow.entity.exceptions.*;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.repository.CustomerRepository;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.service.exceptions.CustomerNotAuthorizedException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@TestPropertySource(locations = "classpath:application-test.properties")
public class CustomerTests {

    @Autowired
    private CustomerRepository customerRepository;


    @Test
    void testCanReplaceCard()
            throws CustomerNotOwnerOfCardException,
            CustomerNotAllowedToReplaceException,
            CustomerNotAuthorizedException,
            NewEndDateOldCardNotSetException,
            CardNotCreatedException,
            StartDateInThePastException,
            CardIsInactiveException {
        Customer customer1 = new Customer("testCustomer1",AuthorizationLevel.LEVEL_3, new ArrayList<>());
        CardArrangement debitCardArrangement1 = new CardArrangement("Debit cards",new ArrayList<>());
        Card card1 = new Card("testCard1", LocalDate.of(2023, 6,28), LocalDate.of(2028, 6,28),Status.ACTIVE);
        debitCardArrangement1.getCards().add(card1);
        customer1.getCardArrangements().add(debitCardArrangement1);
        customerRepository.save(customer1);

        Card newCard = customer1.replaceCard(card1);

        assertNotNull(newCard);
    }

    @Test
    void testNewCardGetsAddedToCorrectCustomer()
            throws CustomerNotOwnerOfCardException,
            CustomerNotAllowedToReplaceException,
            CustomerNotAuthorizedException,
            NewEndDateOldCardNotSetException,
            CardNotCreatedException,
            StartDateInThePastException,
            CardIsInactiveException {
        Customer customer1 = new Customer("testCustomer1", AuthorizationLevel.LEVEL_3, new ArrayList<>());
        CardArrangement debitCardArrangement1 = new CardArrangement("Debit cards", new ArrayList<>());
        Card card1 = new Card("testCard1", LocalDate.of(2023, 6, 28), LocalDate.of(2028, 6, 28), Status.ACTIVE);
        debitCardArrangement1.getCards().add(card1);
        customer1.getCardArrangements().add(debitCardArrangement1);
        customerRepository.save(customer1);

        Card newCard = customer1.replaceCard(card1);

        Card result = customer1.getCardArrangements().get(0).getCards().get(1);

        assertEquals(newCard, result);
    }

    @org.junit.Test(expected = NullPointerException.class)
    public void testCardWithStartDateInFutureCannotBeReplaced()
            throws CustomerNotOwnerOfCardException,
            CustomerNotAllowedToReplaceException,
            CustomerNotAuthorizedException,
            NewEndDateOldCardNotSetException,
            CardNotCreatedException,
            StartDateInThePastException,
            CardIsInactiveException {
        Customer customer1 = new Customer("testCustomer1", AuthorizationLevel.LEVEL_3, new ArrayList<>());
        CardArrangement debitCardArrangement1 = new CardArrangement("Debit cards", new ArrayList<>());
        Card card1 = new Card("testCard1", LocalDate.of(2023, 8, 28), LocalDate.of(2028, 6, 28), Status.ACTIVE);
        debitCardArrangement1.getCards().add(card1);
        customer1.getCardArrangements().add(debitCardArrangement1);
        customerRepository.save(customer1);

        Card newCard = customer1.replaceCard(card1);

        assertNull(newCard);
    }

    @org.junit.Test(expected = NullPointerException.class)
    public void testCardWithStatusOnInactiveCannotBeReplaced()
            throws CustomerNotOwnerOfCardException,
            CustomerNotAllowedToReplaceException,
            CustomerNotAuthorizedException,
            NewEndDateOldCardNotSetException,
            CardNotCreatedException,
            StartDateInThePastException,
            CardIsInactiveException {
        Customer customer1 = new Customer("testCustomer1", AuthorizationLevel.LEVEL_3, new ArrayList<>());
        CardArrangement debitCardArrangement1 = new CardArrangement("Debit cards", new ArrayList<>());
        Card card1 = new Card("testCard1", LocalDate.of(2023, 6, 28), LocalDate.of(2028, 6, 28), Status.INACTIVE);
        debitCardArrangement1.getCards().add(card1);
        customer1.getCardArrangements().add(debitCardArrangement1);
        customerRepository.save(customer1);

        Card newCard = customer1.replaceCard(card1);

        assertNull(newCard);
    }

    @org.junit.Test(expected = NullPointerException.class)
    public void testCardWithStatusOnExpiredCanBeReplaced()
            throws CustomerNotOwnerOfCardException,
            CustomerNotAllowedToReplaceException,
            CustomerNotAuthorizedException,
            NewEndDateOldCardNotSetException,
            CardNotCreatedException,
            StartDateInThePastException,
            CardIsInactiveException {
        Customer customer1 = new Customer("testCustomer1", AuthorizationLevel.LEVEL_3, new ArrayList<>());
        CardArrangement debitCardArrangement1 = new CardArrangement("Debit cards", new ArrayList<>());
        Card card1 = new Card("testCard1", LocalDate.of(2023, 6, 28), LocalDate.of(2028, 6, 28), Status.EXPIRED);
        debitCardArrangement1.getCards().add(card1);
        customer1.getCardArrangements().add(debitCardArrangement1);
        customerRepository.save(customer1);

        Card newCard = customer1.replaceCard(card1);

        assertNull(newCard);
    }


    @org.junit.Test(expected = NullPointerException.class)
    public void testCannotReplaceWhenCustomerDoesNotHaveReplaceRight()
            throws CustomerNotOwnerOfCardException,
            CustomerNotAllowedToReplaceException,
            CustomerNotAuthorizedException,
            NewEndDateOldCardNotSetException,
            CardNotCreatedException,
            StartDateInThePastException,
            CardIsInactiveException {
        Customer customer1 = new Customer("testCustomer1",AuthorizationLevel.LEVEL_1, new ArrayList<>());
        CardArrangement debitCardArrangement1 = new CardArrangement("Debit cards",new ArrayList<>());
        Card card1 = new Card("testCard1", LocalDate.of(2023, 6,28), LocalDate.of(2028, 6,28),Status.ACTIVE);
        debitCardArrangement1.getCards().add(card1);
        customer1.getCardArrangements().add(debitCardArrangement1);
        customerRepository.save(customer1);

        Card newCard = customer1.replaceCard(card1);

        assertNull(newCard);
    }
}
