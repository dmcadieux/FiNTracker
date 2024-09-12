package com.example.FiNTracker.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "authorized_users")
public class AuthorizedUser {

    @Id
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private Long user_id;

    @Column(name = "account_id", nullable = false)
    private Long account_id;

    @Column(name = "permission", length = 20, nullable = false)
    private String permission;

    public AuthorizedUser() {
    }

    public AuthorizedUser(Long user_id, Long account_id, String permission) {
        this.user_id = user_id;
        this.account_id = account_id;
        this.permission = permission;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public Long getAccount_id() {
        return account_id;
    }

    public void setAccount_id(Long account_id) {
        this.account_id = account_id;
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
                "user_id=" + user_id +
                ", account_id=" + account_id +
                ", permission='" + permission + '\'' +
                '}';
    }
}
