package com.example.FiNTracker.Entity;

import jakarta.persistence.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "authorized_users")
public class AuthorizedUser {

    @EmbeddedId
    private AuthorizedUserId id;

    @Column(name = "permission", length = 20, nullable = false)
    private String permission;

    public AuthorizedUser() {
    }

    public AuthorizedUser(AuthorizedUserId id, String permission) {
        this.id = id;
        this.permission = permission;
    }

    public AuthorizedUserId getId() {
        return id;
    }

    public void setId(AuthorizedUserId id) {
        this.id = id;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }
}
