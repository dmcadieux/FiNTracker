package com.example.FiNTracker.Controller;


import com.example.FiNTracker.Entity.Transaction;
import com.example.FiNTracker.Service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate
    ) {
        return transactionService.findAllTransactionsBetweenDates(startDate, endDate);
    }

    @GetMapping("category")
    public List<Transaction> getAllEntriesByCategory(
            @RequestParam String category
    ) {
        return transactionService.findAllTransactionsByCategory(category);
    }
}
