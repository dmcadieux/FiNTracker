package com.example.FiNTracker.Repo;

import com.example.FiNTracker.Entity.AuthorizedUserId;
import com.example.FiNTracker.Entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findAll();

    List<Transaction> findByDateBetween(LocalDate startDate, LocalDate endDate);

    List<Transaction> findAllByCategory(String category);

    List<Transaction> findAllByAmountBetween(Float amount1, Float amount2);

    List<Transaction> findAllByTransactionName(String transactionName);

    Transaction findByTransactionId(Long transactionId);

    // Returns all transactions for all accounts that the user has access to
    @Query("SELECT DISTINCT t FROM Transaction t " +
            "JOIN AuthorizedUser au ON t.accountId = au.id.accountId " +
            "WHERE au.id.userId = :userId")
    List<Transaction> findDistinctTransactionByUserId(@Param("userId") Long userId);

    @Query("SELECT DISTINCT t FROM Transaction t " +
            "JOIN AuthorizedUser au ON t.accountId = au.id.accountId " +
            "WHERE au.id.accountId = :accountId")
    List<Transaction> findDistinctTransactionByAccountId(@Param("accountId") Long accountId);

    // TODO Write queries to join au.user_id to t.user_id for various purposes

    //TODO Write query to return all transactions by month
}
