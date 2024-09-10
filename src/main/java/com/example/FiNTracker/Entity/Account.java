package com.example.FiNTracker.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "account_id")
    private Long account_id;

    @Column(name = "account_name")
    private String account_name;

    @Column(name = "owner_id")
    private Long owner_id;
}
