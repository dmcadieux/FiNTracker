package com.example.FiNTracker.Repo;

import com.example.FiNTracker.Entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {

    List<Account> findAll();

    Account findByAccountID(Long accountID);

    Account findByAccountName(String accountName);

    List<Account> findAllByOwnerId(Long ownerID);

    List<Account> findAllByDateBetween(LocalDate startDate, LocalDate endDate);

}
