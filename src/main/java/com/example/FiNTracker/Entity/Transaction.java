package com.example.FiNTracker.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private Long transaction_id;

    @Column(name = "category")
    private String category;

    @Column(name = "transaction_name")
    private String transaction_name;

    @Column(name = "amount")
    private Float amount;

    @Column(name = "date")
    private LocalDate date;

    public Transaction() {
    }

    public Transaction(String category, String transaction_name, Float amount, LocalDate date) {
        this.category = category;
        this.transaction_name = transaction_name;
        this.amount = amount;
        this.date = date;
    }

    public Long getTransaction_id() {
        return transaction_id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTransaction_name() {
        return transaction_name;
    }

    public void setTransaction_name(String transaction_name) {
        this.transaction_name = transaction_name;
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
                "transaction_id=" + transaction_id +
                ", category='" + category + '\'' +
                ", transaction_name='" + transaction_name + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                '}';
    }
}
