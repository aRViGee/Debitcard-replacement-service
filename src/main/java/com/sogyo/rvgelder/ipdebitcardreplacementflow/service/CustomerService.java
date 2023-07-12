package com.sogyo.rvgelder.ipdebitcardreplacementflow.service;

import com.sogyo.rvgelder.ipdebitcardreplacementflow.entity.Card;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.entity.Customer;


public interface CustomerService {

    Card replaceCard(String customerNumber, String cardNumber);

    Card getCardByCardNumber(String cardNumber);

    Customer getCustomerByCustomerNumber(String customerNumber);
}
