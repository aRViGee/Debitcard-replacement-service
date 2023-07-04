package com.sogyo.rvgelder.ipdebitcardreplacementflow.service;

import com.sogyo.rvgelder.ipdebitcardreplacementflow.entity.Card;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.entity.Customer;
import com.sogyo.rvgelder.ipdebitcardreplacementflow.entity.Status;

public interface CardService {

    Card findCard(Integer cardId);

//    Customer findOwner();

////    Save operation
//    Card saveCard(Card card);

////    Read operations
//    Status getStatus(Card card);

}
