package com.example.FiNTracker.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "financialentries")
public class FinancialEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "bank")
    private String bank;

    @Column(name = "transactionlabel")
    private String transactionLabel;

    @Column(name = "balanceChange")
    private Float balanceChange;

    @Column(name = "date")
    private LocalDate date;

    public FinancialEntry() {
    }

    public FinancialEntry(String bank, String transactionLabel, Float balanceChange, LocalDate date) {
        this.bank = bank;
        this.transactionLabel = transactionLabel;
        this.balanceChange = balanceChange;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getTransactionLabel() {
        return transactionLabel;
    }

    public void setTransactionLabel(String transactionLabel) {
        this.transactionLabel = transactionLabel;
    }

    public Float getBalanceChange() {
        return balanceChange;
    }

    public void setBalanceChange(Float balanceChange) {
        this.balanceChange = balanceChange;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
