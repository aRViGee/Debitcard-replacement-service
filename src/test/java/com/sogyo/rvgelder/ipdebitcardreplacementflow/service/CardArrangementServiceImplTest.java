package com.sogyo.rvgelder.ipdebitcardreplacementflow.service;

import com.sogyo.rvgelder.ipdebitcardreplacementflow.Main;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.entity.AuthorizationLevel;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.entity.CardArrangement;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.entity.Customer;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.repository.CardArrangementRepository;
import jakarta.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Main.class)
@Transactional
@TestPropertySource(locations = "classpath:application-test.properties")
public class CardArrangementServiceImplTest {

    @Autowired
    private CardArrangementService cardArrangementService;
    @Autowired
    private CustomerService customerService;

    @Resource
    private CardArrangementRepository cardArrangementRepository;
//
//    @Test
//    public void testCanFindCardArrangementById() {
//        Customer customer1 = new Customer(AuthorizationLevel.LEVEL_3);
//        customerService.saveCustomer(customer1);
//        CardArrangement cardArrangement1 = new CardArrangement(customer1);
//        cardArrangementService.saveCardArrangement(cardArrangement1);
//
//        var result = cardArrangementService.findCardArrangement(cardArrangement1.getId());
//
//        assertEquals(cardArrangement1, result);
//    }
//
//
//    @Test
//    public void testCanReadItsCustomer() {
//        Customer customer1 = new Customer(AuthorizationLevel.LEVEL_3);
//        customerService.saveCustomer(customer1);
//        CardArrangement cardArrangement1 = new CardArrangement(customer1);
//        cardArrangementService.saveCardArrangement(cardArrangement1);
//
//        assertTrue(false);
//    }

}
