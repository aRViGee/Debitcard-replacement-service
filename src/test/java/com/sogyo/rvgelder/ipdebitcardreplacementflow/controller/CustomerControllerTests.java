package com.sogyo.rvgelder.ipdebitcardreplacementflow.controller;

import com.sogyo.rvgelder.ipdebitcardreplacementflow.entity.*;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.repository.CustomerRepository;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.service.CustomerService;
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
public class CustomerControllerTests {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerController customerController;

    private CustomerService customerService;

//    @Test
//    void testCanReplaceDebitCard() {
//        Customer customer1 = new Customer("testCustomer1", AuthorizationLevel.LEVEL_3, new ArrayList<>());
//        CardArrangement debitCardArrangement1 = new CardArrangement("Debit cards",new ArrayList<>());
//        Card card1 = new Card("testCard1", "2023-06-28", "2028-06-28", Status.ACTIVE);
//        debitCardArrangement1.getCards().add(card1);
//        customer1.getCardArrangements().add(debitCardArrangement1);
//        customerRepository.save(customer1);
//
//
//        var result = customerController.replaceDebitCard("testCustomer1","testCard1");
//
//        assertSame( "A new card has been added to your account, with card number: ",result);
//    }
}
