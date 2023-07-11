package com.sogyo.rvgelder.ipdebitcardreplacementflow.service;

import com.sogyo.rvgelder.ipdebitcardreplacementflow.entity.AuthorizationLevel;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.entity.Card;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.entity.CardArrangement;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.entity.Customer;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.repository.CustomerRepository;


public interface CustomerService {

    void replaceCard(String customerNumber, String cardNumber);

//    Customer methods

//    AuthorizationLevel getAuthorizationLevel(Customer customer);

    //    CardArrangement methods
//    CardArrangement getCardArrangementById(Customer customer, Integer id);

//    CardArrangement getCardArrangementByType(Customer customer, String cardArrangementType);

    //    CardArrangement createCardArrangement(String cardArrangementType, List<Card> cards);

//    Card methods

    Card getCardByCardNumber(String cardNumber);

    Customer getCustomerByCustomerNumber(String customerNumber);
}
