package com.example.FiNTracker.Repo;

import com.example.FiNTracker.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {

    List<Account> findAll();

    Account findByAccountId(Long accountId);

    Account findByAccountName(String accountName);

    List<Account> findAllByOwnerId(Long ownerID);

    List<Account> findAllByCreatedBetween(LocalDate startDate, LocalDate endDate);

}
