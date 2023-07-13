package com.sogyo.rvgelder.ipdebitcardreplacementflow.service;

import com.sogyo.rvgelder.ipdebitcardreplacementflow.entity.*;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.repository.CardRepository;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CardRepository cardRepository;


    public Card replaceCard(String customerNumber, String cardNumber) {
        Customer customer = getCustomerByCustomerNumber(customerNumber);
        Card card = getCardByCardNumber(cardNumber);
        Card newCard = customer.replaceCard(card);
        //TODO - Try...catch if the customer can't be saved into DB?
        customerRepository.save(customer);
        return newCard;
    }

    @Override
    public Card getCardByCardNumber(String cardNumber) {
        //TODO - Try...catch if the cardNumber can't be found?
        return cardRepository.findByCardNumber(cardNumber);
    }

    @Override
    public Customer getCustomerByCustomerNumber(String customerNumber) {
        //TODO - Try...catch if the customerNumber can't be found?
        return customerRepository.findByCustomerNumber(customerNumber);
    }

    public static boolean isAuthorized(String customerNumber, Integer processId) {
        //TODO - Try...catch if external authorization fails?
        return true;
    }


}



