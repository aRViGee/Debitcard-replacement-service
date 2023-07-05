package com.sogyo.rvgelder.ipdebitcardreplacementflow.service;

import com.sogyo.rvgelder.ipdebitcardreplacementflow.entity.Card;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.entity.Customer;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class CardServiceImpl implements CardService {

    @Autowired
    private CardRepository cardRepository;

    @Override
    public Card findCard(Integer cardId) {
        return cardRepository.findById(cardId).orElseThrow(() -> new NoSuchElementException());
    }
    
//    @Override
//    public Customer findOwner() {
//        findOwnCardArrangement();
//    }

    private void findOwnCardArrangement() {
    }

//    Save operation

    @Override
    public Card saveCard(Card card) {
        return cardRepository.save(card);
    }
}
