package com.sogyo.rvgelder.ipdebitcardreplacementflow.service;

import com.sogyo.rvgelder.ipdebitcardreplacementflow.entity.Card;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.entity.Customer;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.entity.exceptions.CustomerNotAllowedToReplaceException;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.entity.exceptions.CustomerNotOwnerOfCardException;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.service.exceptions.CustomerNotFoundException;


public interface CustomerService {

    Card replaceCard(String customerNumber, String cardNumber) throws CustomerNotOwnerOfCardException, CustomerNotAllowedToReplaceException, CustomerNotFoundException;

    Card getCardByCardNumber(String cardNumber);

    Customer getCustomerByCustomerNumber(String customerNumber) throws CustomerNotFoundException;
}
