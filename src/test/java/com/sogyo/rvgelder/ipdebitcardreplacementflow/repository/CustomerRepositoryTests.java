package com.sogyo.rvgelder.ipdebitcardreplacementflow.repository;

import com.sogyo.rvgelder.ipdebitcardreplacementflow.entity.*;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.service.CustomerServiceImpl;
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
public class CustomerRepositoryTests {


    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CardRepository cardRepository;

    @Autowired
    private CustomerServiceImpl customerService;

    @Test
    void testCanSaveCustomerCardArrangementAndCard() {
        Customer customer1 = new Customer("testCustomer1", AuthorizationLevel.LEVEL_3, new ArrayList<>());
        CardArrangement debitCardArrangement1 = new CardArrangement("Debit cards", new ArrayList<>());
        Card card1 = new Card("testCard1", LocalDate.of(2023, 6, 28), LocalDate.of(2028, 6, 28), Status.ACTIVE);
        debitCardArrangement1.getCards().add(card1);
        customer1.getCardArrangements().add(debitCardArrangement1);

        customerRepository.save(customer1);

        Customer resultCustomer = customerRepository.findByCustomerNumber("testCustomer1");
        CardArrangement resultCardArrangement = resultCustomer.getCardArrangements().get(0);
        Card resultCard = resultCardArrangement.getCards().get(0);

        assertNotNull(resultCustomer);
        assertNotNull(resultCardArrangement);
        assertNotNull(resultCard);
    }

    @Test
    void testCanGetCardByCardNumber() {
        Customer customer1 = new Customer("testCustomer1", AuthorizationLevel.LEVEL_3, new ArrayList<>());
        CardArrangement debitCardArrangement1 = new CardArrangement("Debit cards", new ArrayList<>());
        Card card1 = new Card("testCard1", LocalDate.of(2023, 6, 28), LocalDate.of(2028, 6, 28), Status.ACTIVE);
        debitCardArrangement1.getCards().add(card1);
        customer1.getCardArrangements().add(debitCardArrangement1);
        customerRepository.save(customer1);

        Card result = cardRepository.findByCardNumber("testCard1");

        assertSame(result, card1);
    }

    @Test
    void testCanAddNewCard() {
        Customer customer1 = new Customer("testCustomer1", AuthorizationLevel.LEVEL_3, new ArrayList<>());
        CardArrangement debitCardArrangement1 = new CardArrangement("Debit cards", new ArrayList<>());
        Card card1 = new Card("testCard1", LocalDate.of(2023, 6, 28), LocalDate.of(2028, 6, 28), Status.ACTIVE);
        debitCardArrangement1.getCards().add(card1);
        customer1.getCardArrangements().add(debitCardArrangement1);
        customerRepository.save(customer1);

        Card newCard = customerService.replaceCard(customer1.getCustomerNumber(), card1.getCardNumber());

        Card result = cardRepository.findByCardNumber(newCard.getCardNumber());

        assertEquals(newCard, result);
    }

    @Test
    void testNewCardGetsAddedToCustomersDebitCardArrangement() {
        Customer customer1 = new Customer("testCustomer1", AuthorizationLevel.LEVEL_3, new ArrayList<>());
        CardArrangement debitCardArrangement1 = new CardArrangement("Debit cards",new ArrayList<>());
        Card card1 = new Card("testCard1", LocalDate.of(2023, 6,28), LocalDate.of(2028, 6,28), Status.ACTIVE);
        debitCardArrangement1.getCards().add(card1);
        customer1.getCardArrangements().add(debitCardArrangement1);
        customerRepository.save(customer1);

        customerService.replaceCard(customer1.getCustomerNumber(), card1.getCardNumber());

        Card result = customerRepository.findByCustomerNumber("testCustomer1").getCardArrangements().get(0).getCards().get(1);

        assertNotNull(result);
    }

    @Test
    void testOldCardGetsNewEndDate() {
        Customer customer1 = new Customer("testCustomer1", AuthorizationLevel.LEVEL_3, new ArrayList<>());
        CardArrangement debitCardArrangement1 = new CardArrangement("Debit cards", new ArrayList<>());
        Card card1 = new Card("testCard1", LocalDate.of(2023, 6, 28), LocalDate.of(2028, 6, 28), Status.ACTIVE);
        debitCardArrangement1.getCards().add(card1);
        customer1.getCardArrangements().add(debitCardArrangement1);
        customerRepository.save(customer1);

        customerService.replaceCard(customer1.getCustomerNumber(), card1.getCardNumber());

        LocalDate resultEndDateOldCard = cardRepository.findByCardNumber("testCard1").getEndDate();

        assertEquals(LocalDate.now().plusDays(14), resultEndDateOldCard);
    }

}
