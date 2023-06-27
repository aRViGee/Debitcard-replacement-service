package com.sogyo.rvgelder.ipdebitcardreplacementflow.entity;

import jakarta.persistence.*;

@Entity(name="Card")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
//    @OneToMany
    @Column(name = "card_arrangement_id", nullable = false/*, length = 25*/)
    private int cardArrangementID;
    @Column(name = "start_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private java.util.Date startDate; /*TODO How do I convert this to the database's 'date' format? Separate the month number and year?*/
    @Column(name = "end_date", nullable = false)
    @Temporal(TemporalType.DATE)
    private java.util.Date endDate; /*TODO idem TODO startDate*/
    @Column(name = "status", nullable = false)
    private Enum status;

//    public Card(
//            int id,
//            int cardArrangementID,
//            String startDate,
//            String endDate,
//            Enum status
//    ) {
//        this.id = id;
//        this.cardArrangementID = cardArrangementID;
//        this.startDate = startDate;
//        this.endDate = endDate;
//        this.status = status;
//    }
}
