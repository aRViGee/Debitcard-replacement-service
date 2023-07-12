package com.sogyo.rvgelder.ipdebitcardreplacementflow.service;


import com.sogyo.rvgelder.ipdebitcardreplacementflow.entity.*;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.repository.CardRepository;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.logging.Logger;


@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CardRepository cardRepository;

//    public void addNewCard(Long cardArrangementId, Card card) {
//        cardRepository.save(card);
//    }


    public Card replaceCard(String customerNumber, String cardNumber) {
        Customer customer = getCustomerByCustomerNumber(customerNumber);
        Card card = getCardByCardNumber(cardNumber);
        Card newCard = customer.replaceCard(card);
        customerRepository.save(customer);
        return newCard;
    }



    public static boolean isAuthorized(String customerNumber, Integer processId) {
//        Logger logger = //TODO Make a logger for some visual feedback?
        System.out.println("Card replacement is (externally) authorized");
        return true;
    }






    @Override
    public Card getCardByCardNumber(String cardNumber) {
        return cardRepository.findByCardNumber(cardNumber);
    }

    @Override
    public Customer getCustomerByCustomerNumber(String customerNumber) {
        return customerRepository.findByCustomerNumber(customerNumber);
    }


}



