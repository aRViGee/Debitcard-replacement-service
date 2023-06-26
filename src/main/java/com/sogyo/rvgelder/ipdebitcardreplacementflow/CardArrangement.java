package com.sogyo.rvgelder.ipdebitcardreplacementflow;

public class CardArrangement {
    private final int cardArrangementID;
    private final int customerID;

    public CardArrangement(
            int cardArrangementID,
            int customerID
    ) {
        this.cardArrangementID = cardArrangementID;
        this.customerID = customerID;
    }
}
