package com.sogyo.rvgelder.ipdebitcardreplacementflow.service;

import com.sogyo.rvgelder.ipdebitcardreplacementflow.entity.Card;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.entity.CardArrangement;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.entity.Customer;

import java.util.List;

public interface CustomerService {

    Customer findCustomer(Integer customerId);

//    Save operation
    Customer saveCustomer(Customer customer);

//    Read operation
    List<Customer> fetchCustomerList();

//    List<CardArrangement> fetchCardArrangements(Integer customerId);

////    Update operation
//    Customer updateCustomer(Customer customer, Integer customerId);

//    Delete operation
    void deleteCustomerById(Integer customerId);

//    Replacement operations
    void replaceCard(Integer customerId, Integer cardId);


}
