package com.example.FiNTracker.Controller;


import com.example.FiNTracker.Entity.AuthorizedUserId;
import com.example.FiNTracker.Entity.Transaction;
import com.example.FiNTracker.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@RestController
public class TransactionController {

    private final TransactionService transactionService;

    @Autowired
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping("/get")
    public List<Transaction> getAllTransactions() {
        return transactionService.findAllTransactions();
    }

    @GetMapping("/date-range")
    public List<Transaction> getAllFinancialEntriesBetweenDates(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
            @RequestParam long accountId
    ) {
        return transactionService.findAllTransactionsBetweenDates(startDate, endDate, accountId);
    }

    @GetMapping("/category")
    public List<Transaction> getAllEntriesByCategory(
            @RequestParam String category
    ) {
        return transactionService.findAllTransactionsByCategory(category);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Transaction>> getTransactionsForUser(@PathVariable Long userId) {
        List<Transaction> transactions = transactionService.getTransactionsForUser(userId);
        return ResponseEntity.ok(transactions);
    }

    @GetMapping("/account/{accountId}")
    public ResponseEntity<List<Transaction>> getTransactionsForAccount(@PathVariable Long accountId) {
        List<Transaction> transactions = transactionService.getTransactionsForAccount(accountId);
        return ResponseEntity.ok(transactions);
    }

    @GetMapping("/transactions/{year}/{month}/{accountId}")
    public ResponseEntity<List<Transaction>> getTransactionsByMonth(
            @PathVariable int year,
            @PathVariable int month,
            @PathVariable long accountId) {
        List<Transaction> transactions = transactionService.getTransactionsByMonth(year, month, accountId);
        return ResponseEntity.ok(transactions);
    }

    @GetMapping("sum/{accountId}/{category}")
    public ResponseEntity<List<Object[]>> getSumByCategory(
            @PathVariable String category,
            @PathVariable long accountId) {
        List<Object[]> categoryTotal = transactionService.sumTransactionAmountByCategory(category, accountId);
        return ResponseEntity.ok(categoryTotal);
    }

}
