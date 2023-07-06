package com.sogyo.rvgelder.ipdebitcardreplacementflow.service;


import com.sogyo.rvgelder.ipdebitcardreplacementflow.entity.CardArrangement;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.entity.Customer;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.repository.CardArrangementRepository;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.repository.CustomerRepository;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;


@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    public void replaceCard(String customerNumber, String cardNumber) {
        if (verifyCardReplacement(customerNumber,cardNumber)) {
            if (true/*TODO - External authorization implementation*/) {
//                TODO - Fulfillment:
//                  TODO - Fulfillment - Create new card
//                      TODO - Fulfillment - if new card created: set end_date current card
            }
//
        }
    }

    private boolean verifyCardReplacement(String customerNumber, String cardNumber) {
        return (isOwnerOfCard(customerNumber,cardNumber)) && (isAllowedToReplace(customerNumber,cardNumber));
    }

    private boolean isAllowedToReplace(String customerNumber, String cardNumber) {
        return false;
    }

    private boolean isOwnerOfCard(String customerNumber, String cardNumber) {

        return false;
    }
}



