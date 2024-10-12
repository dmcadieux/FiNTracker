package com.example.FiNTracker.Service;

import com.example.FiNTracker.Entity.AuthorizedUser;
import com.example.FiNTracker.Entity.AuthorizedUserId;
import com.example.FiNTracker.Entity.Transaction;
import com.example.FiNTracker.Repo.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    public List<Transaction> findAllTransactions() {
        return transactionRepository.findAll();
    }

    public List<Transaction> findAllTransactionsBetweenDates(LocalDate startDate, LocalDate endDate) {
        return transactionRepository.findByDateBetween(startDate, endDate);
    }

    public List<Transaction> findAllTransactionsByCategory(String category) {
        return transactionRepository.findAllByCategory(category);
    }

    public List<Transaction> findAllByAmountBetween(Float amount1, Float amount2) {
        return transactionRepository.findAllByAmountBetween(amount1, amount2);
    }

    public List<Transaction> findAllByTransactionName(String transactionName) {
        return transactionRepository.findAllByTransactionName(transactionName);
    }

    public Transaction findByTransactionID(Long transactionId) {
        return transactionRepository.findByTransactionId(transactionId);
    }

    public List<Transaction> getTransactionsForAuthorizedUser(Long userId, Long accountId) {
        AuthorizedUserId authorizedUserId = new AuthorizedUserId();
        authorizedUserId.setUserId(userId);
        authorizedUserId.setAccountId(accountId);
        return transactionRepository.findAllTransactionsByAuthorizedUserId(authorizedUserId);
    }



}
