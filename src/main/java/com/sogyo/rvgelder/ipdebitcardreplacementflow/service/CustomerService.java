package com.sogyo.rvgelder.ipdebitcardreplacementflow.service;

import com.sogyo.rvgelder.ipdebitcardreplacementflow.entity.AuthorizationLevel;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.entity.CardArrangement;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.entity.Customer;


public interface CustomerService {

    void replaceCard(Customer customer, String cardNumber);

//    Customer methods

    AuthorizationLevel getAuthorizationLevel(Customer customer);

    //    CardArrangement methods
    CardArrangement getCardArrangementById(Customer customer, Integer id);

    CardArrangement getCardArrangementByType(Customer customer, String cardArrangementType);

    //    CardArrangement createCardArrangement(String cardArrangementType, List<Card> cards);

//    Card methods

}
