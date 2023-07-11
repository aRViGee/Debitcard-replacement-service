package com.sogyo.rvgelder.ipdebitcardreplacementflow.repository;

import com.sogyo.rvgelder.ipdebitcardreplacementflow.entity.CardArrangement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardArrangementRepository extends JpaRepository<CardArrangement, Long> {

    CardArrangement findByCardArrangementType(String cardArrangementType);
}
