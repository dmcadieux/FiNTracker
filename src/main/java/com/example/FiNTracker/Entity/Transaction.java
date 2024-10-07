package com.example.FiNTracker.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "transactions")
public class Transaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "transaction_id")
    private Long transactionId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;

    @Column(name = "category")
    private String category;

    @Column(name = "transaction_name")
    private String transactionName;

    @Column(name = "amount")
    private Float amount;

    @Column(name = "date")
    private LocalDate date;

    public Transaction() {
    }

    public Transaction(Account account, String category, String transactionName, Float amount, LocalDate date) {
        this.account = account;
        this.category = category;
        this.transactionName = transactionName;
        this.amount = amount;
        this.date = date;
    }

    public Long getTransaction_id() {
        return transactionId;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTransactionName() {
        return transactionName;
    }

    public void setTransaction_name(String transaction_name) {
        this.transactionName = transaction_name;
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
                "transactionId=" + transactionId +
                ", account=" + account +
                ", category='" + category + '\'' +
                ", transactionName='" + transactionName + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                '}';
    }
}
