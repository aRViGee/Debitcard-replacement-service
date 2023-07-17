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
        customerRepository.save(customer);
        return newCard;
    }

    @Override
    public Card getCardByCardNumber(String cardNumber) {
        return cardRepository.findByCardNumber(cardNumber);
    }

    @Override
    public Customer getCustomerByCustomerNumber(String customerNumber) {
        return customerRepository.findByCustomerNumber(customerNumber);
    }

    public static boolean isAuthorized(String customerNumber, Integer processId) {
        return true;
    }


}



