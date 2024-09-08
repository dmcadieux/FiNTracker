package com.example.FiNTracker.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "budgets")
public class Budget {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "user_id")
    private Long user_id;

    @Column(name = "category")
    private String category;

    @Column(name = "budget_limit")
    private Float budget_limit;

    @Column(name = "created")
    private LocalDate date;

    public Budget() {
    }

    public Budget(String category, Float budget_limit, LocalDate date) {
        this.category = category;
        this.budget_limit = budget_limit;
        this.date = date;
    }

    public Long getUser_id() {
        return user_id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Float getBudget_limit() {
        return budget_limit;
    }

    public void setBudget_limit(Float budget_limit) {
        this.budget_limit = budget_limit;
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
                "user_id=" + user_id +
                ", category='" + category + '\'' +
                ", budget_limit=" + budget_limit +
                ", date=" + date +
                '}';
    }
}
