package com.example.FiNTracker.Repo;

import com.example.FiNTracker.Entity.AuthorizedUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorizedUserRepository extends JpaRepository<AuthorizedUser, Long> {

    List<AuthorizedUser> findAll();

    List<AuthorizedUser> findAllById_UserId(Long userId);

    List<AuthorizedUser> findAllById_AccountId(Long accountId);

    AuthorizedUser findById_UserIdAndId_AccountId(Long userId, Long accountId);


}
