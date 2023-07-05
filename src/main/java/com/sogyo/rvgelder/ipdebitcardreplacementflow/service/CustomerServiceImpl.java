package com.sogyo.rvgelder.ipdebitcardreplacementflow.service;


import com.sogyo.rvgelder.ipdebitcardreplacementflow.entity.CardArrangement;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.entity.Customer;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.repository.CardArrangementRepository;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.repository.CustomerRepository;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;


@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private CardArrangementRepository cardArrangementRepository;


    @Override
    public Customer findCustomer(Integer customerId) {
        return customerRepository.findById(customerId).orElseThrow(() -> new NoSuchElementException());
    }


    //    Save operation
    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }


    //    Read operation
    @Override
    public List<Customer> fetchCustomerList() {return customerRepository.findAll();}

//    @Override
//    public List<CardArrangement> fetchCardArrangements(Integer customerId) {
//        return;
//    }

//    Update operation
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

    public void replaceCard(Integer customerId, Integer cardId) {
        if (verifyCardReplacement(customerId,cardId)) {
            if (true/*TODO - External authorization implementation*/) {
//                TODO - Fulfillment:
//                  TODO - Fulfillment - Create new card
//                      TODO - Fulfillment - if new card created: set end_date current card
            }
//
        }
    }

    private boolean verifyCardReplacement(Integer customerId, Integer cardId) {
        return (isOwnerOfCard(customerId,cardId)) && (isAllowedToReplace(customerId,cardId));
    }

    private boolean isAllowedToReplace(Integer customerId, Integer cardId) {
        return false;
    }

    private boolean isOwnerOfCard(Integer customerId, Integer cardId) {

        return false;
    }
}



