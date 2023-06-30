package com.sogyo.rvgelder.ipdebitcardreplacementflow.entity;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="Card")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = CardArrangement.class)
    @JoinColumn(name = "card_arrangement_id", referencedColumnName = "id", nullable = false/*, length = 25*/)
    private CardArrangement cardArrangement;
    @Column(name = "start_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private java.util.Date startDate; /*TODO How do I convert this to the database's 'date' format? Separate the month number and year?*/
    @Column(name = "end_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private java.util.Date endDate; /*TODO idem TODO startDate*/
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Status status;

    public Card(int id, CardArrangement cardArrangement, Date startDate, Date endDate, Status status) {
        this.id = id;
        this.cardArrangement = cardArrangement;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }
}
