package com.example.FiNTracker.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class AuthorizedUserId implements Serializable {
    @Column(name = "user_id")
    private Long userId;

    @Column(name = "account_id")
    private Long accountId;

    public AuthorizedUserId() {
    }

    public AuthorizedUserId(Long userId, Long accountId) {
        this.userId = userId;
        this.accountId = accountId;
    }

    // TODO find out equals and haschode methods

}
