package com.sogyo.rvgelder.ipdebitcardreplacementflow.service;

import com.sogyo.rvgelder.ipdebitcardreplacementflow.entity.*;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.entity.exceptions.*;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.repository.CardRepository;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.repository.CustomerRepository;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.service.exceptions.CardNotFoundException;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.service.exceptions.CustomerNotAuthorizedException;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.service.exceptions.CustomerNotFoundException;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.service.exceptions.CustomerNotSavedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CardRepository cardRepository;


    public Card replaceCard(String customerNumber, String cardNumber)
            throws CustomerNotOwnerOfCardException,
            CustomerNotAllowedToReplaceException,
            CustomerNotFoundException,
            CardNotFoundException,
            CustomerNotAuthorizedException,
            CustomerNotSavedException,
            NewEndDateOldCardNotSetException,
            CardNotCreatedException,
            StartDateInThePastException,
            CardIsInactiveException {

        Customer customer = getCustomerByCustomerNumber(customerNumber);
        Card card = getCardByCardNumber(cardNumber);
        Card newCard = customer.replaceCard(card);

        try {
            customerRepository.save(customer);
        } catch (Exception e) {
            throw new CustomerNotSavedException("Failed to update customer in the database");
        }
        return newCard;
    }

    @Override
    public Card getCardByCardNumber(String cardNumber)
            throws CardNotFoundException {
        Card card = cardRepository.findByCardNumber(cardNumber);
        if (card == null) {
            throw new CardNotFoundException("You do not own a card with card number " + cardNumber);
        }
        return card;
    }

    @Override
    public Customer getCustomerByCustomerNumber(String customerNumber)
            throws CustomerNotFoundException {
        Customer customer = customerRepository.findByCustomerNumber(customerNumber);
        if (customer == null) {
            throw new CustomerNotFoundException("Customer with customer number " + customerNumber + " not found.");
        }
        return customer;
    }


    public static boolean isAuthorized(String customerNumber, Integer processId) throws CustomerNotAuthorizedException {
        try {
            return true;
        } catch (Exception e) {
            throw new CustomerNotAuthorizedException("Customer was not authorized.");
        }
    }


}



