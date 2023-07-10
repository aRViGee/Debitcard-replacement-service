package com.sogyo.rvgelder.ipdebitcardreplacementflow.entity;


import jakarta.persistence.*;

import java.text.SimpleDateFormat;
import java.util.Date;

@Entity
@Table(name="Card")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "card_number")
    private String cardNumber;
    @Column(name = "start_date", nullable = true)
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Column(name = "end_date", nullable = true)
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Status status;

    public Card(){}

    public Card(String cardNumber, Status status) {
        this.cardNumber = cardNumber;
        this.status = status;
    }

    //TODO - add constructor with startDate and endDate

    public Status getStatus() {
        return status;
    }

    public String getCardNumber() {
        return cardNumber;
    }
}
