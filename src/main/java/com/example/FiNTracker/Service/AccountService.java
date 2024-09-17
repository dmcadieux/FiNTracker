package com.example.FiNTracker.Service;

import com.example.FiNTracker.Entity.Account;
import com.example.FiNTracker.Repo.AccountRepository;
import com.example.FiNTracker.Repo.AuthorizedUserRepository;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AccountService {

    private final AccountRepository accountRepository;


    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    List<Account> findAll() {
        return accountRepository.findAll();
    }

    public Account findByAccountID(Long accountID) {
        return accountRepository.findByAccountID(accountID);
    }

    public Account findByAccountName(String accountName) {
        return accountRepository.findByAccountName(accountName);
    }

    public List<Account> findAllByOwnerId(Long ownerID) {
        return accountRepository.findAllByOwnerId(ownerID);
    }

    public List<Account> findAllByDateBetween(LocalDate startDate, LocalDate endDate) {
        return accountRepository.findAllByDateBetween(startDate, endDate);
    }

}
