package com.sogyo.rvgelder.ipdebitcardreplacementflow.service;

import com.sogyo.rvgelder.ipdebitcardreplacementflow.entity.Customer;

import java.util.List;

public interface CustomerService {

    Customer findCustomer(Integer customerId);

//    Save operation
    Customer saveCustomer(Customer customer);

//    Read operation
    List<Customer> fetchCustomerList();

////    Update operation
//    Customer updateCustomer(Customer customer, Integer customerId);

//    Delete operation
    void deleteCustomerById(Integer customerId);

}
