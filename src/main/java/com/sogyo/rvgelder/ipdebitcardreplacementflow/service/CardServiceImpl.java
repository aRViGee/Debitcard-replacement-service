package com.sogyo.rvgelder.ipdebitcardreplacementflow.service;

import com.sogyo.rvgelder.ipdebitcardreplacementflow.entity.Card;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.entity.Customer;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.entity.Status;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    private CardRepository cardRepository;

//    Save operation
    static boolean createNewDebitCard(Customer customer) {
        Card card = new Card("5E6F7G8H", Status.INACTIVE);
        return true;
    }

}
