package com.sogyo.rvgelder.ipdebitcardreplacementflow.service;


//import org.junit.jupiter.api.Test;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.Main;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.entity.AuthorizationLevel;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.entity.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Main.class)

@TestPropertySource(locations = "classpath:application.properties")
public class CustomerServiceImplTest {


        @Autowired
        private CustomerService customerService;

        @Test
        public void testTrueIsTrue() {
                assertTrue(true);
        }

        @Test
        public void testDatabaseIsAccessible(){
                var result = customerService.fetchCustomerList().size() > 0;

                assertTrue(result);
        }

        @Test
        public void testCanWriteToDatabase(){
                Customer customer = new Customer(AuthorizationLevel.LEVEL_2);
                var result = customerService.saveCustomer(customer);
                var customerDB = customerService.findById(result.getId());

                assertTrue(result.getId() > 0);
                assertEquals(result.getAuthorizationLevel(),customerDB.getAuthorizationLevel());
        }
}


