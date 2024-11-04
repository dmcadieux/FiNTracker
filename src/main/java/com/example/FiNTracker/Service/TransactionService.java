package com.example.FiNTracker.Service;

import com.example.FiNTracker.Entity.Transaction;
import com.example.FiNTracker.Repo.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
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

    public List<Transaction> findAllTransactionsBetweenDates(LocalDate startDate, LocalDate endDate, Long accountId) {
        return transactionRepository.findByDateBetweenAndAccountId(startDate, endDate, accountId);
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

    public List<Transaction> getTransactionsForUser(Long userId) {
        return transactionRepository.findDistinctTransactionByUserId(userId);
    }

    public List<Transaction> getTransactionsForAccount(Long accountId) {
        return transactionRepository.findDistinctTransactionByAccountId(accountId);
    }

    public List<Transaction> getTransactionsByMonth(int year, int month, Long accountId) {

        LocalDate startDate = LocalDate.of(year, month, 1);
        LocalDate endDate = startDate.plusMonths(1);

        return transactionRepository.findByDateBetweenAndAccountId(startDate, endDate, accountId);

    }

    public List<Object[]> sumTransactionAmountByCategory(String category, Long accountId) {
        return transactionRepository.sumAmountByCategory(category, accountId);
    }



}
