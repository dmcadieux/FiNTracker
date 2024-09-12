package com.example.FiNTracker.Repo;

import com.example.FiNTracker.Entity.AuthorizedUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AuthorizedUserRepository extends JpaRepository<AuthorizedUser, Long> {

    List<AuthorizedUser> findAll();

    List<AuthorizedUser> findAllByUserID(Long userID);

    List<AuthorizedUser> findAllByAccountID(Long accountID);

    AuthorizedUser findByUserIDAndAccountID(Long userID, Long accountID);


}
