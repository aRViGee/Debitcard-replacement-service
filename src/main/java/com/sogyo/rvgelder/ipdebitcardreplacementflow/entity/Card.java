package com.sogyo.rvgelder.ipdebitcardreplacementflow.entity;

import jakarta.persistence.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Objects;

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
    private LocalDate startDate;
    @Column(name = "end_date", nullable = false)
//    @Temporal(TemporalType.DATE)
    private LocalDate endDate;
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Status status;

    public Card(){}

    public Card(String cardNumber, LocalDate startDate, LocalDate endDate, Status status) {
        this.cardNumber = cardNumber;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return Objects.equals(cardNumber, card.cardNumber) && Objects.equals(startDate, card.startDate) && Objects.equals(endDate, card.endDate) && status == card.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(cardNumber, startDate, endDate, status);
    }
}
