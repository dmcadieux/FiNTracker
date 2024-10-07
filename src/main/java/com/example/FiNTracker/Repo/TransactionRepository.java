package com.example.FiNTracker.Repo;

import com.example.FiNTracker.Entity.AuthorizedUserId;
import com.example.FiNTracker.Entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findAll();

    List<Transaction> findByDateBetween(LocalDate startDate, LocalDate endDate);

    List<Transaction> findAllByCategory(String category);

    List<Transaction> findAllByAmountBetween(Float amount1, Float amount2);

    List<Transaction> findAllByTransactionName(String transactionName);

    Transaction findByTransactionId(Long transactionId);

    List<Transaction> findAllByAccount_AuthorizedUsers_Id(AuthorizedUserId authorizedUserId);

    // TODO Write queries to join au.user_id to t.user_id for various purposes

    //TODO Write query to return all transactions by month
}
