package com.sogyo.rvgelder.ipdebitcardreplacementflow.entity;

import com.sogyo.rvgelder.ipdebitcardreplacementflow.repository.CustomerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@TestPropertySource(locations = "classpath:application-test.properties")
public class CustomerTests {

    @Autowired
    private CustomerRepository customerRepository;



    @Test
    void testCanReplaceCard() {
        Customer customer1 = new Customer("testCustomer1",AuthorizationLevel.LEVEL_3, new ArrayList<>());
        CardArrangement debitCardArrangement1 = new CardArrangement("Debit cards",new ArrayList<>());
        Card card1 = new Card("testCard1", "2023-06-28", "2028-06-28",Status.ACTIVE);
        debitCardArrangement1.getCards().add(card1);
        customer1.getCardArrangements().add(debitCardArrangement1);
        customerRepository.save(customer1);

        Card newCard = customer1.replaceCard(card1);

        assertNotNull(newCard);
    }

//    @Test
//    void testCantReplaceWhenCardDoesntExist() {
//        fail();
//
//    }

}
