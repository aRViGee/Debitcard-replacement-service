package com.sogyo.rvgelder.ipdebitcardreplacementflow.entity;

import jakarta.persistence.*;

@Entity
@Table(name="Card")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "card_arrangement_id", nullable = false/*, length = 25*/)
    private int cardArrangementID;
    @Column(name = "start_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private java.util.Date startDate; /*TODO How do I convert this to the database's 'date' format? Separate the month number and year?*/
    @Column(name = "end_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private java.util.Date endDate; /*TODO idem TODO startDate*/
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Status status;

}
