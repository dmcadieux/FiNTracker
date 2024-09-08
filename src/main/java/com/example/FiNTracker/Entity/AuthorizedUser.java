package com.example.FiNTracker.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "authorized_users")
public class AuthorizedUser {

    @Id
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private Long user_id;

    @Column(name = "permission", length = 20, nullable = false)
    private String permission;

    public AuthorizedUser() {
    }

    public AuthorizedUser(String permission) {
        this.permission = permission;
    }

    public Long getUser_id() {
        return user_id;
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
                ", permission='" + permission + '\'' +
                '}';
    }
}
