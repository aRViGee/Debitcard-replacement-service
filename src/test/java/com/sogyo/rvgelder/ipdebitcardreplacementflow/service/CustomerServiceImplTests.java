package com.sogyo.rvgelder.ipdebitcardreplacementflow.service;

import com.sogyo.rvgelder.ipdebitcardreplacementflow.controller.CustomerController;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.entity.*;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.entity.exceptions.*;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.repository.CustomerRepository;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.service.exceptions.CardNotFoundException;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.service.exceptions.CustomerNotAuthorizedException;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.service.exceptions.CustomerNotFoundException;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.service.exceptions.CustomerNotSavedException;
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
public class CustomerServiceImplTests {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerController customerController;

    @Autowired
    private CustomerServiceImpl customerService;


    @Test
    void testCanReplaceCard()
            throws CustomerNotOwnerOfCardException,
            CustomerNotAllowedToReplaceException,
            CustomerNotFoundException,
            CardNotFoundException,
            CustomerNotAuthorizedException,
            CustomerNotSavedException,
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

        Card newCard = customerService.replaceCard(customer1.getCustomerNumber(), card1.getCardNumber());

        assertNotNull(newCard);
    }

    @Test
    void testNewCardGetsAddedToCorrectCustomer()
            throws CustomerNotOwnerOfCardException,
            CustomerNotAllowedToReplaceException,
            CustomerNotFoundException,
            CardNotFoundException,
            CustomerNotAuthorizedException,
            CustomerNotSavedException,
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

        Card newCard = customerService.replaceCard(customer1.getCustomerNumber(), card1.getCardNumber());

        Card result = customerService.getCustomerByCustomerNumber("testCustomer1").getCardArrangements().get(0).getCards().get(1);

        assertEquals(newCard, result);
    }

    @org.junit.Test(expected = NullPointerException.class)
    public void testCannotReplaceWhenCustomerNumberIsIncorrect()
            throws CustomerNotOwnerOfCardException,
            CustomerNotAllowedToReplaceException,
            CustomerNotFoundException,
            CardNotFoundException,
            CustomerNotAuthorizedException,
            CustomerNotSavedException,
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

        Card newCard = customerService.replaceCard("wrongCustomerNumber", "testCard1");

        assertNull(newCard);
    }

    @org.junit.Test(expected = NullPointerException.class)
    public void testCannotReplaceWhenCardNumberIsIncorrect()
            throws CustomerNotOwnerOfCardException,
            CustomerNotAllowedToReplaceException,
            CustomerNotFoundException,
            CardNotFoundException,
            CustomerNotAuthorizedException,
            CustomerNotSavedException,
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

        Card newCard = customerService.replaceCard("testCustomer1", "wrongCardNumber");

        assertNull(newCard);
    }

    @org.junit.Test(expected = NullPointerException.class)
    public void testCannotReplaceWhenCustomerNotOwnerOfCard()
            throws CustomerNotOwnerOfCardException,
            CustomerNotAllowedToReplaceException,
            CustomerNotFoundException,
            CardNotFoundException,
            CustomerNotAuthorizedException,
            CustomerNotSavedException,
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
        Customer customer2 = new Customer("testCustomer2",AuthorizationLevel.LEVEL_3, new ArrayList<>());
        CardArrangement debitCardArrangement2 = new CardArrangement("Debit cards",new ArrayList<>());
        Card card2 = new Card("testCard2", LocalDate.of(2023, 6,28), LocalDate.of(2028, 6,28),Status.ACTIVE);
        debitCardArrangement2.getCards().add(card2);
        customer2.getCardArrangements().add(debitCardArrangement2);
        customerRepository.save(customer2);

        Card newCard = customerService.replaceCard("testCustomer1", "testCard2");

        assertNull(newCard);
    }
}
