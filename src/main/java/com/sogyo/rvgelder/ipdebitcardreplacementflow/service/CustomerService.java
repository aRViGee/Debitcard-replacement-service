package com.sogyo.rvgelder.ipdebitcardreplacementflow.service;

import com.sogyo.rvgelder.ipdebitcardreplacementflow.entity.AuthorizationLevel;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.entity.Card;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.entity.CardArrangement;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.entity.Customer;

import java.util.List;

public interface CustomerService {

    void replaceCard(String customerNumber, String cardNumber);

    Customer createCustomer(String customerNumber, AuthorizationLevel authorizationLevel, List<CardArrangement> cardArrangements);

    Customer createCompleteCustomer(String customerNumber, AuthorizationLevel authorizationLevel, List<CardArrangement> cardArrangements);

//    CardArrangement createCardArrangement(String cardArrangementType, List<Card> cards);

    Card createNewCard();

}
