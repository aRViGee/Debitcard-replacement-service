package com.sogyo.rvgelder.ipdebitcardreplacementflow.service;

import com.sogyo.rvgelder.ipdebitcardreplacementflow.entity.Card;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.entity.CardArrangement;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.entity.Customer;

import java.util.List;

public interface CardArrangementService {

    CardArrangement findCardArrangement(Integer cardArrangementId);

    //    Save operation
    CardArrangement saveCardArrangement(CardArrangement cardArrangement);

    //    Read operation
    List<CardArrangement> fetchCardArrangementList();

//    List<Card> fetchCardList();

//    Customer getCustomer();



//    //    Update operation
//    CardArrangement updateCardArrangement(CardArrangement cardArrangement, Integer cardArrangementId);
//
//    //    Delete operation
//    void deleteCardArrangementById(Integer cardArrangementId);

}
