package com.example.FiNTracker.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id", nullable = false)
    private Long account_id;

    @Column(name = "account_name", nullable = false)
    private String account_name;

    @Column(name = "owner_id", nullable = false)
    private Long owner_id;

    @Column(name = "created", nullable = false)
    private LocalDate created;

    public Account() {
    }

    public Account(String account_name, Long owner_id, LocalDate created) {
        this.account_name = account_name;
        this.owner_id = owner_id;
        this.created = created;
    }

    public Long getAccount_id() {
        return account_id;
    }

    public String getAccount_name() {
        return account_name;
    }

    public void setAccount_name(String account_name) {
        this.account_name = account_name;
    }

    public Long getOwner_id() {
        return owner_id;
    }

    public void setOwner_id(Long owner_id) {
        this.owner_id = owner_id;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "Account{" +
                "account_id=" + account_id +
                ", account_name='" + account_name + '\'' +
                ", owner_id=" + owner_id +
                ", created=" + created +
                '}';
    }
}
