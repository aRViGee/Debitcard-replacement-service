package com.sogyo.rvgelder.ipdebitcardreplacementflow.service;

import com.sogyo.rvgelder.ipdebitcardreplacementflow.Main;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.entity.AuthorizationLevel;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.entity.Customer;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.repository.CustomerRepository;
import jakarta.annotation.Resource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Main.class)
@Transactional
@TestPropertySource(locations = "classpath:application-test.properties")
public class CustomerServiceImplTest {

        @Autowired
        private CustomerService customerService;

        @Resource
        private CustomerRepository customerRepository;

        @Test
        public void testCanFindCustomerById() {
                Customer customer1 = new Customer(AuthorizationLevel.LEVEL_3);
                Customer customer2 = new Customer(AuthorizationLevel.LEVEL_2);
                customerService.saveCustomer(customer1);
                customerService.saveCustomer(customer2);

                var result = customerService.findCustomer(1);
                System.out.println(customerRepository.findAll());

                assertEquals(customer1,result);
        }

        @Test
        public void testCanGetListOfAllCustomers() {
                Customer customer1 = new Customer(AuthorizationLevel.LEVEL_3);
                customerService.saveCustomer(customer1);
                Customer customer2 = new Customer(AuthorizationLevel.LEVEL_1);
                customerService.saveCustomer(customer2);
                Customer customer3 = new Customer(AuthorizationLevel.LEVEL_2);
                customerService.saveCustomer(customer3);

                var result = customerService.fetchCustomerList().size();

                assertEquals(3, result);
        }

        @Test
        public void testCanReadAuthorizationLevelAttribute() {
                Customer customer = new Customer(AuthorizationLevel.LEVEL_3);

                var resultAuthorizationLevel = customer.getAuthorizationLevel();

                assertSame(AuthorizationLevel.LEVEL_3, resultAuthorizationLevel);
        }

        @Test
        public void testCanAddCustomerToDatabase() {
                Customer customer = new Customer(AuthorizationLevel.LEVEL_2);
                var result = customerService.saveCustomer(customer);
                var customerDB = customerService.findCustomer(result.getId());

                assertTrue(result.getId() > 0);
                assertEquals(result.getAuthorizationLevel(),customerDB.getAuthorizationLevel());
        }

        @Test
        public void testCanDeleteCustomer() {
                Customer customer1 = new Customer(AuthorizationLevel.LEVEL_3);
                customerService.saveCustomer(customer1);
                Customer customer2 = new Customer(AuthorizationLevel.LEVEL_1);
                customerService.saveCustomer(customer2);

                customerService.deleteCustomerById(1);


        }

}


