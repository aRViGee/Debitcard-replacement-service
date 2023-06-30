package com.sogyo.rvgelder.ipdebitcardreplacementflow.service;

import com.sogyo.rvgelder.ipdebitcardreplacementflow.Main;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.entity.AuthorizationLevel;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.entity.CardArrangement;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.entity.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Main.class)

@TestPropertySource(locations = "classpath:application.properties")
public class CustomerServiceImplTest {

        @Autowired
        private CustomerService customerService;

        @Test
        public void testCanGetListOfAllCustomers() {
                Customer customer1 = new Customer(AuthorizationLevel.LEVEL_3);
                Customer customer2 = new Customer(AuthorizationLevel.LEVEL_1);
                Customer customer3 = new Customer(AuthorizationLevel.LEVEL_2);
                customerService.saveCustomer(customer1);
                customerService.saveCustomer(customer2);
                customerService.saveCustomer(customer3);

                var result = customerService.fetchCustomerList();

                assertEquals(3, result.size());
        }

        @Test
        public void testCanReadCustomerAttributes() {
                Customer customer = new Customer(AuthorizationLevel.LEVEL_3);
                CardArrangement cardArrangement = new CardArrangement(customer);
                ArrayList<CardArrangement> arrangements = new ArrayList<>();
                arrangements.add(cardArrangement);
                customer.setCardArrangements(arrangements);

                var resultAuthorizationLevel = customer.getAuthorizationLevel();
                var resultCardArrangements = customer.getCardArrangements();

                assertSame(resultAuthorizationLevel, AuthorizationLevel.LEVEL_3);
                assertNotNull(resultCardArrangements);
        }

        @Test
        public void testCanAddCustomerToDatabase() {
                Customer customer = new Customer(AuthorizationLevel.LEVEL_2);
                var result = customerService.saveCustomer(customer);
                var customerDB = customerService.findById(result.getId());

                assertTrue(result.getId() > 0);
                assertEquals(result.getAuthorizationLevel(),customerDB.getAuthorizationLevel());
        }

        @Test
        public void testCanChangeCustomerAuthorizationLevel() {
                Customer customer = new Customer(AuthorizationLevel.LEVEL_3);

                customer.setAuthorizationLevel(AuthorizationLevel.LEVEL_1);

                assertSame(AuthorizationLevel.LEVEL_1,customer.getAuthorizationLevel());

        }
}


