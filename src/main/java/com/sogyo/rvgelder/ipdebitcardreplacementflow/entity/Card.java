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
    @ManyToOne(fetch = FetchType.EAGER, targetEntity = CardArrangement.class)
    @JoinColumn(name = "card_arrangement_id", referencedColumnName = "id", nullable = false/*, length = 25*/)
    private CardArrangement cardArrangement;
    @Column(name = "start_date", nullable = true)
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Column(name = "end_date", nullable = true)
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Status status;

    public Card(Status status) {
        this.status = status;
    }

    public Card(CardArrangement cardArrangement, Status status) {
        this.cardArrangement = cardArrangement;
        this.status = status;
    }

        public Card(CardArrangement cardArrangement, Date startDate, Date endDate, Status status) {
        this.cardArrangement = cardArrangement;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public CardArrangement getCardArrangement() {
        return cardArrangement;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public Status getStatus() {
        return status;
    }


}
