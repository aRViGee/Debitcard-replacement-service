package com.sogyo.rvgelder.ipdebitcardreplacementflow.service;


import com.sogyo.rvgelder.ipdebitcardreplacementflow.entity.*;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.repository.CardRepository;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;


@Service
public class CustomerServiceImpl implements CustomerService/*, ExternalAuthorization*/ {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CardRepository cardRepository;


    public void replaceCard(String customerNumber, String cardNumber) {
        Customer customer = getCustomerByCustomerNumber(customerNumber);
        Card card = getCardByCardNumber(cardNumber);
        customer.replaceCard(card);
    }



    public static boolean isAuthorized(String customerNumber, Integer processId) {
//        Logger logger = //TODO Make a logger for some visual feedback?
        return true;
    }


//    Customer method implementation

//    @Override
//    public AuthorizationLevel getAuthorizationLevel(Customer customer) {
//        return customer.getAuthorizationLevel();
//    }


//    CardArrangement method implementations
//    @Override
//    public CardArrangement getCardArrangementById(Customer customer, Integer id) {
//        return customer.getCardArrangements().get(id);
//    }

//    @Override
//    public CardArrangement getCardArrangementByType(Customer customer, String cardArrangementType) {
////        TODO - Refactor with recursion
//        for (int index = 0; index < customer.getCardArrangements().size(); index++) {
//            if (customer.getCardArrangements().get(index).getCardArrangementType().equals(cardArrangementType)) {
//                return customer.getCardArrangements().get(index);
//            }
//        }
//        return null;
//    }

    @Override
    public Card getCardByCardNumber(String cardNumber) {
        return cardRepository.findByCardNumber(cardNumber);
    }

    @Override
    public Customer getCustomerByCustomerNumber(String customerNumber) {
        return customerRepository.findByCustomerNumber(customerNumber);
    }


}



