package com.sogyo.rvgelder.ipdebitcardreplacementflow.repository;

import com.sogyo.rvgelder.ipdebitcardreplacementflow.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card, Long> {


    Card findByCardNumber(String cardNumber);
}
