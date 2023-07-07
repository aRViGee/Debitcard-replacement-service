package com.sogyo.rvgelder.ipdebitcardreplacementflow.service;

import com.sogyo.rvgelder.ipdebitcardreplacementflow.Main;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.entity.*;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.repository.CustomerRepository;
import jakarta.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Main.class)
@Transactional
@TestPropertySource(locations = "classpath:application-test.properties")
public class CustomerServiceImplTest {

    public static Customer createCompleteCustomer(
            String customerNumber,
            AuthorizationLevel authorizationLevel,
            String cardArrangementType,
            String cardNumber,
            Status status) {
        Customer customer = new Customer(customerNumber, authorizationLevel, new ArrayList<>());
        CardArrangement cardArrangement = new CardArrangement(cardArrangementType, new ArrayList<>());
        Card card = new Card(cardNumber, status);
        cardArrangement.getCards().add(card);
        customer.getCardArrangements().add(cardArrangement);
        return customer;
    }

        @Autowired
        private CustomerService customerService;

        @Autowired
        private CardArrangementService cardArrangementService;

        @Autowired
        private CardService cardService;


//        @Resource
//        private CustomerRepository customerRepository;


    @Test
    public void testCanFetchAttributesCustomer() {
        Customer customer = createCompleteCustomer(
                "12345678",
                AuthorizationLevel.LEVEL_3,
                "debitCardArrangement",
                "0A1B2C3D",
                Status.ACTIVE);

        assertEquals("12345678",customer.getCustomerNumber());
        assertEquals(AuthorizationLevel.LEVEL_3,customer.getAuthorizationLevel());
    }

    @Test
    public void testCanFetchAttributesCardArrangement() {
        Customer customer = createCompleteCustomer(
                "12345678",
                AuthorizationLevel.LEVEL_3,
                "debitCardArrangement",
                "0A1B2C3D",
                Status.ACTIVE);

        assertEquals("debitCardArrangement",customer.getCardArrangements().get(0).getCardArrangementType());
    }

    @Test
    public void testCanFetchAttributesCard() {
        Customer customer = createCompleteCustomer(
                "12345678",
                AuthorizationLevel.LEVEL_3,
                "debitCardArrangement",
                "0A1B2C3D",
                Status.ACTIVE);

        assertEquals("0A1B2C3D",customer.getCardArrangements().get(0).getCards().get(0).getCardNumber());
        assertEquals(Status.ACTIVE,customer.getCardArrangements().get(0).getCards().get(0).getStatus());
    }




//        @Test
//        public void testCanFindCustomerById() {
//                Customer customer1 = new Customer(AuthorizationLevel.LEVEL_3);
//                customerService.saveCustomer(customer1);
//
//                var result = customerService.findCustomer(customer1.getId());
//
//                assertEquals(customer1,result);
//        }
//
////        @Test
////        public void testCanGetListOfAllCustomers() {
////                Customer customer1 = new Customer(AuthorizationLevel.LEVEL_3);
////                customerService.saveCustomer(customer1);
////                Customer customer2 = new Customer(AuthorizationLevel.LEVEL_1);
////                customerService.saveCustomer(customer2);
////                Customer customer3 = new Customer(AuthorizationLevel.LEVEL_2);
////                customerService.saveCustomer(customer3);
////
////                var result = customerService.fetchCustomerList().size();
////
////                assertEquals(3, result);
////        }
//
//        @Test
//        public void testCanReadAuthorizationLevelAttribute() {
//                Customer customer = new Customer(AuthorizationLevel.LEVEL_3);
//
//                var resultAuthorizationLevel = customer.getAuthorizationLevel();
//
//                assertSame(AuthorizationLevel.LEVEL_3, resultAuthorizationLevel);
//        }
//
//        @Test
//        public void testCanAddCustomerToDatabase() {
//                Customer customer = new Customer(AuthorizationLevel.LEVEL_2);
//                var result = customerService.saveCustomer(customer);
//                var customerDB = customerService.findCustomer(result.getId());
//
//                assertTrue(result.getId() > 0);
////                assertNotNull(result.getId());
//                assertEquals(result.getAuthorizationLevel(),customerDB.getAuthorizationLevel());
//        }
//
//        @Test(expected = NoSuchElementException.class)
//        public void testCanDeleteCustomer() {
//                Customer customer1 = new Customer(AuthorizationLevel.LEVEL_3);
//                customerService.saveCustomer(customer1);
//                Customer customer2 = new Customer(AuthorizationLevel.LEVEL_1);
//                customerService.saveCustomer(customer2);
//
//                customerService.deleteCustomerById(customer1.getId());
//                var resultList = customerService.fetchCustomerList().size();
//
//                assertEquals(1, resultList);
//                assertSame(customerService.findCustomer(customer2.getId()), customer2);
//                assertNull(customerService.findCustomer(customer1.getId()));
//        }
//
//        @Test
//        public void testCanGetListOfAllCardArrangementsOfSpecificCustomer() {
//                Customer customer1 = new Customer(AuthorizationLevel.LEVEL_3);
//                customer1.cardArrangements.add(new CardArrangement(customer1));
//                customerService.saveCustomer(customer1);
////                CardArrangement cardArrangement1 = new CardArrangement(customer1);
////                cardArrangementService.saveCardArrangement(cardArrangement1);
////                CardArrangement cardArrangement2 = new CardArrangement(customer1);
////                cardArrangementService.saveCardArrangement(cardArrangement2);
////                Customer customer2 = new Customer(AuthorizationLevel.LEVEL_2);
////                customerService.saveCustomer(customer2);
////                CardArrangement cardArrangement3 = new CardArrangement(customer2);
////                cardArrangementService.saveCardArrangement(cardArrangement3);
//
////                var result = cardArrangementService.fetchCardArrangementList(customer1.getId()).size();
//                var result = customer1.getCardArrangements().size();
//                assertEquals(1, result);
//        }
//
//        @Test
//        public void testCanGetListOfAllCardArrangementsOfSpecificCustomer2() {
//                Customer customer1 = new Customer(AuthorizationLevel.LEVEL_3);
////                customer1.cardArrangements.add(new CardArrangement(customer1));
//                customerService.saveCustomer(customer1);
//                CardArrangement cardArrangement1 = new CardArrangement(customer1);
//                cardArrangementService.saveCardArrangement(cardArrangement1);
////                CardArrangement cardArrangement2 = new CardArrangement(customer1);
////                cardArrangementService.saveCardArrangement(cardArrangement2);
////                Customer customer2 = new Customer(AuthorizationLevel.LEVEL_2);
////                customerService.saveCustomer(customer2);
////                CardArrangement cardArrangement3 = new CardArrangement(customer2);
////                cardArrangementService.saveCardArrangement(cardArrangement3);
//
////                var result = cardArrangementService.fetchCardArrangementList(customer1.getId()).size();
//                var result = customer1.getCardArrangements().size();
//                assertEquals(1, result);
//        }

}


