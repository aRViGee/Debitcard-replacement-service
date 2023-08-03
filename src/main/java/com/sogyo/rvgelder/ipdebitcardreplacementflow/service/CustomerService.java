package com.sogyo.rvgelder.ipdebitcardreplacementflow.service;

import com.sogyo.rvgelder.ipdebitcardreplacementflow.entity.Card;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.entity.Customer;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.entity.exceptions.CardNotCreatedException;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.entity.exceptions.CustomerNotAllowedToReplaceException;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.entity.exceptions.CustomerNotOwnerOfCardException;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.entity.exceptions.NewEndDateOldCardNotSetException;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.service.exceptions.CardNotFoundException;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.service.exceptions.CustomerNotAuthorizedException;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.service.exceptions.CustomerNotFoundException;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.service.exceptions.CustomerNotSavedException;


public interface CustomerService {

    Card replaceCard(String customerNumber, String cardNumber) throws CustomerNotOwnerOfCardException, CustomerNotAllowedToReplaceException, CustomerNotFoundException, CardNotFoundException, CustomerNotAuthorizedException, CustomerNotSavedException, NewEndDateOldCardNotSetException, CardNotCreatedException;

    Card getCardByCardNumber(String cardNumber) throws CardNotFoundException;

    Customer getCustomerByCustomerNumber(String customerNumber) throws CustomerNotFoundException;
}
