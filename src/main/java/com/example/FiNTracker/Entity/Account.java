package com.example.FiNTracker.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<AuthorizedUser> authorizedUsers = new HashSet<>();

    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Transaction> transactions = new ArrayList<>();

    public Account() {
    }

    public Account(String account_name, Long owner_id, LocalDate created, Set<AuthorizedUser> authorizedUsers, List<Transaction> transactions) {
        this.account_name = account_name;
        this.owner_id = owner_id;
        this.created = created;
        this.authorizedUsers = authorizedUsers;
        this.transactions = transactions;
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

    public Set<AuthorizedUser> getAuthorizedUsers() {
        return authorizedUsers;
    }

    public void setAuthorizedUsers(Set<AuthorizedUser> authorizedUsers) {
        this.authorizedUsers = authorizedUsers;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    @Override
    public String toString() {
        return "Account{" +
                "account_id=" + account_id +
                ", account_name='" + account_name + '\'' +
                ", owner_id=" + owner_id +
                ", created=" + created +
                ", authorizedUsers=" + authorizedUsers +
                ", transactions=" + transactions +
                '}';
    }
}
