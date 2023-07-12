package com.sogyo.rvgelder.ipdebitcardreplacementflow.entity;


import jakarta.persistence.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name="Card")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "card_number", unique = true, nullable = false)
    private String cardNumber;
    @Column(name = "start_date", nullable = false)
//    @Temporal(TemporalType.DATE)
    private String startDate;
    @Column(name = "end_date", nullable = false)
//    @Temporal(TemporalType.DATE)
    private String endDate;
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Status status;

    public Card(){}

    public Card(String cardNumber, Status status) {
        this.cardNumber = cardNumber;
        this.status = status;
    }


    public Card(String cardNumber, String startDate, String endDate, Status status) {
        this.cardNumber = cardNumber;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

    //TODO - add constructor with startDate and endDate

    public Status getStatus() {
        return status;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
