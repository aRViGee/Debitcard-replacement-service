package com.sogyo.rvgelder.ipdebitcardreplacementflow.service;

import com.sogyo.rvgelder.ipdebitcardreplacementflow.entity.CardArrangement;

import java.util.List;

public interface CardArrangementService {

    CardArrangement findCardArrangement(Integer cardArrangementId);

    //    Save operation
    CardArrangement saveCardArrangement(CardArrangement cardArrangement);

    //    Read operation
    List<CardArrangement> fetchCardArrangementList();

    //    Update operation
    CardArrangement updateCardArrangement(CardArrangement cardArrangement, Integer cardArrangementId);

    //    Delete operation
    void deleteCardArrangementById(Integer cardArrangementId);

}
