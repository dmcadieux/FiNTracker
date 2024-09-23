package com.example.FiNTracker.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "authorized_users")
public class AuthorizedUser {

    @EmbeddedId
    private AuthorizedUserId id;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @MapsId("accountId")
    @JoinColumn(name = "account_id")
    private Account account;

    @Column(name = "permission", length = 20, nullable = false)
    private String permission;

    public AuthorizedUser() {
    }

    public AuthorizedUser(AuthorizedUserId id, User user, Account account, String permission) {
        this.id = id;
        this.user = user;
        this.account = account;
        this.permission = permission;
    }

    public AuthorizedUserId getId() {
        return id;
    }

    public void setId(AuthorizedUserId id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    @Override
    public String toString() {
        return "AuthorizedUser{" +
                "id=" + id +
                ", user=" + user +
                ", account=" + account +
                ", permission='" + permission + '\'' +
                '}';
    }
}
