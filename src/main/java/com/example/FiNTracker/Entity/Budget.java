package com.example.FiNTracker.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "budgets")
public class Budget {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "account_id", nullable = false)
    private Long accountId;

    @Column(name = "category")
    private String category;

    @Column(name = "budget_limit")
    private Float budgetLimit;

    @Column(name = "created")
    private LocalDate date;

    public Budget() {
    }

    public Budget(Long accountId, String category, Float budgetLimit, LocalDate date) {
        this.accountId = accountId;
        this.category = category;
        this.budgetLimit = budgetLimit;
        this.date = date;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Float getBudgetLimit() {
        return budgetLimit;
    }

    public void setBudgetLimit(Float budgetLimit) {
        this.budgetLimit = budgetLimit;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Budget{" +
                "userId=" + userId +
                ", accountId=" + accountId +
                ", category='" + category + '\'' +
                ", budgetLimit=" + budgetLimit +
                ", date=" + date +
                '}';
    }
}
