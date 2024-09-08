package com.example.FiNTracker.Entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long user_id;

    @Column(name = "username", length = 50, nullable = false, unique = true)
    private String username;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password_hash", nullable = false)
    private String password_hash;

    @Column(name = "created", nullable = false)
    private LocalDate created;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private AuthorizedUser authorizedUser;

    public User() {
    }

    public User(String username, String email, String password_hash, LocalDate created, AuthorizedUser authorizedUser) {
        this.username = username;
        this.email = email;
        this.password_hash = password_hash;
        this.created = created;
        this.authorizedUser = authorizedUser;
    }

    public Long getUser_id() {
        return user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword_hash() {
        return password_hash;
    }

    public void setPassword_hash(String password_hash) {
        this.password_hash = password_hash;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public AuthorizedUser getAuthorizedUser() {
        return authorizedUser;
    }

    public void setAuthorizedUser(AuthorizedUser authorizedUser) {
        this.authorizedUser = authorizedUser;
    }
}
