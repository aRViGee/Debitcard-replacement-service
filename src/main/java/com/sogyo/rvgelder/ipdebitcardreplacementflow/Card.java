package com.sogyo.rvgelder.ipdebitcardreplacementflow;

public class Card {
    private final int cardID;
    private final int cardArrangementID;
    private final String startDate; /*TODO How do I convert this to the database's 'date' format? Separate the month number and year?*/
    private final String endDate; /*TODO idem TODO startDate*/
    private Enum status;

    public Card(
            int cardID,
            int cardArrangementID,
            String startDate,
            String endDate,
            Enum status
    ) {
        this.cardID = cardID;
        this.cardArrangementID = cardArrangementID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }
}
