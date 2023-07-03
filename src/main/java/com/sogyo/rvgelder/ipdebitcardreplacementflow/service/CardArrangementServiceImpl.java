package com.sogyo.rvgelder.ipdebitcardreplacementflow.service;

import com.sogyo.rvgelder.ipdebitcardreplacementflow.entity.CardArrangement;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.repository.CardArrangementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CardArrangementServiceImpl implements CardArrangementService {

    @Autowired
    private CardArrangementRepository cardArrangementRepository;

    @Override
    public CardArrangement findCardArrangement(Integer cardArrangementId) {
        return cardArrangementRepository.findById(cardArrangementId).get();
    }

//    Save operation
    @Override
    public CardArrangement saveCardArrangement(CardArrangement cardArrangement) {
        return cardArrangementRepository.save(cardArrangement);
    }

//    Read operation
    @Override
    public List<CardArrangement> fetchCardArrangementList() {
        return cardArrangementRepository.findAll();
    }

//    Update operation
    @Override
    public CardArrangement updateCardArrangement(CardArrangement cardArrangement, Integer cardArrangementId) {

        CardArrangement cardArrangementDB = cardArrangementRepository.findById(cardArrangementId).get();

//        cardArrangementDB.setCustomer(cardArrangement.getCustomer());

        if (Objects.nonNull(cardArrangement.getCards())) {
            cardArrangementDB.setCards(cardArrangement.getCards());
        }

        return cardArrangementRepository.save(cardArrangementDB);
    }

//    Delete operation
    @Override
    public void deleteCardArrangementById(Integer cardArrangementId) {
        cardArrangementRepository.deleteById(cardArrangementId);
    }
}
