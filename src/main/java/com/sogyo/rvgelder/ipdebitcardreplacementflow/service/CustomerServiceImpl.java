package com.sogyo.rvgelder.ipdebitcardreplacementflow.service;

import com.sogyo.rvgelder.ipdebitcardreplacementflow.entity.AuthorizationLevel;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.entity.Customer;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer findById(Integer customerId) {
        return customerRepository.findById(customerId).get();
    }


    //    Save operation
    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    //    Read operation
    @Override
    public List<Customer> fetchCustomerList() {
        return customerRepository.findAll();
    }

//    //    Update operation
//    @Override
//    public Customer updateCustomer(
//            /*Customer customer,*/
//            Integer customerId, AuthorizationLevel authorizationLevel) {
//
//        Customer customerDB = customerRepository.findById(customerId).get();
//
//
//
////        if (Objects.nonNull(customer.getAuthorizationLevel()) && !"".equalsIgnoreCase(customer.getAuthorizationLevel())) {
//        customerDB.setAuthorizationLevel(authorizationLevel);
////        }
//
//        /*if (Objects.nonNull(
//                customer.getCardArrangements())
//                *//*&& !"".equalsIgnoreCase(
//                customer.getCardArrangementArrayList())*//*) {
//            customerDB.setCardArrangements(
//                    customer.getCardArrangements());
//        }*/
//
//        return customerRepository.save(customerDB);
//    }

    //    Delete operation
    @Override
    public void deleteCustomerById(Integer customerId) {
        customerRepository.deleteById(customerId);
    }

}



