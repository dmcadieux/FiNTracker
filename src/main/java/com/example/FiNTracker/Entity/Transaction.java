package com.example.FiNTracker.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "bank")
    private String bank;

    @Column(name = "label")
    private String label;

    @Column(name = "category")
    private String category;

    @Column(name = "amount")
    private Float amount;

    @Column(name = "date")
    private LocalDate date;

    public Transaction() {
    }

    public Transaction(String bank, String label, String category, Float amount, LocalDate date) {
        this.bank = bank;
        this.label = label;
        this.category = category;
        this.amount = amount;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", bank='" + bank + '\'' +
                ", label='" + label + '\'' +
                ", category='" + category + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                '}';
    }
}
